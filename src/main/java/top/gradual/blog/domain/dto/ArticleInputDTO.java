package top.gradual.blog.domain.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description: 博文DTO
 * @Author: gradual
 * @Date: 2018-08-27 12:15
 */
public class ArticleInputDTO implements Serializable {
    private Long id;
    private String html;
    private String text;
    private Date createTime = new Date();
    private Long typeId[];
    private Long userId;
    private String title;

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

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Long[] getTypeId() {
        return typeId;
    }

    public void setTypeId(Long[] typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ArticleInputDTO{" +
                "html='" + html + '\'' +
                ", text='" + text + '\'' +
                ", createTime=" + createTime +
                ", typeId=" + Arrays.toString(typeId) +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                '}';
    }
}