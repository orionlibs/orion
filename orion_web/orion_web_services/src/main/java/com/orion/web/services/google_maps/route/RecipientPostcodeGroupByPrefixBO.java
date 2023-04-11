package com.orion.web.services.google_maps.route;

import java.util.List;
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
public class RecipientPostcodeGroupByPrefixBO
{
    private List<RecipientPostcodeVO> postcodes;
    private String postcodePrefix;
    //private float maximumDistanceWithinGroup;
    private float sumOfDistancesWithinGroup;
}