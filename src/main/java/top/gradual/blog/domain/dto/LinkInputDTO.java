package top.gradual.blog.domain.dto;

/**
 * @Description: 输入Link对象
 * @Author: gradual
 * @Date: 2018-09-20 上午9:11
 */
public class LinkInputDTO {
    private Long id;
    private String title;
    private String href;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LinkInputDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                '}';
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
}
