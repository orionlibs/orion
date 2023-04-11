package com.orion.user_management.reset_password.reset.using_code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ResetPasswordValidationData
{
    private Boolean areSecurityQuestionsSetUpForUser;
    private String forgotPasswordCode;
    private int securityQuestionID;
    private String securityQuestionAnswer;
}