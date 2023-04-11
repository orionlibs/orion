package com.orion.user_management.reset_password;

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
public class ResetPasswordResult extends OrionResponse
{
    private Boolean passwordHasBeenResetSuccessfully;
    private Boolean areSecurityQuestionsSetUpForUser;
    private Boolean validSecurityQuestion;
    private Boolean validResetPasswordCode;
    private Boolean expiredResetPasswordCode;
    private Boolean newPasswordMatchesOld;
    private String userID;
    private Boolean validPassword;
    private int securityQuestionID;
    private String securityQuestion;


    public static ResetPasswordResult of()
    {
        return ResetPasswordResult.builder().build();
    }
}