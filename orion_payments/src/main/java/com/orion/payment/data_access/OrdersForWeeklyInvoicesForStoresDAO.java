package com.orion.payment.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.payment.model.OrderForWeeklyInvoiceForStoreModel;
import com.orion.payment.model.PaymentDatabaseModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrdersForWeeklyInvoicesForStoresDAO extends OrionDAO
{
    public static List<OrderForWeeklyInvoiceForStoreModel> getInvoicesByWeeklyInvoiceForStoreID2(String weeklyInvoiceForStoreID2)
    {
        OrderForWeeklyInvoiceForStoreModel model = OrderForWeeklyInvoiceForStoreModel.builder()
                        .weeklyInvoiceForStoreID2(weeklyInvoiceForStoreID2)
                        .build();
        List<Object> temp = Database.getModels(model,
                        PaymentDatabaseModel.tableOrdersForWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.weeklyInvoiceForStoreID2));
        List<OrderForWeeklyInvoiceForStoreModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrderForWeeklyInvoiceForStoreModel)model1));
        }

        return results;
    }


    public static OrderForWeeklyInvoiceForStoreModel getByID(long orderForWeeklyInvoiceForStoreID)
    {
        OrderForWeeklyInvoiceForStoreModel model = OrderForWeeklyInvoiceForStoreModel.of(orderForWeeklyInvoiceForStoreID);
        return (OrderForWeeklyInvoiceForStoreModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableOrdersForWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.orderForWeeklyInvoiceForStoreID));
    }


    public static int save(OrderForWeeklyInvoiceForStoreModel model)
    {
        return Database.saveModel(model,
                        PaymentDatabaseModel.tableOrdersForWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName);
    }


    public static int update(OrderForWeeklyInvoiceForStoreModel model)
    {
        Assert.notNull(model, "The given OrderForWeeklyInvoiceForStoreModel is null.");
        return Database.updateModel(model,
                        PaymentDatabaseModel.tableOrdersForWeeklyInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.orderForWeeklyInvoiceForStoreID));
    }
}