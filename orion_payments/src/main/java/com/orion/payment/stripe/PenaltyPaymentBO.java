package com.orion.payment.stripe;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.payment.PaymentService;
import com.orion.payment.data_access.PaymentsDAO;
import com.orion.payment.model.PaymentModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class PenaltyPaymentBO extends Orion
{
    private long amountToCharge;
    private Long orderID;


    public static PenaltyPaymentBO of(Long orderID, long amountToCharge)
    {
        return PenaltyPaymentBO.builder()
                        .orderID(orderID)
                        .amountToCharge(amountToCharge)
                        .build();
    }


    public SQLTimestamp chargePenalty()
    {
        PaymentModel paymentModel = PaymentService.getPaymentByOrderID(orderID);
        SQLTimestamp penaltyChargeDateTime = null;
        //SQLTimestamp penaltyChargeDateTime = StripePaymentService.chargeUser(paymentModel.getStripeSessionID(), amountToCharge);

        if(penaltyChargeDateTime != null)
        {
            paymentModel.setPenaltyChargeDateTime(penaltyChargeDateTime);
            //paymentModel.setPenaltyChargeInvoiceURL(refund.getReceiptNumber());
            int rowsAffected = PaymentsDAO.update(paymentModel);

            if(rowsAffected != 0)
            {
                return penaltyChargeDateTime;
            }
            else
            {
                return null;
            }

        }
        else
        {
            return null;
        }

    }
}