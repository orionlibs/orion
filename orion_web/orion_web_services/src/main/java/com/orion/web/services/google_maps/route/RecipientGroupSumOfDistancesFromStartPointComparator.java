package com.orion.web.services.google_maps.route;

import java.util.Comparator;

public class RecipientGroupSumOfDistancesFromStartPointComparator implements Comparator<RecipientPostcodeGroupByPrefixBO>
{
    @Override
    public int compare(RecipientPostcodeGroupByPrefixBO x, RecipientPostcodeGroupByPrefixBO y)
    {

        if(x.getSumOfDistancesWithinGroup() < y.getSumOfDistancesWithinGroup())
        {
            return -1;
        }
        else if(x.getSumOfDistancesWithinGroup() > y.getSumOfDistancesWithinGroup())
        {
            return 1;
        }
        else
        {
            return 0;
        }

    }
}