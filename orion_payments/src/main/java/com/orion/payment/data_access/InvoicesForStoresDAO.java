package com.orion.payment.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.payment.model.InvoiceForStoreModel;
import com.orion.payment.model.PaymentDatabaseModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoicesForStoresDAO extends OrionDAO
{
    public static List<InvoiceForStoreModel> getInvoicesByOrderID(Long orderID)
    {
        InvoiceForStoreModel model = InvoiceForStoreModel.builder()
                        .orderID(orderID)
                        .build();
        List<Object> temp = Database.getModels(model,
                        PaymentDatabaseModel.tableInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.orderID));
        List<InvoiceForStoreModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((InvoiceForStoreModel)model1));
        }

        return results;
    }


    public static InvoiceForStoreModel getByID(long invoiceForStoreID)
    {
        InvoiceForStoreModel model = InvoiceForStoreModel.of(invoiceForStoreID);
        return (InvoiceForStoreModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceForStoreID));
    }


    public static String getInvoiceURLByOrderIDAndMerchantID(Long orderID, String merchantID)
    {
        Assert.notNull(orderID, "The given orderID is null.");
        InvoiceForStoreModel model = InvoiceForStoreModel.builder()
                        .orderID(orderID)
                        .merchantID(merchantID)
                        .build();
        InvoiceForStoreModel temp = (InvoiceForStoreModel)Database.getOneModel(model,
                        InvoiceForStoreModel.of(),
                        PaymentDatabaseModel.tableInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceForStoreURL),
                        Arrays.asList(PaymentDatabaseModel.orderID,
                                        PaymentDatabaseModel.merchantID));
        return temp != null ? temp.getInvoiceForStoreURL() : "";
    }


    public static int save(InvoiceForStoreModel model)
    {
        return Database.saveModel(model,
                        PaymentDatabaseModel.tableInvoicesForStores,
                        Database.paymentsDatabaseName);
    }


    public static int update(InvoiceForStoreModel model)
    {
        Assert.notNull(model, "The given InvoiceForStoreModel is null.");
        return Database.updateModel(model,
                        PaymentDatabaseModel.tableInvoicesForStores,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceForStoreID));
    }
}