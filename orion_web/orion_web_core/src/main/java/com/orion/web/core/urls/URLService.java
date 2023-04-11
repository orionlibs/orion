package com.orion.web.core.urls;

import com.orion.core.abstraction.OrionService;
import com.orion.core.string.StringsService;
import java.util.List;

public class URLService extends OrionService
{
    public static String encodeURLWithUTF8(String URLToEncode)
    {
        return URLEncoder.encodeWithUTF8(URLToEncode);
    }


    public static String decodeURLWithUTF8(String URLToEncode)
    {
        return URLDecoder.decodeWithUTF8(URLToEncode);
    }


    public static String encodeURLRemovingSymbolsWithUTF8(String URLToEncode)
    {
        return URLEncoder.encodeRemovingSymbolsWithUTF8(URLToEncode);
    }


    public static String encodeURLRemovingSymbolsExceptForHyphenAndSpaceWithUTF8(String URLToEncode)
    {
        return URLEncoder.encodeRemovingSymbolsExceptForHyphenAndSpaceWithUTF8(URLToEncode);
    }


    public static boolean doesURLStartWithAny(String url, List<String> prefixesToCheck)
    {
        return StringsService.doesStartWithAny(url, prefixesToCheck);
    }
}