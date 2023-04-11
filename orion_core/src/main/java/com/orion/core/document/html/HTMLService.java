package com.orion.core.document.html;

import com.googlecode.htmlcompressor.compressor.HtmlCompressor;
import com.orion.core.abstraction.OrionService;
import org.jsoup.Jsoup;

public class HTMLService extends OrionService
{
    public static String minifyHTMLContent(String contentInHTML)
    {
        HtmlCompressor compressor = new HtmlCompressor();
        compressor.setCompressCss(true);
        compressor.setCompressJavaScript(true);
        compressor.setYuiJsPreserveAllSemiColons(true);
        return compressor.compress(contentInHTML);
    }


    public static String unminifyHTMLContent(String contentInHTML)
    {
        return Jsoup.parse(contentInHTML).toString();
    }
}