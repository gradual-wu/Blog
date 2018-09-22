package top.gradual.blog.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import top.gradual.blog.dao.mapper.BlogArticleMapper;
import top.gradual.blog.domain.dto.ArticleInputDTO;
import top.gradual.blog.domain.dto.ArticlePraiseItem;
import top.gradual.blog.domain.dto.ArticleResultDTO;
import top.gradual.blog.domain.dto.ArticleTypeResultDTO;
import top.gradual.blog.domain.entites.BlogArticle;
import top.gradual.blog.domain.entites.BlogArticleExample;
import top.gradual.blog.domain.entites.BlogArticleWithBLOBs;
import top.gradual.blog.domain.vo.ArticleCartVO;
import top.gradual.blog.exception.ArticleInsertException;
import top.gradual.blog.service.ArticleService;
import top.gradual.blog.service.ArticleTypeService;
import top.gradual.blog.service.ArticleWithTypeNexusService;
import top.gradual.blog.util.DateFormatUtil;


import static java.util.stream.Collectors.toList;

/**
 * @Description: 博文类服务层接口实现类
 * @Author: gradual
 * @Date: 2018-08-27 12:12
 */
@Service("articleService")
@Transactional(rollbackFor = Exception.class)
@CacheConfig(cacheNames = "blogArticle", cacheManager = "articleCacheManager")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private BlogArticleMapper blogArticleMapper;

    @Autowired
    private  ArticleTypeService articleTypeService;

    @Autowired
    private ArticleWithTypeNexusService articleWithTypeNexusService;


    private final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    /**
     * @description: 添加博文
     *
     * @author: gradual
     * @date: 2018/9/5 8:16
     * @param: [article]
     * @return: top.gradual.blog.domain.dto.ArticleResultDTO
     */
    @Override
    @CachePut(key = "#result.id")
    public ArticleResultDTO addArticle(ArticleInputDTO article) {
        ArticleResultDTO resultDTO = new ArticleResultDTO();
        try {
            logger.debug("添加博文" + article);
            logger.debug("开始插入博文信息");
            BlogArticleWithBLOBs blogArticle = new BlogArticleWithBLOBs();
            blogArticle.setGmtCreate(new Date());
            blogArticle.setGmtModified(new Date());
            blogArticle.setStatus(0);
            blogArticle.setUserId(article.getUserId());
            blogArticle.setPraise((long) 0);
            blogArticle.setHtml(article.getHtml());
            if (article.getText().length() < 90) {
                blogArticle.setTxt(article.getText());
            } else {
                blogArticle.setTxt(article.getText().substring(0, 90) + "...");
            }
            blogArticle.setTitle(article.getTitle());
            int i = blogArticleMapper.insert(blogArticle);
            logger.debug("插入操作结束");
            logger.debug("返回值" + i);
            if (i <= 0) {
                logger.debug("未能成功插入数据");
                throw new ArticleInsertException("发布博客出现了一个问题");
            }
            logger.debug("添加博文分类 ::" + Arrays.toString(article.getTypeId()));
            boolean flag = articleWithTypeNexusService.addNexus(article.getTypeId(), blogArticle.getId());
            if (!flag) {
                logger.debug("未能成功插入博文分类信息");
                throw new ArticleInsertException("发布博客出现了一个问题");
            }
            BeanUtils.copyProperties(blogArticle, resultDTO);
            resultDTO.setCreateTime(DateFormatUtil.format(blogArticle.getGmtCreate()));
            for (Long typeId : article.getTypeId()) {
                logger.debug("查找id为" + typeId + "的分类对象");
                ArticleTypeResultDTO typeResultDTO = articleTypeService.getArticleTypeById(typeId);
                resultDTO.getTypes().add(typeResultDTO);
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //手动开启事务回滚
        }
        return resultDTO;
    }


    /**
     * 获取博文信息
     * */
    @Override
    @Cacheable(key = "#id")
    public ArticleResultDTO getArticleById(long id) {
        logger.debug("获取ID为" + id + "的博文");
        BlogArticleWithBLOBs article =  blogArticleMapper.selectByPrimaryKey(id);
        ArticleResultDTO resultDTO = new ArticleResultDTO();
        BeanUtils.copyProperties(article, resultDTO);
        resultDTO.setCreateTime(DateFormatUtil.format(article.getGmtCreate()));
        logger.debug("获取博文分类信息");
        Long[] typeIds = articleWithTypeNexusService.getNexusByArticleId(resultDTO.getId());
        for (Long typeId : typeIds) {
            resultDTO.getTypes().add(articleTypeService.getArticleTypeById(typeId));
        }
        return resultDTO;
    }

    /**
     * @description: 根据用户获取博文列表
     *
     * @author: gradual
     * @date: 2018/9/4 19:44
     * @param: [id]
     * @return: java.util.List<top.gradual.blog.domain.dto.ArticleResultDTO>
     */
    @Override
    public PageInfo<ArticleCartVO> getArticleByUser(long id, int pageNum) {
        BlogArticleExample example = new BlogArticleExample();
        BlogArticleExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(1L);
        logger.debug("分页查询ArticleItem列表信息");
        PageInfo<ArticleCartVO> pageInfo = PageHelper.startPage(pageNum, 10).doSelectPageInfo(() -> blogArticleMapper.selectToListByUserId(id));
        logger.debug("获取到分页信息" + pageInfo);
        logger.debug("给分页实体对象中匹配图片");
        for (ArticleCartVO card : pageInfo.getList()) {
            logger.debug("给每个博文信息匹配图片");
            Long[] typeIds = articleWithTypeNexusService.getNexusByArticleId(card.getId());
            logger.debug("获取博文的第一个分类");
            ArticleTypeResultDTO type = articleTypeService.getArticleTypeById(typeIds[0]);
            String str = type.getImgBase64();
            if (str != null && !"".equals(str) && !"null".equals(str)) {
                logger.debug("获取到分类图片链接" + str);
                card.setImgPath(str);
            }
        }
        return pageInfo;
    }

    @Override
    public PageInfo<ArticleCartVO> getArticleListByTypeId(long id, int pageNum) {
        logger.debug("获取分类ID为" + id + "的博文列表");
        Long[] articleIds = articleWithTypeNexusService.getArticleIdByTypeId(id);
        PageInfo<ArticleCartVO> pageInfo = PageHelper.startPage(pageNum, 10)
                .doSelectPageInfo(() -> blogArticleMapper.selectArtilceListByIds(articleIds));
        logger.debug("获取到的对象::" + pageInfo);
        logger.debug("给分页实体对象中匹配图片");
        ArticleTypeResultDTO type = articleTypeService.getArticleTypeById(id);
        for (ArticleCartVO card : pageInfo.getList()) {
            logger.debug("给每个博文信息匹配图片");
            String str = type.getImgBase64();
            if (str != null && !"".equals(str) && !"null".equals(str)) {
                logger.debug("获取到分类图片链接" + str);
                card.setImgPath(str);
            }
        }
        return pageInfo;
    }

    /**
     * @description: 点赞
     *
     * @author: gradual
     * @date: 2018/9/19 上午10:23
     * @param: [articleId]
     * @return: top.gradual.blog.domain.dto.ArticleResultDTO
     */
    @CachePut(key = "#id")
    public ArticleResultDTO addPraise(Long id) {
        logger.debug("为博文ID为" + id + "的博文点赞");
        ArticleResultDTO article = this.getArticleById(id);
        BlogArticleWithBLOBs article1 = new BlogArticleWithBLOBs();
        article1.setPraise(article.getPraise() + 1);
        article1.setId(id);
        int i = blogArticleMapper.updateByPrimaryKeySelective(article1);
        if (i > 0) {
            article.setPraise(article.getPraise() + 1);
            return article;
        }
        return null;
    }

    /**
     * @description: 获取博文的点赞量
     *
     * @author: gradual
     * @date: 2018/9/21 下午3:19
     * @param: []
     * @return: java.util.List<top.gradual.blog.domain.dto.ArticlePraiseItem>
     */
    @Override
    public List<ArticlePraiseItem> getArticleByPraise() {
        List<BlogArticle> blogArticles = blogArticleMapper.selectArticleByPraise();
        return blogArticles.stream()
                .map(a -> (new ArticlePraiseItem(a.getId(), a.getTitle())))
                .collect(toList());
    }

    @Override
    @CachePut(key = "#result.id")
    public ArticleResultDTO updateArticle(ArticleInputDTO inputDTO) {
        logger.debug("更新博文ID为" + inputDTO.getId() + "的博文");
        BlogArticleWithBLOBs articleWithBLOBs = new BlogArticleWithBLOBs();
        articleWithBLOBs.setTxt(inputDTO.getText());
        articleWithBLOBs.setHtml(inputDTO.getHtml());
        articleWithBLOBs.setId(inputDTO.getId());
        articleWithBLOBs.setTitle(inputDTO.getTitle());
        logger.debug("删除之前的与分类关联信息");
        articleWithTypeNexusService.deleteNexusByArticleId(inputDTO.getId());
        logger.debug("建立新的关联信息");
        articleWithTypeNexusService.addNexus(inputDTO.getTypeId(), inputDTO.getId());
        logger.debug("更新博文信息");
        int i = blogArticleMapper.updateByPrimaryKeySelective(articleWithBLOBs);
        if (i > 0) {
            logger.debug("成功更新博文信息,开始组织返回对象");
            ArticleResultDTO articleOld = this.getArticleById(inputDTO.getId());
            articleOld.setHtml(inputDTO.getHtml());
            articleOld.setTitle(inputDTO.getTitle());
            articleOld.setTxt(inputDTO.getText());
            articleOld.getTypes().clear();
            for (Long typeId : inputDTO.getTypeId()) {
                logger.debug("查找id为" + typeId + "的分类对象");
                ArticleTypeResultDTO typeResultDTO = articleTypeService.getArticleTypeById(typeId);
                articleOld.getTypes().add(typeResultDTO);
            }
            return articleOld;
        }
        return null;
    }

    /**
     * @description: 根据博文ID删除博文
     *
     * @author: gradual
     * @date: 2018/9/21 下午3:19
     * @param: [id]
     * @return: boolean
     */
    @Override
    @CacheEvict(key = "#id")
    public boolean deleteArticle(Long id) {
        int i = blogArticleMapper.deleteByPrimaryKey(id);
        logger.debug("判断是否删除成功");
        if (i > 0) {
            logger.debug("删除成功，开始删除关联");
            return articleWithTypeNexusService.deleteNexusByArticleId(id);
        }
        return false;
    }
}