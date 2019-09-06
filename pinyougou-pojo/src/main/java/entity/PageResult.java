package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @类名: PageResult
 * @描述:
 * @作者: 郭廷俊
 * @时间: 2019-09-03 20:21
 **/
public class PageResult implements Serializable {

    private long total; //总记录数

    private List rows; //当前页结果

    private Integer pageSize;

    private Integer pageNum;

    private long totalPage;

    public PageResult() {
    }

    public PageResult(long total, List rows, Integer pageNum,Integer pageSize,  long totalPage) {
        this.total = total;
        this.rows = rows;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.totalPage = totalPage;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", totalPage=" + totalPage +
                '}';
    }
}
