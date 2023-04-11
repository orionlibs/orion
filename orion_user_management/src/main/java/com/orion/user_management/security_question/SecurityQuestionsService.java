package com.orion.user_management.security_question;

import com.orion.core.abstraction.OrionService;
import com.orion.user_management.registration.OrionRegistrationRequestBean;
import com.orion.user_management.reset_password.storefront_api.request.OrionResetPasswordRequestBean;
import com.orion.user_management.security_question.after_registration.SecurityQuestionsAfterRegistrationManager;
import com.orion.user_management.security_question.data_access.OrionSecurityQuestionsDAO;
import com.orion.user_management.security_question.data_access.OrionUsersSecurityQuestionsDAO;
import com.orion.user_management.security_question.model.OrionSecurityQuestionModel;
import com.orion.user_management.security_question.model.OrionUserSecurityQuestionModel;
import java.util.List;

public class SecurityQuestionsService extends OrionService
{
    public static void saveSecurityQuestions(OrionUserSecurityQuestionModel model)
    {
        OrionUsersSecurityQuestionsDAO.saveUserSecurityQuestions(model);
    }


    public static void updateSecurityQuestions(OrionUserSecurityQuestionModel model)
    {
        OrionUsersSecurityQuestionsDAO.updateUserSecurityQuestions(model);
    }


    public static boolean areSecurityQuestionsSetUpForUser(String userID)
    {
        return OrionUsersSecurityQuestionsDAO.areSecurityQuestionsSetUpForUser(userID);
    }


    public static OrionSecurityQuestionModel getRandomSecurityQuestionForUser(String userID)
    {
        return RandomSecurityQuestionForUserProvider.getRandomQuestion(userID);
    }


    public static boolean isGivenSecurityQuestionAnswerForUserValid(String userID, OrionResetPasswordRequestBean resetPasswordRequestBean)
    {
        return SecurityQuestionAnswerForUserVerifier.verify(userID, resetPasswordRequestBean);
    }


    public static List<OrionSecurityQuestionModel> getAvailableSecurityQuestions()
    {
        return OrionSecurityQuestionsDAO.getSecurityQuestions();
    }


    public static OrionSecurityQuestionModel getSecurityQuestionByID(int securityQuestionID)
    {
        return OrionSecurityQuestionsDAO.getSecurityQuestionByID(securityQuestionID);
    }


    public static OrionUserSecurityQuestionModel saveQuestionsAndAnswersAfterRegistration(OrionRegistrationRequestBean registrationRequestBean, String userID)
    {
        return SecurityQuestionsAfterRegistrationManager.saveQuestionsAndAnswers(registrationRequestBean, userID);
    }
}