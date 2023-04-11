package com.orion.user_management.email_validation;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.exception.Assert;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.email_validation.model.OrionEmailValidationCodeModel;
import com.orion.user_management.exception.UserDoesNotExistException;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
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
public class UserEmailAddressValidatorBO extends Orion
{
    private String emailValidationCode;
    private OrionEmailValidationCodeModel model;


    public static UserEmailAddressValidatorBO ofCode(String emailValidationCode)
    {
        return UserEmailAddressValidatorBO.builder().emailValidationCode(emailValidationCode).build();
    }


    public static UserEmailAddressValidatorBO ofModel(OrionEmailValidationCodeModel model)
    {
        return UserEmailAddressValidatorBO.builder().model(model).build();
    }


    public UserManagementEmailValidationResponseBean validateByCode()
    {

        if(emailValidationCode == null || emailValidationCode.isEmpty())
        {
            return UserManagementEmailValidationResponseBean.builder()
                            .validValidationCode(false)
                            .build();
        }
        else
        {

            try
            {
                OrionEmailValidationResponseBean result = OrionEmailValidationService.validateEmail(emailValidationCode);
                return UserManagementEmailValidationResponseBean.builder()
                                .validValidationCode(result.getEmailValidationEmailSuccessful())
                                .expiredValidationCode(result.getExpiredValidationCode())
                                .authorities(result.getAuthorities())
                                .username(result.getUsername())
                                .build();
            }
            catch(Exception e)
            {
                return UserManagementEmailValidationResponseBean.builder()
                                .validValidationCode(false)
                                .build();
            }

        }

    }


    public OrionEmailValidationResponseBean validateByModel() throws UserDoesNotExistException, EmailValidationCodeForUserDoesNotExistException, UserHasNoAuthorityException
    {
        Assert.notNull(model, "The OrionEmailValidationCodesModel input cannot be null.");
        OrionEmailValidationResponseBean emailValidationResponseBean = new OrionEmailValidationResponseBean();
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(model.getUserID());

        if(CalendarService.hasExpired(model.getExpirationDateTime()))
        {
            emailValidationResponseBean.setExpiredValidationCode(Boolean.TRUE);
            emailValidationResponseBean.setEmailValidationEmailSuccessful(Boolean.FALSE);
            emailValidationResponseBean.setUsername(authority.getUsername());
            //OrionEmailValidationService.deleteEmailValidationCodeByUserID(model.getUserID());
        }
        else
        {
            emailValidationResponseBean.setExpiredValidationCode(Boolean.FALSE);
            OrionUserDetailsModel userDetails = UserAccountService.getUserDetailsByUserID(model.getUserID());

            if(userDetails != null)
            {
                emailValidationResponseBean.setUser(userDetails);
                emailValidationResponseBean.setEmailValidationEmailSuccessful(Boolean.TRUE);
                emailValidationResponseBean.setAuthorities(authority.getAuthority());
                OrionUserModel user = UserAccountService.getUserByUserID(model.getUserID());
                user.setEnabled(Boolean.TRUE);
                user.setPendingEmailAddressValidation(Boolean.FALSE);
                UserAccountService.updateUserByUserID(user);
                //OrionEmailValidationService.deleteEmailValidationCodeByUserID(model.getUserID());
                UserAccountService.emailUserAccountValidation(authority.getUsername());
            }
            else
            {
                throw new UserDoesNotExistException("User with ID '{}' does not exist.", model.getUserID());
            }

        }

        return emailValidationResponseBean;
    }
}