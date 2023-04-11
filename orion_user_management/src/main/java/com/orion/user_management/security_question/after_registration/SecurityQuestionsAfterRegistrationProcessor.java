package com.orion.user_management.security_question.after_registration;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.security_question.model.OrionUserSecurityQuestionModel;

class SecurityQuestionsAfterRegistrationProcessor extends Orion
{
    static OrionUserSecurityQuestionModel saveQuestionsAndAnswers(Data data)
    {
        return OrionUserSecurityQuestionModel.builder()
                        .userID(data.getUserID())
                        .securityQuestionID1(data.getRegistrationRequestBean().getSecurityQuestionID1())
                        .securityQuestionID2(data.getRegistrationRequestBean().getSecurityQuestionID2())
                        .securityQuestionAnswer1(data.getSecurityQuestionAnswer1())
                        .securityQuestionAnswer2(data.getSecurityQuestionAnswer2())
                        .build();
    }
}