package com.orion.user_management.account.tasks;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.CalendarService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.account.model.OrionAccountReactivationValidationCodeModel;
import com.orion.user_management.email_validation.OrionEmailValidationResponseBean;
import com.orion.user_management.exception.UserHasNoAuthorityException;

public class ValidateAccountReactivationTask extends OrionService
{
    public static OrionEmailValidationResponseBean run(String emailValidationCode) throws UserHasNoAuthorityException
    {
        OrionEmailValidationResponseBean responseBean = new OrionEmailValidationResponseBean();
        OrionAccountReactivationValidationCodeModel model = UserAccountService.getAccountReactivationValidationCodeByCode(emailValidationCode);

        if(model != null)
        {
            responseBean.setAuthorities(UserAccountService.getAuthorityByUserID(model.getUserID()).getAuthority());
            UserAccountService.deleteAccountReactivationValidationCodeByUserID(model.getUserID());

            if(CalendarService.hasExpired(model.getExpirationDateTime()))
            {
                responseBean.setEmailValidationEmailSuccessful(Boolean.FALSE);
                responseBean.setExpiredValidationCode(Boolean.TRUE);
                responseBean.setHasErrors(Boolean.TRUE);
                return responseBean;
            }
            else
            {
                UserAccountService.enableAccountByUserID(model.getUserID());
                UserAccountService.activateAccount(model.getUserID());
                responseBean.setEmailValidationEmailSuccessful(Boolean.TRUE);
                responseBean.setExpiredValidationCode(Boolean.FALSE);
                responseBean.setHasErrors(Boolean.FALSE);
                return responseBean;
            }

        }
        else
        {
            responseBean.setEmailValidationEmailSuccessful(Boolean.FALSE);
            responseBean.setExpiredValidationCode(Boolean.FALSE);
            responseBean.setHasErrors(Boolean.TRUE);
            return responseBean;
        }

    }
}