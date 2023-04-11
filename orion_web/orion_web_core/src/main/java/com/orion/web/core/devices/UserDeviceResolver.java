package com.orion.web.core.devices;

import com.orion.core.abstraction.Orion;
import com.orion.web.core.app.header.HTTPHeader;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class UserDeviceResolver extends Orion
{
    public static int resolveDeviceType(HttpServletRequest request)
    {
        String userAgent = request.getHeader(HTTPHeader.UserAgent.get());

        if(userAgent != null)
        {
            userAgent = userAgent.toLowerCase();

            if(UserDeviceResolverHelper.isTabletDevice(userAgent))
            {
                return UserDeviceType.TABLET;
            }
            else if(UserDeviceResolverHelper.isMobileDevice(userAgent, request))
            {
                return UserDeviceType.MOBILE;
            }

        }

        return UserDeviceType.DESKTOP;
    }
}