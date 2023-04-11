package com.orion.user_management.forgot_password;

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
public class ForgotPasswordResponseBean extends OrionResponse
{
    private Boolean userExists;
    private Boolean isPasswordChangeRequestSuccessful;
    private Boolean accountPendingValidation;
    private String sender;
    private String senderName;
    private String emailAddress;
    private String subject;
    private String resetPasswordEmailHTML;


    public static ForgotPasswordResponseBean of()
    {
        return ForgotPasswordResponseBean.builder().build();
    }
}