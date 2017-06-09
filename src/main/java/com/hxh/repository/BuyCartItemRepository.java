package com.hxh.repository;

import com.hxh.entity.BuyItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by huxuanhao on 2017-06-09.
 */
@Repository
public interface BuyCartItemRepository extends JpaRepository<BuyItem,Integer>,JpaSpecificationExecutor<BuyItem>{

}
