package top.gradual.blog.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.gradual.blog.domain.entites.TypeArticleNexus;
import top.gradual.blog.domain.entites.TypeArticleNexusExample;
import top.gradual.blog.domain.entites.TypeCount;

public interface TypeArticleNexusMapper {
    long countByExample(TypeArticleNexusExample example);

    int deleteByExample(TypeArticleNexusExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TypeArticleNexus record);

    int insertSelective(TypeArticleNexus record);

    List<TypeArticleNexus> selectByExample(TypeArticleNexusExample example);

    TypeArticleNexus selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TypeArticleNexus record, @Param("example") TypeArticleNexusExample example);

    int updateByExample(@Param("record") TypeArticleNexus record, @Param("example") TypeArticleNexusExample example);

    int updateByPrimaryKeySelective(TypeArticleNexus record);

    int updateByPrimaryKey(TypeArticleNexus record);

    List<TypeCount> countByType();
}