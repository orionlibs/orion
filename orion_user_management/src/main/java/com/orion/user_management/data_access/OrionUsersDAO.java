package com.orion.user_management.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.DateRangeWithSQLTimestamp;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserModel;
import com.orion.user_management.model.UserManagementDatabaseModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OrionUsersDAO extends OrionDAO
{
    public static long getNumberOfAccountLockdowns()
    {
        return Database.getSumOfColumn(UserManagementDatabaseModel.numberOfAccountLockdowns,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName);
    }


    public static long getNumberOfLoggedInUsers()
    {
        OrionUserModel model = OrionUserModel.builder()
                        .loggedIn(true)
                        .build();
        return Database.getNumberOfRecords(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.loggedIn));
    }


    public static long getNumberOfLoggedOutUsers()
    {
        OrionUserModel model = OrionUserModel.builder()
                        .loggedIn(false)
                        .build();
        return Database.getNumberOfRecords(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.loggedIn));
    }


    public static long getNumberOfEnabledAccounts()
    {
        OrionUserModel model = OrionUserModel.builder()
                        .enabled(true)
                        .build();
        return Database.getNumberOfRecords(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.enabled));
    }


    public static long getNumberOfDisabledAccounts()
    {
        OrionUserModel model = OrionUserModel.builder()
                        .enabled(false)
                        .build();
        return Database.getNumberOfRecords(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.enabled));
    }


    public static List<OrionUserModel> getUsers()
    {
        List<Object> temp = Database.getAllRows(OrionUserModel.of(),
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName);
        List<OrionUserModel> users = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(user -> users.add((OrionUserModel)user));
        }

        return users;
    }


    public static OrionUserModel getByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserModel model = OrionUserModel.of(userID);
        return (OrionUserModel)Database.getOneModel(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static OrionUserModel getByUserIDAndEnabled(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserModel model = OrionUserModel.builder()
                        .userID(userID)
                        .enabled(true)
                        .build();
        return (OrionUserModel)Database.getOneModel(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID,
                                        UserManagementDatabaseModel.enabled));
    }


    public static int disableAccountByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserModel model = getByUserID(userID);
        model.setEnabled(false);
        model.setLoggedIn(false);
        model.setMustChangePassword(false);
        model.setNumberOfAccountLockdowns(0);
        model.setNeedsReauthentication(false);
        model.setPendingEmailAddressValidation(false);
        model.setLastAccountUpdateDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp());
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.enabled,
                                        UserManagementDatabaseModel.loggedIn,
                                        UserManagementDatabaseModel.mustChangePassword,
                                        UserManagementDatabaseModel.lastAccountUpdateDateTime,
                                        UserManagementDatabaseModel.needsReauthentication,
                                        UserManagementDatabaseModel.pendingEmailAddressValidation,
                                        UserManagementDatabaseModel.numberOfAccountLockdowns),
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int enableAccountByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserModel model = OrionUserModel.builder()
                        .userID(userID)
                        .enabled(true)
                        .lastAccountUpdateDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp())
                        .build();
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.enabled),
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int resetPasswordByUserID(String userID, String password)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        Assert.notEmpty(password, "The given password is null/empty.");
        OrionUserModel model = OrionUserModel.builder()
                        .userID(userID)
                        .password(password)
                        .lastAccountUpdateDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp())
                        .build();
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.password,
                                        UserManagementDatabaseModel.lastAccountUpdateDateTime),
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int setUserAsLoggedInByUserID(OrionUserModel model)
    {
        Assert.notNull(model, "The given OrionUserModel is null.");
        model.setLoggedIn(true);
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.loggedIn,
                                        UserManagementDatabaseModel.lastLogInDateTime),
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int setUserAsLoggedInByUserID(String userID, SQLTimestamp lastLogInDateTime)
    {
        Assert.notNull(userID, "The given userID is null.");
        OrionUserModel model = OrionUserModel.builder()
                        .userID(userID)
                        .loggedIn(true)
                        .lastLogInDateTime(lastLogInDateTime)
                        .build();
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.loggedIn,
                                        UserManagementDatabaseModel.lastLogInDateTime),
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int setUserAsLoggedOutByUserID(OrionUserModel model)
    {
        Assert.notNull(model, "The given OrionUserModel is null.");
        model.setLoggedIn(false);
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.loggedIn,
                                        UserManagementDatabaseModel.lastLogInDateTime),
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int setUserAsLoggedOutByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserModel model = OrionUserModel.builder()
                        .userID(userID)
                        .loggedIn(false)
                        .build();
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.loggedIn),
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int setAllUsersAsLoggedOut()
    {
        OrionUserModel model = OrionUserModel.builder()
                        .loggedIn(false)
                        .build();
        return Database.updateAllRows(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.loggedIn));
    }


    public static boolean isUserLoggedInByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserModel model = OrionUserModel.builder()
                        .userID(userID)
                        .loggedIn(true)
                        .build();
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectColumn(UserManagementDatabaseModel.loggedIn);
        mySQLQuery.fromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers);
        mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(Arrays.asList(UserManagementDatabaseModel.userID,
                        UserManagementDatabaseModel.loggedIn));
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, model, mySQLQuery.getParameters());
        return temp != null && !temp.isEmpty();
    }


    public static boolean isUserEnabledByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserModel model = OrionUserModel.builder()
                        .userID(userID)
                        .enabled(true)
                        .build();
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectColumn(UserManagementDatabaseModel.enabled);
        mySQLQuery.fromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers);
        mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(Arrays.asList(UserManagementDatabaseModel.userID,
                        UserManagementDatabaseModel.enabled));
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, model, mySQLQuery.getParameters());
        return temp != null && !temp.isEmpty();
    }


    public static boolean doesAccountNeedReauthentication(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserModel model = OrionUserModel.builder()
                        .userID(userID)
                        .build();
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectColumn(UserManagementDatabaseModel.needsReauthentication);
        mySQLQuery.fromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers);
        mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(Arrays.asList(UserManagementDatabaseModel.userID));
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, model, mySQLQuery.getParameters());
        return temp != null && !temp.isEmpty();
    }


    public static List<OrionUserModel> getUserRegistrationDateTimes()
    {
        List<Object> temp = Database.getModels(OrionUserModel.of(),
                        OrionUserModel.of(),
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.registrationDateTime),
                        null);
        List<OrionUserModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserModel)model1));
        }

        return results;
    }


    public static List<OrionUserModel> getUserRegistrationDateTimesForDateRange(String startDate, String endDate) throws InvalidDateException
    {
        Assert.notEmpty(startDate, "The given startDate is null/empty.");
        Assert.notEmpty(endDate, "The given endDate is null/empty.");
        DateRangeWithSQLTimestamp dateRangeWithSQLTimestamp = CalendarService.convert2DateStringsToDateRange(startDate, endDate);
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers);
        mySQLQuery.where();
        mySQLQuery.columnIsBetween(UserManagementDatabaseModel.registrationDateTime,
                        dateRangeWithSQLTimestamp.getStartDate().toString(),
                        dateRangeWithSQLTimestamp.getEndDate().toString());
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, OrionUserModel.of());
        List<OrionUserModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserModel)model1));
        }

        return results;
    }


    public static List<OrionUserModel> getUserRegistrationDateTimesByAuthorityForDateRange(String authority, String startDate, String endDate) throws InvalidDateException
    {
        Assert.notEmpty(authority, "The given authority is null/empty.");
        Assert.notEmpty(startDate, "The given startDate is null/empty.");
        Assert.notEmpty(endDate, "The given endDate is null/empty.");
        List<OrionUserModel> userLogins = new ArrayList<>();
        List<OrionAuthorityModel> authorities = UserAccountService.getAuthoritiesByAuthority(authority);
        List<String> userIDsForAuthority = authorities.stream().map(authority1 -> authority1.getUserID()).collect(Collectors.toList());

        for(String userIDForAuthority : userIDsForAuthority)
        {
            userLogins.addAll(getUserRegistrationDateTimesByUserIDForDateRange(userIDForAuthority, startDate, endDate));
        }

        return userLogins;
    }


    public static List<OrionUserModel> getUserRegistrationDateTimesByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserModel model = OrionUserModel.of(userID);
        List<Object> temp = Database.getModels(model,
                        OrionUserModel.of(),
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.registrationDateTime),
                        Arrays.asList(UserManagementDatabaseModel.userID));
        List<OrionUserModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserModel)model1));
        }

        return results;
    }


    public static List<OrionUserModel> getUserRegistrationDateTimesByUserIDForDateRange(String userID, String startDate, String endDate) throws InvalidDateException
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        Assert.notEmpty(startDate, "The given startDate is null/empty.");
        Assert.notEmpty(endDate, "The given endDate is null/empty.");
        OrionUserModel model = OrionUserModel.of(userID);
        DateRangeWithSQLTimestamp dateRangeWithSQLTimestamp = CalendarService.convert2DateStringsToDateRange(startDate, endDate);
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableUsers);
        mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(Arrays.asList(UserManagementDatabaseModel.userID));
        mySQLQuery.and();
        mySQLQuery.columnIsBetween(UserManagementDatabaseModel.registrationDateTime,
                        dateRangeWithSQLTimestamp.getStartDate().toString(),
                        dateRangeWithSQLTimestamp.getStartDate().toString());
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, model, mySQLQuery.getParameters());
        List<OrionUserModel> results = new ArrayList<>();

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(model1 -> results.add((OrionUserModel)model1));
        }

        return results;
    }


    public static List<OrionUserModel> getUserRegistrationDateTimesByAuthority(String authority)
    {
        Assert.notEmpty(authority, "The given authority is null/empty.");
        List<OrionUserModel> results = new ArrayList<>();
        List<OrionAuthorityModel> authorities = UserAccountService.getAuthoritiesByAuthority(authority);
        List<String> userIDsForAuthority = authorities.stream().map(authority1 -> authority1.getUserID()).collect(Collectors.toList());

        for(String userIDForAuthority : userIDsForAuthority)
        {
            results.addAll(getUserRegistrationDateTimesByUserID(userIDForAuthority));
        }

        return results;
    }


    public static long getNumberOfUserRegistrationsByDate(String date)
    {
        Assert.notEmpty(date, "The given date is null/empty.");
        OrionUserModel model = OrionUserModel.builder()
                        .registrationDate(date)
                        .build();
        return Database.getNumberOfRecords(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.registrationDate));
    }


    public static long getNumberOfUserRegistrationsByAuthorityAndDate(String authority, String date)
    {
        Assert.notEmpty(authority, "The given authority is null/empty.");
        Assert.notEmpty(date, "The given date is null/empty.");
        long results = 0L;
        List<OrionAuthorityModel> authorities = UserAccountService.getAuthoritiesByAuthority(authority);
        List<String> userIDsForAuthority = authorities.stream().map(authority1 -> authority1.getUserID()).collect(Collectors.toList());

        for(String userIDForAuthority : userIDsForAuthority)
        {
            OrionUserModel model = OrionUserModel.builder()
                            .userID(userIDForAuthority)
                            .registrationDate(date)
                            .build();
            results += Database.getNumberOfRecords(model,
                            UserManagementDatabaseModel.tableUsers,
                            Database.usersDatabaseName,
                            Arrays.asList(UserManagementDatabaseModel.userID,
                                            UserManagementDatabaseModel.registrationDate));
        }

        return results;
    }


    public static int save(OrionUserModel model)
    {
        return Database.saveModel(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName);
    }


    public static int update(OrionUserModel model)
    {
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int delete(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserModel model = OrionUserModel.builder()
                        .userID(userID)
                        .build();
        return Database.deleteModel(model,
                        UserManagementDatabaseModel.tableUsers,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }
}