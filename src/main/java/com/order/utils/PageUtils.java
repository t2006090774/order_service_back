package com.order.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;

/**
 * @program: order-service
 * @description:
 * @author: jax
 * * @create: 2019-09-02 14:46
 **/
public class PageUtils {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 10;

    public static PageRequest buildPageRequest(Integer pageNumber, Integer pageSize){
        pageNumber = StringUtils.isEmpty(pageNumber)?DEFAULT_PAGE_NUMBER:pageNumber;
        pageSize = StringUtils.isEmpty(pageSize)?DEFAULT_PAGE_SIZE:pageSize;
        return PageRequest.of(pageNumber,pageSize);
    }

}
