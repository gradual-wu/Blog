package top.gradual.blog.domain.dto;

import java.io.Serializable;

/**
 * @Description:
 * @Author: gradual
 * @Date: 2018-08-28 12:55
 */
public class ArticleTypeResultDTO implements Serializable {

    private long id;
    private String type;
    private String imgBase64;

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }

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
        return "ArticleTypeResultDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
