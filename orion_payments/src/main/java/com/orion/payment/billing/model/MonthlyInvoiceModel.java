package com.orion.payment.billing.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import com.orion.data.source.database.IgnoreForORM;
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
public class MonthlyInvoiceModel implements OrionModel
{
    @IgnoreForORM
    private long monthlyInvoiceID;
    private String userID;
    private String yearMonth;
    private String invoiceURL;


    public static MonthlyInvoiceModel of()
    {
        return MonthlyInvoiceModel.builder().build();
    }


    public static MonthlyInvoiceModel of(long monthlyInvoiceID)
    {
        return MonthlyInvoiceModel.builder().monthlyInvoiceID(monthlyInvoiceID).build();
    }


    @Override
    public MonthlyInvoiceModel clone()
    {
        return (MonthlyInvoiceModel)CloningService.clone(this);
    }


    @Override
    public MonthlyInvoiceModel getCopy()
    {
        return this.clone();
    }
}