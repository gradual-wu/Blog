package top.gradual.blog.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.gradual.blog.dao.mapper.TypeArticleNexusMapper;
import top.gradual.blog.domain.entites.TypeArticleNexus;
import top.gradual.blog.domain.entites.TypeArticleNexusExample;
import top.gradual.blog.domain.entites.TypeCount;
import top.gradual.blog.service.ArticleWithTypeNexusService;

/**
 * @Description: 博文和分类关联相关Service实现类
 * @Author: gradual
 * @Date: 2018-09-04 19:59
 */
@Service("articleWithTypeNexusService")
public class ArticleWithTypeNexusServiceImpl implements ArticleWithTypeNexusService {

    @Autowired
    private TypeArticleNexusMapper typeArticleNexusMapper;

    private Logger logger = LoggerFactory.getLogger(ArticleWithTypeNexusServiceImpl.class);

    /**
     * @description: 插入关联信息
     *
     * @author: gradual
     * @date: 2018/9/4 20:06
     * @param: [types, articleId]
     * @return: boolean
     */
    @Override
    @Transactional
    public boolean addNexus(Long[] types, Long articleId) {
        logger.debug("为博文ID为::" + articleId + "的博文添加分类ID::" + types);
        int count = 0;
        for (Long typeId : types) {
            TypeArticleNexus nexus = new TypeArticleNexus();
            nexus.setArticleId(articleId);
            nexus.setTypeId(typeId);
            nexus.setGmtCreate(new Date());
            nexus.setGmtModified(new Date());
            typeArticleNexusMapper.insert(nexus);
            count ++;
        }
        return count == types.length;
    }

    /**
     * @description: 通过博文ID获取分类Id数组
     *
     * @author: gradual
     * @date: 2018/9/4 20:26
     * @param: [id]
     * @return: java.lang.Long[] 包含分类ID的数组
     */
    @Override
    @Cacheable(cacheNames = "articleWithTypeNexus", key = "#id")
    public Long[] getNexusByArticleId(Long id) {
        logger.debug("获取博文Id为" + id + "的所有分类ID");
        TypeArticleNexusExample example = new TypeArticleNexusExample();
        TypeArticleNexusExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(id);
        List<TypeArticleNexus> typeArticleNexuses = typeArticleNexusMapper.selectByExample(example);
        Long types[] = new Long[typeArticleNexuses.size()];
        for (int i = 0 ; i < types.length ; i ++) {
            types[i] = typeArticleNexuses.get(i).getTypeId();
        }
        logger.debug("获取到分类ID" + types);
        return types;
    }

    @Override
    public List<TypeCount> getTypeCountList() {
        return typeArticleNexusMapper.countByType();
    }

    /**
     * @description: 根据分类ID获取博文ID
     *
     * @author: gradual
     * @date: 2018/9/7 11:04
     * @param: [id]
     * @return: java.lang.Long[]
     */
    @Override
    public Long[] getArticleIdByTypeId(long id) {
        TypeArticleNexusExample example = new TypeArticleNexusExample();
        TypeArticleNexusExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIdEqualTo(id);
        List<TypeArticleNexus> nexuses = typeArticleNexusMapper.selectByExample(example);
        Long articleIds[] = new Long[nexuses.size()];
        for (int i = 0 ; i < articleIds.length ; i ++) {
            articleIds[i] = nexuses.get(i).getArticleId();
        }
        return articleIds;
    }

    /**
     * @description: 根据博文ID删除博文分类关联信息
     *
     * @author: gradual
     * @date: 2018/9/21 下午3:25
     * @param: [id]
     * @return: boolean
     */
    @Override
    @CacheEvict(cacheNames = "articleWithTypeNexus", allEntries = true)
    public boolean deleteNexusByArticleId(Long id) {
        TypeArticleNexusExample example = new TypeArticleNexusExample();
        TypeArticleNexusExample.Criteria criteria = example.createCriteria();
        criteria.andArticleIdEqualTo(id);
        int i = typeArticleNexusMapper.deleteByExample(example);
        if (i > 0) {
            return true;
        }
        return false;
    }
}
