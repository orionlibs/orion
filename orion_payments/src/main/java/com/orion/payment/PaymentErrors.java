package com.orion.payment;

import com.orion.core.abstraction.OrionErrorMessages;

public class PaymentErrors extends OrionErrorMessages
{
    public static final String ErrorOrderNotExists = "Order does not exist for orderID: ";
    public static final String ErrorWithPaymentWithStripe = "Problem with payment with Stripe";
    public static final String ErrorWithRetrievingUserPaymentMethods = "Problem with retrieving user payment methods";
    public static final String ErrorWithRetrievingWeeklyPeriods = "Problem with retrieving weekly periods";
    public static final String ErrorWithPaymentWithStripeSessionIDGeneration = "Problem with payment with Stripe Session ID generation for orderID = ";
    public static final String ErrorWithPaymentWithStripeSessionIDGenerationForMultidrop = "Problem with payment with Stripe Session ID generation for multidrop";
    public static final String PaymentNotCompletedErrorForOrderID = "Someone tried to set the payment as successful before payment was completed for orderID = ";
    public static final String ErrorWithPaymentCancellationWithStripe = "Problem with payment cancellation with Stripe";
    public static final String ShippingNotExistForOrderID = "Shipping does not exist for orderID = ";
}