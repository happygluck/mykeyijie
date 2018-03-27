package com.keyijie.common.restful;

import java.io.Serializable;
import java.util.List;

/**
 * Restful实体（带分页）
 */
public class RestPageBody<T> implements Serializable {
    private int code;
    private String message;
    private List<T> data;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long totalElements;

    public RestPageBody() {
    }

    public RestPageBody(int code, String message, int pageNumber, int pageSize) {
        this.code = code;
        this.message = message;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public RestPageBody(int code, List<T> data, int pageNumber, int pageSize, int totalPages, long totalElements) {
        this.code = code;
        this.data = data;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}
