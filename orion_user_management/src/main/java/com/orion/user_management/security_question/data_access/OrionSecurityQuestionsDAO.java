package com.orion.user_management.security_question.data_access;

import com.orion.core.abstraction.OrionDAO;
import com.orion.core.exception.Assert;
import com.orion.data.source.database.Database;
import com.orion.user_management.security_question.model.OrionSecurityQuestionModel;
import com.orion.user_management.security_question.model.SecurityQuestionDatabaseModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrionSecurityQuestionsDAO extends OrionDAO
{
    public static List<OrionSecurityQuestionModel> getSecurityQuestions()
    {
        List<OrionSecurityQuestionModel> questions = new ArrayList<>();
        List<Object> temp = Database.getAllRows(OrionSecurityQuestionModel.of(),
                        SecurityQuestionDatabaseModel.tableSecurityQuestions,
                        Database.usersDatabaseName);

        if(temp != null && !temp.isEmpty())
        {
            temp.forEach(question -> questions.add((OrionSecurityQuestionModel)question));
        }

        return questions;
    }


    public static OrionSecurityQuestionModel getSecurityQuestionByID(int securityQuestionID)
    {
        OrionSecurityQuestionModel model = OrionSecurityQuestionModel.of(securityQuestionID);
        return (OrionSecurityQuestionModel)Database.getOneModel(model,
                        SecurityQuestionDatabaseModel.tableSecurityQuestions,
                        Database.usersDatabaseName,
                        Arrays.asList(SecurityQuestionDatabaseModel.securityQuestionID));
    }


    public static OrionSecurityQuestionModel getSecurityQuestionByName(String securityQuestion)
    {
        Assert.notEmpty(securityQuestion, "The given securityQuestion is null/empty.");
        OrionSecurityQuestionModel model = OrionSecurityQuestionModel.builder()
                        .securityQuestion(securityQuestion)
                        .build();
        return (OrionSecurityQuestionModel)Database.getOneModel(model,
                        SecurityQuestionDatabaseModel.tableSecurityQuestions,
                        Database.usersDatabaseName,
                        Arrays.asList(SecurityQuestionDatabaseModel.securityQuestion));
    }


    public static int saveSecurityQuestion(OrionSecurityQuestionModel model)
    {
        return Database.saveModel(model,
                        SecurityQuestionDatabaseModel.tableSecurityQuestions,
                        Database.usersDatabaseName);
    }


    public static int updateSecurityQuestion(OrionSecurityQuestionModel model)
    {
        return Database.updateModel(model,
                        SecurityQuestionDatabaseModel.tableSecurityQuestions,
                        Database.usersDatabaseName,
                        Arrays.asList(SecurityQuestionDatabaseModel.securityQuestionID));
    }
}