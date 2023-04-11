package com.orion.payment.billing.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.data.source.database.Database;
import com.orion.payment.billing.model.MonthlyInvoiceModel;
import com.orion.payment.model.PaymentDatabaseModel;
import java.util.Arrays;

public class MonthlyInvoicesDAO extends OrionDAO
{
    public static MonthlyInvoiceModel getByID(long monthlyInvoiceID)
    {
        MonthlyInvoiceModel model = MonthlyInvoiceModel.of(monthlyInvoiceID);
        return (MonthlyInvoiceModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableMonthlyInvoices,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.monthlyInvoiceID));
    }


    public static int save(MonthlyInvoiceModel model)
    {
        return Database.saveModel(model,
                        PaymentDatabaseModel.tableMonthlyInvoices,
                        Database.paymentsDatabaseName);
    }


    public static int update(MonthlyInvoiceModel model)
    {
        return Database.updateModel(model,
                        PaymentDatabaseModel.tableMonthlyInvoices,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.monthlyInvoiceID));
    }
}