package com.orion.user_management.authentication.login.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.DateRangeWithSQLTimestamp;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.authentication.login.model.LoginDatabaseModel;
import com.orion.user_management.authentication.login.model.OrionUserLoginModel;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.UserManagementDatabaseModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrionUserLoginsDAO extends OrionDAO
{
    public static long getNumberOfUserLogins()
    {
        return Database.getNumberOfRecords(LoginDatabaseModel.tableUserLogins,
                        Database.usersDatabaseName);
    }


    public static List<OrionUserLoginModel> getUserLoginsByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserLoginModel model = OrionUserLoginModel.of(userID);
        List<Object> temp = Database.getModels(model,
                        LoginDatabaseModel.tableUserLogins,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
        List<OrionUserLoginModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserLoginModel)model1));
        }

        return results;
    }


    public static List<OrionUserLoginModel> getUserLogins()
    {
        List<OrionUserLoginModel> userLogins = new ArrayList<>();
        List<Object> temp = Database.getAllRows(OrionUserLoginModel.of(),
                        LoginDatabaseModel.tableUserLogins,
                        Database.usersDatabaseName);

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(userLogin -> userLogins.add((OrionUserLoginModel)userLogin));
        }

        return userLogins;
    }


    public static List<OrionUserLoginModel> getDateTimesByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserLoginModel model = OrionUserLoginModel.of(userID);
        List<Object> temp = Database.getModels(model,
                        OrionUserLoginModel.of(),
                        LoginDatabaseModel.tableUserLogins,
                        Database.usersDatabaseName,
                        Arrays.asList(LoginDatabaseModel.loginDateTime),
                        Arrays.asList(UserManagementDatabaseModel.userID));
        List<OrionUserLoginModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserLoginModel)model1));
        }

        return results;
    }


    public static List<OrionUserLoginModel> getDateTimesByUserIDForDateRange(String userID, String startDate, String endDate) throws InvalidDateException
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        Assert.notEmpty(startDate, "The given startDate is null/empty.");
        Assert.notEmpty(endDate, "The given endDate is null/empty.");
        OrionUserLoginModel model = OrionUserLoginModel.of(userID);
        DateRangeWithSQLTimestamp dateRangeWithSQLTimestamp = CalendarService.convert2DateStringsToDateRange(startDate, endDate);
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(Database.usersDatabaseName + LoginDatabaseModel.tableUserLogins);
        mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(Arrays.asList(UserManagementDatabaseModel.userID));
        mySQLQuery.and();
        mySQLQuery.columnIsBetween(LoginDatabaseModel.loginDateTime,
                        dateRangeWithSQLTimestamp.getStartDate().toString(),
                        dateRangeWithSQLTimestamp.getEndDate().toString());
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, model, mySQLQuery.getParameters());
        List<OrionUserLoginModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserLoginModel)model1));
        }

        return results;
    }


    public static List<OrionUserLoginModel> getDateTimesByAuthority(String authority)
    {
        Assert.notEmpty(authority, "The given authority is null/empty.");
        List<OrionUserLoginModel> userLogins = new ArrayList<>();
        List<OrionAuthorityModel> authorities = UserAccountService.getAuthoritiesByAuthority(authority);
        List<String> userIDsForAuthority = authorities.stream().map(authority1 -> authority1.getUserID()).collect(Collectors.toList());

        for(String userIDForAuthority : userIDsForAuthority)
        {
            userLogins.addAll(getDateTimesByUserID(userIDForAuthority));
        }

        return userLogins;
    }


    public static List<OrionUserLoginModel> getDateTimesByAuthorityForDateRange(String authority, String startDate, String endDate) throws InvalidDateException
    {
        Assert.notEmpty(authority, "The given authority is null/empty.");
        Assert.notEmpty(startDate, "The given startDate is null/empty.");
        Assert.notEmpty(endDate, "The given endDate is null/empty.");
        List<OrionUserLoginModel> userLogins = new ArrayList<>();
        List<OrionAuthorityModel> authorities = UserAccountService.getAuthoritiesByAuthority(authority);
        List<String> userIDsForAuthority = authorities.stream().map(authority1 -> authority1.getUserID()).collect(Collectors.toList());

        for(String userIDForAuthority : userIDsForAuthority)
        {
            userLogins.addAll(getDateTimesByUserIDForDateRange(userIDForAuthority, startDate, endDate));
        }

        return userLogins;
    }


    public static List<OrionUserLoginModel> getDateTimesForDateRange(String startDate, String endDate) throws InvalidDateException
    {
        Assert.notEmpty(startDate, "The given startDate is null/empty.");
        Assert.notEmpty(endDate, "The given endDate is null/empty.");
        DateRangeWithSQLTimestamp dateRangeWithSQLTimestamp = CalendarService.convert2DateStringsToDateRange(startDate, endDate);
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(Database.usersDatabaseName + LoginDatabaseModel.tableUserLogins);
        mySQLQuery.where();
        mySQLQuery.columnIsBetween(LoginDatabaseModel.loginDateTime,
                        dateRangeWithSQLTimestamp.getStartDate().toString(),
                        dateRangeWithSQLTimestamp.getEndDate().toString());
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, OrionUserLoginModel.of());
        List<OrionUserLoginModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserLoginModel)model1));
        }

        return results;
    }


    public static long getNumberOfLoginsByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserLoginModel model = OrionUserLoginModel.of(userID);
        return Database.getNumberOfRecords(model,
                        LoginDatabaseModel.tableUserLogins,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static long getNumberOfLoginsByAuthority(String authority)
    {
        Assert.notEmpty(authority, "The given authority is null/empty.");
        List<OrionAuthorityModel> authorities = UserAccountService.getAuthoritiesByAuthority(authority);
        List<String> userIDsForAuthority = authorities.stream().map(authority1 -> authority1.getUserID()).collect(Collectors.toList());
        long result = 0L;

        for(String userIDForAuthority : userIDsForAuthority)
        {
            result += getNumberOfLoginsByUserID(userIDForAuthority);
        }

        return result;
    }


    public static long getNumberOfLoginsByUserIDAndDate(String userID, String date)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        Assert.notEmpty(date, "The given date is null/empty.");
        OrionUserLoginModel model = OrionUserLoginModel.builder()
                        .userID(userID)
                        .loginDate(date)
                        .build();
        return Database.getNumberOfRecords(model,
                        LoginDatabaseModel.tableUserLogins,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID,
                                        LoginDatabaseModel.loginDate));
    }


    public static long getNumberOfLoginsByDate(String date)
    {
        Assert.notEmpty(date, "The given date is null/empty.");
        OrionUserLoginModel model = OrionUserLoginModel.builder()
                        .loginDate(date)
                        .build();
        return Database.getNumberOfRecords(model,
                        LoginDatabaseModel.tableUserLogins,
                        Database.usersDatabaseName,
                        Arrays.asList(LoginDatabaseModel.loginDate));
    }


    public static long getNumberOfLoginsByAuthorityAndDate(String authority, String date)
    {
        Assert.notEmpty(authority, "The given authority is null/empty.");
        Assert.notEmpty(date, "The given date is null/empty.");
        List<OrionAuthorityModel> authorities = UserAccountService.getAuthoritiesByAuthority(authority);
        List<String> userIDsForAuthority = authorities.stream().map(authority1 -> authority1.getUserID()).collect(Collectors.toList());
        long result = 0L;

        for(String userIDForAuthority : userIDsForAuthority)
        {
            OrionUserLoginModel model = OrionUserLoginModel.builder()
                            .userID(userIDForAuthority)
                            .loginDate(date)
                            .build();
            result += Database.getNumberOfRecords(model,
                            LoginDatabaseModel.tableUserLogins,
                            Database.usersDatabaseName,
                            Arrays.asList(UserManagementDatabaseModel.userID,
                                            LoginDatabaseModel.loginDate));
        }

        return result;
    }


    public static int save(OrionUserLoginModel model)
    {
        return Database.saveModel(model,
                        LoginDatabaseModel.tableUserLogins,
                        Database.usersDatabaseName);
    }
}