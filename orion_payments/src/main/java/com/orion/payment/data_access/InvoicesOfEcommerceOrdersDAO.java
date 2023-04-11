package com.orion.payment.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.payment.model.InvoiceOfEcommerceOrderModel;
import com.orion.payment.model.PaymentDatabaseModel;
import java.util.Arrays;

public class InvoicesOfEcommerceOrdersDAO extends OrionDAO
{
    public static InvoiceOfEcommerceOrderModel getByID(long invoiceOfEcommerceOrderID)
    {
        InvoiceOfEcommerceOrderModel model = InvoiceOfEcommerceOrderModel.of(invoiceOfEcommerceOrderID);
        return (InvoiceOfEcommerceOrderModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableInvoicesOfEcommerceOrders,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceOfEcommerceOrderID));
    }


    public static InvoiceOfEcommerceOrderModel getByID2(String invoiceOfEcommerceOrderID2)
    {
        InvoiceOfEcommerceOrderModel model = InvoiceOfEcommerceOrderModel.ofID2(invoiceOfEcommerceOrderID2);
        return (InvoiceOfEcommerceOrderModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableInvoicesOfEcommerceOrders,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceOfEcommerceOrderID2));
    }


    public static int save(InvoiceOfEcommerceOrderModel model)
    {
        return Database.saveModel(model,
                        PaymentDatabaseModel.tableInvoicesOfEcommerceOrders,
                        Database.paymentsDatabaseName);
    }


    public static int update(InvoiceOfEcommerceOrderModel model)
    {
        Assert.notNull(model, "The given InvoiceOfEcommerceOrderModel is null.");
        return Database.updateModel(model,
                        PaymentDatabaseModel.tableInvoicesOfEcommerceOrders,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceOfEcommerceOrderID));
    }
}