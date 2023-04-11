package com.orion.payment.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.SQLTimestamp;
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
public class WeeklyInvoiceForStoreModel implements OrionModel
{
    @IgnoreForORM
    private long weeklyInvoiceForStoreID;
    private String weeklyInvoiceForStoreID2;
    private String userID;
    private String merchantID;
    private String invoiceNumber;
    @EncodeBase64ForString
    @DecodeBase64ForString
    private String invoiceURL;
    private SQLTimestamp invoiceDateTime;
    private String invoiceDate;
    private SQLTimestamp startDateOfWeekDateTime;
    private String startDateOfWeek;
    private SQLTimestamp endDateOfWeekDateTime;
    private String endDateOfWeek;
    private Boolean isPaid;
    private String dueDate;
    private Long amountDueAmount;
    private Integer numberOfOrders;


    public static WeeklyInvoiceForStoreModel of()
    {
        return WeeklyInvoiceForStoreModel.builder().build();
    }


    public static WeeklyInvoiceForStoreModel of(long weeklyInvoiceForStoreID)
    {
        return WeeklyInvoiceForStoreModel.builder().weeklyInvoiceForStoreID(weeklyInvoiceForStoreID).build();
    }


    public static WeeklyInvoiceForStoreModel ofID2(String weeklyInvoiceForStoreID2)
    {
        return WeeklyInvoiceForStoreModel.builder().weeklyInvoiceForStoreID2(weeklyInvoiceForStoreID2).build();
    }


    @Override
    public WeeklyInvoiceForStoreModel clone()
    {
        return (WeeklyInvoiceForStoreModel)CloningService.clone(this);
    }


    @Override
    public WeeklyInvoiceForStoreModel getCopy()
    {
        return this.clone();
    }
}