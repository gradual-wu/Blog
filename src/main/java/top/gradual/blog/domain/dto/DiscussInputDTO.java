package top.gradual.blog.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: gradual
 * @Date: 2018-09-17 上午11:12
 */
public class DiscussInputDTO implements Serializable {
    private String ip;
    private Long articleId;
    private String nikename;
    private String text;
    private Date createTime = new Date();

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
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
        return "DiscussInputDTO{" +
                "ip='" + ip + '\'' +
                ", articleId=" + articleId +
                ", nikename='" + nikename + '\'' +
                ", text='" + text + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
