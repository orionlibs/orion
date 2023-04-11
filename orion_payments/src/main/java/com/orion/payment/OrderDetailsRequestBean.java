package com.orion.payment;

import com.orion.payment.model.PaymentProductsModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderDetailsRequestBean
{
    private String sessionBasketID;
    private String emailAddress;
    private String userID;
    private String currencyCode;
    private long grandTotalPriceAmount;
    private long quantity;
    private String orderName;
    private String merchantID;
    private Boolean isCourierOrder;
    private PaymentProductsModel products;


    public static OrderDetailsRequestBean of()
    {
        return OrderDetailsRequestBean.builder().build();
    }
}