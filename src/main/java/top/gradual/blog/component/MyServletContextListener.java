package top.gradual.blog.component;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import top.gradual.blog.domain.dto.ArticlePraiseItem;
import top.gradual.blog.domain.dto.LinksDTO;
import top.gradual.blog.domain.entites.TypeCount;
import top.gradual.blog.service.ArticleService;
import top.gradual.blog.service.ArticleWithTypeNexusService;
import top.gradual.blog.service.BlogLinksService;

/**
 * @Description: 自定义ServletContext监视器
 * @Author: gradual
 * @Date: 2018-09-06 15:35
 */
public class MyServletContextListener implements ServletContextListener {

    private ArticleWithTypeNexusService articleWithTypeNexusService;

    private ArticleService articleService;

    private BlogLinksService blogLinksService;

    private Logger logger = LoggerFactory.getLogger(MyServletContextListener.class);


    @Autowired
    public MyServletContextListener(ArticleWithTypeNexusService articleWithTypeNexusService, ArticleService articleService, BlogLinksService blogLinksService) {
        logger.debug("初始化服务层接口");
        this.articleWithTypeNexusService = articleWithTypeNexusService;
        this.articleService = articleService;
        this.blogLinksService = blogLinksService;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.debug("项目启动,初始化数据....");
        logger.debug("初始化分类信息");
        List<TypeCount> typeCounts = articleWithTypeNexusService.getTypeCountList();
        logger.debug("初始化点赞排行信息");
        List<ArticlePraiseItem> praiseItems = articleService.getArticleByPraise();
        logger.debug("初始化友链信息");
        List<LinksDTO> links = blogLinksService.getAllLinks();

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("typeCounts", typeCounts);
        servletContext.setAttribute("praiseItems", praiseItems);
        servletContext.setAttribute("links", links);

        logger.debug("加入分类信息 [typeCounts]-->>" + typeCounts);
        logger.debug("加入点赞排行 [praiseItems]-->>" + praiseItems);
        logger.debug("加入友链信息 [links]-->>" + links);
        logger.debug("初始化完成！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug("项目停止");
    }
}
