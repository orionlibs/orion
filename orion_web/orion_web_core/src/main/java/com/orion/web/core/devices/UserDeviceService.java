package com.orion.web.core.devices;

import com.orion.core.abstraction.OrionService;
import javax.servlet.http.HttpServletRequest;

public class UserDeviceService extends OrionService
{
    public static int resolveDevice(HttpServletRequest request)
    {
        return UserDeviceResolver.resolveDeviceType(request);
    }
}