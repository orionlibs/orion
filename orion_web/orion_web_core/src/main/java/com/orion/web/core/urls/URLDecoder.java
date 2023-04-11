package com.orion.web.core.urls;

import com.orion.core.abstraction.Orion;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
class URLDecoder extends Orion
{
    static String decodeWithUTF8(String url)
    {

        try
        {
            return java.net.URLDecoder.decode(url, StandardCharsets.UTF_8.name());
        }
        catch(UnsupportedEncodingException e)
        {
            return "";
        }

    }
}