package com.orion.payment.model;

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
public class OrderForWeeklyInvoiceForStoreModel implements OrionModel
{
    @IgnoreForORM
    private long orderForWeeklyInvoiceForStoreID;
    private String weeklyInvoiceForStoreID2;
    private String orderFulfillmentDate;
    private Long orderID;
    private Long amountDueAmount;


    public static OrderForWeeklyInvoiceForStoreModel of()
    {
        return OrderForWeeklyInvoiceForStoreModel.builder().build();
    }


    public static OrderForWeeklyInvoiceForStoreModel of(long orderForWeeklyInvoiceForStoreID)
    {
        return OrderForWeeklyInvoiceForStoreModel.builder().orderForWeeklyInvoiceForStoreID(orderForWeeklyInvoiceForStoreID).build();
    }


    public static OrderForWeeklyInvoiceForStoreModel ofWeeklyInvoiceForStoreID2(String weeklyInvoiceForStoreID2)
    {
        return OrderForWeeklyInvoiceForStoreModel.builder().weeklyInvoiceForStoreID2(weeklyInvoiceForStoreID2).build();
    }


    @Override
    public OrderForWeeklyInvoiceForStoreModel clone()
    {
        return (OrderForWeeklyInvoiceForStoreModel)CloningService.clone(this);
    }


    @Override
    public OrderForWeeklyInvoiceForStoreModel getCopy()
    {
        return this.clone();
    }
}