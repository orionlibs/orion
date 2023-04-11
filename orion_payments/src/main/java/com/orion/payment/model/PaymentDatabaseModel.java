package com.orion.payment.model;

/**
 * model for the Orion database containing database tables and their columns
 * @author dimitrios.efthymiou
 */
public class PaymentDatabaseModel
{
    public static final String tablePayments = "." + "payments";
    public static final String userID = "userID";
    public static final String orderID = "orderID";
    public static final String fullName = "fullName";
    public static final String emailAddress = "emailAddress";
    public static final String phoneNumber = "phoneNumber";
    public static final String addressID = "addressID";
    public static final String stripeSessionID = "stripeSessionID";
    public static final String paymentID = "paymentID";
    public static final String paymentMethod = "paymentMethod";
    public static final String totalAmount = "totalAmount";
    public static final String currencyCode = "currencyCode";
    public static final String error = "error";
    public static final String isMoneyCaptured = "isMoneyCaptured";
    public static final String paymentStatus = "paymentStatus";
    public static final String refundStatus = "refundStatus";
    public static final String paymentSuccessful = "paymentSuccessful";
    public static final String refundSuccessful = "refundSuccessful";
    public static final String transactionID = "transactionID";
    public static final String refundReceiptID = "refundReceiptID";
    public static final String transactionURL = "transactionURL";
    public static final String invoiceURL = "invoiceURL";
    public static final String invoiceStripeURL = "invoiceStripeURL";
    public static final String invoiceNumber = "invoiceNumber";
    public static final String penaltyChargeInvoiceURL = "penaltyChargeInvoiceURL";
    public static final String paymentDateTime = "paymentDateTime";
    public static final String refundDateTime = "refundDateTime";
    public static final String moneyCaptureDateTime = "moneyCaptureDateTime";
    public static final String processingFeeAmount = "processingFeeAmount";
    public static final String penaltyChargeDateTime = "penaltyChargeDateTime";
    public static final String tableUserBillingAddress = "." + "user_billing_address";
    public static final String userBillingAddressID = "userBillingAddressID";
    public static final String tableUserBillingDetails = "." + "user_billing_details";
    public static final String userBillingDetailsID = "userBillingDetailsID";
    public static final String tableMonthlyInvoices = "." + "monthly_invoices";
    public static final String monthlyInvoiceID = "monthlyInvoiceID";
    public static final String yearMonth = "yearMonth";
    public static final String tableInvoicesForStores = "." + "invoices_for_stores";
    public static final String invoiceForStoreID = "invoiceForStoreID";
    public static final String invoiceForStoreNumber = "invoiceForStoreNumber";
    public static final String invoiceForStoreURL = "invoiceForStoreURL";
    public static final String merchantID = "merchantID";
    public static final String tableWeeklyInvoicesForStores = "." + "weekly_invoices_for_stores";
    public static final String weeklyInvoiceForStoreID = "weeklyInvoiceForStoreID";
    public static final String weeklyInvoiceForStoreID2 = "weeklyInvoiceForStoreID2";
    public static final String invoiceDate = "invoiceDate";
    public static final String invoiceDateTime = "invoiceDateTime";
    public static final String startDateOfWeek = "startDateOfWeek";
    public static final String endDateOfWeek = "endDateOfWeek";
    public static final String startDateOfWeekDateTime = "startDateOfWeekDateTime";
    public static final String endDateOfWeekDateTime = "endDateOfWeekDateTime";
    public static final String isPaid = "isPaid";
    public static final String dueDate = "dueDate";
    public static final String amountDueAmount = "amountDueAmount";
    public static final String numberOfOrders = "numberOfOrders";
    public static final String tableOrdersForWeeklyInvoicesForStores = "." + "orders_for_weekly_invoices_for_stores";
    public static final String orderForWeeklyInvoiceForStoreID = "orderForWeeklyInvoiceForStoreID";
    public static final String orderFulfillmentDate = "orderFulfillmentDate";
    public static final String tableInvoicesOfCourierOrdersUsingDirectDebit = "." + "invoices_of_courier_orders_using_direct_debit";
    public static final String invoiceOfCourierOrderUsingDirectDebitID = "invoiceOfCourierOrderUsingDirectDebitID";
    public static final String invoiceOfCourierOrderUsingDirectDebitID2 = "invoiceOfCourierOrderUsingDirectDebitID2";
    public static final String hasEmailBeenSentToUser = "hasEmailBeenSentToUser";
    public static final String tableSuccessfulInvoices = "." + "successful_invoices";
    public static final String userIDOfAgent = "userIDOfAgent";
    public static final String processingDateTime = "processingDateTime";
    public static final String successfulDirectDebitDateTime = "successfulDirectDebitDateTime";
    public static final String manualProcessing = "manualProcessing";
    public static final String userIDOfCustomer = "userIDOfCustomer";
    public static final String tableInvoicesOfEcommerceOrders = "." + "invoices_of_ecommerce_orders";
    public static final String invoiceOfEcommerceOrderID = "invoiceOfEcommerceOrderID";
    public static final String invoiceOfEcommerceOrderID2 = "invoiceOfEcommerceOrderID2";
}