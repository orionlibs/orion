package com.orion.payment.stripe;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.SQLTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class CustomerChargeResponseVO extends Orion
{
    private SQLTimestamp paymentTimestamp;
    private String transactionID;
    private String transactionURL;
    private String invoiceStripeURL;
    private Long processingFeeAmount;
}