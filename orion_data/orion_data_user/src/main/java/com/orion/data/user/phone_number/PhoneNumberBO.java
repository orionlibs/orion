package com.orion.data.user.phone_number;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.orion.core.abstraction.Orion;
import com.orion.data.user.phone_number.model.PhoneNumberRegionCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class PhoneNumberBO extends Orion
{
    private String phoneNumber;
    private String regionCodeString;
    private PhoneNumberRegionCode regionCode;


    public static PhoneNumberBO of(String phoneNumber, String regionCodeString)
    {
        return PhoneNumberBO.builder().phoneNumber(phoneNumber).regionCodeString(regionCodeString).build();
    }


    public static PhoneNumberBO of(String phoneNumber, PhoneNumberRegionCode regionCode)
    {
        return PhoneNumberBO.builder().phoneNumber(phoneNumber).regionCode(regionCode).build();
    }


    public boolean isValid()
    {

        if(phoneNumber != null)
        {
            PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();

            try
            {
                PhoneNumber phoneNumberTemp = PhoneNumberUtil.getInstance().parse(phoneNumber.trim(), regionCodeString);
                return phoneUtil.isValidNumber(phoneNumberTemp);
            }
            catch(NumberParseException e)
            {
                return false;
            }

        }
        else
        {
            return false;
        }

    }


    public String normalise()
    {

        if(phoneNumber != null)
        {
            phoneNumber = phoneNumber.trim();

            if(!phoneNumber.isEmpty())
            {
                String result = PhoneNumberUtil.normalizeDigitsOnly(phoneNumber.trim());

                if(phoneNumber.startsWith("+"))
                {
                    return "00" + result;
                }
                else
                {
                    return result;
                }

            }
            else
            {
                return "";
            }

        }
        else
        {
            return "";
        }

    }
}