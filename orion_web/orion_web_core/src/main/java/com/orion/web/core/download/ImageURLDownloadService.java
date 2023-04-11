package com.orion.web.core.download;

import com.orion.core.abstraction.OrionService;
import com.orion.core.runnable.OrionJob;
import java.io.IOException;
import org.jsoup.Jsoup;

public class ImageURLDownloadService extends OrionService implements OrionJob
{
    private String baseURL;


    public ImageURLDownloadService(String baseURL)
    {
        this.baseURL = baseURL;
    }


    public void download()
    {

        try
        {
            Jsoup.connect(baseURL).get().select("a").forEach(link -> System.out.println(link.attr("abs:href")));
            //Jsoup.connect(baseURL).get().select("img").forEach(link -> System.out.println(link.attr("abs:src")));
        }
        catch(IOException e)
        {
        }

    }


    @Override
    public void run()
    {
        download();
    }
}