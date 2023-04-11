package com.orion.data.user.address;

import com.orion.core.abstraction.Orion;
import com.orion.data.user.address.model.OrionUserAddressModel;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class InvalidFieldsBO extends Orion
{
    private OrionUserAddressModel model;


    public static InvalidFieldsBO of(OrionUserAddressModel model)
    {
        return InvalidFieldsBO.builder().model(model).build();
    }


    public Set<String> getInvalidFieldsForAddress()
    {
        Set<String> invalidFields = new HashSet<>();
        //boolean isInvalidHouseNumber = UserAddressService.isInvalidHouseNumber(model);
        boolean isInvalidHouseAddressLines = UserAddressService.isInvalidHouseAddressLines(model);
        boolean isInvalidPostcode = UserAddressService.isInvalidPostcode(model);
        boolean isInvalidCountryCodeAlpha2 = UserAddressService.isInvalidCountryCodeAlpha2(model);
        /*if(isInvalidHouseNumber)
        {
            invalidFields.add("houseNumber");
        }*/

        if(isInvalidHouseAddressLines)
        {
            invalidFields.add("houseAddressLine1");
            invalidFields.add("houseAddressLine2");
        }

        if(isInvalidPostcode)
        {
            invalidFields.add("postcode");
        }
        else
        {
            String postcodePrefix = UserAddressService.getPostcodePrefix(model.getPostcode());

            if(postcodePrefix == null)
            {
                invalidFields.add("postcode");
            }

        }

        if(isInvalidCountryCodeAlpha2)
        {
            invalidFields.add("countryCodeAlpha2");
        }

        return invalidFields;
    }
}