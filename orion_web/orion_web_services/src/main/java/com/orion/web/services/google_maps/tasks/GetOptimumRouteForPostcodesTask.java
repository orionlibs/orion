package com.orion.web.services.google_maps.tasks;

import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeoApiContext.Builder;
import com.google.maps.errors.ApiException;
import com.google.maps.errors.InvalidRequestException;
import com.google.maps.errors.ZeroResultsException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import com.orion.core.abstraction.OrionConfigurable;
import com.orion.core.configuration.annotations.prop.Prop;
import com.orion.web.services.google_maps.route.AGoogleMapsTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GetOptimumRouteForPostcodesTask extends AGoogleMapsTask implements OrionConfigurable
{
    private int numberOfRetries = 0;
    @Prop(key = "google.maps.api.key")
    private String apiKey;


    public List<String> run(String postcodeStart, String postcodeEnd, List<String> postcodes)
    {
        Builder requestBuilder = new GeoApiContext.Builder();
        requestBuilder.apiKey(apiKey);
        requestBuilder.connectTimeout(15, TimeUnit.SECONDS);
        requestBuilder.readTimeout(15, TimeUnit.SECONDS);
        requestBuilder.maxRetries(2);
        GeoApiContext geoAPIContext = requestBuilder.build();
        DirectionsApiRequest request = new DirectionsApiRequest(geoAPIContext);
        request.alternatives(false);
        //request.custom(postcodeStart, postcodeEnd);
        request.origin(postcodeStart);
        request.destination(postcodeEnd);
        request.optimizeWaypoints(true);
        List<DirectionsApiRequest.Waypoint> waypoints = new ArrayList<>();
        List<String> sortedPostcodes = new ArrayList<>(postcodes);
        Collections.sort(sortedPostcodes);
        sortedPostcodes.forEach(intermediatePostcode -> waypoints.add(new DirectionsApiRequest.Waypoint(intermediatePostcode)));
        request.waypoints(waypoints.toArray(new DirectionsApiRequest.Waypoint[0]));
        request.mode(TravelMode.WALKING);
        request.units(Unit.IMPERIAL);
        List<String> optimumRouteForPostcodes = new ArrayList<>();

        try
        {
            DirectionsResult response = request.await();
            DirectionsRoute[] routes = response.routes;
            int[] waypointOrder = routes[0].waypointOrder;
            optimumRouteForPostcodes.add(postcodeStart);

            for(int i = 0; i < waypointOrder.length; i++)
            {
                optimumRouteForPostcodes.add(postcodes.get(waypointOrder[i]));
            }

            optimumRouteForPostcodes.add(postcodeEnd);
        }
        catch(ZeroResultsException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            optimumRouteForPostcodes.add(postcodeStart);
            optimumRouteForPostcodes.addAll(sortedPostcodes);
            optimumRouteForPostcodes.add(postcodeEnd);
            return optimumRouteForPostcodes;
        }
        catch(InvalidRequestException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            return processAPICall(postcodeStart, postcodeEnd, postcodes, geoAPIContext);
        }
        catch(ApiException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            optimumRouteForPostcodes.add(postcodeStart);
            optimumRouteForPostcodes.addAll(sortedPostcodes);
            optimumRouteForPostcodes.add(postcodeEnd);
            return optimumRouteForPostcodes;
        }
        catch(InterruptedException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            return processAPICall(postcodeStart, postcodeEnd, postcodes, geoAPIContext);
        }
        catch(IOException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            return processAPICall(postcodeStart, postcodeEnd, postcodes, geoAPIContext);
        }
        catch(Exception e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            return processAPICall(postcodeStart, postcodeEnd, postcodes, geoAPIContext);
        }
        finally
        {
            closeRequest(geoAPIContext);
        }

        return optimumRouteForPostcodes;
    }


    public List<String> run(List<String> postcodes)
    {

        if(postcodes != null)
        {

            if(postcodes.size() < 3)
            {
                return new ArrayList<String>(postcodes);
            }
            else
            {
                return run(postcodes.get(0), postcodes.get(postcodes.size() - 1), postcodes.subList(1, postcodes.size() - 1));
            }

        }
        else
        {
            return null;
        }

    }


    private List<String> processAPICall(String postcodeStart, String postcodeEnd, List<String> postcodes, GeoApiContext geoAPIContext)
    {
        closeRequest(geoAPIContext);

        if(numberOfRetries == 0)
        {

            try
            {
                Thread.sleep(3000);
                numberOfRetries = 1;
                return run(postcodeStart, postcodeEnd, postcodes);
            }
            catch(InterruptedException e)
            {
                return null;
            }

        }
        else
        {
            return null;
        }

    }
}