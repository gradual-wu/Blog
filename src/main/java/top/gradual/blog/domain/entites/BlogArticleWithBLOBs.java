package top.gradual.blog.domain.entites;

public class BlogArticleWithBLOBs extends BlogArticle {
    private String html;

    private String txt;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt == null ? null : txt.trim();
    }
}