package com.orion.user_management.email_validation;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.string.StringsService;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.data.user.email_address.EmailAddressService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.account.model.OrionAccountReactivationValidationCodeModel;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class UserAccountReactivationBO extends Orion
{
    private String emailValidationCode;
    private String emailAddress;


    public static UserAccountReactivationBO ofCode(String emailValidationCode)
    {
        return UserAccountReactivationBO.builder().emailValidationCode(emailValidationCode).build();
    }


    public static UserAccountReactivationBO ofEmailAddress(String emailAddress)
    {
        return UserAccountReactivationBO.builder().emailAddress(emailAddress).build();
    }


    public UserManagementEmailValidationResponseBean validateAccountReactivationCode()
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
                OrionEmailValidationResponseBean result = UserAccountService.validateAccountReactivationCode(emailValidationCode);
                return UserManagementEmailValidationResponseBean.builder()
                                .validValidationCode(result.getEmailValidationEmailSuccessful())
                                .expiredValidationCode(result.getExpiredValidationCode())
                                .authorities(result.getAuthorities())
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


    public boolean requestNewAccountReactivationValidationCode() throws UserHasNoAuthorityException
    {
        emailAddress = EmailAddressService.normaliseEmailAddress(emailAddress);
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUsername(emailAddress);

        if(authority != null)
        {
            OrionAccountReactivationValidationCodeModel validationCodeModel = UserAccountService.getAccountReactivationValidationCodeByUserID(authority.getUserID());
            int numberOfMinutes = ConfigurationService.getIntegerProp("user.management.reactivate.account.code.expiration.in.minutes", 20);

            if(validationCodeModel != null)
            {
                validationCodeModel.setExpirationDateTime(CalendarService.addMinutesToCurrentSQLDatetime(numberOfMinutes));
                UserAccountService.updateAccountReactivationValidationCode(validationCodeModel);
                return true;
            }
            else
            {
                String accountReactivationCode = StringsService.generateRandomNumericCode(ConfigurationService.getIntegerProp("user.management.length.of.validation.numeric.code", 4));
                validationCodeModel = OrionAccountReactivationValidationCodeModel.builder()
                                .userID(authority.getUserID())
                                .emailValidationCode(accountReactivationCode)
                                .expirationDateTime(CalendarService.addMinutesToCurrentSQLDatetime(numberOfMinutes))
                                .build();
                UserAccountService.saveAccountReactivationValidationCode(validationCodeModel);
                UserAccountService.emailUserAccountReactivationValidationCode(authority.getUsername(), accountReactivationCode);
                return true;
            }

        }
        else
        {
            return false;
        }

    }
}