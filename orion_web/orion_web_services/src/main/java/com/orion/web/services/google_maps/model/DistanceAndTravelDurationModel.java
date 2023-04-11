package com.orion.web.services.google_maps.model;

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
public class DistanceAndTravelDurationModel implements OrionModel
{
    private float distance;
    private long travelDurationInSeconds;


    public static DistanceAndTravelDurationModel of()
    {
        return DistanceAndTravelDurationModel.builder().build();
    }


    @Override
    public DistanceAndTravelDurationModel clone()
    {
        return (DistanceAndTravelDurationModel)CloningService.clone(this);
    }


    @Override
    public DistanceAndTravelDurationModel getCopy()
    {
        return this.clone();
    }
}