package top.gradual.blog.domain.vo;

import java.util.List;
import java.util.Map;

import top.gradual.blog.domain.dto.ArticleResultDTO;

/**
 * @Description: 编辑界面显示对象
 * @Author: gradual
 * @Date: 2018-08-28 15:45
 */
public class EditVO {
    private Map<String, Long> articleTypes;
    private ArticleResultDTO article;
    private List<Long> typeIds;

    public List<Long> getTypeIds() {
        return typeIds;
    }

    public void setTypeIds(List<Long> typeIds) {
        this.typeIds = typeIds;
    }

    public ArticleResultDTO getArticle() {
        return article;
    }

    public void setArticle(ArticleResultDTO article) {
        this.article = article;
    }

    public Map<String, Long> getArticleTypes() {
        return articleTypes;
    }

    public void setArticleTypes(Map<String, Long> articleTypes) {
        this.articleTypes = articleTypes;
    }

    @Override
    public String toString() {
        return "EditVO{" +
                "articleTypes=" + articleTypes +
                '}';
    }
}
