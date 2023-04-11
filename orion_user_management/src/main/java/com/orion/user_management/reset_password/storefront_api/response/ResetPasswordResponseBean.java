package com.orion.user_management.reset_password.storefront_api.response;

import com.orion.core.abstraction.OrionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class ResetPasswordResponseBean extends OrionResponse
{
    private Boolean areSecurityQuestionsSetUpForUser;
    private Boolean validResetPasswordCode;
    private Boolean validSecurityQuestion;
    private Boolean expiredResetPasswordCode;
    private Boolean passwordHasBeenResetSuccessfully;
    private Boolean newPasswordMatchesOld;
    private Boolean validPassword;
    private int securityQuestionID;
    private String securityQuestion;
    private String userID;


    public static ResetPasswordResponseBean of()
    {
        return ResetPasswordResponseBean.builder().build();
    }
}