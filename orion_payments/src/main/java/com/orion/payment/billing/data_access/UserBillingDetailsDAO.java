package com.orion.payment.billing.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.payment.billing.model.UserBillingDetailsModel;
import com.orion.payment.model.PaymentDatabaseModel;
import java.util.Arrays;

public class UserBillingDetailsDAO extends OrionDAO
{
    public static UserBillingDetailsModel getByID(String userBillingDetailsID)
    {
        UserBillingDetailsModel model = UserBillingDetailsModel.of(userBillingDetailsID);
        return (UserBillingDetailsModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableUserBillingDetails,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.userBillingDetailsID));
    }


    public static String getEmailAddressByID(String userBillingDetailsID)
    {
        UserBillingDetailsModel model = UserBillingDetailsModel.of(userBillingDetailsID);
        UserBillingDetailsModel temp = (UserBillingDetailsModel)Database.getOneModel(model,
                        UserBillingDetailsModel.of(),
                        PaymentDatabaseModel.tableUserBillingDetails,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.emailAddress),
                        Arrays.asList(PaymentDatabaseModel.userBillingDetailsID));
        return temp != null ? temp.getEmailAddress() : "";
    }


    public static int save(UserBillingDetailsModel model)
    {
        return Database.saveModel(model,
                        PaymentDatabaseModel.tableUserBillingDetails,
                        Database.paymentsDatabaseName);
    }


    public static int update(UserBillingDetailsModel model)
    {
        return Database.updateModel(model,
                        PaymentDatabaseModel.tableUserBillingDetails,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.userBillingDetailsID));
    }


    public static int delete(String userBillingDetailsID)
    {
        Assert.notNull(userBillingDetailsID, "The given userBillingDetailsID is null.");
        UserBillingDetailsModel model = UserBillingDetailsModel.of(userBillingDetailsID);
        return Database.deleteModel(model,
                        PaymentDatabaseModel.tableUserBillingDetails,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.userBillingDetailsID));
    }
}