package com.sdust.entity;

import lombok.Data;

@Data
public class PageEntity {
	private Integer currentPage;
    private Integer startPage;
    private Integer pageSize;


    public Integer getCurrentPage() {
        currentPage=currentPage==null?1:currentPage;
        return currentPage;
    }

    public Integer getStartPage() {
        startPage=startPage==null?0:startPage;
        return startPage;
    }

    public Integer getPageSize() {
        pageSize=pageSize==null?10:pageSize;
        return pageSize;
    }
}
