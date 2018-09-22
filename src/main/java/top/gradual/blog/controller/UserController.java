package top.gradual.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.gradual.blog.domain.dto.UserInfoInputDTO;
import top.gradual.blog.domain.dto.UserInfoResultDTO;
import top.gradual.blog.service.UserService;

/**
 * @Description: 用户控制层
 * @Author: gradual
 * @Date: 2018-08-26 16:53
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/login.html")
    public String tologinView() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Object userLogin(UserInfoInputDTO infoInputDTO, HttpSession session) {
        logger.debug("用户登录数据" + infoInputDTO);
        UserInfoResultDTO resultDTO = userService.userLogin(infoInputDTO);
        logger.debug("组织返回JSON对象");
        Map<String, Object> result = new HashMap<>();
        if (resultDTO != null) {
            session.setAttribute("user", resultDTO);
            result.put("message", "登录成功，为您跳转到主页！");
            result.put("flag", true);
        } else {
            result.put("message", "用户名或密码不存在");
            result.put("flag", false);
        }
        return result;
    }
}
