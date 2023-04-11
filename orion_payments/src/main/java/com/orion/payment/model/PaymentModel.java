package com.orion.payment.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.object.CloningService;
import com.orion.data.source.database.IgnoreForORM;
import com.orion.data.source.security.annotations.DecodeBase64ForString;
import com.orion.data.source.security.annotations.DecryptAsData;
import com.orion.data.source.security.annotations.EncodeBase64ForString;
import com.orion.data.source.security.annotations.EncryptAsData;
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
public class PaymentModel implements OrionModel
{
    @IgnoreForORM
    private long paymentID;
    private String userID;
    private Long orderID;
    private String stripeSessionID;
    private String paymentMethod;
    private long totalAmount;
    private String currencyCode;
    private String error;
    private Boolean isMoneyCaptured;
    private String paymentStatus;
    private String refundStatus;
    private Boolean paymentSuccessful;
    private Boolean refundSuccessful;
    @EncodeBase64ForString
    @DecodeBase64ForString
    private String transactionID;
    @EncodeBase64ForString
    @DecodeBase64ForString
    private String refundReceiptID;
    @EncodeBase64ForString
    @DecodeBase64ForString
    private String transactionURL;
    @EncodeBase64ForString
    @DecodeBase64ForString
    private String invoiceURL;
    @EncodeBase64ForString
    @DecodeBase64ForString
    private String invoiceStripeURL;
    private String invoiceNumber;
    private SQLTimestamp paymentDateTime;
    private SQLTimestamp refundDateTime;
    private SQLTimestamp moneyCaptureDateTime;
    private SQLTimestamp penaltyChargeDateTime;
    @EncodeBase64ForString
    @DecodeBase64ForString
    private String penaltyChargeInvoiceURL;
    private Long processingFeeAmount;
    @EncryptAsData
    @DecryptAsData
    private String fullName;
    @EncryptAsData
    @DecryptAsData
    private String emailAddress;
    @EncryptAsData
    @DecryptAsData
    private String phoneNumber;
    private String addressID;


    public static PaymentModel of()
    {
        return PaymentModel.builder().build();
    }


    public static PaymentModel of(long paymentID)
    {
        return PaymentModel.builder().paymentID(paymentID).build();
    }


    public static PaymentModel ofOrderID(Long orderID)
    {
        return PaymentModel.builder().orderID(orderID).build();
    }


    @Override
    public PaymentModel clone()
    {
        return (PaymentModel)CloningService.clone(this);
    }


    @Override
    public PaymentModel getCopy()
    {
        return this.clone();
    }
}