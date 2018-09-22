package top.gradual.blog.domain.vo;

import java.util.List;

import top.gradual.blog.domain.dto.ArticleResultDTO;
import top.gradual.blog.domain.dto.DiscussResultDTO;

/**
 * @Description: 博客界面显示类
 * @Author: gradual
 * @Date: 2018-08-27 12:43
 */
public class ArticleVO {
    private ArticleResultDTO article;
    private List<DiscussResultDTO> discusses;

    public List<DiscussResultDTO> getDiscusses() {
        return discusses;
    }

    public void setDiscusses(List<DiscussResultDTO> discusses) {
        this.discusses = discusses;
    }

    public ArticleResultDTO getArticle() {
        return article;
    }

    public void setArticle(ArticleResultDTO article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "ArticleVO{" +
                "article=" + article +
                '}';
    }
}
