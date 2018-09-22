package top.gradual.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.gradual.blog.domain.dto.ArticleTypeInputDTO;
import top.gradual.blog.domain.dto.ArticleTypeResultDTO;
import top.gradual.blog.domain.dto.UserInfoResultDTO;
import top.gradual.blog.service.ArticleTypeService;

/**
 * @Description: 博文分类Controller
 * @Author: gradual
 * @Date: 2018-08-28 15:23
 */
@RestController
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    @PostMapping("/addArticleType")
    public Map<String, Object> addArticleType(ArticleTypeInputDTO articleTypeInputDTO, HttpSession session) {
        ArticleTypeResultDTO articleTypeResultDTO = articleTypeService.getArticleTypeByTypeName(articleTypeInputDTO.getType());
        Map<String, Object> map = new HashMap<>();
        if (articleTypeResultDTO != null) {
            map.put("flag", false);
            map.put("message", "该类型已经存在！");
            return map;
        }
        UserInfoResultDTO user = (UserInfoResultDTO) session.getAttribute("user");
        articleTypeInputDTO.setId(user.getId());
        ArticleTypeResultDTO articleTypeResultDTO1 = articleTypeService.addArticleType(articleTypeInputDTO);
        map.put("flag", true);
        map.put("message", "该类型成功添加");
        map.put("id", articleTypeResultDTO1.getId());
        return map;
    }

}
