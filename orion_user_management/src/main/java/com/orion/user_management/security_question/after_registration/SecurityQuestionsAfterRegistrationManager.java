package com.orion.user_management.security_question.after_registration;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.registration.OrionRegistrationRequestBean;
import com.orion.user_management.security_question.model.OrionUserSecurityQuestionModel;

public class SecurityQuestionsAfterRegistrationManager extends Orion
{
    public static OrionUserSecurityQuestionModel saveQuestionsAndAnswers(OrionRegistrationRequestBean registrationRequestBean, String userID)
    {

        if(Preconditions.validate(registrationRequestBean.getSecurityQuestionAnswer1(), registrationRequestBean.getSecurityQuestionAnswer2()))
        {
            Data data = SecurityQuestionsAfterRegistrationPreprocessor.preprocess(registrationRequestBean);
            data.setUserID(userID);
            data.setRegistrationRequestBean(registrationRequestBean);
            return SecurityQuestionsAfterRegistrationProcessor.saveQuestionsAndAnswers(data);
        }
        else
        {
            return null;
        }

    }
}