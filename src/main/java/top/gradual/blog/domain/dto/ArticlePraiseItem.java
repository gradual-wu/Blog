package top.gradual.blog.domain.dto;

import java.io.Serializable;

/**
 * @Description: 文章点赞排行项
 * @Author: gradual
 * @Date: 2018-09-19 下午2:48
 */
public class ArticlePraiseItem implements Serializable {
    private Long id;
    private String title;

    public ArticlePraiseItem() {}

    public ArticlePraiseItem(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ArticlePraiseItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
