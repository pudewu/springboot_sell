package com.sell.demo.service.impl;

import com.sell.demo.dataobject.ProductInfo;
import com.sell.demo.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() throws Exception {
         ProductInfo productInfo =productService.findOne("123456");
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<ProductInfo> productInfoList = productService.findAll(pageRequest);
        System.out.println(productInfoList.getTotalElements());
        Assert.assertNotEquals(0,productInfoList.getTotalElements());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("小龙虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductDescription("美味小龙虾");
        productInfo.setProductIcon("https://xxxxx.jpg");
        productInfo.setProductStock(20);
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(2);
        ProductInfo productInfoList = productService.save(productInfo);

    }

}