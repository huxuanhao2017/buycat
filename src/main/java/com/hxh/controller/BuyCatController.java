package com.hxh.controller;

import com.alibaba.fastjson.JSONObject;
import com.hxh.entity.BuyCart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by huxuanhao on 2017-05-20.
 */
@Controller
public class BuyCatController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(int n,String j) {
        // output : str having value ? false
        return n+"hello 你好"+j;
    }

    @RequestMapping("/add")
    public String buycart(String skuId, Integer num, HttpServletRequest request,
                          HttpServletResponse response) {
        BuyCart buyerCart = null;
        Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("buyerCart".equals(cookie.getName())) {//cookie中已有购物车
                    try {
                        String value = URLDecoder.decode(cookie.getValue(), "utf-8");
                        System.out.println(value);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
        if (null == buyerCart) {
            buyerCart = new BuyCart();
        }
//        if (skuId != null && num != null) {
//            BuyItem buyerItem = new BuyItem();
//            buyerItem.setId(skuId);
//            buyerItem.setNum(num);
//            buyerItem.setHave(false);
//            if (buyerCart.getItems() == null) {
//                List<BuyItem> list = new ArrayList<BuyItem>();
//                buyerCart.setItems(list);
//            }
//            buyerCart.addItem(buyerItem, buyerCart.getItems());
//        }
        JSONObject json = new JSONObject();
        json.put("skuId", "938366");
        json.put("num",1);
        JSONObject json1 = new JSONObject();
        json1.put("skuId", "938366");
        json1.put("num",2);
        json1.put("store",7878);
        Cookie cookie = null;
        Cookie cookieAdd = null;
        try {
            cookie = new Cookie("buyerCart", null);
            cookieAdd = new Cookie("changeItem", URLEncoder.encode(json.toString(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        cookie.setMaxAge(24 * 60 * 60);
        cookieAdd.setMaxAge(24 * 60 * 60);
        cookieAdd.setPath("/");
        cookie.setPath("/");
      // response.addCookie(cookie);
        response.addCookie(cookieAdd);
        return "redirect:/hello";
    }
}
