package com.orion.web.services.google_maps;

import com.orion.core.abstraction.OrionService;
import com.orion.web.services.google_maps.model.DistanceAndTravelDurationModel;
import com.orion.web.services.google_maps.route.OptimumRouteService;
import com.orion.web.services.google_maps.route.OptimumRouteVO;
import com.orion.web.services.google_maps.tasks.GetDistanceAndTravelDurationTask;
import com.orion.web.services.google_maps.tasks.GetFormattedPostcodeTask;
import java.util.List;

public class GoogleMapsService extends OrionService
{
    public static DistanceAndTravelDurationModel getDistanceAndTravelDuration(String postcode1, String postcode2)
    {
        return new GetDistanceAndTravelDurationTask().run(postcode1, postcode2);
    }


    public static String getFormattedPostcode(String postcode)
    {
        return new GetFormattedPostcodeTask().run(postcode);
    }


    public static OptimumRouteVO getOptimumRouteForPostcodes(String actualStartPostcode, String startPostcode, String endPostcode, List<String> waypoints, Float distanceBetweenHighPriorityAndCollectionPostcode)
    {
        return OptimumRouteService.getOptimumRouteForPostcodes(actualStartPostcode, startPostcode, endPostcode, waypoints, distanceBetweenHighPriorityAndCollectionPostcode);
    }


    public static List<String> getOptimumRouteForPostcodes(List<String> postcodes, Float distanceBetweenHighPriorityAndCollectionPostcode)
    {
        String startPostcode = postcodes.get(0);
        String endPostcode = postcodes.get(postcodes.size() - 1);
        List<String> waypoints = postcodes.subList(1, postcodes.size() - 1);
        return getOptimumRouteForPostcodes(startPostcode, startPostcode, endPostcode, waypoints, distanceBetweenHighPriorityAndCollectionPostcode).getRoute();
    }
}