package top.gradual.blog;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.gradual.blog.dao.mapper.TypeArticleNexusMapper;
import top.gradual.blog.domain.entites.TypeCount;

/**
 * @Description: 主页测试类
 * @Author: gradual
 * @Date: 2018-09-06 12:52
 */
public class IndexTest extends TestParent {

    @Autowired
    private TypeArticleNexusMapper typeArticleNexusMapper;

    @Test
    public void testTypeCount() {
        List<TypeCount> typeCounts = typeArticleNexusMapper.countByType();
        System.out.println(typeCounts);
    }

}
