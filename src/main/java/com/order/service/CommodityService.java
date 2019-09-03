package com.order.service;

import com.order.bean.Commodity;
import com.order.bean.CommodityType;
import org.springframework.data.domain.Page;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

public interface CommodityService {

    /**
     * 商品列表
     * @param commodity
     * @return
     */
     Page<Commodity> getCommodityList(Commodity commodity);


    /**
     * 保存商品
     * @param commodity
     * @return
     */
    Commodity save(Commodity commodity);

    /**
     * 保存商品
     * @param shopId
     * @return
     */
    List<CommodityType> getCommodityType(Integer shopId);

}
