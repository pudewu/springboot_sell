package com.sell.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sell.demo.dataobject.OrderDetail;
import com.sell.demo.enums.OrderStatusEnum;
import com.sell.demo.enums.PayStatusEnum;
import com.sell.demo.utils.serializer.Date2LongSerilizer;
import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /**订单id*/
    private String orderId;

    /**买家名字*/
    private String buyerName;

    /**买家手机号*/
    private String buyerPhone;

    /**买家地址*/
    private String buyerAddress;

    /**买家微信id*/
    private String buyerOpenid;

    /**订单总金额*/
    private BigDecimal orderAmount;

    /**订单状态 默认状态为新订单*/
    private Integer orderStatus ;

    /**支付状态 默认0为未支付*/
    private Integer payStatus;

    /**创建时间*/
    @JsonSerialize(using = Date2LongSerilizer.class)
    private Date createTime;

    /**更新时间*/
    @JsonSerialize(using = Date2LongSerilizer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

}
