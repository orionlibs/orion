package com.orion.data.user.address;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.string.StringsService;
import com.orion.data.geodata.country.CountryService;
import com.orion.data.user.address.model.OrionUserAddressModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class UserAddressBO extends Orion
{
    private OrionUserAddressModel address;


    public static UserAddressBO of(OrionUserAddressModel address)
    {
        return UserAddressBO.builder().address(address).build();
    }


    public boolean isValidAddress()
    {
        Assert.notNull(address, "The given address cannot be null.");
        return ((address.getHouseAddressLine1() != null && !address.getHouseAddressLine1().isEmpty())
                        || (address.getHouseAddressLine2() != null && !address.getHouseAddressLine2().isEmpty()))
                        && address.getPostcode() != null && !address.getPostcode().isEmpty();
    }


    public boolean isValidHouseNumber()
    {
        return address.getHouseNumber() != null && !address.getHouseNumber().isEmpty();
    }


    public boolean isValidHouseAddressLines()
    {
        return (address.getHouseAddressLine1() != null && !address.getHouseAddressLine1().isEmpty())
                        || (address.getHouseAddressLine2() != null && !address.getHouseAddressLine2().isEmpty());
    }


    public boolean isValidCountryCodeAlpha2()
    {
        return CountryService.getCountryShortNameFromCodeAlpha2(address.getCountryCodeAlpha2().trim().toUpperCase()) != null;
    }


    public void normaliseAddress()
    {
        Assert.notNull(address, "The given address cannot be null.");

        if(address.getHouseNumber() != null && !address.getHouseNumber().isEmpty())
        {
            address.setHouseNumber(address.getHouseNumber().trim());
        }

        if((address.getHouseAddressLine1() == null || address.getHouseAddressLine1().isEmpty())
                        && address.getHouseAddressLine2() != null && !address.getHouseAddressLine2().isEmpty())
        {
            address.setHouseAddressLine1(address.getHouseAddressLine2());
            address.setHouseAddressLine2(null);
        }

        if(address.getHouseAddressLine1() != null && !address.getHouseAddressLine1().isEmpty())
        {
            address.setHouseAddressLine1(address.getHouseAddressLine1().trim());
        }

        if(address.getHouseAddressLine2() != null && !address.getHouseAddressLine2().isEmpty())
        {
            address.setHouseAddressLine2(address.getHouseAddressLine2().trim());
        }

        if(address.getCounty() != null && !address.getCounty().isEmpty())
        {
            address.setCounty(address.getCounty().trim());
        }

        if(address.getCity() != null && !address.getCity().isEmpty())
        {
            address.setCity(address.getCity().trim());
        }

        address.setPostcode(address.getPostcode().trim());
        address.setCountryCodeAlpha2(address.getCountryCodeAlpha2().trim().toUpperCase());
        address.setCountry(CountryService.getCountryShortNameFromCodeAlpha2(address.getCountryCodeAlpha2()));
    }


    public String formatAddressIn1Line()
    {
        StringBuilder fullAddress = new StringBuilder();

        if(address.getHouseName() != null && !address.getHouseName().isEmpty())
        {
            fullAddress.append(address.getHouseName());
            fullAddress.append(", ");
        }

        if(address.getHouseNumber() != null && !address.getHouseNumber().isEmpty())
        {
            fullAddress.append(address.getHouseNumber());
            fullAddress.append(", ");
        }

        if(address.getHouseAddressLine1() != null && !address.getHouseAddressLine1().isEmpty())
        {
            fullAddress.append(address.getHouseAddressLine1());
            fullAddress.append(", ");
        }

        if(address.getHouseAddressLine2() != null && !address.getHouseAddressLine2().isEmpty())
        {
            fullAddress.append(address.getHouseAddressLine2());
            fullAddress.append(", ");
        }

        if(address.getCity() != null && !address.getCity().isEmpty())
        {
            fullAddress.append(address.getCity());
            fullAddress.append(", ");
        }

        if(address.getCounty() != null && !address.getCounty().isEmpty())
        {
            fullAddress.append(address.getCounty());
            fullAddress.append(", ");
        }

        if(address.getPostcode() != null && !address.getPostcode().isEmpty())
        {
            fullAddress.append(address.getPostcode());
            fullAddress.append(", ");
        }

        if(address.getCountry() != null && !address.getCountry().isEmpty())
        {

            if("United Kingdom of Great Britain and Northern Ireland".equals(address.getCountry()))
            {
                fullAddress.append("U.K.");
            }
            else
            {
                fullAddress.append(address.getCountry());
            }

        }

        return StringsService.deleteCharacterFromTheEnd(fullAddress, ", ").toString();
    }


    public String formatAddressIn1LineWithoutCountry()
    {

        if(address != null)
        {
            StringBuilder fullAddress = new StringBuilder();

            if(address.getHouseName() != null && !address.getHouseName().isEmpty())
            {
                fullAddress.append(address.getHouseName());
                fullAddress.append(", ");
            }

            if(address.getHouseNumber() != null && !address.getHouseNumber().isEmpty())
            {
                fullAddress.append(address.getHouseNumber());
                fullAddress.append(", ");
            }

            if(address.getHouseAddressLine1() != null && !address.getHouseAddressLine1().isEmpty())
            {
                fullAddress.append(address.getHouseAddressLine1());
                fullAddress.append(", ");
            }

            if(address.getHouseAddressLine2() != null && !address.getHouseAddressLine2().isEmpty())
            {
                fullAddress.append(address.getHouseAddressLine2());
                fullAddress.append(", ");
            }

            if(address.getCity() != null && !address.getCity().isEmpty())
            {
                fullAddress.append(address.getCity());
                fullAddress.append(", ");
            }

            if(address.getPostcode() != null && !address.getPostcode().isEmpty())
            {
                fullAddress.append(address.getPostcode());
            }

            return fullAddress.toString();
        }
        else
        {
            return "";
        }

    }
}