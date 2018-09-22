package top.gradual.blog.service.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;
import top.gradual.blog.dao.mapper.ArticleTypeMapper;
import top.gradual.blog.domain.dto.ArticleTypeInputDTO;
import top.gradual.blog.domain.dto.ArticleTypeResultDTO;
import top.gradual.blog.domain.entites.ArticleType;
import top.gradual.blog.domain.entites.ArticleTypeExample;
import top.gradual.blog.service.ArticleTypeService;

/**
 * @Description: 博文分类管理Service实现类
 * @Author: gradual
 * @Date: 2018-08-28 10:10
 */
@Service("articleTypeService")
@CacheConfig(cacheNames = "articleType", cacheManager = "articleTypeCacheManager")
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Autowired
    @Qualifier("articleTypeCacheManager")
    private RedisCacheManager articleTypeRedisCacheManager;

    private final Logger logger = LoggerFactory.getLogger(ArticleTypeServiceImpl.class);

    /**
     * @description: 添加分类
     *
     * @author: gradual
     * @date: 2018/8/28 13:10
     * @param: [articleTypeInputDTO]
     * @return: top.gradual.blog.domain.dto.ArticleTypeResultDTO
     */
    @CachePut(key = "#result.id")
    @Override
    public ArticleTypeResultDTO addArticleType(ArticleTypeInputDTO articleTypeInputDTO) {
        ArticleType articleType = new ArticleType();
        articleType.setCreateId(articleTypeInputDTO.getId());
        articleType.setGmtCreate(new Date());
        articleType.setGmtModified(new Date());
        articleType.setType(articleTypeInputDTO.getType());
        int flag = articleTypeMapper.insert(articleType);
        if (flag <= 0) {
            return null;
        }
        ArticleTypeResultDTO articleTypeResultDTO = new ArticleTypeResultDTO();
        articleTypeResultDTO.setId(articleType.getId());
        articleTypeResultDTO.setType(articleType.getType());
        return articleTypeResultDTO;
    }

    /**
     * @description: 通过类ID获取类实例
     *
     * @author: gradual
     * @date: 2018/8/28 13:10
     * @param: [id]
     * @return: top.gradual.blog.domain.dto.ArticleTypeResultDTO
     */
    @Cacheable(key = "#id")
    @Override
    public ArticleTypeResultDTO getArticleTypeById(long id) {
        ArticleType articleType = articleTypeMapper.selectByPrimaryKey(id);
        if (articleType == null) {
            return null;
        }
        ArticleTypeResultDTO articleTypeResultDTO = new ArticleTypeResultDTO();
        BeanUtils.copyProperties(articleType, articleTypeResultDTO);
        return articleTypeResultDTO;
    }

    @Cacheable(key = "#type")
    @Override
    public ArticleTypeResultDTO getArticleTypeByTypeName(String type) {
        ArticleTypeExample example = new ArticleTypeExample();
        ArticleTypeExample.Criteria criteria= example.createCriteria();
        criteria.andTypeEqualTo(type);
        List<ArticleType> articleTypes = articleTypeMapper.selectByExample(example);
        if (articleTypes.size() == 0) {
            return null;
        }
        ArticleTypeResultDTO resultDTO = new ArticleTypeResultDTO();
        BeanUtils.copyProperties(articleTypes.get(0), resultDTO);
        return resultDTO;
    }

    /**
     * @description: 获取所有博文分类
     *
     * @author: gradual
     * @date: 2018/8/28 15:20
     * @param: []
     * @return: java.util.List<top.gradual.blog.domain.dto.ArticleTypeResultDTO>
     */
    @Override
    public List<ArticleTypeResultDTO> getArticleTypeAll() {
        logger.debug("获取所有分类");
        List<ArticleType> articleTypes = articleTypeMapper.selectByExample(new ArticleTypeExample());
        if (articleTypes.size() == 0) {
            logger.debug("没有分类信息");
            return null;
        }
        logger.debug("获取到分类信息::" + articleTypes);
        logger.debug("创建分类返回对象集合");
        List<ArticleTypeResultDTO> articleTypeResultDTOS = new LinkedList<>();
        logger.debug("获取缓存");
        Cache cache = articleTypeRedisCacheManager.getCache("articleType");
        for (ArticleType articleType : articleTypes) {
            ArticleTypeResultDTO articleTypeResultDTO = new ArticleTypeResultDTO();
            BeanUtils.copyProperties(articleType, articleTypeResultDTO);
            articleTypeResultDTOS.add(articleTypeResultDTO);
            cache.put(articleType.getId(), articleTypeResultDTO);
        }
        return articleTypeResultDTOS;
    }
}
