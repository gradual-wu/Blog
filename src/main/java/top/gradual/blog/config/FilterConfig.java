package top.gradual.blog.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.druid.support.http.WebStatFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * @Description: 过滤器配置类
 * @Author: gradual
 * @Date: 2018-09-03 10:28
 */
@Configuration
public class FilterConfig {

    /**
     * druid监控过滤器
     * */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js, *.css, /druid/*, *.jpg, *.png, *.ico, *.html, *.gif");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Collections.singletonList("/*"));
        return bean;
    }

    /**
     * @description: 添加乱码过滤器
     *
     * @author: gradual
     * @date: 2018/9/12 下午3:45
     * @param: []
     * @return: org.springframework.boot.web.servlet.FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean characterEncodingFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setForceEncoding(true);
        encodingFilter.setEncoding("UTF-8");
        bean.setFilter(encodingFilter);
        return bean;
    }
}
