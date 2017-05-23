package com.hxh.controller;

import com.alibaba.fastjson.JSONObject;
import com.hxh.entity.BuyerCart;
import com.hxh.entity.BuyerItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huxuanhao on 2017-05-20.
 */
@Controller
public class BuyCatController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello 你好";
    }

    @RequestMapping("/add")
    public String buycart(String skuId, Integer num, HttpServletRequest request,
                          HttpServletResponse response)  {
        BuyerCart buyerCart = null;
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("buyerCart".equals(cookie.getName())) {//cookie中已有购物车
                    try {
                        String value = URLDecoder.decode(cookie.getValue(),"utf-8");
                        System.out.println(value);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        if (null == buyerCart) {
            buyerCart = new BuyerCart();
        }
        if (skuId != null && num != null) {
            BuyerItem buyerItem = new BuyerItem();
            buyerItem.setId(skuId);
            buyerItem.setNum(num);
            buyerItem.setHave(false);
            if (buyerCart.getItems() == null) {
                List<BuyerItem> list = new ArrayList<BuyerItem>();
                buyerCart.setItems(list);
            }
            buyerCart.addItem(buyerItem, buyerCart.getItems());
        }
        JSONObject json = new JSONObject();
        json.put("dsd","2211");
        json.put("hxh","123");

        Cookie cookie = null;
        try {
            cookie = new Cookie("buyerCart",URLEncoder.encode(json.toString(),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/hello";
    }
}
