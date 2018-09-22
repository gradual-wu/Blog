package top.gradual.blog.domain.dto;

import java.io.Serializable;

/**
 * @Description: 留言返回对象
 * @Author: gradual
 * @Date: 2018-09-17 上午11:21
 */
public class DiscussResultDTO implements Serializable {
    private String nikename;
    private String createTime;
    private String text;

    public DiscussResultDTO(String nikename, String createTime, String text) {
        this.nikename = nikename;
        this.createTime = createTime;
        this.text = text;
    }

    public DiscussResultDTO() {}

    @Override
    public String toString() {
        return "DiscussResultDTO{" +
                "nikename='" + nikename + '\'' +
                ", createTime=" + createTime +
                ", text='" + text + '\'' +
                '}';
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
