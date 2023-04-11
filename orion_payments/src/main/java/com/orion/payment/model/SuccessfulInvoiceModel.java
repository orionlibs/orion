package com.orion.payment.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.object.CloningService;
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
public class SuccessfulInvoiceModel implements OrionModel
{
    private String invoiceNumber;
    private String userIDOfAgent;
    private SQLTimestamp processingDateTime;
    private SQLTimestamp successfulDirectDebitDateTime;
    private Boolean manualProcessing;
    private String userIDOfCustomer;


    public static SuccessfulInvoiceModel of()
    {
        return SuccessfulInvoiceModel.builder().build();
    }


    public static SuccessfulInvoiceModel of(String invoiceNumber)
    {
        return SuccessfulInvoiceModel.builder().invoiceNumber(invoiceNumber).build();
    }


    @Override
    public SuccessfulInvoiceModel clone()
    {
        return (SuccessfulInvoiceModel)CloningService.clone(this);
    }


    @Override
    public SuccessfulInvoiceModel getCopy()
    {
        return this.clone();
    }
}