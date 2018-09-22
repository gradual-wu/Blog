package top.gradual.blog.service;

import java.util.List;

import top.gradual.blog.domain.dto.ArticleTypeInputDTO;
import top.gradual.blog.domain.dto.ArticleTypeResultDTO;

/**
 * @Description: 博文分类Service接口
 * @Author: gradual
 * @Date: 2018-08-28 10:08
 */
public interface ArticleTypeService {
    /**
     * 添加分类
     * */
    ArticleTypeResultDTO addArticleType(ArticleTypeInputDTO articleTypeInputDTO);

    /**
     * 通过Id获取分类
     * */
    ArticleTypeResultDTO getArticleTypeById(long id);

    /**
     * 获取所有分类
     * */
    List<ArticleTypeResultDTO> getArticleTypeAll();

    /**
     * 通过分类名获取分类实例
     * */
    ArticleTypeResultDTO getArticleTypeByTypeName(String type);

}
