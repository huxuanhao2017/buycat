package com.hxh;

import com.hxh.controller.BuyCatController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by huxuanhao on 2017-05-22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BuyCartTest {
    @Autowired
    private BuyCatController buyCatController;
    @Test
    public void test1(){
        System.out.println(buyCatController.hello());
        System.out.println(11);
    }
}
