package com.order.repository;

import com.order.bean.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityDao extends JpaRepository<Commodity,Long>, JpaSpecificationExecutor {

//    List<Commodity> findByCommodityTypeIn(Integer shopId);

//    List<Commodity> findAll();

}
