package com.orion.user_management.security_question.after_registration;

import com.orion.core.abstraction.Orion;

class Preconditions extends Orion
{
    public static boolean validate(String securityQuestionAnswer1, String securityQuestionAnswer2)
    {
        return securityQuestionAnswer1 != null && !securityQuestionAnswer1.isEmpty()
                        && securityQuestionAnswer2 != null && !securityQuestionAnswer2.isEmpty();
    }
}