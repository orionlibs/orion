package com.orion.data.user.address;

import com.orion.core.abstraction.Orion;
import com.orion.web.services.google_maps.GoogleMapsService;
import java.util.regex.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class PostcodeBO extends Orion
{
    private String postcode;


    public static PostcodeBO of(String postcode)
    {
        return PostcodeBO.builder().postcode(postcode).build();
    }


    public boolean isValidPostcode()
    {
        return postcode != null && !postcode.isEmpty();
    }


    public String getPostcodePrefixWithoutUsingGoogleMaps()
    {
        String[] tokens = postcode.split("\\s+");

        if(tokens != null && tokens.length > 0)
        {
            return tokens[0];
        }
        else
        {
            return null;
        }

    }


    public boolean isValidPostcode(String postcodePattern)
    {
        return Pattern.compile(postcodePattern).matcher(postcode).matches();
    }


    public String getPostcodePrefix()
    {
        postcode = GoogleMapsService.getFormattedPostcode(postcode);

        if(postcode != null && !postcode.isEmpty())
        {
            return getPostcodePrefixWithoutUsingGoogleMaps();
        }
        else
        {
            return null;
        }

    }
}