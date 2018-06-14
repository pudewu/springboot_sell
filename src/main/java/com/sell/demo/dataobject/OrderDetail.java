package com.sell.demo.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
@Entity
@Data
public class OrderDetail {


    /**订单详情id*/
    @Id
    private String detailId;

    /**订单Id*/
    private String orderId;

    /**商品id*/
    private String productId;

    /**商品名称*/
    private String productName;

    /**商品价格*/
    private BigDecimal productPrice;

    /**数量*/
    private  Integer productQuantity;

    /**商品小图*/
    private  String productIcon;

}
