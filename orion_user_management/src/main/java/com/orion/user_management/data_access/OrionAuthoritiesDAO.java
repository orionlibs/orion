package com.orion.user_management.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.data.source.database.mysql.MySQLQueryBuilderService;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserAuthority;
import com.orion.user_management.model.UserManagementDatabaseModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrionAuthoritiesDAO extends OrionDAO
{
    public static List<OrionAuthorityModel> getUsersAuthorities()
    {
        List<OrionAuthorityModel> authorities = new ArrayList<>();
        List<Object> temp = Database.getAllRows(OrionAuthorityModel.of(),
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName);

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(authority -> authorities.add((OrionAuthorityModel)authority));
        }

        return authorities;
    }


    public static List<OrionAuthorityModel> getAuthoritiesByAuthority(String authority)
    {
        Assert.notEmpty(authority, "The given authority is null/empty.");
        List<OrionAuthorityModel> authorities = new ArrayList<>();
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .authority("%" + authority + "%")
                        .build();
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableAuthorities);
        mySQLQuery.whereColumnContains(UserManagementDatabaseModel.authority);
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, OrionAuthorityModel.of(), mySQLQuery.getParameters());

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(authority1 -> authorities.add((OrionAuthorityModel)authority1));
        }

        return authorities;
    }


    public static List<OrionAuthorityModel> getActiveAuthoritiesByAuthority(String authority)
    {
        Assert.notEmpty(authority, "The given authority is null/empty.");
        List<OrionAuthorityModel> authorities = new ArrayList<>();
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .authority("%" + authority + "%")
                        .build();
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectEverythingFromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableAuthorities);
        mySQLQuery.whereColumnContains(UserManagementDatabaseModel.authority);
        mySQLQuery.and();
        mySQLQuery.append("(" + UserManagementDatabaseModel.isDeleted + " IS NULL OR " + UserManagementDatabaseModel.isDeleted + "=0)");
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, OrionAuthorityModel.of(), mySQLQuery.getParameters());

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(authority1 -> authorities.add((OrionAuthorityModel)authority1));
        }

        return authorities;
    }


    public static List<OrionAuthorityModel> getUsernamesByAuthority(String authority)
    {
        Assert.notEmpty(authority, "The given authority is null/empty.");
        List<OrionAuthorityModel> authorities = new ArrayList<>();
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .authority("%" + authority + "%")
                        .build();
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectColumn(UserManagementDatabaseModel.username);
        mySQLQuery.fromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableAuthorities);
        mySQLQuery.whereColumnContains(UserManagementDatabaseModel.authority);
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, OrionAuthorityModel.of(), mySQLQuery.getParameters());

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(authority1 -> authorities.add((OrionAuthorityModel)authority1));
        }

        return authorities;
    }


    public static boolean doesUserExistByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionAuthorityModel model = OrionAuthorityModel.of(userID);
        return Database.doesRowExistWithConditionConjunction(model,
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static boolean doesUserExistByUsername(String username)
    {
        Assert.notEmpty(username, "The given username is null/empty.");
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .username(username)
                        .build();
        return Database.doesRowExistWithConditionConjunction(model,
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.username));
    }


    public static boolean doesPendingUsernameExist(String pendingUsername)
    {
        Assert.notEmpty(pendingUsername, "The given pendingUsername is null/empty.");
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .newUsername(pendingUsername)
                        .build();
        return Database.doesRowExistWithConditionConjunction(model,
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.newUsername));
    }


    public static boolean isAccountActivated(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .userID(userID)
                        .isDeactivated(Boolean.FALSE)
                        .build();
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.selectColumn(UserManagementDatabaseModel.isDeactivated);
        mySQLQuery.fromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableAuthorities);
        mySQLQuery.whereColumnsEqualsQuestionMarkConjunction(Arrays.asList(UserManagementDatabaseModel.userID,
                        UserManagementDatabaseModel.isDeactivated));
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        List<Object> temp = Database.runSQL(SQL, model, mySQLQuery.getParameters());
        return temp != null && !temp.isEmpty();
    }


    public static long getNumberOfNonAdministratorUsers()
    {
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .authority("%" + OrionUserAuthority.Administrator.get() + "%")
                        .build();
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.count();
        mySQLQuery.fromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableAuthorities);
        mySQLQuery.whereColumnNotContains(UserManagementDatabaseModel.authority);
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        return Database.getNumberOfRecords(SQL, mySQLQuery.getParameters());
    }


    public static long getNumberOfAdministratorUsers()
    {
        return getNumberOfUsersByAuthority(OrionUserAuthority.Administrator.get());
    }


    public static long getNumberOfAnonymousUsers()
    {
        return getNumberOfUsersByAuthority(OrionUserAuthority.Anonymous.get());
    }


    public static long getNumberOfUsersByAuthority(String authority)
    {
        Assert.notEmpty(authority, "The given authority is null/empty.");
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .authority("%" + authority + "%")
                        .build();
        MySQLQueryBuilderService mySQLQuery = new MySQLQueryBuilderService();
        mySQLQuery.count();
        mySQLQuery.fromTable(Database.usersDatabaseName + UserManagementDatabaseModel.tableAuthorities);
        mySQLQuery.whereColumnContains(UserManagementDatabaseModel.authority);
        mySQLQuery.buildParametersArray(model);
        String SQL = mySQLQuery.semicolon().toString();
        return Database.getNumberOfRecords(SQL, mySQLQuery.getParameters());
    }


    public static long getNumberOfRegisteredUsers()
    {
        return Database.getNumberOfRecords(UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName);
    }


    public static OrionAuthorityModel getByUsername(String username) throws UserHasNoAuthorityException
    {
        Assert.notEmpty(username, "The given username is null/empty.");
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .username(username)
                        .build();
        OrionAuthorityModel temp = (OrionAuthorityModel)Database.getOneModel(model,
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.username));

        if(temp != null)
        {
            String[] authorities = temp.getAuthority().split(",");

            if(authorities.length == 0)
            {
                logError("No authorities exist in the database for userID '{}'", model.getUserID());
                throw new UserHasNoAuthorityException();
            }

        }

        return temp;
    }


    public static OrionAuthorityModel getByNewUsername(String username) throws UserHasNoAuthorityException
    {
        Assert.notEmpty(username, "The given username is null/empty.");
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .username(username)
                        .build();
        OrionAuthorityModel temp = (OrionAuthorityModel)Database.getOneModel(model,
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.newUsername));

        if(temp != null)
        {
            String[] authorities = temp.getAuthority().split(",");

            if(authorities.length == 0)
            {
                logError("No authorities exist in the database for userID '{}'", model.getUserID());
                throw new UserHasNoAuthorityException();
            }

        }

        return temp;
    }


    public static OrionAuthorityModel getByUserID(String userID) throws UserHasNoAuthorityException
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .userID(userID)
                        .build();
        OrionAuthorityModel temp = (OrionAuthorityModel)Database.getOneModel(model,
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));

        if(temp != null)
        {
            String[] authorities = temp.getAuthority().split(",");

            if(authorities.length == 0)
            {
                logError("No authorities exist in the database for userID '{}'", temp.getUserID());
                throw new UserHasNoAuthorityException();
            }

        }

        return temp;
    }


    public static String getUsernameByUserID(String userID) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel model = getByUserID(userID);
        return (model != null) ? model.getUsername() : null;
    }


    public static String getUserIDByUsername(String username) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel model = getByUsername(username);
        return (model != null) ? model.getUserID() : null;
    }


    public static String getUserIDByNewUsername(String username) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel model = getByNewUsername(username);
        return (model != null) ? model.getUserID() : null;
    }


    public static String getNewUsernameByUserID(String userID) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel model = getByUserID(userID);
        return (model != null) ? model.getNewUsername() : null;
    }


    public static int activateAccountByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .userID(userID)
                        .isDeactivated(Boolean.FALSE)
                        .build();
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.isDeactivated),
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int deactivateAccountByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .userID(userID)
                        .isDeactivated(Boolean.TRUE)
                        .build();
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.isDeactivated),
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int save(OrionAuthorityModel model)
    {
        return Database.saveModel(model,
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName);
    }


    public static int update(OrionAuthorityModel model)
    {
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int updateNewUsernameByUserID(String newUsername, String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .userID(userID)
                        .newUsername(newUsername)
                        .build();
        return Database.updateModel(model,
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.newUsername),
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int delete(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionAuthorityModel model = OrionAuthorityModel.builder()
                        .userID(userID)
                        .build();
        return Database.deleteModel(model,
                        UserManagementDatabaseModel.tableAuthorities,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int delete(OrionAuthorityModel model)
    {
        Assert.notNull(model, "The given model is null.");
        return delete(model.getUserID());
    }
}