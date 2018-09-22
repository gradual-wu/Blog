package top.gradual.blog.domain.entites;

import java.util.Date;

/**
 * @Description: 博客友情链接
 * @Author: gradual
 * @Date: 2018-09-19 下午7:52
 */
public class BlogLinks {
    private Long id;
    private Date gmtCreate;
    private Date gmtModified;
    private String href;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BlogLinks{" +
                "id=" + id +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", href='" + href + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
