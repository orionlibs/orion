package com.orion.web.core.urls;

import com.orion.core.abstraction.Orion;
import com.orion.core.string.StringsService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.util.UriComponentsBuilder;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
class URLEncoder extends Orion
{
    static String encodeWithUTF8(String url)
    {
        return UriComponentsBuilder.fromUriString(url).build().encode().toUri().toString();
    }


    static String encodeRemovingSymbolsWithUTF8(String url)
    {
        return encodeWithUTF8(StringsService.deleteSymbolCharacters(url));
    }


    static String encodeRemovingSymbolsExceptForHyphenAndSpaceWithUTF8(String url)
    {
        return encodeWithUTF8(StringsService.deleteSymbolCharactersExceptForHyphenAndSpace(url));
    }
}