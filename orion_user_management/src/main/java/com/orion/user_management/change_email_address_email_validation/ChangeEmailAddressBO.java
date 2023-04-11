package com.orion.user_management.change_email_address_email_validation;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.exception.Assert;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.change_email_address_email_validation.model.ChangeEmailAddressEmailValidationCodeModel;
import com.orion.user_management.email_validation.EmailValidationCodeForUserDoesNotExistException;
import com.orion.user_management.exception.UserDoesNotExistException;
import com.orion.user_management.model.OrionUserDetailsModel;
import com.orion.user_management.model.OrionUserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class ChangeEmailAddressBO extends Orion
{
    private ChangeEmailAddressEmailValidationCodeModel model;


    public static ChangeEmailAddressBO of(ChangeEmailAddressEmailValidationCodeModel model)
    {
        return ChangeEmailAddressBO.builder().model(model).build();
    }


    public ChangeEmailAddressEmailValidationResponseBean validateCode() throws UserDoesNotExistException, ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException, EmailValidationCodeForUserDoesNotExistException
    {
        Assert.notNull(model, "The ChangeEmailAddressEmailValidationCodeModel input cannot be null.");
        ChangeEmailAddressEmailValidationResponseBean emailValidationResponseBean = new ChangeEmailAddressEmailValidationResponseBean();

        if(CalendarService.hasExpired(model.getExpirationDateTime()))
        {
            emailValidationResponseBean.setExpiredValidationCode(Boolean.TRUE);
            emailValidationResponseBean.setEmailValidationEmailSuccessful(Boolean.FALSE);
            ChangeEmailAddressEmailValidationService.deleteEmailValidationCodeByUserID(model.getUserID());
        }
        else
        {
            emailValidationResponseBean.setExpiredValidationCode(Boolean.FALSE);
            int numberOfRowsAffected1 = ChangeEmailAddressEmailValidationService.deleteEmailValidationCodeByUserID(model.getUserID());

            if(numberOfRowsAffected1 > 0)
            {
                OrionUserDetailsModel userDetails = UserAccountService.getUserDetailsByUserID(model.getUserID());

                if(userDetails != null)
                {
                    emailValidationResponseBean.setEmailValidationEmailSuccessful(userDetails != null);
                    OrionUserModel user = UserAccountService.getUserByUserID(model.getUserID());
                    user.setEnabled(Boolean.TRUE);
                    user.setPendingEmailAddressValidation(Boolean.FALSE);
                    UserAccountService.updateUserByUserID(user);
                }
                else
                {
                    throw new UserDoesNotExistException("User with ID '{}' does not exist.", model.getUserID());
                }

            }
            else
            {
                throw new EmailValidationCodeForUserDoesNotExistException("Email validation code does not exist for userID '{}'", model.getUserID());
            }

        }

        return emailValidationResponseBean;
    }
}