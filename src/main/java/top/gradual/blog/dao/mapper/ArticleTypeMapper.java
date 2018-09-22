package top.gradual.blog.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.gradual.blog.domain.entites.ArticleType;
import top.gradual.blog.domain.entites.ArticleTypeExample;

public interface ArticleTypeMapper {
    long countByExample(ArticleTypeExample example);

    int deleteByExample(ArticleTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    List<ArticleType> selectByExample(ArticleTypeExample example);

    ArticleType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByExample(@Param("record") ArticleType record, @Param("example") ArticleTypeExample example);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);
}