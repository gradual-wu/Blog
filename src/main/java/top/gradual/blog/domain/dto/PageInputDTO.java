package top.gradual.blog.domain.dto;

import java.io.Serializable;

/**
 * @Description: 用户需要分页信息
 * @Author: gradual
 * @Date: 2018-09-05 19:11
 */
public class PageInputDTO implements Serializable {
    private int pageNum = 1;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "PageInputDTO{" +
                "pageNum=" + pageNum +
                '}';
    }
}
