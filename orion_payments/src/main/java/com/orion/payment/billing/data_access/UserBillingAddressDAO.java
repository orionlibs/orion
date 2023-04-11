package com.orion.payment.billing.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.payment.billing.model.UserBillingAddressModel;
import com.orion.payment.model.PaymentDatabaseModel;
import java.util.Arrays;

public class UserBillingAddressDAO extends OrionDAO
{
    public static UserBillingAddressModel getByID(String userBillingAddressID)
    {
        Assert.notEmpty(userBillingAddressID, "The given userBillingAddressID is null/empty.");
        UserBillingAddressModel model = UserBillingAddressModel.of(userBillingAddressID);
        return (UserBillingAddressModel)Database.getOneModel(model,
                        PaymentDatabaseModel.tableUserBillingAddress,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.userBillingAddressID));
    }


    public static int save(UserBillingAddressModel model)
    {
        return Database.saveModel(model,
                        PaymentDatabaseModel.tableUserBillingAddress,
                        Database.paymentsDatabaseName);
    }


    public static int update(UserBillingAddressModel model)
    {
        return Database.updateModel(model,
                        PaymentDatabaseModel.tableUserBillingAddress,
                        Database.paymentsDatabaseName,
                        Arrays.asList(PaymentDatabaseModel.userBillingAddressID));
    }
}