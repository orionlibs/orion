package com.orion.payment.stripe;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.payment.OrderDetailsRequestBean;
import com.stripe.net.RequestOptions;

public class StripePaymentService extends OrionService
{
    public static RequestOptions generateDefaultStripeAPIRequestOptions()
    {
        return RequestOptions.builder()
                        .setConnectTimeout(15_000)
                        .setReadTimeout(15_000)
                        .setMaxNetworkRetries(2)
                        .setApiKey(InMemoryConfigurationService.getProp("payment.stripe.api.key"))
                        .build();
    }


    public static String createNewStripeSessionForPayment(OrderDetailsRequestBean requestBean)
    {
        return StripeSessionBO.of(requestBean, generateDefaultStripeAPIRequestOptions()).createNewSession();
    }


    public static boolean setPaymentAsSuccessful(String userID, String stripeSessionID, Long orderID, String currencyCode, boolean doesUserNotExist)
    {
        return StripePaymentBO.of(userID, stripeSessionID, orderID, doesUserNotExist, generateDefaultStripeAPIRequestOptions(), currencyCode).setAsSuccessful();
    }


    public static SQLTimestamp refundUserForOrderID(Long orderID)
    {
        return StripePaymentBO.ofOrderID(orderID).refund();
    }


    public static SQLTimestamp doPartialRefundForUserForOrderID(Long orderID, long amountToRefund)
    {
        return StripePaymentBO.ofOrderID(orderID).doPartialRefund(amountToRefund);
    }


    public static SQLTimestamp refundUser(String stripeSessionID)
    {
        return StripePaymentBO.ofStripeSessionID(stripeSessionID, generateDefaultStripeAPIRequestOptions()).refundBySession();
    }


    public static SQLTimestamp doPartialRefundForUser(String stripeSessionID, long amountToRefund)
    {
        return StripePaymentBO.ofStripeSessionID(stripeSessionID, generateDefaultStripeAPIRequestOptions()).doPartialRefundBySession(amountToRefund);
    }


    public static SQLTimestamp chargePenaltyForDelivery(Long orderID, long amountToCharge)
    {
        return PenaltyPaymentBO.of(orderID, amountToCharge).chargePenalty();
    }


    public static boolean captureMoney(String stripeSessionID)
    {
        return StripePaymentBO.ofStripeSessionID(stripeSessionID, generateDefaultStripeAPIRequestOptions()).captureMoney();
    }


    public static boolean doesStripeCustomerIDExist(String stripeCustomerID)
    {
        return StripeCustomerBO.ofCustomerID(stripeCustomerID, generateDefaultStripeAPIRequestOptions()).doesCustomerIDExist();
    }


    public static String createStripeCustomer(String userID, String username, String userFullNameOrBusinessName, String userPhoneNumber)
    {
        return StripeCustomerBO.ofUserDetails(userID, username, userFullNameOrBusinessName, userPhoneNumber, generateDefaultStripeAPIRequestOptions()).createStripeCustomer();
    }


    public static boolean updateStripeCustomerDetails(String stripeCustomerID, String newUsername, String newUserFullNameOrBusinessName, String newUserPhoneNumber)
    {
        return StripeCustomerBO.ofUserIDAndUserDetails(stripeCustomerID, newUsername, newUserFullNameOrBusinessName, newUserPhoneNumber, generateDefaultStripeAPIRequestOptions()).updateStripeCustomer();
    }


    public static String createNewStripeSessionForBACSDirectDebitMandateSetup(String stripeCustomerID)
    {
        return StripeBACSDirectDebitBO.of(stripeCustomerID, generateDefaultStripeAPIRequestOptions()).createNewStripeSessionForBACSDirectDebitMandateSetup();
    }


    public static String getPaymentMethodID(String directDebitSetupSessionID)
    {
        return StripePaymentMethodBO.ofDirectDebitSetupSessionID(directDebitSetupSessionID, generateDefaultStripeAPIRequestOptions()).getPaymentMethodID();
    }


    public static CustomerChargeResponseVO chargeCustomer(String stripeCustomerID, String paymentMethodID, long amountToCharge, String paymentDescription)
    {
        return StripePaymentBO.ofAmount(stripeCustomerID, paymentMethodID, amountToCharge, paymentDescription, generateDefaultStripeAPIRequestOptions()).chargeCustomer();
    }
}