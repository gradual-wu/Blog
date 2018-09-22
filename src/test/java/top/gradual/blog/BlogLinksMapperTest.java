package top.gradual.blog;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.gradual.blog.dao.mapper.BlogLinksMapper;
import top.gradual.blog.domain.entites.BlogLinks;

/**
 * @Description:
 * @Author: gradual
 * @Date: 2018-09-20 上午8:56
 */
public class BlogLinksMapperTest extends TestParent {

    @Autowired
    private BlogLinksMapper blogLinksMapper;

    @Test
    public void testInsert() {
        BlogLinks links = new BlogLinks();
        links.setGmtCreate(new Date());
        links.setGmtModified(new Date());
        links.setHref("www.baidu.com");
        links.setTitle("百度");
        blogLinksMapper.insertSelective(links);
        System.out.println(links);
    }

    @Test
    public void testUpdate() {
        BlogLinks links = new BlogLinks();
        links.setHref("www.baibaibai.com");
        links.setId(3L);
        System.out.println(blogLinksMapper.updateByPrimaryKey(links));
    }

    @Test
    public void delete() {
        System.out.println(blogLinksMapper.deleteByPrimaryKey(3L));
    }

    @Test
    public void get() {
        System.out.println(blogLinksMapper.selectAllLinks());
    }
}
