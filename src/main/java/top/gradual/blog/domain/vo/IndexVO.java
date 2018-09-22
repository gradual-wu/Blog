package top.gradual.blog.domain.vo;

import com.github.pagehelper.PageInfo;

/**
 * @Description: 主页所需数据类
 * @Author: gradual
 * @Date: 2018-09-05 19:15
 */
public class IndexVO {
    /**
     * 分页
     * */
    PageInfo<ArticleCartVO> pageInfo;

    public PageInfo<ArticleCartVO> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<ArticleCartVO> pageInfo) {
        this.pageInfo = pageInfo;
    }

}
