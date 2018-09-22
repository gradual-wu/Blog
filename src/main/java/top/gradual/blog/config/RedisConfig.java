package top.gradual.blog.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import top.gradual.blog.domain.dto.ArticleResultDTO;
import top.gradual.blog.domain.dto.ArticleTypeResultDTO;
import top.gradual.blog.domain.dto.DiscussResultDTO;
import top.gradual.blog.domain.dto.UserInfoResultDTO;

/**
 * @Description: Redis配置类
 * @Author: gradual
 * @Date: 2018-09-03 16:14
 */
@Configuration
public class RedisConfig {

    /**
     * @description: 用户信息返回缓存模板
     *
     * @author: gradual
     * @date: 2018/9/17 下午10:09
     * @param: [redisConnectionFactory]
     * @return: org.springframework.data.redis.core.RedisTemplate<java.lang.Object,top.gradual.blog.domain.dto.UserInfoResultDTO>
     */
    @Bean
    public RedisTemplate<Object, UserInfoResultDTO> userRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, UserInfoResultDTO> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(UserInfoResultDTO.class));
        return template;
    }

    /**
     * @description: 用户留言类返回缓存模板
     *
     * @author: gradual
     * @date: 2018/9/17 下午10:11
     * @param: [redisConnectionFactory]
     * @return: org.springframework.data.redis.core.RedisTemplate<java.lang.Object,top.gradual.blog.domain.dto.DiscussResultDTO>
     */
    @Bean
    public RedisTemplate<Object, DiscussResultDTO> discussRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, DiscussResultDTO> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(DiscussResultDTO.class));
        return template;
    }

    /**
     * @description: 文章缓存模板
     *
     * @author: gradual
     * @date: 2018/9/17 下午10:11
     * @param: [redisConnectionFactory]
     * @return: org.springframework.data.redis.core.RedisTemplate<java.lang.Object,top.gradual.blog.domain.dto.ArticleResultDTO>
     */
    @Bean
    public RedisTemplate<Object, ArticleResultDTO> articleRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, ArticleResultDTO> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(ArticleResultDTO.class));
        return template;
    }

    /**
     * @description: 文章分类缓存模板
     *
     * @author: gradual
     * @date: 2018/9/17 下午10:12
     * @param: [redisConnectionFactory]
     * @return: org.springframework.data.redis.core.RedisTemplate<java.lang.Object,top.gradual.blog.domain.dto.ArticleTypeResultDTO>
     */
    @Bean
    public RedisTemplate<Object, ArticleTypeResultDTO> articleTypeRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, ArticleTypeResultDTO> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(ArticleTypeResultDTO.class));
        return template;
    }

    /**
     * @description: 默认缓存管理器
     *
     * @author: gradual
     * @date: 2018/9/17 下午10:12
     * @param: [redisTemplate]
     * @return: org.springframework.data.redis.cache.RedisCacheManager
     */
    @Primary
    @Bean
    public RedisCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate) {
        Jackson2JsonRedisSerializer<Object> redisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setUsePrefix(true);
        return  cacheManager;
    }

    /**
     * @description: 留言缓存管理器
     *
     * @author: gradual
     * @date: 2018/9/17 下午10:13
     * @param: [discussRedisTemplate]
     * @return: org.springframework.data.redis.cache.RedisCacheManager
     */
    @Bean
    public RedisCacheManager discussCacheManager(RedisTemplate<Object, DiscussResultDTO> discussRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(discussRedisTemplate);
        cacheManager.setUsePrefix(true);
        return  cacheManager;
    }

    /**
     * @description: 用户信息缓存管理器
     *
     * @author: gradual
     * @date: 2018/9/17 下午10:13
     * @param: [userRedisTemplate]
     * @return: org.springframework.data.redis.cache.RedisCacheManager
     */
    @Bean
    public RedisCacheManager userCacheManager(RedisTemplate<Object, UserInfoResultDTO> userRedisTemplate) {

        RedisCacheManager cacheManager = new RedisCacheManager(userRedisTemplate);
        cacheManager.setUsePrefix(true);
        return  cacheManager;
    }

    /**
     * @description: 文章分类缓存管理器
     *
     * @author: gradual
     * @date: 2018/9/17 下午10:14
     * @param: [articleTypeRedisTemplate]
     * @return: org.springframework.data.redis.cache.RedisCacheManager
     */
    @Bean
    public RedisCacheManager articleTypeCacheManager(RedisTemplate<Object, ArticleTypeResultDTO> articleTypeRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(articleTypeRedisTemplate);
        cacheManager.setUsePrefix(true);
        return  cacheManager;
    }

    /**
     * @description: 文章缓存管理器
     *
     * @author: gradual
     * @date: 2018/9/17 下午10:14
     * @param: [articleRedisTemplate]
     * @return: org.springframework.data.redis.cache.RedisCacheManager
     */
    @Bean
    public RedisCacheManager articleCacheManager(RedisTemplate<Object, ArticleResultDTO> articleRedisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(articleRedisTemplate);
        cacheManager.setUsePrefix(true);
        return  cacheManager;
    }

}
