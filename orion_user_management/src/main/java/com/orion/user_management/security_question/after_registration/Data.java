package com.orion.user_management.security_question.after_registration;

import com.orion.user_management.registration.OrionRegistrationRequestBean;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
class Data
{
    private String userID;
    private String securityQuestionAnswer1;
    private String securityQuestionAnswer2;
    private OrionRegistrationRequestBean registrationRequestBean;
}