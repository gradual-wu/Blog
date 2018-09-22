package top.gradual.blog;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.gradual.blog.domain.dto.DiscussInputDTO;
import top.gradual.blog.domain.dto.DiscussResultDTO;
import top.gradual.blog.service.ArticleDiscussService;

/**
 * @Description:
 * @Author: gradual
 * @Date: 2018-09-18 上午9:10
 */
public class ArticleDiscussServiceTest extends TestParent {

    @Autowired
    private ArticleDiscussService articleDiscussService;

    @Test
    public void testGet() {
        List<DiscussResultDTO> discuss = articleDiscussService.getDiscuss(204L);
        List<DiscussResultDTO> discuss2 = articleDiscussService.getDiscuss(203L);
        System.out.println(discuss);
        System.out.println(discuss2);
    }

    @Test
    public void testAdd() {
        DiscussInputDTO inputDTO = new DiscussInputDTO();
        inputDTO.setArticleId(203L);
        inputDTO.setCreateTime(new Date());
        inputDTO.setIp("127.0.0.1");
        inputDTO.setNikename("aaa");
        inputDTO.setText("bucuobucuo");
        System.out.println(articleDiscussService.addDiscuss(inputDTO));
    }
}
