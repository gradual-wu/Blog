package top.gradual.blog.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import top.gradual.blog.domain.entites.BlogArticle;
import top.gradual.blog.domain.entites.BlogArticleExample;
import top.gradual.blog.domain.entites.BlogArticleWithBLOBs;
import top.gradual.blog.domain.vo.ArticleCartVO;

public interface BlogArticleMapper {
    long countByExample(BlogArticleExample example);

    int deleteByExample(BlogArticleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BlogArticleWithBLOBs record);

    int insertSelective(BlogArticleWithBLOBs record);

    List<BlogArticleWithBLOBs> selectByExampleWithBLOBs(BlogArticleExample example);

    List<BlogArticle> selectByExample(BlogArticleExample example);

    BlogArticleWithBLOBs selectByPrimaryKey(Long id);

    List<ArticleCartVO> selectToListByUserId(Long id);

    int updateByExampleSelective(@Param("record") BlogArticleWithBLOBs record, @Param("example") BlogArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogArticleWithBLOBs record, @Param("example") BlogArticleExample example);

    int updateByExample(@Param("record") BlogArticle record, @Param("example") BlogArticleExample example);

    int updateByPrimaryKeySelective(BlogArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BlogArticleWithBLOBs record);

    int updateByPrimaryKey(BlogArticle record);

    List<ArticleCartVO> selectArtilceListByIds(Long ids[]);

    List<BlogArticle> selectArticleByPraise();
}