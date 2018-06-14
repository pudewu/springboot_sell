package com.sell.demo.enums;

import lombok.Getter;

@Getter
public enum  ProductStatusEnum {

    UP(0,"在售商品"),
    DOWN(1,"下架商品")
            ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
