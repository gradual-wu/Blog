package top.gradual.blog.domain.vo;

/**
 * @Description: 博文卡片式显示类
 * @Author: gradual
 * @Date: 2018-08-27 12:45
 */
public class ArticleCartVO {
    private String imgPath;
    private Long id;
    private String title;
    private String txt;
    private Long praise;

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

    public Long getPraise() {
        return praise;
    }

    public void setPraise(Long praise) {
        this.praise = praise;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "ArticleCartVO{" +
                "imgPath='" + imgPath + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", txt='" + txt + '\'' +
                ", praise=" + praise +
                '}';
    }
}
