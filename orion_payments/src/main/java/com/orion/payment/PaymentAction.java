package com.orion.payment;

import com.orion.core.abstraction.OrionErrorMessages;

public class PaymentAction extends OrionErrorMessages
{
    public static final String APICallGetUserPaymentMethods = "API - get user payment methods";
    public static final String APICallGetWeeklyPeriods = "API - get weekly periods";
    public static final String APICallGetNewStripeSession = "API - get new Stripe session";
    public static final String APICallSetPaymentAsSuccessfulForCourier = "API - set payment as successful for courier";
    public static final String APICallSetPaymentAsSuccessfulForShopping = "API - set payment as successful for shopping";
    public static final String APICallCancelPaymentForCourier = "API - cancel payment for courier";
    public static final String APICallCancelPaymentForShopping = "API - cancel payment for shopping";
    public static final String PaymentIsSuccessful = "payment is successful";
    public static final String PaymentIsUnsuccessful = "payment is unsuccessful";
}