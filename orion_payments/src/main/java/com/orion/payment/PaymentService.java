package com.orion.payment;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.abstraction.OrionService;
import com.orion.core.content.Pagination;
import com.orion.payment.data_access.InvoicesForStoresDAO;
import com.orion.payment.data_access.InvoicesOfCourierOrdersUsingDirectDebitDAO;
import com.orion.payment.data_access.InvoicesOfEcommerceOrdersDAO;
import com.orion.payment.data_access.OrdersForWeeklyInvoicesForStoresDAO;
import com.orion.payment.data_access.PaymentsDAO;
import com.orion.payment.data_access.SuccessfulInvoicesDAO;
import com.orion.payment.data_access.WeeklyInvoicesForStoresDAO;
import com.orion.payment.model.InvoiceForStoreModel;
import com.orion.payment.model.InvoiceOfCourierOrderUsingDirectDebitModel;
import com.orion.payment.model.InvoiceOfEcommerceOrderModel;
import com.orion.payment.model.OrderForWeeklyInvoiceForStoreModel;
import com.orion.payment.model.PaymentModel;
import com.orion.payment.model.SuccessfulInvoiceModel;
import com.orion.payment.model.WeeklyInvoiceForStoreModel;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentService extends OrionService
{
    public static void disassociatePaymentsForUserID(String userID)
    {
        PaymentsDAO.disassociatePaymentsForUserID(userID);
    }


    public static PaymentModel getPaymentByOrderID(Long orderID)
    {
        return PaymentsDAO.getByOrderID(orderID);
    }


    public static String getEmailAddressByOrderID(Long orderID)
    {
        return PaymentsDAO.getEmailAddressByOrderID(orderID);
    }


    public static String getStripeSessionIDByOrderID(Long orderID)
    {
        return PaymentsDAO.getStripeSessionIDByOrderID(orderID);
    }


    public static boolean doesPaymentExistForOrderID(Long orderID)
    {
        return PaymentsDAO.doesPaymentExistForOrderID(orderID);
    }


    public static String getInvoiceURLByOrderID(Long orderID)
    {
        return PaymentsDAO.getInvoiceURLByOrderID(orderID);
    }


    public static String getStripeInvoiceURLByOrderID(Long orderID)
    {
        return PaymentsDAO.getStripeInvoiceURLByOrderID(orderID);
    }


    public static PaymentModel getInvoiceURLsByOrderID(Long orderID)
    {
        return PaymentsDAO.getInvoiceURLsByOrderID(orderID);
    }


    public static long getProcessingFeeAmountByOrderID(Long orderID)
    {
        return PaymentsDAO.getProcessingFeeAmountByOrderID(orderID);
    }


    public static long getTotalAmountByOrderID(Long orderID)
    {
        return PaymentsDAO.getTotalAmountByOrderID(orderID);
    }


    public static long getSumOfTotalAmountsByOrderIDs(List<Long> orderIDs)
    {
        return PaymentsDAO.getSumOfTotalAmountsByOrderIDs(orderIDs);
    }


    public static long getAverageOfTotalAmountsByOrderIDs(List<Long> orderIDs)
    {
        return PaymentsDAO.getAverageOfTotalAmountsByOrderIDs(orderIDs);
    }


    public static PaymentModel getPaymentByStripeSessionID(String stripeSessionID)
    {
        return PaymentsDAO.getByStripeSessionID(stripeSessionID);
    }


    public static int savePayment(PaymentModel model)
    {
        return PaymentsDAO.save(model);
    }


    public static int updatePayment(PaymentModel model)
    {
        return PaymentsDAO.update(model);
    }


    public static int saveOrUpdatePayment(PaymentModel model)
    {
        return PaymentsDAO.saveOrUpdate(model);
    }


    public static int[] updatePayments(List<PaymentModel> models)
    {
        List<OrionModel> modelsCasted = models.stream().map(e -> (OrionModel)e).collect(Collectors.toList());
        return PaymentsDAO.update(modelsCasted);
    }


    public static int deletePayment(Long paymentID)
    {
        return PaymentsDAO.delete(paymentID);
    }


    public static int deletePaymentByOrderID(Long orderID)
    {
        return PaymentsDAO.deleteByOrderID(orderID);
    }


    public static List<InvoiceForStoreModel> getInvoicesForStoresByOrderID(Long orderID)
    {
        return InvoicesForStoresDAO.getInvoicesByOrderID(orderID);
    }


    public static InvoiceForStoreModel getInvoiceForStoreByID(long invoiceForStoreID)
    {
        return InvoicesForStoresDAO.getByID(invoiceForStoreID);
    }


    public static String getInvoiceForStoreURLByOrderIDAndMerchantID(Long orderID, String merchantID)
    {
        return InvoicesForStoresDAO.getInvoiceURLByOrderIDAndMerchantID(orderID, merchantID);
    }


    public static int saveInvoiceForStore(InvoiceForStoreModel model)
    {
        return InvoicesForStoresDAO.save(model);
    }


    public static int updateInvoiceForStore(InvoiceForStoreModel model)
    {
        return InvoicesForStoresDAO.update(model);
    }


    public static List<WeeklyInvoiceForStoreModel> getWeeklyInvoicesForStoreByUserID(String userID)
    {
        return WeeklyInvoicesForStoresDAO.getInvoicesByUserID(userID);
    }


    public static List<WeeklyInvoiceForStoreModel> getWeeklyInvoicesForStoreByMerchantID(String merchantID)
    {
        return WeeklyInvoicesForStoresDAO.getInvoicesByMerchantID(merchantID);
    }


    public static List<WeeklyInvoiceForStoreModel> getWeeklyInvoicesForStoreInReverseChronologicalOrderByMerchantID(String merchantID, Pagination pagination)
    {
        return WeeklyInvoicesForStoresDAO.getInvoicesInReverseChronologicalOrderByMerchantID(merchantID, pagination);
    }


    public static long getNumberOfWeeklyInvoicesForStore(String merchantID)
    {
        return WeeklyInvoicesForStoresDAO.getNumberOfWeeklyInvoicesForStore(merchantID);
    }


    public static List<WeeklyInvoiceForStoreModel> getWeeklyInvoicesForStoreByDate(String invoiceDate)
    {
        return WeeklyInvoicesForStoresDAO.getInvoicesByDate(invoiceDate);
    }


    public static WeeklyInvoiceForStoreModel getWeeklyInvoiceForStoreByStartDateAndMerchantID(String invoiceStartDateOfWeek, String merchantID)
    {
        return WeeklyInvoicesForStoresDAO.getInvoiceByStartDateAndMerchantID(invoiceStartDateOfWeek, merchantID);
    }


    public static List<WeeklyInvoiceForStoreModel> getWeeklyInvoicesForStoreByStartDateAndMerchantID(List<String> invoiceStartDatesOfWeek, String merchantID)
    {
        return WeeklyInvoicesForStoresDAO.getInvoicesByStartDateAndMerchantID(invoiceStartDatesOfWeek, merchantID);
    }


    public static WeeklyInvoiceForStoreModel getWeeklyInvoiceForStoreByID(long weeklyInvoiceForStoreID)
    {
        return WeeklyInvoicesForStoresDAO.getByID(weeklyInvoiceForStoreID);
    }


    public static WeeklyInvoiceForStoreModel getWeeklyInvoiceForStoreByID2(String weeklyInvoiceForStoreID2)
    {
        return WeeklyInvoicesForStoresDAO.getByID2(weeklyInvoiceForStoreID2);
    }


    public static WeeklyInvoiceForStoreModel getWeeklyInvoiceForStoreByIDAndUserID(Long weeklyInvoiceForStoreID, String storeUserID)
    {
        return WeeklyInvoicesForStoresDAO.getByIDAndUserID(weeklyInvoiceForStoreID, storeUserID);
    }


    public static WeeklyInvoiceForStoreModel getWeeklyInvoiceForStoreForWeek(String merchantID, String startDateOfWeek, String endDateOfWeek)
    {
        return WeeklyInvoicesForStoresDAO.getForWeek(merchantID, startDateOfWeek, endDateOfWeek);
    }


    public static int saveWeeklyInvoiceForStore(WeeklyInvoiceForStoreModel model)
    {
        return WeeklyInvoicesForStoresDAO.save(model);
    }


    public static int updateWeeklyInvoiceForStore(WeeklyInvoiceForStoreModel model)
    {
        return WeeklyInvoicesForStoresDAO.update(model);
    }


    public static OrderForWeeklyInvoiceForStoreModel getOrderForWeeklyInvoiceForStoreByOrderForWeeklyInvoiceForStoreID(long orderForWeeklyInvoiceForStoreID)
    {
        return OrdersForWeeklyInvoicesForStoresDAO.getByID(orderForWeeklyInvoiceForStoreID);
    }


    public static List<OrderForWeeklyInvoiceForStoreModel> getOrdersForWeeklyInvoiceForStoreByWeeklyInvoiceForStoreID2(String weeklyInvoiceForStoreID2)
    {
        return OrdersForWeeklyInvoicesForStoresDAO.getInvoicesByWeeklyInvoiceForStoreID2(weeklyInvoiceForStoreID2);
    }


    public static int saveOrderForWeeklyInvoiceForStore(OrderForWeeklyInvoiceForStoreModel model)
    {
        return OrdersForWeeklyInvoicesForStoresDAO.save(model);
    }


    public static int updateOrderForWeeklyInvoiceForStore(OrderForWeeklyInvoiceForStoreModel model)
    {
        return OrdersForWeeklyInvoicesForStoresDAO.update(model);
    }


    public static InvoiceOfCourierOrderUsingDirectDebitModel getPaidInvoiceOfCourierOrderForDirectDebitUserByID(long invoiceOfCourierOrderUsingDirectDebitID)
    {
        return InvoicesOfCourierOrdersUsingDirectDebitDAO.getByID(invoiceOfCourierOrderUsingDirectDebitID);
    }


    public static InvoiceOfCourierOrderUsingDirectDebitModel getPaidInvoiceOfCourierOrderForDirectDebitUserByID2(String invoiceOfCourierOrderUsingDirectDebitID2)
    {
        return InvoicesOfCourierOrdersUsingDirectDebitDAO.getByID2(invoiceOfCourierOrderUsingDirectDebitID2);
    }


    public static int saveInvoiceOfCourierOrderUsingDirectDebit(InvoiceOfCourierOrderUsingDirectDebitModel model)
    {
        return InvoicesOfCourierOrdersUsingDirectDebitDAO.save(model);
    }


    public static int saveInvoiceOfEcommerceOrder(InvoiceOfEcommerceOrderModel model)
    {
        return InvoicesOfEcommerceOrdersDAO.save(model);
    }


    public static int updateInvoiceOfCourierOrderUsingDirectDebit(InvoiceOfCourierOrderUsingDirectDebitModel model)
    {
        return InvoicesOfCourierOrdersUsingDirectDebitDAO.update(model);
    }


    public static List<SuccessfulInvoiceModel> getAllSuccessfulInvoices()
    {
        return SuccessfulInvoicesDAO.getAll();
    }


    public static SuccessfulInvoiceModel getSuccessfulInvoiceByInvoiceNumber(String invoiceNumber)
    {
        return SuccessfulInvoicesDAO.getByInvoiceNumber(invoiceNumber);
    }


    public static int saveSuccessfulInvoice(SuccessfulInvoiceModel model)
    {
        return SuccessfulInvoicesDAO.save(model);
    }


    public static int updateSuccessfulInvoice(SuccessfulInvoiceModel model)
    {
        return SuccessfulInvoicesDAO.update(model);
    }
}