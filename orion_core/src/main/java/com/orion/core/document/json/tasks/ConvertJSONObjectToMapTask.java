package com.orion.core.document.json.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.document.json.JSONObject;
import com.orion.core.document.json.JSONService;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import java.util.Map;

public class ConvertJSONObjectToMapTask extends Orion
{
    public static Map<?, ?> run(JSONObject jsonObject)
    {
        Assert.notNull(jsonObject, "The given jsonObject is null.");

        if(jsonObject.getJSONMapData() != null)
        {
            return jsonObject.getJSONMapData();
        }
        else if(jsonObject.getJSONStringData() != null)
        {
            return JSONService.convertJSONToMap(jsonObject.getJSONStringData());
        }
        else
        {
            throw new InvalidArgumentException("The given jsonObject does not have mapData or stringData in it.");
        }

    }
}