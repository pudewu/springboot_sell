package com.sell.demo.dao;

import com.sell.demo.dataobject.OrderMaster;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String OPPENID="110110";
    @Test
    public void OrderMasterSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerOpenid(OPPENID);
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("小孩");
        orderMaster.setBuyerAddress("贵州");
        orderMaster.setBuyerPhone("18785291364");
        orderMaster.setOrderAmount(new BigDecimal(3.2));
        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest pageRequest = new PageRequest(0,1);
        Page<OrderMaster> result =  orderMasterDao.findByBuyerOpenid(OPPENID,pageRequest);
        Assert.assertNotEquals(0,result.getTotalElements());
    }

}