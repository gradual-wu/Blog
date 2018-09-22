package top.gradual.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.gradual.blog.domain.dto.DiscussInputDTO;
import top.gradual.blog.domain.dto.DiscussResultDTO;
import top.gradual.blog.service.ArticleDiscussService;

/**
 * @Description: 留言控制器
 * @Author: gradual
 * @Date: 2018-09-18 下午8:57
 */
@RestController
public class DiscussController {

    @Autowired
    private ArticleDiscussService articleDiscussService;

    private Logger logger = LoggerFactory.getLogger(DiscussController.class);

    @PostMapping("/discuss")
    public Object addDiscuss(DiscussInputDTO inputDTO, HttpServletRequest request) {
        logger.debug("接收到留言表单信息：：" + inputDTO);
        Map<String, Object> result = new HashMap<>();
        String ip = request.getRemoteAddr();
        logger.debug("获取到IP地址：" + ip);
        inputDTO.setIp(ip);
        logger.debug("添加留言");
        DiscussResultDTO resultDTO = articleDiscussService.addDiscuss(inputDTO);
        if (resultDTO != null) {
            result.put("flag", true);
            result.put("message", "发布留言成功！");
            result.put("result", resultDTO);
        } else {
            result.put("flag", false);
            result.put("message", "发布留言失败！");
        }
        return result;
    }
}
