package top.gradual.blog.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.gradual.blog.domain.entites.ArticleDiscuss;
import top.gradual.blog.domain.entites.ArticleDiscussExample;

public interface ArticleDiscussMapper {
    long countByExample(ArticleDiscussExample example);

    int deleteByExample(ArticleDiscussExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleDiscuss record);

    int insertSelective(ArticleDiscuss record);

    List<ArticleDiscuss> selectByExample(ArticleDiscussExample example);

    ArticleDiscuss selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleDiscuss record, @Param("example") ArticleDiscussExample example);

    int updateByExample(@Param("record") ArticleDiscuss record, @Param("example") ArticleDiscussExample example);

    int updateByPrimaryKeySelective(ArticleDiscuss record);

    int updateByPrimaryKey(ArticleDiscuss record);
}