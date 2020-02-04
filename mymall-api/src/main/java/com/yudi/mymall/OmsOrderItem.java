package com.yudi.mymall;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
@Getter
@Setter
@ToString
public class OmsOrderItem implements Serializable {

    private String id;
    private String         orderId;
    private String orderSn;
    private String         productId;
    private String productPic;
    private String        productName;
    private String productBrand;
    private String         productSn;
    private String productPrice;
    private int         productQuantity;
    private String productSkuId;
    private String        productSkuCode;
    private String productCategoryId;
    private String         sp1;
    private String sp2;
    private String        sp3;
    private String promotionName;
    private BigDecimal promotionAmount;
    private BigDecimal couponAmount;
    private BigDecimal         integrationAmount;
    private String realAmount;
    private int        giftIntegration;
    private int giftGrowth;
    private String        productAttr;




}
