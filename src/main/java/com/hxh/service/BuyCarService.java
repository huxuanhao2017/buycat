package com.hxh.service;

import com.hxh.entity.BuyItem;
import org.springframework.data.domain.Page;

/**
 * Created by huxuanhao on 2017-06-09.
 */
public interface BuyCarService {
    Page<BuyItem> getPage();
}
