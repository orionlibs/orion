package com.orion.user_management.security_question.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.user_management.model.UserManagementDatabaseModel;
import com.orion.user_management.security_question.model.OrionUserSecurityQuestionModel;
import com.orion.user_management.security_question.model.SecurityQuestionDatabaseModel;
import java.util.Arrays;

public class OrionUsersSecurityQuestionsDAO extends OrionDAO
{
    public static boolean areSecurityQuestionsSetUpForUser(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserSecurityQuestionModel model = OrionUserSecurityQuestionModel.of(userID);
        model = getUserSecurityQuestionsByUserID(userID);
        return model.getSecurityQuestionAnswer1() != null && !model.getSecurityQuestionAnswer1().isEmpty()
                        && model.getSecurityQuestionAnswer2() != null && !model.getSecurityQuestionAnswer2().isEmpty();
    }


    public static OrionUserSecurityQuestionModel getUserSecurityQuestionsByUserID(String userID)
    {
        Assert.notEmpty(userID, "The given userID is null/empty.");
        OrionUserSecurityQuestionModel model = OrionUserSecurityQuestionModel.of(userID);
        return (OrionUserSecurityQuestionModel)Database.getOneModel(model,
                        SecurityQuestionDatabaseModel.tableUsersSecurityQuestions,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }


    public static int saveUserSecurityQuestions(OrionUserSecurityQuestionModel model)
    {
        return Database.saveModel(model,
                        SecurityQuestionDatabaseModel.tableUsersSecurityQuestions,
                        Database.usersDatabaseName);
    }


    public static int updateUserSecurityQuestions(OrionUserSecurityQuestionModel model)
    {
        return Database.updateModel(model,
                        SecurityQuestionDatabaseModel.tableUsersSecurityQuestions,
                        Database.usersDatabaseName,
                        Arrays.asList(UserManagementDatabaseModel.userID));
    }
}