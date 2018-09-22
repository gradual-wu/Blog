package top.gradual.blog.domain.dto;

import java.io.Serializable;

/**
 * @Description: 博文分类输入DTO对象
 * @Author: gradual
 * @Date: 2018-08-28 10:16
 */
public class ArticleTypeInputDTO implements Serializable {
    /**
     * 用户ID
     * */
    private long id;

    /**
     * 自定义类型
     * */
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ArticleTypeInputDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
