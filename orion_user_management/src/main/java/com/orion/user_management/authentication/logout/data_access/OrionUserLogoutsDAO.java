package com.orion.user_management.authentication.logout.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.DateRangeWithSQLTimestamp;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import com.orion.user_management.authentication.logout.model.LogoutDatabaseModel;
import com.orion.user_management.authentication.logout.model.OrionUserLogoutModel;
import com.orion.user_management.model.UserManagementDatabaseModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrionUserLogoutsDAO extends OrionDAO
{
    public static long getNumberOfUserLogouts()
    {
        return Database.getNumberOfRecords(LogoutDatabaseModel.tableUserLogouts,
                        Database.usersDatabaseName);
    }


    public static List<OrionUserLogoutModel> getUserLogoutsByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserLogoutModel model = OrionUserLogoutModel.of(userID);
        List<Object> temp = Database.getModels(model,
                        LogoutDatabaseModel.tableUserLogouts,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
        List<OrionUserLogoutModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserLogoutModel)model1));
        }

        return results;
    }


    public static long getNumberOfLogoutsByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserLogoutModel model = OrionUserLogoutModel.of(userID);
        return Database.getNumberOfRecords(model,
                        LogoutDatabaseModel.tableUserLogouts,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static List<OrionUserLogoutModel> getDateTimesByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserLogoutModel model = OrionUserLogoutModel.of(userID);
        List<Object> temp = Database.getModels(model,
                        OrionUserLogoutModel.of(),
                        LogoutDatabaseModel.tableUserLogouts,
                        Database.usersDatabaseName,
                        Arrays.asList(LogoutDatabaseModel.logoutDateTime),
                        Arrays.asList(UserManagementDatabaseModel.userID));
        List<OrionUserLogoutModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserLogoutModel)model1));
        }

        return results;
    }


    public static long getNumberOfLogoutsByDate(String date)
    {
        Assert.notEmpty(date, "The given date is null/empty.");
        OrionUserLogoutModel model = OrionUserLogoutModel.builder()
                        .logoutDate(date)
                        .build();
        return Database.getNumberOfRecords(model,
                        LogoutDatabaseModel.tableUserLogouts,
                        Database.usersDatabaseName,
                        Arrays.asList(LogoutDatabaseModel.logoutDate));
    }


    public static long getNumberOfLogoutsByUserIDAndDate(String userID, String date)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        Assert.notEmpty(date, "The given date is null/empty.");
        OrionUserLogoutModel model = OrionUserLogoutModel.builder()
                        .userID(userID)
                        .logoutDate(date)
                        .build();
        return Database.getNumberOfRecords(model,
                        LogoutDatabaseModel.tableUserLogouts,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID,
                                        LogoutDatabaseModel.logoutDate));
    }


    public static List<OrionUserLogoutModel> getDateTimesByUserIDForDateRange(String userID, String startDate, String endDate) throws InvalidDateException
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        Assert.notEmpty(startDate, "The given startDate is null/empty.");
        Assert.notEmpty(endDate, "The given endDate is null/empty.");
        OrionUserLogoutModel model = OrionUserLogoutModel.of(userID);
        DateRangeWithSQLTimestamp dateRangeWithSQLTimestamp = CalendarService.convert2DateStringsToDateRange(startDate, endDate);
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(Database.usersDatabaseName + LogoutDatabaseModel.tableUserLogouts);
        mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(Arrays.asList(UserManagementDatabaseModel.userID));
        mySQLQuery.and();
        mySQLQuery.columnIsBetween(LogoutDatabaseModel.logoutDateTime,
                        dateRangeWithSQLTimestamp.getStartDate().toString(),
                        dateRangeWithSQLTimestamp.getEndDate().toString());
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, model, mySQLQuery.getParameters());
        List<OrionUserLogoutModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserLogoutModel)model1));
        }

        return results;
    }


    public static int save(OrionUserLogoutModel model)
    {
        return Database.saveModel(model,
                        LogoutDatabaseModel.tableUserLogouts,
                        Database.usersDatabaseName);
    }
}