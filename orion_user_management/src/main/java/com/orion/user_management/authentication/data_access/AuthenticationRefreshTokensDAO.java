package com.orion.user_management.authentication.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.user_management.authentication.model.AuthenticationDatabaseModel;
import com.orion.user_management.authentication.model.AuthenticationRefreshTokenModel;
import java.util.Arrays;

public class AuthenticationRefreshTokensDAO extends OrionDAO
{
    public static boolean doesRefreshTokenExistByTokenAndUserID(String refreshToken, String userID)
    {
        AuthenticationRefreshTokenModel model = AuthenticationRefreshTokenModel.builder()
                        .refreshToken(refreshToken)
                        .userID(userID)
                        .build();
        return Database.doesRowExistWithConditionConjunction(model,
                        AuthenticationDatabaseModel.tableAuthenticationRefreshTokens,
                        Database.usersDatabaseName,
                        Arrays.asList(AuthenticationDatabaseModel.refreshToken,
                                        AuthenticationDatabaseModel.userID));
    }


    public static int save(AuthenticationRefreshTokenModel model)
    {
        Assert.notNull(model, "The given OrionEmailValidationCodesModel is null.");
        return Database.saveModel(model,
                        AuthenticationDatabaseModel.tableAuthenticationRefreshTokens,
                        Database.usersDatabaseName);
    }


    public static int deleteByToken(String refreshToken)
    {
        Assert.notEmpty(refreshToken, "The given refreshToken is null/empty.");
        AuthenticationRefreshTokenModel model = AuthenticationRefreshTokenModel.of(refreshToken);
        return Database.deleteModel(model,
                        AuthenticationDatabaseModel.tableAuthenticationRefreshTokens,
                        Database.usersDatabaseName,
                        Arrays.asList(AuthenticationDatabaseModel.refreshToken));
    }


    public static int deleteTokensByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        AuthenticationRefreshTokenModel model = AuthenticationRefreshTokenModel.builder()
                        .userID(userID)
                        .build();
        return Database.deleteModel(model,
                        AuthenticationDatabaseModel.tableAuthenticationRefreshTokens,
                        Database.usersDatabaseName,
                        Arrays.asList(AuthenticationDatabaseModel.userID));
    }
}