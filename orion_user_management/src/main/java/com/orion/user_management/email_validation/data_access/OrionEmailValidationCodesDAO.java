package com.orion.user_management.email_validation.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.user_management.email_validation.model.EmailValidationDatabaseModel;
import com.orion.user_management.email_validation.model.OrionEmailValidationCodeModel;
import com.orion.user_management.model.UserManagementDatabaseModel;
import java.util.Arrays;

public class OrionEmailValidationCodesDAO extends OrionDAO
{
    public static long getNumberOfAccountsYetToBeValidated()
    {
        return Database.getNumberOfRecords(EmailValidationDatabaseModel.tableEmailValidationCodes,
                        Database.usersDatabaseName);
    }


    public static OrionEmailValidationCodeModel getEmailValidationCodeByCode(String emailValidationCode)
    {
        Assert.notEmpty(emailValidationCode, "The given emailValidationCode is null/empty.");
        OrionEmailValidationCodeModel model = OrionEmailValidationCodeModel.builder()
                        .emailValidationCode(emailValidationCode)
                        .build();
        return (OrionEmailValidationCodeModel)Database.getOneModel(model,
                        EmailValidationDatabaseModel.tableEmailValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(EmailValidationDatabaseModel.emailValidationCode));
    }


    public static OrionEmailValidationCodeModel getEmailValidationCodeByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionEmailValidationCodeModel model = OrionEmailValidationCodeModel.builder()
                        .userID(userID)
                        .build();
        return (OrionEmailValidationCodeModel)Database.getOneModel(model,
                        EmailValidationDatabaseModel.tableEmailValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static boolean pendingEmailValidationByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionEmailValidationCodeModel model = OrionEmailValidationCodeModel.builder()
                        .userID(userID)
                        .build();
        return Database.doesRowExistWithConditionConjunction(model,
                        EmailValidationDatabaseModel.tableEmailValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int saveEmailValidationCode(OrionEmailValidationCodeModel model)
    {
        Assert.notNull(model, "The given OrionEmailValidationCodesModel is null.");
        return Database.saveModel(model,
                        EmailValidationDatabaseModel.tableEmailValidationCodes,
                        Database.usersDatabaseName);
    }


    public static int updateEmailValidationCode(OrionEmailValidationCodeModel model)
    {
        Assert.notNull(model, "The given OrionEmailValidationCodesModel is null.");
        return Database.updateModel(model,
                        EmailValidationDatabaseModel.tableEmailValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int deleteEmailValidationCodeByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionEmailValidationCodeModel model = OrionEmailValidationCodeModel.of(userID);
        return Database.deleteModel(model,
                        EmailValidationDatabaseModel.tableEmailValidationCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }
}