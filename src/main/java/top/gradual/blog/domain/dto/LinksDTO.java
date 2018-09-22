package top.gradual.blog.domain.dto;

import java.io.Serializable;

/**
 * @Description: 链接
 * @Author: gradual
 * @Date: 2018-09-20 上午9:03
 */
public class LinksDTO implements Serializable {
    private Long id;
    private String title;
    private String href;

    public LinksDTO() {}

    public LinksDTO(Long id, String title, String href) {
        this.id = id;
        this.title = title;
        this.href = href;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "LinksDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
