package top.gradual.blog.component;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.gradual.blog.domain.dto.UserInfoResultDTO;
import top.gradual.blog.util.JackJsonUtils;
import top.gradual.blog.util.JsonUtil;

/**
 * @Description: 用户登录权限拦截器
 * @Author: gradual
 * @Date: 2018-09-10 9:54
 */
public class CheckUserLoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(CheckUserLoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("用户访问：" + request.getRequestURI());
        JsonUtil jsonUtil = new JackJsonUtils();
        UserInfoResultDTO user = (UserInfoResultDTO) request.getSession().getAttribute("user");
        if (user == null || user.getRole() != 1) {
            logger.debug("用户未登录,构建返回信息");
            Map<String, String> map = new LinkedHashMap<>();
            map.put("message", "您当前没有登录,无法进行此操作,将为你跳转到登录界面!");
            map.put("url", request.getContextPath() + "/login.html");
            logger.debug("准备跳转,判断用户请求方式");
            if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
                logger.debug("当前为ajax请求");
                map.put("flag", "true");
                String json = jsonUtil.mapToJson(map);
                response.getWriter().write(json);
            } else {
                logger.debug("当前为普通请求");
                request.setAttribute("map", map);
                response.sendRedirect("/login.html");
            }
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
