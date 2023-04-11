package com.orion.web.core.download;

import com.orion.core.abstraction.OrionService;

public class URLDownloadService extends OrionService
{
    public static void main(String[] args)
    {
        //Elements elements = Jsoup.connect("https://repo1.maven.org/maven2/").get().select("a");
        //Jsoup.connect("https://repo1.maven.org/maven2/").get().select("a").forEach(link -> System.out.println(link.attr("abs:href")));
        /*try
        {
            URL urlImage = new URL(href);
            InputStream in = urlImage.openStream();
            byte[] buffer = new byte[4096];
            int n = -1;
            OutputStream os = new FileOutputStream(mavenDir + "/" + jarFileName);

            while((n = in.read(buffer)) != -1)
            {
                os.write(buffer, 0, n);
            }

            os.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }*/
    }
    /*public static void download(String baseURL)
    {
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        for(int i = 1; i <= 100; i++)
        {
            executor.execute(new ImageURLDownloadService(baseURL + i));
        }

    }*/
}