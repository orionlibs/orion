package com.orion.user_management.reset_password.storefront_api.request;

import com.orion.core.abstraction.OrionRequest;
import com.orion.core.data.validation.Validator;
import com.orion.core.data.validation.annotation.NotBlank;
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
public class OrionResetPasswordValidationRequestBean extends OrionRequest implements Validator
{
    private Boolean areSecurityQuestionsSetUpForUser;
    @NotBlank
    private String forgotPasswordCode;
    private int securityQuestionID;
    private String securityQuestionAnswer;
}