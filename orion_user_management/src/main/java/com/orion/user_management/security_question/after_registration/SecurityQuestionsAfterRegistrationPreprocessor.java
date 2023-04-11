package com.orion.user_management.security_question.after_registration;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.registration.OrionRegistrationRequestBean;

class SecurityQuestionsAfterRegistrationPreprocessor extends Orion
{
    static Data preprocess(OrionRegistrationRequestBean registrationRequestBean)
    {
        return Data.builder()
                        .securityQuestionAnswer1(registrationRequestBean.getSecurityQuestionAnswer1().toLowerCase())
                        .securityQuestionAnswer2(registrationRequestBean.getSecurityQuestionAnswer2().toLowerCase())
                        .build();
    }
}