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
public class DistanceBetweenPostcodesModel implements OrionModel
{
    private String postcode1;
    private String postcode2;
    private float distance;
    private Long travelDurationInSeconds;
    private Boolean isPostcode1Valid;
    private Boolean isPostcode2Valid;


    public static DistanceBetweenPostcodesModel of()
    {
        return DistanceBetweenPostcodesModel.builder().build();
    }


    public static DistanceBetweenPostcodesModel of(String postcode1, String postcode2)
    {
        return DistanceBetweenPostcodesModel.builder().postcode1(postcode1).postcode2(postcode2).build();
    }


    @Override
    public DistanceBetweenPostcodesModel clone()
    {
        return (DistanceBetweenPostcodesModel)CloningService.clone(this);
    }


    @Override
    public DistanceBetweenPostcodesModel getCopy()
    {
        return this.clone();
    }
}