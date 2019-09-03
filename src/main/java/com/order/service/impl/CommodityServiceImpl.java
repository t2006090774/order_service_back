package com.order.service.impl;

import com.order.bean.Commodity;
import com.order.bean.CommodityType;
import com.order.repository.CommodityDao;
import com.order.repository.CommodityTypeDao;
import com.order.service.CommodityService;
import com.order.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;


@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;
    @Autowired
    private CommodityTypeDao commodityTypeDao;

    /**
     * 查询商品列表
     * @param commodity
     * @return Commodity
     */
    public Page<Commodity> getCommodityList(Commodity commodity) {
        Specification querySpeci = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if(!StringUtils.isEmpty(commodity.getShopId())) {
                    predicates.add(criteriaBuilder
                            .equal(root.get("shopId"), commodity.getShopId()));
                }
                if(!StringUtils.isEmpty(commodity.getCommodityType())){
                    predicates.add(criteriaBuilder
                            .equal(root.get("commodityType"), commodity.getCommodityType()));
                }
                if(!StringUtils.isEmpty(commodity.getCommodityName())){
                    predicates.add(criteriaBuilder
                            .like(root.get("commodityName"), "%"+commodity.getCommodityName()+"%"));
                }
                predicates.add(criteriaBuilder
                        .equal(root.get("delFlag"), 1));

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        PageRequest pageRequest = PageUtils.buildPageRequest(commodity.getPageNum(), commodity.getPageSize());
        return commodityDao.findAll(querySpeci,pageRequest);
    }



    @Override
    public Commodity save(Commodity commodity) {
        commodity.setCreateTime(new Date());
        commodity.setDelFlag(1);
        return commodityDao.save(commodity);
    }

    @Override
    public List<CommodityType> getCommodityType(Integer shopId) {
        return commodityTypeDao.findByShopId(shopId);
    }


/**
 * 查询商品列表
 * @param shopId
 * @return Commodity

 @Override
 public List<Commodity> getCommodityList(Integer shopId) {

 // 查询所有商品列表
 List<Commodity> commoList = commodityDao.findByCommodityTypeIn(shopId);

 return commoList;
 }
 */

}
