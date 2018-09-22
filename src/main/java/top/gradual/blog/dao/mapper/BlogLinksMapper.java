package top.gradual.blog.dao.mapper;

import java.util.List;

import top.gradual.blog.domain.entites.BlogLinks;

/**
 * @Description:
 * @Author: gradual
 * @Date: 2018-09-19 下午6:00
 */
public interface BlogLinksMapper {

    List<BlogLinks> selectAllLinks();

    int updateByPrimaryKey(BlogLinks links);

    int deleteByPrimaryKey(Long id);

    int insertSelective(BlogLinks links);
}
