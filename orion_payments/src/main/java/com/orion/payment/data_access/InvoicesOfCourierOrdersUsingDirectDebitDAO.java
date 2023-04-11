package com.orion.payment.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.payment.model.InvoiceOfCourierOrderUsingDirectDebitModel;
import com.orion.payment.model.PaymentDatabaseModel;
import java.util.Arrays;

public class InvoicesOfCourierOrdersUsingDirectDebitDAO extends OrionDAO
{
    public static InvoiceOfCourierOrderUsingDirectDebitModel getByID(long invoiceOfCourierOrderUsingDirectDebitID)
    {
        InvoiceOfCourierOrderUsingDirectDebitModel model = InvoiceOfCourierOrderUsingDirectDebitModel.of(invoiceOfCourierOrderUsingDirectDebitID);
        return (InvoiceOfCourierOrderUsingDirectDebitModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableInvoicesOfCourierOrdersUsingDirectDebit,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceOfCourierOrderUsingDirectDebitID));
    }


    public static InvoiceOfCourierOrderUsingDirectDebitModel getByID2(String invoiceOfCourierOrderUsingDirectDebitID2)
    {
        InvoiceOfCourierOrderUsingDirectDebitModel model = InvoiceOfCourierOrderUsingDirectDebitModel.ofID2(invoiceOfCourierOrderUsingDirectDebitID2);
        return (InvoiceOfCourierOrderUsingDirectDebitModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableInvoicesOfCourierOrdersUsingDirectDebit,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceOfCourierOrderUsingDirectDebitID2));
    }


    public static int save(InvoiceOfCourierOrderUsingDirectDebitModel model)
    {
        return Database.saveModel(model,
                        PaymentDatabaseModel.tableInvoicesOfCourierOrdersUsingDirectDebit,
                        Database.paymentsDatabaseName);
    }


    public static int update(InvoiceOfCourierOrderUsingDirectDebitModel model)
    {
        Assert.notNull(model, "The given PaidInvoiceOfMultidropOrderForDirectDebitUserModel is null.");
        return Database.updateModel(model,
                        PaymentDatabaseModel.tableInvoicesOfCourierOrdersUsingDirectDebit,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.invoiceOfCourierOrderUsingDirectDebitID));
    }
}