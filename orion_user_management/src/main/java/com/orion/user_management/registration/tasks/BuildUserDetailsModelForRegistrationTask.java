package com.orion.user_management.registration.tasks;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.string.StringsService;
import com.orion.data.user.phone_number.PhoneNumberService;
import com.orion.data.user.phone_number.model.PhoneNumberRegionCode;
import com.orion.user_management.model.OrionUserDetailsModel;
import com.orion.user_management.registration.OrionRegistrationRequestBean;
import java.util.Arrays;

public class BuildUserDetailsModelForRegistrationTask extends OrionService
{
    public static OrionUserDetailsModel run(OrionRegistrationRequestBean registrationRequestBean, String username) throws InvalidDateException
    {
        String firstName = registrationRequestBean.getFirstName();
        String lastName = registrationRequestBean.getLastName();

        if(firstName != null && !firstName.isEmpty())
        {
            firstName = firstName.trim();
        }

        if(lastName != null && !lastName.isEmpty())
        {
            lastName = lastName.trim();
        }

        if(firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty())
        {

            if(registrationRequestBean.getFullName() != null)
            {
                String[] fullNameTokens = registrationRequestBean.getFullName().trim().split("\\s+");
                firstName = fullNameTokens[0];

                if(fullNameTokens.length == 1)
                {
                    lastName = "";
                }
                else if(fullNameTokens.length == 2)
                {
                    lastName = fullNameTokens[1];
                }
                else if(fullNameTokens.length > 2)
                {
                    lastName = StringsService.concatenateSeparatedBySpace(Arrays.asList(fullNameTokens).subList(1, fullNameTokens.length));
                }

            }

        }

        OrionUserDetailsModel userDetails = new OrionUserDetailsModel();
        userDetails.setEmailAddress(username);
        userDetails.setFirstName(StringsService.convertFirstCharacterToUppercase(firstName));
        userDetails.setMiddleName("");

        if(lastName != null && !lastName.isEmpty())
        {
            userDetails.setLastName(StringsService.convertFirstCharacterToUppercase(lastName));
        }

        if(registrationRequestBean.getMobileNumber() != null)
        {
            userDetails.setMobileNumber(PhoneNumberService.normalisePhoneNumber(registrationRequestBean.getMobileNumber().trim(), PhoneNumberRegionCode.GB));
        }

        if(registrationRequestBean.getBirthdate() != null)
        {
            userDetails.setBirthdate(CalendarService.convertDateStringToSQLTimestampObject(registrationRequestBean.getBirthdate().trim()));
        }

        return userDetails;
    }
}