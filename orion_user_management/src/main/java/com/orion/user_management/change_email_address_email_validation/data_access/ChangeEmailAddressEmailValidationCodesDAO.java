package com.orion.user_management.change_email_address_email_validation.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.user_management.change_email_address_email_validation.model.ChangeEmailAddressEmailValidationCodeModel;
import com.orion.user_management.change_email_address_email_validation.model.ChangeEmailAddressEmailValidationDatabaseModel;
import com.orion.user_management.email_validation.model.EmailValidationDatabaseModel;
import com.orion.user_management.model.UserManagementDatabaseModel;
import java.util.Arrays;

public class ChangeEmailAddressEmailValidationCodesDAO extends OrionDAO
{
    public static long getNumberOfAccountsYetToBeValidated()
    {
        return Database.getNumberOfRecords(ChangeEmailAddressEmailValidationDatabaseModel.tableChangeEmailAddressEmailValidationCodes,
                        Database.usersDatabaseName);
    }


    public static ChangeEmailAddressEmailValidationCodeModel getEmailValidationCodeModelByCode(String emailValidationCode)
    {
        Assert.notEmpty(emailValidationCode, "The given emailValidationCode is null/empty.");
        ChangeEmailAddressEmailValidationCodeModel model = ChangeEmailAddressEmailValidationCodeModel.builder()
                        .emailValidationCode(emailValidationCode)
                        .build();
        return (ChangeEmailAddressEmailValidationCodeModel)Database.getOneModel(model,
                        ChangeEmailAddressEmailValidationDatabaseModel.tableChangeEmailAddressEmailValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(EmailValidationDatabaseModel.emailValidationCode));
    }


    public static ChangeEmailAddressEmailValidationCodeModel getEmailValidationCodeModelByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        ChangeEmailAddressEmailValidationCodeModel model = ChangeEmailAddressEmailValidationCodeModel.builder()
                        .userID(userID)
                        .build();
        return (ChangeEmailAddressEmailValidationCodeModel)Database.getOneModel(model,
                        ChangeEmailAddressEmailValidationDatabaseModel.tableChangeEmailAddressEmailValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static boolean pendingEmailValidationByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        ChangeEmailAddressEmailValidationCodeModel model = ChangeEmailAddressEmailValidationCodeModel.builder()
                        .userID(userID)
                        .build();
        return Database.doesRowExistWithConditionConjunction(model,
                        ChangeEmailAddressEmailValidationDatabaseModel.tableChangeEmailAddressEmailValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int saveEmailValidationCode(ChangeEmailAddressEmailValidationCodeModel model)
    {
        Assert.notNull(model, "The given OrionEmailValidationCodesModel is null.");
        return Database.saveModel(model,
                        ChangeEmailAddressEmailValidationDatabaseModel.tableChangeEmailAddressEmailValidationCodes,
                        Database.usersDatabaseName);
    }


    public static int updateEmailValidationCode(ChangeEmailAddressEmailValidationCodeModel model)
    {
        Assert.notNull(model, "The given OrionEmailValidationCodesModel is null.");
        return Database.updateModel(model,
                        ChangeEmailAddressEmailValidationDatabaseModel.tableChangeEmailAddressEmailValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int deleteEmailValidationCodeByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        ChangeEmailAddressEmailValidationCodeModel model = ChangeEmailAddressEmailValidationCodeModel.of(userID);
        return Database.deleteModel(model,
                        ChangeEmailAddressEmailValidationDatabaseModel.tableChangeEmailAddressEmailValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }
}