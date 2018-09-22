package top.gradual.blog.domain.vo;

import com.github.pagehelper.PageInfo;

import top.gradual.blog.domain.dto.ArticleTypeResultDTO;

/**
 * @Description: 分类检索界面
 * @Author: gradual
 * @Date: 2018-09-07 16:25
 */
public class ListVO {
    private PageInfo<ArticleCartVO> pageInfo;
    private ArticleTypeResultDTO type;

    public ArticleTypeResultDTO getType() {
        return type;
    }

    public void setType(ArticleTypeResultDTO type) {
        this.type = type;
    }

    public PageInfo<ArticleCartVO> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<ArticleCartVO> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
