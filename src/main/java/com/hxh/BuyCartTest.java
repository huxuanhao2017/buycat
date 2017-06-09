package com.hxh;

import com.hxh.controller.BuyCatController;
import com.hxh.entity.BuyItem;
import com.hxh.repository.BuyCartItemRepository;
import com.hxh.service.BuyCarService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * Created by huxuanhao on 2017-05-22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BuyCartTest {
    @Autowired
    private BuyCatController buyCatController;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Autowired
    private BuyCartItemRepository buyCartItemRepository;
    @Autowired
    private BuyCarService buyCarService;

    @Test
    public void test1() {
        System.out.println(buyCatController.hello());
        List<BuyItem> buyCarts = buyCartItemRepository.findAll();
        System.out.println(buyCarts);
        buyCarts.forEach((BuyItem p) ->
                System.out.println(p.toString())
        );
        System.out.println(11);
    }

    @Test
    public void test2() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void test3() throws Exception {
        Page<BuyItem> page = buyCarService.getPage();
        List<BuyItem> list = page.getContent();
        list.forEach(p ->
                System.out.println(p.toString())
        );
    }
}
