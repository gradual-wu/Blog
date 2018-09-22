package top.gradual.blog.service;

import java.util.List;

import top.gradual.blog.domain.entites.TypeCount;

/**
 * @Description: 博文和分类关联相关Service接口
 * @Author: gradual
 * @Date: 2018-09-04 19:56
 */
public interface ArticleWithTypeNexusService {

    boolean addNexus(Long types[], Long articleId);

    Long[] getNexusByArticleId(Long id);

    List<TypeCount> getTypeCountList();

    Long[] getArticleIdByTypeId(long id);

    boolean deleteNexusByArticleId(Long id);
}
