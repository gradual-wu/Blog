package top.gradual.blog;

import java.util.List;

import com.github.pagehelper.PageInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.gradual.blog.dao.mapper.BlogArticleMapper;
import top.gradual.blog.domain.dto.ArticleInputDTO;
import top.gradual.blog.domain.dto.ArticleResultDTO;
import top.gradual.blog.domain.vo.ArticleCartVO;
import top.gradual.blog.service.ArticleService;
import top.gradual.blog.service.ArticleTypeService;

/**
 * @Description: 博文相关服务层测试类
 * @Author: gradual
 * @Date: 2018-09-04 20:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleTypeService articleTypeService;

    @Autowired
    private BlogArticleMapper blogArticleMapper;

    @Test
    public void testDeleteArticle() {
        boolean b = articleService.deleteArticle(143L);
        System.out.println(b);
    }

    @Test
    public void testServiceGetArticleByIds() {
        PageInfo<ArticleCartVO> pageInfo = articleService.getArticleListByTypeId(4, 1);
        System.out.println(pageInfo);
    }

    @Test
    public void testGetArticleByIds() {
        List<ArticleCartVO> carts = blogArticleMapper.selectArtilceListByIds(new Long[]{71L, 62L});
        System.out.println(carts);
    }


    @Test
    public void testInsert() {
        for (int i = 0 ; i < 60 ; i ++) {
            ArticleInputDTO inputDTO = new ArticleInputDTO();
            inputDTO.setHtml("Gradual个人博客 测试 HTML<br>" + i);
            inputDTO.setText("Gradual个人博客 测试 TEXT" + i);
            long m = (long) (Math.random() * 5) + 1;
            long n = (long) (Math.random() * 5) + 1;
            inputDTO.setTypeId(new Long[]{m, n});
            inputDTO.setUserId(1L);
            inputDTO.setTitle("Gradual个人博客.测试" + i);
            ArticleResultDTO resultDTO = articleService.addArticle(inputDTO);
            System.out.println(resultDTO);
        }
    }

    @Test
    public void testGet() {
        articleService.getArticleById(1);
        articleService.getArticleById(2);
        articleService.getArticleById(3);
        articleService.getArticleById(4);
        articleService.getArticleById(5);
        articleService.getArticleById(6);
        articleService.getArticleById(7);
    }

    @Test
    public void testGetTypeAll() {
        System.out.println(articleTypeService.getArticleTypeAll());
    }
    @Test
    public void testGetTypeById() {
        System.out.println(articleTypeService.getArticleTypeById(1));
        System.out.println(articleTypeService.getArticleTypeById(2));
        System.out.println(articleTypeService.getArticleTypeById(3));
        System.out.println(articleTypeService.getArticleTypeById(9));
        System.out.println(articleTypeService.getArticleTypeById(10));
    }

    @Test
    public void pageHelper() {
        PageInfo<ArticleCartVO> articleByUser = articleService.getArticleByUser(1, 2);
        for (ArticleCartVO cartVO : articleByUser.getList()) {
            System.out.println(cartVO);
        }
        System.out.println(articleByUser);
    }

}
