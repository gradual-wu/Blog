package top.gradual.blog.component;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.gradual.blog.domain.dto.ArticlePraiseItem;
import top.gradual.blog.domain.dto.LinksDTO;
import top.gradual.blog.domain.entites.TypeCount;
import top.gradual.blog.service.ArticleService;
import top.gradual.blog.service.ArticleWithTypeNexusService;
import top.gradual.blog.service.BlogLinksService;

/**
 * @Description: 重新加载 定时器
 * @Author: gradual
 * @Date: 2018-09-19 下午2:23
 */
@Component
public class ReloadTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleWithTypeNexusService articleWithTypeNexusService;

    @Autowired
    private BlogLinksService blogLinksService;

    @Autowired
    private ServletContext context;

    private Logger logger = LoggerFactory.getLogger(ReloadTask.class);

    /**
     * @description: 刷新ServletContext容器中的分类和点赞排行(十分钟刷新一次)
     *
     * @author: gradual
     * @date: 2018/9/19 下午3:00
     * @param: []
     * @return: void
     */
    @Scheduled(fixedRate = 1000 * 60 * 10)
    public void reloadServletContext() {
        logger.debug("开始刷新全局信息");

        logger.debug("获取分类信息");
        List<TypeCount> typeCounts = articleWithTypeNexusService.getTypeCountList();
        logger.debug("获取点赞排行信息");
        List<ArticlePraiseItem> praiseItems = articleService.getArticleByPraise();
        logger.debug("获取友链信息");
        List<LinksDTO> links = blogLinksService.getAllLinks();

        context.setAttribute("typeCounts", typeCounts);
        context.setAttribute("praiseItems", praiseItems);
        context.setAttribute("links", links);

        logger.debug("刷新分类信息 [typeCounts]-->>" + typeCounts);
        logger.debug("刷新点赞排行 [praiseItems]-->>" + praiseItems);
        logger.debug("刷新友链信息 [links]-->>" + links);
    }
}
