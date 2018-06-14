package com.sell.demo.controller;

import com.sell.demo.VO.ProductInfoVo;
import com.sell.demo.VO.ProductVO;
import com.sell.demo.VO.ResultVO;
import com.sell.demo.dataobject.ProductCategory;
import com.sell.demo.dataobject.ProductInfo;
import com.sell.demo.service.CategoryService;
import com.sell.demo.service.ProductInfoService;
import com.sell.demo.service.impl.ProductServiceImpl;
import com.sell.demo.utils.ResultVOUtil;
import javafx.print.Collation;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")

public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2.查询类目（一次性查询）
//        List<Integer> categoryTypeList = new ArrayList<>();
        //传统方式
//        for (ProductInfo productinfo: productInfoList
//             ) {
//            categoryTypeList.add(productinfo.getCategoryType());
//        }
        //精简方法 （java8 新特性 lamda）
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<ProductInfoVo> productInfoVoList = new ArrayList<>();
            for (ProductInfo productInfo: productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }

            }
            productVO.setProductInfoVoList(productInfoVoList);

            productVOList.add(productVO);
        }

        //封装了ResultVO
        return ResultVOUtil.succes(productVOList);
    }
}
