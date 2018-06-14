package com.sell.demo.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Data
public class ProductInfo {
    /**商品信息id*/
    @Id
    private String productId;
    /**名字*/
    private String productName;
    /**商品价格*/
    private BigDecimal productPrice;
    /** 库存 */
    private Integer productStock;
    /** 商品描述*/
    private String productDescription;
    /** 商品小图标*/
    private String productIcon;
    /** 商品状态 0正常，1下架*/
    private Integer productStatus;
    /**类目编号*/
    private Integer categoryType;




}
