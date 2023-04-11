package com.orion.user_management.forgot_password.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import com.orion.user_management.forgot_password.model.ForgotPasswordDatabaseModel;
import com.orion.user_management.forgot_password.model.OrionForgotPasswordCodesModel;
import com.orion.user_management.model.OrionUserDetailsModel;
import com.orion.user_management.model.UserManagementDatabaseModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrionForgotPasswordCodesDAO extends OrionDAO
{
    public static long getNumberOfResetPasswordRequests()
    {
        return Database.getNumberOfRecords(ForgotPasswordDatabaseModel.tableForgotPasswordCodes,
                        Database.usersDatabaseName);
    }


    public static OrionForgotPasswordCodesModel getForgotPasswordCodeByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionForgotPasswordCodesModel model = OrionForgotPasswordCodesModel.of(userID);
        return (OrionForgotPasswordCodesModel)Database.getOneModel(model,
                        ForgotPasswordDatabaseModel.tableForgotPasswordCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static OrionForgotPasswordCodesModel getForgotPasswordCodeByCode(String forgotPasswordCode)
    {
        Assert.notEmpty(forgotPasswordCode, "The given forgotPasswordCode is null/empty.");
        OrionForgotPasswordCodesModel model = OrionForgotPasswordCodesModel.builder()
                        .forgotPasswordCode(forgotPasswordCode)
                        .build();
        return (OrionForgotPasswordCodesModel)Database.getOneModel(model,
                        ForgotPasswordDatabaseModel.tableForgotPasswordCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(ForgotPasswordDatabaseModel.forgotPasswordCode));
    }


    public static boolean pendingForgotPasswordByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionForgotPasswordCodesModel model = OrionForgotPasswordCodesModel.builder()
                        .userID(userID)
                        .build();
        return Database.doesRowExistWithConditionConjunction(model,
                        ForgotPasswordDatabaseModel.tableForgotPasswordCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static List<OrionUserDetailsModel> getUsersWithPendingResetPasswordChange(OrionUserDetailsModel model)
    {
        Assert.notNull(model, "The given OrionUserDetailsModel is null/empty.");
        model.setEnabled(false);
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectTableDotEverythingFromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableUserDetails);
        mySQLQuery.joinWithTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers);
        Map<String, String> columnPairs1 = new HashMap<>();
        columnPairs1.put(Database.usersDatabaseName + UserManagementDatabaseModel.tableUserDetails + "." + UserManagementDatabaseModel.userID,
                        Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers + "." + UserManagementDatabaseModel.userID);
        mySQLQuery.onColumns(columnPairs1);
        mySQLQuery.joinWithTable(Database.usersDatabaseName + ForgotPasswordDatabaseModel.tableForgotPasswordCodes);
        Map<String, String> columnPairs2 = new HashMap<>();
        columnPairs2.put(Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers + "." + UserManagementDatabaseModel.userID,
                        Database.usersDatabaseName + ForgotPasswordDatabaseModel.tableForgotPasswordCodes + "." + UserManagementDatabaseModel.userID);
        mySQLQuery.onColumns(columnPairs2);
        mySQLQuery.whereColumnEqualsQuestionMark(Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers + "." + UserManagementDatabaseModel.enabled);
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, model, mySQLQuery.getParameters());
        List<OrionUserDetailsModel> usersWithPendingResetPasswordChange = null;

        if(temp != null && !temp.isEmpty())
        {
            usersWithPendingResetPasswordChange = new ArrayList<OrionUserDetailsModel>(temp.size());

            for(Object model1 : temp)
            {
                usersWithPendingResetPasswordChange.add((OrionUserDetailsModel)model1);
            }

        }

        return usersWithPendingResetPasswordChange;
    }


    public static int save(OrionForgotPasswordCodesModel model)
    {
        Assert.notNull(model, "The given OrionForgotPasswordCodesModel is null.");
        return Database.saveModel(model,
                        ForgotPasswordDatabaseModel.tableForgotPasswordCodes,
                        Database.usersDatabaseName);
    }


    public static int update(OrionForgotPasswordCodesModel model)
    {
        Assert.notNull(model, "The given OrionForgotPasswordCodesModel is null.");
        return Database.updateModel(model,
                        ForgotPasswordDatabaseModel.tableForgotPasswordCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int deleteByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionForgotPasswordCodesModel model = OrionForgotPasswordCodesModel.of(userID);
        return Database.deleteModel(model,
                        ForgotPasswordDatabaseModel.tableForgotPasswordCodes,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }
}