package top.gradual.blog.service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import top.gradual.blog.domain.dto.ArticleInputDTO;
import top.gradual.blog.domain.dto.ArticlePraiseItem;
import top.gradual.blog.domain.dto.ArticleResultDTO;
import top.gradual.blog.domain.vo.ArticleCartVO;

/**
 * @Description: 博文类服务层接口
 * @Author: gradual
 * @Date: 2018-08-27 12:11
 */
public interface ArticleService {

    ArticleResultDTO addArticle(ArticleInputDTO article);

    ArticleResultDTO getArticleById(long id);

    PageInfo<ArticleCartVO> getArticleByUser(long id, int pageNum);

    PageInfo<ArticleCartVO> getArticleListByTypeId(long id, int pageNum);

    ArticleResultDTO addPraise(Long id);

    List<ArticlePraiseItem> getArticleByPraise();

    ArticleResultDTO updateArticle(ArticleInputDTO inputDTO);

    boolean deleteArticle(Long id);
}