package com.orion.payment.billing;

import com.orion.core.abstraction.OrionService;
import com.orion.payment.billing.data_access.MonthlyInvoicesDAO;
import com.orion.payment.billing.data_access.UserBillingDetailsDAO;
import com.orion.payment.billing.model.MonthlyInvoiceModel;
import com.orion.payment.billing.model.UserBillingDetailsModel;

public class BillingService extends OrionService
{
    public static UserBillingDetailsModel getBillingDetailsByID(String userBillingDetailsID)
    {
        return UserBillingDetailsDAO.getByID(userBillingDetailsID);
    }


    public static String getBillingEmailAddressByID(String userBillingDetailsID)
    {
        return UserBillingDetailsDAO.getEmailAddressByID(userBillingDetailsID);
    }


    public static int saveBillingDetails(UserBillingDetailsModel billingDetailsModel)
    {
        return UserBillingDetailsDAO.save(billingDetailsModel);
    }


    public static int updateBillingDetails(UserBillingDetailsModel billingDetailsModel)
    {
        return UserBillingDetailsDAO.update(billingDetailsModel);
    }


    public static int deleteBillingDetails(String userBillingDetailsID)
    {
        return UserBillingDetailsDAO.delete(userBillingDetailsID);
    }


    public static MonthlyInvoiceModel getMonthlyInvoiceByID(long monthlyInvoiceID)
    {
        return MonthlyInvoicesDAO.getByID(monthlyInvoiceID);
    }


    public static int saveMonthlyInvoice(MonthlyInvoiceModel monthlyInvoiceModel)
    {
        return MonthlyInvoicesDAO.save(monthlyInvoiceModel);
    }


    public static int updateMonthlyInvoice(MonthlyInvoiceModel monthlyInvoiceModel)
    {
        return MonthlyInvoicesDAO.update(monthlyInvoiceModel);
    }
}