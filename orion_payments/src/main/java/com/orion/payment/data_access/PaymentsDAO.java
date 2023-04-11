package com.orion.payment.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.abstraction.OrionModel;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import com.orion.payment.model.PaymentDatabaseModel;
import com.orion.payment.model.PaymentModel;
import com.orion.user_management.model.OrionUserAuthority;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentsDAO extends OrionDAO
{
    public static List<PaymentModel> getPayments()
    {
        List<Object> temp = Database.getAllRows(PaymentModel.of(),
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName);
        List<PaymentModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((PaymentModel)model1));
        }

        return results;
    }


    public static List<PaymentModel> getPaymentsByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        PaymentModel model = PaymentModel.builder()
                        .userID(userID)
                        .build();
        List<Object> temp = Database.getModels(model,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.userID));
        List<PaymentModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((PaymentModel)model1));
        }

        return results;
    }


    public static void disassociatePaymentsForUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        List<PaymentModel> payments = getPaymentsByUserID(userID);

        if(payments != null && !payments.isEmpty())
        {
            payments.forEach(payment -> payment.setUserID(OrionUserAuthority.Anonymous.get()));
            List<OrionModel> modelsCasted = payments.stream().map(e -> (OrionModel)e).collect(Collectors.toList());
            update(modelsCasted);
        }

    }


    public static boolean doesPaymentExistForOrderID(Long orderID)
    {
        Assert.notNull(orderID, "The given orderID is null.");
        PaymentModel model = PaymentModel.builder()
                        .orderID(orderID)
                        .build();
        return Database.doesRowExistWithConditionConjunction(model,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.orderID));
    }


    public static PaymentModel getByID(long paymentID)
    {
        PaymentModel model = PaymentModel.of(paymentID);
        return (PaymentModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.paymentID));
    }


    public static PaymentModel getByTransactionID(String transactionID)
    {
        Assert.notEmpty(transactionID, "The given transactionID is null/empty.");
        PaymentModel model = PaymentModel.builder()
                        .transactionID(transactionID)
                        .build();
        return (PaymentModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.transactionID));
    }


    public static boolean doesPaymentExistForTransactionID(String transactionID)
    {
        Assert.notEmpty(transactionID, "The given transactionID is null/empty.");
        PaymentModel model = PaymentModel.builder()
                        .transactionID(transactionID)
                        .build();
        return Database.doesRowExistWithConditionConjunction(model,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.transactionID));
    }


    public static PaymentModel getByOrderID(Long orderID)
    {
        Assert.notNull(orderID, "The given orderID is null.");
        PaymentModel model = PaymentModel.builder()
                        .orderID(orderID)
                        .build();
        return (PaymentModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.orderID));
    }


    public static String getStripeSessionIDByOrderID(Long orderID)
    {
        Assert.notNull(orderID, "The given orderID is null.");
        PaymentModel model = PaymentModel.builder()
                        .orderID(orderID)
                        .build();
        PaymentModel temp = (PaymentModel)Database.getOneModel(model,
                        PaymentModel.of(),
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.stripeSessionID),
                        Arrays.asList(PaymentDatabaseModel.orderID));
        return temp != null ? temp.getStripeSessionID() : "";
    }


    public static String getEmailAddressByOrderID(Long orderID)
    {
        Assert.notNull(orderID, "The given orderID is null.");
        PaymentModel model = PaymentModel.builder()
                        .orderID(orderID)
                        .build();
        PaymentModel temp = (PaymentModel)Database.getOneModel(model,
                        PaymentModel.of(),
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.emailAddress),
                        Arrays.asList(PaymentDatabaseModel.orderID));
        return temp != null ? temp.getEmailAddress() : "";
    }


    public static String getInvoiceURLByOrderID(Long orderID)
    {
        Assert.notNull(orderID, "The given orderID is null.");
        PaymentModel model = PaymentModel.builder()
                        .orderID(orderID)
                        .build();
        PaymentModel temp = (PaymentModel)Database.getOneModel(model,
                        PaymentModel.of(),
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceURL),
                        Arrays.asList(PaymentDatabaseModel.orderID));
        return temp != null ? temp.getInvoiceURL() : "";
    }


    public static String getStripeInvoiceURLByOrderID(Long orderID)
    {
        Assert.notNull(orderID, "The given orderID is null.");
        PaymentModel model = PaymentModel.builder()
                        .orderID(orderID)
                        .build();
        PaymentModel temp = (PaymentModel)Database.getOneModel(model,
                        PaymentModel.of(),
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceStripeURL),
                        Arrays.asList(PaymentDatabaseModel.orderID));
        return temp != null ? temp.getInvoiceStripeURL() : "";
    }


    public static PaymentModel getInvoiceURLsByOrderID(Long orderID)
    {
        Assert.notNull(orderID, "The given orderID is null.");
        PaymentModel model = PaymentModel.builder()
                        .orderID(orderID)
                        .build();
        PaymentModel temp = (PaymentModel)Database.getOneModel(model,
                        PaymentModel.of(),
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceStripeURL,
                                        PaymentDatabaseModel.invoiceURL),
                        Arrays.asList(PaymentDatabaseModel.orderID));
        return temp;
    }


    public static long getProcessingFeeAmountByOrderID(Long orderID)
    {
        Assert.notNull(orderID, "The given orderID is null.");
        PaymentModel model = PaymentModel.builder()
                        .orderID(orderID)
                        .build();
        PaymentModel temp = (PaymentModel)Database.getOneModel(model,
                        PaymentModel.of(),
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.processingFeeAmount),
                        Arrays.asList(PaymentDatabaseModel.orderID));
        return temp != null ? temp.getProcessingFeeAmount() : 0L;
    }


    public static long getTotalAmountByOrderID(Long orderID)
    {
        Assert.notNull(orderID, "The given orderID is null.");
        PaymentModel model = PaymentModel.builder()
                        .orderID(orderID)
                        .build();
        PaymentModel temp = (PaymentModel)Database.getOneModel(model,
                        PaymentModel.of(),
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.totalAmount),
                        Arrays.asList(PaymentDatabaseModel.orderID));
        return temp != null ? temp.getTotalAmount() : 0L;
    }


    public static long getSumOfTotalAmountsByOrderIDs(List<Long> orderIDs)
    {
        Assert.notEmpty(orderIDs, "The given orderIDs is null/empty.");
        List<String> orderIDsStrings = orderIDs.stream().map(orderID -> Long.toString(orderID)).collect(Collectors.toList());
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectSumOfColumn(PaymentDatabaseModel.totalAmount);
        mySQLQuery.fromTable(Database.paymentsDatabaseName + PaymentDatabaseModel.tablePayments);
        mySQLQuery.where();
        mySQLQuery.whereColumnIsIn(PaymentDatabaseModel.totalAmount, orderIDsStrings);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, Long.valueOf(0));

        if(temp != null && !temp.isEmpty() && temp.get(0) != null)
        {
            return (long)temp.get(0);
        }

        return 0L;
    }


    public static long getAverageOfTotalAmountsByOrderIDs(List<Long> orderIDs)
    {
        Assert.notEmpty(orderIDs, "The given orderIDs is null/empty.");
        List<String> orderIDsStrings = orderIDs.stream().map(orderID -> Long.toString(orderID)).collect(Collectors.toList());
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectAverageOfColumn(PaymentDatabaseModel.totalAmount);
        mySQLQuery.fromTable(Database.paymentsDatabaseName + PaymentDatabaseModel.tablePayments);
        mySQLQuery.where();
        mySQLQuery.whereColumnIsIn(PaymentDatabaseModel.totalAmount, orderIDsStrings);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, Double.valueOf(0.0));

        if(temp != null && !temp.isEmpty() && temp.get(0) != null)
        {
            return (long)temp.get(0);
        }

        return 0L;
    }


    public static PaymentModel getByStripeSessionID(String stripeSessionID)
    {
        Assert.notEmpty(stripeSessionID, "The given stripeSessionID is null/empty.");
        PaymentModel model = PaymentModel.builder()
                        .stripeSessionID(stripeSessionID)
                        .build();
        return (PaymentModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.stripeSessionID));
    }


    public static boolean doesPaymentExistForStripeSessionID(String stripeSessionID)
    {
        Assert.notEmpty(stripeSessionID, "The given stripeSessionID is null/empty.");
        PaymentModel model = PaymentModel.builder()
                        .stripeSessionID(stripeSessionID)
                        .build();
        return Database.doesRowExistWithConditionConjunction(model,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.stripeSessionID));
    }


    public static int save(PaymentModel model)
    {
        return Database.saveModel(model,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName);
    }


    public static int update(PaymentModel model)
    {
        Assert.notNull(model, "The given PaymentModel is null.");
        return Database.updateModel(model,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.paymentID));
    }


    public static int[] update(List<OrionModel> models)
    {
        return Database.updateModels(models,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.paymentID),
                        false);
    }


    public static int saveOrUpdate(PaymentModel model)
    {
        int rowsAffected = 0;

        if(doesPaymentExistForOrderID(model.getOrderID()))
        {
            update(model);
        }
        else
        {

            if(doesPaymentExistForStripeSessionID(model.getStripeSessionID()))
            {
                rowsAffected = update(model);
            }
            else
            {

                if(model.getTransactionID() != null && !model.getTransactionID().isEmpty())
                {

                    if(doesPaymentExistForTransactionID(model.getTransactionID()))
                    {
                        rowsAffected = update(model);
                    }
                    else
                    {
                        rowsAffected = save(model);
                    }

                }
                else
                {
                    rowsAffected = save(model);
                }

            }

        }

        return rowsAffected;
    }


    public static int delete(Long paymentID)
    {
        Assert.notNull(paymentID, "The given paymentID is null.");
        PaymentModel model = PaymentModel.of(paymentID);
        return Database.deleteModel(model,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.paymentID));
    }


    public static int deleteByOrderID(Long orderID)
    {
        Assert.notNull(orderID, "The given orderID is null.");
        PaymentModel model = PaymentModel.ofOrderID(orderID);
        return Database.deleteModel(model,
                        PaymentDatabaseModel.tablePayments,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.orderID));
    }
}