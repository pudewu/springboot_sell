package com.sell.demo.dao;

import com.sell.demo.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http:xxx.jpg");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("大商品");
        orderDetail.setProductPrice(new BigDecimal(25));
        orderDetail.setProductQuantity(45);
        OrderDetail result =  orderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() throws Exception {

        List<OrderDetail> result = orderDetailDao.findByOrderId("123456");
        Assert.assertNotEquals(0,result.size());
    }

}