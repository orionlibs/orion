package com.orion.payment.model;

import java.util.List;
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
public class PaymentProductsModel
{
    private List<ProductModel> products;
    private String orderName;
    private String merchantID;


    public static PaymentProductsModel of()
    {
        return PaymentProductsModel.builder().build();
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class ProductModel
    {
        private String name;
        private long basePrice;
        private long quantity;
    }
}