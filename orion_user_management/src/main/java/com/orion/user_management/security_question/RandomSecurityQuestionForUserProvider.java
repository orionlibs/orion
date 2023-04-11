package com.orion.user_management.security_question;

import com.orion.core.abstraction.Orion;
import com.orion.core.math.RandomNumberGenerationService;
import com.orion.user_management.security_question.data_access.OrionUsersSecurityQuestionsDAO;
import com.orion.user_management.security_question.model.OrionSecurityQuestionModel;
import com.orion.user_management.security_question.model.OrionUserSecurityQuestionModel;

class RandomSecurityQuestionForUserProvider extends Orion
{
    static OrionSecurityQuestionModel getRandomQuestion(String userID)
    {
        OrionUserSecurityQuestionModel userSecurityQuestions = OrionUsersSecurityQuestionsDAO.getUserSecurityQuestionsByUserID(userID);
        int randomQuestionID = RandomNumberGenerationService.getRandomIntegerExceptZero(1, 2);

        if(randomQuestionID == 1)
        {
            return SecurityQuestionsService.getSecurityQuestionByID(userSecurityQuestions.getSecurityQuestionID1());
        }
        else
        {
            return SecurityQuestionsService.getSecurityQuestionByID(userSecurityQuestions.getSecurityQuestionID2());
        }

    }
}