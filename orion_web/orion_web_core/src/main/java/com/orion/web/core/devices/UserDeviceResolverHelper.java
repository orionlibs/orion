package com.orion.web.core.devices;

import com.orion.core.abstraction.Orion;
import com.orion.web.core.app.header.HTTPHeader;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
class UserDeviceResolverHelper extends Orion
{
    static boolean isTabletDevice(String userAgent)
    {

        if((userAgent.contains("android") || userAgent.contains("silk")) && (!(userAgent.contains("mobile"))))
        {
            return true;
        }

        return UserAgents.tabletUserAgentKeywords.stream().anyMatch(keyword -> userAgent.contains(keyword));
    }


    static boolean isMobileDevice(String userAgent, HttpServletRequest request)
    {

        if((request.getHeader(HTTPHeader.WAPProfile.get()) != null) || (request.getHeader(HTTPHeader.Profile.get()) != null))
        {
            return true;
        }

        if(userAgent.length() >= 4)
        {
            String prefix = userAgent.substring(0, 4).toLowerCase();

            if(UserAgents.mobileUserAgentPrefixes.contains(prefix))
            {
                return true;
            }

        }

        String accept = request.getHeader(HTTPHeader.Accept.get());

        if(accept.contains("wap"))
        {
            return true;
        }

        if(UserAgents.mobileUserAgentKeywords.stream().anyMatch(keyword -> userAgent.contains(keyword)))
        {
            return true;
        }

        Enumeration<String> headers = request.getHeaderNames();

        while(headers.hasMoreElements())
        {

            if(((String)(headers.nextElement())).contains("OperaMini"))
            {
                return true;
            }

        }

        return false;
    }
}