package com.orion.user_management.security_question;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.reset_password.storefront_api.request.OrionResetPasswordRequestBean;
import com.orion.user_management.security_question.data_access.OrionUsersSecurityQuestionsDAO;
import com.orion.user_management.security_question.model.OrionUserSecurityQuestionModel;

class SecurityQuestionAnswerForUserVerifier extends Orion
{
    static boolean verify(String userID, OrionResetPasswordRequestBean resetPasswordRequestBean)
    {
        boolean isValidSecurityQuestion = false;
        OrionUserSecurityQuestionModel securityQuestionsModel = OrionUsersSecurityQuestionsDAO.getUserSecurityQuestionsByUserID(userID);

        if(securityQuestionsModel.getSecurityQuestionID1() == resetPasswordRequestBean.getSecurityQuestionID())
        {

            if(securityQuestionsModel.getSecurityQuestionAnswer1().equals(resetPasswordRequestBean.getSecurityQuestionAnswer()))
            {
                isValidSecurityQuestion = true;
            }

        }
        else if(securityQuestionsModel.getSecurityQuestionID2() == resetPasswordRequestBean.getSecurityQuestionID())
        {

            if(securityQuestionsModel.getSecurityQuestionAnswer2().equals(resetPasswordRequestBean.getSecurityQuestionAnswer()))
            {
                isValidSecurityQuestion = true;
            }

        }

        return isValidSecurityQuestion;
    }
}