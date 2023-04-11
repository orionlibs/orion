package com.orion.web.core.services.heartbeat;

import com.orion.core.abstraction.Orion;
import com.orion.data.source.configuration.data_access.VersionDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class Heartbeat extends Orion
{
    static ResponseEntity<?> isServerAlive()
    {

        if(VersionDAO.getNumberOfVersions() > 0)
        {
            return ResponseEntity.ok().build();
        }
        else
        {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }

    }
}