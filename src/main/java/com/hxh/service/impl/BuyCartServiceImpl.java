package com.hxh.service.impl;

import com.hxh.entity.BuyItem;
import com.hxh.repository.BuyCartItemRepository;
import com.hxh.service.BuyCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huxuanhao on 2017-06-09.
 */
@Service
public class BuyCartServiceImpl implements BuyCarService{

    @Autowired
    private BuyCartItemRepository buyCartItemRepository;
    @Override
    public Page<BuyItem> getPage() {
        Specification<BuyItem> specification = ((root, query, cb)->{
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.equal(root.get("id").as(Integer.class), 1));
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        });

        Sort sort =new Sort(Sort.Direction.DESC,"id");
        return buyCartItemRepository.findAll(
                specification, new PageRequest(0, 10,sort )
        );
    }
}
