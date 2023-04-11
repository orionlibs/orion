package com.orion.payment.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.payment.model.PaymentDatabaseModel;
import com.orion.payment.model.SuccessfulInvoiceModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuccessfulInvoicesDAO extends OrionDAO
{
    public static List<SuccessfulInvoiceModel> getAll()
    {
        List<Object> temp = Database.getAllRows(SuccessfulInvoiceModel.of(),
                        PaymentDatabaseModel.tableSuccessfulInvoices,
                        Database.paymentsDatabaseName);
        List<SuccessfulInvoiceModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((SuccessfulInvoiceModel)model1));
        }

        return results;
    }


    public static SuccessfulInvoiceModel getByInvoiceNumber(String invoiceNumber)
    {
        SuccessfulInvoiceModel model = SuccessfulInvoiceModel.of(invoiceNumber);
        return (SuccessfulInvoiceModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableSuccessfulInvoices,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceNumber));
    }


    public static int save(SuccessfulInvoiceModel model)
    {
        return Database.saveModel(model,
                        PaymentDatabaseModel.tableSuccessfulInvoices,
                        Database.paymentsDatabaseName);
    }


    public static int update(SuccessfulInvoiceModel model)
    {
        Assert.notNull(model, "The given SuccessfulInvoiceModel is null.");
        return Database.updateModel(model,
                        PaymentDatabaseModel.tableSuccessfulInvoices,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceForStoreID));
    }
}