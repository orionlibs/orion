package com.orion.web.services.google_maps.route;

import com.google.maps.GeoApiContext;
import com.orion.core.abstraction.Orion;
import java.io.IOException;

public abstract class AGoogleMapsTask extends Orion
{
    protected void closeRequest(GeoApiContext geoAPIContext)
    {

        try
        {

            if(geoAPIContext != null)
            {
                geoAPIContext.close();
                geoAPIContext.shutdown();
            }

            geoAPIContext = null;
        }
        catch(IOException e)
        {
            /*LoggingService.logError(null,
                            null,
                            GoogleMapsErrorType.GoogleMaps.get(),
                            GoogleMapsErrors.ErrorWithGoogleMaps,
                            e);*/
        }

    }
}