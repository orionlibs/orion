package com.orion.payment.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import com.orion.data.source.database.IgnoreForORM;
import com.orion.data.source.security.annotations.DecodeBase64ForString;
import com.orion.data.source.security.annotations.EncodeBase64ForString;
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
public class InvoiceOfEcommerceOrderModel implements OrionModel
{
    @IgnoreForORM
    private long invoiceOfEcommerceOrderID;
    private String invoiceOfEcommerceOrderID2;
    private String merchantID;
    @EncodeBase64ForString
    @DecodeBase64ForString
    private String invoiceURL;
    private Boolean hasEmailBeenSentToUser;


    public static InvoiceOfEcommerceOrderModel of()
    {
        return InvoiceOfEcommerceOrderModel.builder().build();
    }


    public static InvoiceOfEcommerceOrderModel of(long invoiceOfEcommerceOrderID)
    {
        return InvoiceOfEcommerceOrderModel.builder().invoiceOfEcommerceOrderID(invoiceOfEcommerceOrderID).build();
    }


    public static InvoiceOfEcommerceOrderModel ofID2(String invoiceOfEcommerceOrderID2)
    {
        return InvoiceOfEcommerceOrderModel.builder().invoiceOfEcommerceOrderID2(invoiceOfEcommerceOrderID2).build();
    }


    @Override
    public InvoiceOfEcommerceOrderModel clone()
    {
        return (InvoiceOfEcommerceOrderModel)CloningService.clone(this);
    }


    @Override
    public InvoiceOfEcommerceOrderModel getCopy()
    {
        return this.clone();
    }
}