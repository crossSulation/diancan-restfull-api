package com.diancan.web.resto.controllers;

import com.diancan.domain.resto.Restaurant;
import com.diancan.service.resto.RestarantServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.equalTo;
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestarantServiceImpl restarantService;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getRestaurantById() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/restaurants/{id}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("/restaurants/{id}")));
    }

    @Test
    public void getAllRestaurants() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders.get("/restaurants")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("/restaurants")));
    }

    @Test
    public void addNewRestaurant() throws  Exception{
        Restaurant restaurant =new Restaurant();
        restaurant.setRating(3);
        restaurant.setContactor("laxajaxmail@gmail.com");
        restaurant.setRestoImage("http://baidu.com?test.png");
        restaurant.setRestoName("河港");
        restaurant.setRestodialnumber("13817038724");
        this.mvc.perform(MockMvcRequestBuilders.post("/restaurants",restaurant)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("/restaurants")));
    }

    @Test
    public void getRestaurantsByGivenAddressProvince() {
    }

    @Test
    public void getRestaurantByGivenRating() {
    }

    @Test
    public void delOneRestaurantById() {
    }
}