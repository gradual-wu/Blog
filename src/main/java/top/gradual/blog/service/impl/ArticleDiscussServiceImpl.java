package top.gradual.blog.service.impl;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;
import top.gradual.blog.dao.mapper.ArticleDiscussMapper;
import top.gradual.blog.domain.dto.DiscussInputDTO;
import top.gradual.blog.domain.dto.DiscussResultDTO;
import top.gradual.blog.domain.entites.ArticleDiscuss;
import top.gradual.blog.domain.entites.ArticleDiscussExample;
import top.gradual.blog.service.ArticleDiscussService;
import top.gradual.blog.util.DateFormatUtil;

import static java.util.stream.Collectors.toList;

/**
 * @Description: 博文留言服务层
 * @Author: gradual
 * @Date: 2018-09-17 上午11:09
 */
@Service
@CacheConfig(cacheNames = "articleDiscuss")
public class ArticleDiscussServiceImpl implements ArticleDiscussService {

    @Autowired
    private ArticleDiscussMapper articleDiscussMapper;

    @Autowired
    @Qualifier("discussCacheManager")
    private RedisCacheManager discussCacheManager;

    private Logger logger = LoggerFactory.getLogger(ArticleDiscussServiceImpl.class);

    @Override
    @CacheEvict(key = "#discussInputDTO.articleId")
    public DiscussResultDTO addDiscuss(DiscussInputDTO discussInputDTO) {
        logger.debug("为博文ID为" + discussInputDTO.getArticleId() + "的博文添加留言信息" + discussInputDTO);
        ArticleDiscuss discuss = new ArticleDiscuss();
        discuss.setArticleId(discussInputDTO.getArticleId());
        discuss.setContent(discussInputDTO.getText());
        discuss.setNikename(discussInputDTO.getNikename());
        discuss.setIpAddress(discussInputDTO.getIp());
        discuss.setGmtCreate(discussInputDTO.getCreateTime());
        discuss.setGmtModified(new Date());
        int count = articleDiscussMapper.insertSelective(discuss);
        if (count > 0) {
            logger.debug("添加留言成功，配置返回参数");
            DiscussResultDTO resultDTO = new DiscussResultDTO();
            resultDTO.setCreateTime(DateFormatUtil.format(discuss.getGmtCreate()));
            resultDTO.setText(discussInputDTO.getText());
            resultDTO.setNikename(discussInputDTO.getNikename());
            return resultDTO;
        }
        logger.debug("添加留言失败");
        return null;
    }

    /**
     * @description: 通过博文ID获取博文留言
     *
     * @author: gradual
     * @date: 2018/9/17 下午5:25
     * @param: [articleId]
     * @return: java.util.List<top.gradual.blog.domain.dto.DiscussResultDTO>
     */
    @Override
    @Cacheable(key = "#articleId")
    public List<DiscussResultDTO> getDiscuss(Long articleId) {
        logger.debug("获取博文ID为" + articleId + "的留言信息");
        ArticleDiscussExample example = new ArticleDiscussExample();
        ArticleDiscussExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(articleId);
        List<ArticleDiscuss> discusses = articleDiscussMapper.selectByExample(example);
        discusses.sort(Comparator.comparing(ArticleDiscuss::getGmtCreate));
        return discusses.stream()
                .map(a -> new DiscussResultDTO(a.getNikename(), DateFormatUtil.format(a.getGmtCreate()), a.getContent()))
                .collect(toList());
    }

    /**
     * @description: 通过留言ID删除留言
     *
     * @author: gradual
     * @date: 2018/9/17 下午5:26
     * @param: [id]
     * @return: boolean
     */
    @Override
    public boolean deleteDiscuss(Long id) {
        return false;
    }
}
