package com.orion.data.geodata.postcode.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
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
public class PostcodeModel implements OrionModel
{
    private String boroughName;
    private int boroughID;
    private String city;
    private String county;
    private String countryCodeAlpha2;
    private String country;
    private String postcode;
    private String postcodeWithoutSpace;


    public static PostcodeModel of()
    {
        return PostcodeModel.builder().build();
    }


    public static PostcodeModel of(String boroughName)
    {
        return PostcodeModel.builder().boroughName(boroughName).build();
    }


    @Override
    public PostcodeModel clone()
    {
        return (PostcodeModel)CloningService.clone(this);
    }


    @Override
    public PostcodeModel getCopy()
    {
        return this.clone();
    }
}