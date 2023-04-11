package com.orion.user_management.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import com.orion.user_management.model.OrionUserDetailsModel;
import com.orion.user_management.model.UserManagementDatabaseModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrionUserDetailsDAO extends OrionDAO
{
    public static List<OrionUserDetailsModel> getLoggedInUsers(OrionUserDetailsModel model)
    {
        Assert.notNull(model, "The given OrionUserDetailsModel is null.");
        OrionUserDetailsModel modelCopy = model.getCopy();
        modelCopy.setLoggedIn(true);
        List<OrionUserDetailsModel> users = new ArrayList<>();
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableUserDetails);
        mySQLQuery.joinWithTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers);
        Map<String, String> columnPairs = new HashMap<>();
        columnPairs.put(Database.usersDatabaseName + UserManagementDatabaseModel.tableUserDetails + "." + UserManagementDatabaseModel.userID,
                        Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers + "." + UserManagementDatabaseModel.userID);
        mySQLQuery.onColumns(columnPairs);
        mySQLQuery.whereColumnEqualsQuestionMark(Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers + "." + UserManagementDatabaseModel.loggedIn);
        mySQLQuery.buildParametersArray(modelCopy);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, modelCopy, mySQLQuery.getParameters());

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(user -> users.add((OrionUserDetailsModel)user));
        }

        return users;
    }


    public static List<OrionUserDetailsModel> getAllUsersDetails()
    {
        List<Object> temp = Database.getAllRows(OrionUserDetailsModel.of(),
                        UserManagementDatabaseModel.tableUserDetails,
                        Database.usersDatabaseName);
        List<OrionUserDetailsModel> applicationSpecificUserDetails = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(user -> applicationSpecificUserDetails.add((OrionUserDetailsModel)user));
        }

        return applicationSpecificUserDetails;
    }


    public static OrionUserDetailsModel getUserDetailsByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserDetailsModel model = OrionUserDetailsModel.of(userID);
        return getUserDetailsByUserID(model);
    }


    public static List<OrionUserDetailsModel> getUsersDetailsByPhoneNumber(String phoneNumber)
    {
        Assert.notEmpty(phoneNumber, "The given phoneNumber is null/empty.");
        OrionUserDetailsModel model = OrionUserDetailsModel.builder()
                        .mobileNumber(phoneNumber)
                        .build();
        return getUsersDetailsByPhoneNumber(model);
    }


    public static OrionUserDetailsModel getUserDetailsByUserID(OrionUserDetailsModel model)
    {
        Assert.notNull(model, "The given OrionUserDetailsModel is null.");
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectTableDotEverything(Database.usersDatabaseName + UserManagementDatabaseModel.tableUserDetails);
        mySQLQuery.commaSpace();
        mySQLQuery.append(Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers + "." + UserManagementDatabaseModel.loggedIn);
        mySQLQuery.fromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableUserDetails);
        mySQLQuery.joinWithTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers);
        Map<String, String> columnPairs1 = new HashMap<>();
        columnPairs1.put(Database.usersDatabaseName + UserManagementDatabaseModel.tableUserDetails + "." + UserManagementDatabaseModel.userID,
                        Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers + "." + UserManagementDatabaseModel.userID);
        mySQLQuery.onColumns(columnPairs1);
        mySQLQuery.whereColumnEqualsQuestionMark(Database.usersDatabaseName + UserManagementDatabaseModel.tableUserDetails + "." + UserManagementDatabaseModel.userID);
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, model, mySQLQuery.getParameters());

        if(temp != null && !temp.isEmpty())
        {
            return (OrionUserDetailsModel)temp.get(0);
        }

        return null;
    }


    public static List<OrionUserDetailsModel> getUsersDetailsByPhoneNumber(OrionUserDetailsModel model)
    {
        Assert.notNull(model, "The given OrionUserDetailsModel is null.");
        List<Object> temp = Database.getModels(model,
                        UserManagementDatabaseModel.tableUserDetails,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.mobileNumber));
        List<OrionUserDetailsModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserDetailsModel)model1));
        }

        return results;
    }


    public static String getFirstNameByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null.");
        OrionUserDetailsModel model = OrionUserDetailsModel.of(userID);
        model = (OrionUserDetailsModel)Database.getOneModel(model,
                        OrionUserDetailsModel.of(),
                        UserManagementDatabaseModel.tableUserDetails,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.firstName),
                        Arrays.asList(UserManagementDatabaseModel.userID));
        return (model != null) ? model.getFirstName() : "";
    }


    public static String getFullNameByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null.");
        OrionUserDetailsModel model = OrionUserDetailsModel.of(userID);
        model = (OrionUserDetailsModel)Database.getOneModel(model,
                        OrionUserDetailsModel.of(),
                        UserManagementDatabaseModel.tableUserDetails,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.firstName,
                                        UserManagementDatabaseModel.middleName,
                                        UserManagementDatabaseModel.lastName),
                        Arrays.asList(UserManagementDatabaseModel.userID));
        return (model != null) ? model.getFullName() : "";
    }


    public static String getPhoneNumberByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null.");
        OrionUserDetailsModel model = OrionUserDetailsModel.of(userID);
        model = (OrionUserDetailsModel)Database.getOneModel(model,
                        OrionUserDetailsModel.of(),
                        UserManagementDatabaseModel.tableUserDetails,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.mobileNumber),
                        Arrays.asList(UserManagementDatabaseModel.userID));
        return (model != null) ? model.getMobileNumber() : "";
    }


    public static String getEmailAddressByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null.");
        OrionUserDetailsModel model = OrionUserDetailsModel.of(userID);
        model = (OrionUserDetailsModel)Database.getOneModel(model,
                        OrionUserDetailsModel.of(),
                        UserManagementDatabaseModel.tableUserDetails,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.emailAddress),
                        Arrays.asList(UserManagementDatabaseModel.userID));
        return (model != null) ? model.getEmailAddress() : "";
    }


    public static int save(OrionUserDetailsModel model)
    {
        Assert.notNull(model, "The given OrionUserDetailsModel is null.");
        return Database.saveModel(model,
                        UserManagementDatabaseModel.tableUserDetails,
                        Database.usersDatabaseName);
    }


    public static int update(OrionUserDetailsModel model)
    {
        Assert.notNull(model, "The given OrionUserDetailsModel is null.");
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableUserDetails,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int delete(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserDetailsModel model = OrionUserDetailsModel.of(userID);
        return Database.deleteModel(model,
                        UserManagementDatabaseModel.tableUserDetails,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }
}