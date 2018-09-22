package top.gradual.blog.domain.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 返回的博客数据对象
 * @Author: gradual
 * @Date: 2018-08-27 12:44
 */
public class ArticleResultDTO {
    private Long id;
    private String title;
    private String txt;
    private String html;
    private List<ArticleTypeResultDTO> types = new ArrayList<>();
    private Long userId;
    private Long praise;
    private String createTime;
    private List<DiscussResultDTO> discusses;


    public List<DiscussResultDTO> getDiscusses() {
        return discusses;
    }

    public void setDiscusses(List<DiscussResultDTO> discusses) {
        this.discusses = discusses;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public List<ArticleTypeResultDTO> getTypes() {
        return types;
    }

    public void setTypes(List<ArticleTypeResultDTO> types) {
        this.types = types;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPraise() {
        return praise;
    }

    public void setPraise(Long praise) {
        this.praise = praise;
    }

    @Override
    public String toString() {
        return "ArticleResultDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", txt='" + txt + '\'' +
                ", html='" + html + '\'' +
                ", types=" + types +
                ", userId=" + userId +
                ", praise=" + praise +
                '}';
    }
}
