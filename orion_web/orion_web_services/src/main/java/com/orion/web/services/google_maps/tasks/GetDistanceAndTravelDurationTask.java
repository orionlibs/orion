package com.orion.web.services.google_maps.tasks;

import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeoApiContext.Builder;
import com.google.maps.errors.ApiException;
import com.google.maps.errors.InvalidRequestException;
import com.google.maps.errors.NotFoundException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.web.services.google_maps.model.DistanceAndTravelDurationModel;
import com.orion.web.services.google_maps.route.AGoogleMapsTask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GetDistanceAndTravelDurationTask extends AGoogleMapsTask
{
    private int numberOfRetries = 0;


    public DistanceAndTravelDurationModel run(String postcode1, String postcode2)
    {
        Builder requestBuilder = new GeoApiContext.Builder();
        requestBuilder.apiKey(InMemoryConfigurationService.getProp("google.maps.api.key"));
        requestBuilder.connectTimeout(15, TimeUnit.SECONDS);
        requestBuilder.readTimeout(15, TimeUnit.SECONDS);
        requestBuilder.maxRetries(2);
        GeoApiContext geoAPIContext = requestBuilder.build();
        DirectionsApiRequest request = new DirectionsApiRequest(geoAPIContext);
        request.alternatives(true);
        request.destination(postcode2);
        request.optimizeWaypoints(false);
        request.origin(postcode1);
        request.mode(TravelMode.DRIVING);
        request.units(Unit.IMPERIAL);
        float distance = Float.MAX_VALUE;
        long travelDurationInSeconds = 0L;

        try
        {
            DirectionsResult response = request.await();
            DirectionsRoute[] routes = response.routes;

            if(routes != null && routes.length > 0)
            {

                for(int i = 0; i < routes.length; i++)
                {
                    DirectionsLeg[] legsOfJourney = routes[i].legs;
                    float distanceTemp = legsOfJourney[0].distance.inMeters / 1609.0f;

                    if(distanceTemp < distance)
                    {
                        distance = distanceTemp;
                        travelDurationInSeconds = legsOfJourney[0].duration.inSeconds;
                    }

                }

            }

        }
        catch(NotFoundException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            return processAPICall(postcode1, postcode2, geoAPIContext);
        }
        catch(InvalidRequestException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            return processAPICall(postcode1, postcode2, geoAPIContext);
        }
        catch(ApiException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            return processAPICall(postcode1, postcode2, geoAPIContext);
        }
        catch(InterruptedException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            return processAPICall(postcode1, postcode2, geoAPIContext);
        }
        catch(IOException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            return processAPICall(postcode1, postcode2, geoAPIContext);
        }
        catch(Exception e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
            return processAPICall(postcode1, postcode2, geoAPIContext);
        }
        finally
        {
            closeRequest(geoAPIContext);
        }

        return DistanceAndTravelDurationModel.builder()
                        .distance(distance)
                        .travelDurationInSeconds(travelDurationInSeconds)
                        .build();
    }


    private DistanceAndTravelDurationModel processAPICall(String postcode1, String postcode2, GeoApiContext geoAPIContext)
    {
        closeRequest(geoAPIContext);

        if(numberOfRetries == 0)
        {

            try
            {
                Thread.sleep(3000);
                numberOfRetries = 1;
                return run(postcode1, postcode2);
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