package com.orion.payment.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.content.Pagination;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import com.orion.payment.model.PaymentDatabaseModel;
import com.orion.payment.model.WeeklyInvoiceForStoreModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeeklyInvoicesForStoresDAO extends OrionDAO
{
    public static List<WeeklyInvoiceForStoreModel> getInvoicesByUserID(String userID)
    {
        WeeklyInvoiceForStoreModel model = WeeklyInvoiceForStoreModel.builder()
                        .userID(userID)
                        .build();
        List<Object> temp = Database.getModels(model,
                        PaymentDatabaseModel.tableWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.userID));
        List<WeeklyInvoiceForStoreModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((WeeklyInvoiceForStoreModel)model1));
        }

        return results;
    }


    public static List<WeeklyInvoiceForStoreModel> getInvoicesByMerchantID(String merchantID)
    {
        WeeklyInvoiceForStoreModel model = WeeklyInvoiceForStoreModel.builder()
                        .merchantID(merchantID)
                        .build();
        List<Object> temp = Database.getModels(model,
                        PaymentDatabaseModel.tableWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.merchantID));
        List<WeeklyInvoiceForStoreModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((WeeklyInvoiceForStoreModel)model1));
        }

        return results;
    }


    public static List<WeeklyInvoiceForStoreModel> getInvoicesInReverseChronologicalOrderByMerchantID(String merchantID, Pagination pagination)
    {
        WeeklyInvoiceForStoreModel model = WeeklyInvoiceForStoreModel.builder()
                        .merchantID(merchantID)
                        .build();
        List<Object> temp = Database.getModelsWithDescendingOrder(model,
                        PaymentDatabaseModel.tableWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.merchantID),
                        PaymentDatabaseModel.startDateOfWeekDateTime,
                        pagination);
        List<WeeklyInvoiceForStoreModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((WeeklyInvoiceForStoreModel)model1));
        }

        return results;
    }


    public static long getNumberOfWeeklyInvoicesForStore(String merchantID)
    {
        WeeklyInvoiceForStoreModel model = WeeklyInvoiceForStoreModel.builder()
                        .merchantID(merchantID)
                        .build();
        return Database.getNumberOfRecords(model,
                        PaymentDatabaseModel.tableWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.merchantID));
    }


    public static List<WeeklyInvoiceForStoreModel> getInvoicesByDate(String invoiceDate)
    {
        WeeklyInvoiceForStoreModel model = WeeklyInvoiceForStoreModel.builder()
                        .invoiceDate(invoiceDate)
                        .build();
        List<Object> temp = Database.getModels(model,
                        PaymentDatabaseModel.tableWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceDate));
        List<WeeklyInvoiceForStoreModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((WeeklyInvoiceForStoreModel)model1));
        }

        return results;
    }


    public static WeeklyInvoiceForStoreModel getInvoiceByStartDateAndMerchantID(String invoiceStartDateOfWeek, String merchantID)
    {
        WeeklyInvoiceForStoreModel model = WeeklyInvoiceForStoreModel.builder()
                        .startDateOfWeek(invoiceStartDateOfWeek)
                        .merchantID(merchantID)
                        .build();
        return (WeeklyInvoiceForStoreModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.startDateOfWeek,
                                        PaymentDatabaseModel.merchantID));
    }


    public static List<WeeklyInvoiceForStoreModel> getInvoicesByStartDateAndMerchantID(List<String> invoiceStartDatesOfWeek, String merchantID)
    {
        WeeklyInvoiceForStoreModel model = WeeklyInvoiceForStoreModel.builder()
                        .merchantID(merchantID)
                        .build();
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(Database.paymentsDatabaseName + PaymentDatabaseModel.tableWeeklyInvoicesForStores);
        mySQLQuery.where();
        mySQLQuery.columnIsIn(PaymentDatabaseModel.startDateOfWeek, invoiceStartDatesOfWeek);
        mySQLQuery.descendingOrderByColumn(PaymentDatabaseModel.startDateOfWeekDateTime);
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, model, mySQLQuery.getParameters());
        List<WeeklyInvoiceForStoreModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((WeeklyInvoiceForStoreModel)model1));
        }

        return results;
    }


    public static WeeklyInvoiceForStoreModel getByID(long weeklyInvoiceForStoreID)
    {
        WeeklyInvoiceForStoreModel model = WeeklyInvoiceForStoreModel.of(weeklyInvoiceForStoreID);
        return (WeeklyInvoiceForStoreModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.weeklyInvoiceForStoreID));
    }


    public static WeeklyInvoiceForStoreModel getByID2(String weeklyInvoiceForStoreID2)
    {
        WeeklyInvoiceForStoreModel model = WeeklyInvoiceForStoreModel.ofID2(weeklyInvoiceForStoreID2);
        return (WeeklyInvoiceForStoreModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.weeklyInvoiceForStoreID2));
    }


    public static WeeklyInvoiceForStoreModel getByIDAndUserID(Long weeklyInvoiceForStoreID, String userID)
    {
        WeeklyInvoiceForStoreModel model = WeeklyInvoiceForStoreModel.builder()
                        .weeklyInvoiceForStoreID(weeklyInvoiceForStoreID)
                        .userID(userID)
                        .build();
        return (WeeklyInvoiceForStoreModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.weeklyInvoiceForStoreID,
                                        PaymentDatabaseModel.userID));
    }


    public static WeeklyInvoiceForStoreModel getForWeek(String merchantID, String startDateOfWeek, String endDateOfWeek)
    {
        WeeklyInvoiceForStoreModel model = WeeklyInvoiceForStoreModel.builder()
                        .merchantID(merchantID)
                        .startDateOfWeek(startDateOfWeek)
                        .endDateOfWeek(endDateOfWeek)
                        .build();
        return (WeeklyInvoiceForStoreModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.merchantID,
                                        PaymentDatabaseModel.startDateOfWeek,
                                        PaymentDatabaseModel.endDateOfWeek));
    }


    public static int save(WeeklyInvoiceForStoreModel model)
    {
        return Database.saveModel(model,
                        PaymentDatabaseModel.tableWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName);
    }


    public static int update(WeeklyInvoiceForStoreModel model)
    {
        Assert.notNull(model, "The given WeeklyInvoiceForStoreModel is null.");
        return Database.updateModel(model,
                        PaymentDatabaseModel.tableWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.weeklyInvoiceForStoreID));
    }
}