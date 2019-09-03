package com.order.bean;

/**
 * @program: order-service
 * @description:
 * @author: jax
 * * @create: 2019-08-30 14:43
 **/

public class Page {

    private Integer pageNum;
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
