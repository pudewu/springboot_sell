package com.sell.demo.dao;

import com.sell.demo.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryDao.findOne(2);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest1(){
        ProductCategory productCategory = new ProductCategory("男生最爱",1);
        ProductCategory result = productCategoryDao.save(productCategory);
        Assert.assertNotNull(result);
        //Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result =  productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result);
    }

}