package com.orion.core.document.json.tasks;

import com.google.gson.Gson;
import com.orion.core.abstraction.Orion;
import com.orion.core.document.json.JSONObject;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;

public class ConvertJSONObjectToStringTask extends Orion
{
    public static String run(JSONObject jsonObject)
    {
        Assert.notNull(jsonObject, "The given jsonObject is null.");

        if(jsonObject.getJSONStringData() != null)
        {
            return jsonObject.getJSONStringData();
        }
        else if(jsonObject.getJSONMapData() != null)
        {
            return new Gson().toJson(jsonObject.getJSONMapData());
        }
        else
        {
            throw new InvalidArgumentException("The given jsonObject does not have mapData or stringData in it.");
        }

    }
}