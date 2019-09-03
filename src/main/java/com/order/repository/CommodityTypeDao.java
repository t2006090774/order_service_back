package com.order.repository;

import com.order.bean.CommodityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityTypeDao extends JpaRepository<CommodityType,Long> {

    List<CommodityType> findByShopId(Integer shopId);
}
