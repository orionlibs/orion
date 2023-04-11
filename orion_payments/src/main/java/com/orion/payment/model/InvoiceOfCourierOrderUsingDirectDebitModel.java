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
public class InvoiceOfCourierOrderUsingDirectDebitModel implements OrionModel
{
    @IgnoreForORM
    private long invoiceOfCourierOrderUsingDirectDebitID;
    private String invoiceOfCourierOrderUsingDirectDebitID2;
    private String userID;
    @EncodeBase64ForString
    @DecodeBase64ForString
    private String invoiceURL;
    private Boolean hasEmailBeenSentToUser;


    public static InvoiceOfCourierOrderUsingDirectDebitModel of()
    {
        return InvoiceOfCourierOrderUsingDirectDebitModel.builder().build();
    }


    public static InvoiceOfCourierOrderUsingDirectDebitModel of(long invoiceOfCourierOrderUsingDirectDebitID)
    {
        return InvoiceOfCourierOrderUsingDirectDebitModel.builder().invoiceOfCourierOrderUsingDirectDebitID(invoiceOfCourierOrderUsingDirectDebitID).build();
    }


    public static InvoiceOfCourierOrderUsingDirectDebitModel ofID2(String invoiceOfCourierOrderUsingDirectDebitID2)
    {
        return InvoiceOfCourierOrderUsingDirectDebitModel.builder().invoiceOfCourierOrderUsingDirectDebitID2(invoiceOfCourierOrderUsingDirectDebitID2).build();
    }


    @Override
    public InvoiceOfCourierOrderUsingDirectDebitModel clone()
    {
        return (InvoiceOfCourierOrderUsingDirectDebitModel)CloningService.clone(this);
    }


    @Override
    public InvoiceOfCourierOrderUsingDirectDebitModel getCopy()
    {
        return this.clone();
    }
}