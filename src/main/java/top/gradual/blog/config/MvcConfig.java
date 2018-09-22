package top.gradual.blog.config;

import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import top.gradual.blog.component.CheckUserLoginInterceptor;
import top.gradual.blog.component.MyServletContextListener;
import top.gradual.blog.service.ArticleService;
import top.gradual.blog.service.ArticleWithTypeNexusService;
import top.gradual.blog.service.BlogLinksService;

/**
 * @Description: Spring MVC配置类
 * @Author: gradual
 * @Date: 2018-09-03 10:47
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(MvcConfig.class);

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/message").setViewName("message");
        registry.addViewController("/about.html").setViewName("about");
        super.addViewControllers(registry);
    }

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> addServletContextListener(ArticleWithTypeNexusService articleWithTypeNexusService, ArticleService articleService, BlogLinksService blogLinksService) {
        logger.debug("注册ServletContext监听器");
        return new ServletListenerRegistrationBean<>(new MyServletContextListener(articleWithTypeNexusService, articleService, blogLinksService));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        logger.debug("添加登录权限拦截器");
        CheckUserLoginInterceptor check = new CheckUserLoginInterceptor();
        registry.addInterceptor(check)
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/article/type/*", "/uploadImg", "/article-*.html", "/error", "/login.html", "/login", "/discuss", "/praise", "/about.html");

    }

}
