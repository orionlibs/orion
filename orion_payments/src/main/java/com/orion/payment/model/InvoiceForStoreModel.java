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
public class InvoiceForStoreModel implements OrionModel
{
    @IgnoreForORM
    private long invoiceForStoreID;
    private Long orderID;
    private String merchantID;
    private String invoiceForStoreNumber;
    @EncodeBase64ForString
    @DecodeBase64ForString
    private String invoiceForStoreURL;


    public static InvoiceForStoreModel of()
    {
        return InvoiceForStoreModel.builder().build();
    }


    public static InvoiceForStoreModel of(long invoiceForStoreID)
    {
        return InvoiceForStoreModel.builder().invoiceForStoreID(invoiceForStoreID).build();
    }


    @Override
    public InvoiceForStoreModel clone()
    {
        return (InvoiceForStoreModel)CloningService.clone(this);
    }


    @Override
    public InvoiceForStoreModel getCopy()
    {
        return this.clone();
    }
}