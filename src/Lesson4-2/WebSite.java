package Lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WebSite {
    String page = "";
    int beginIndex = 0;
    int endIndex = 0;
    String siteTitle = "";

    public WebSite (String url) throws IOException {
        page = downloadWebPage(url);
        beginIndex = page.indexOf("<title>") + 7;
        endIndex = page.indexOf("</title>");
        siteTitle = page.substring(beginIndex, endIndex);
    }
    public WebSite() throws IOException {
        System.out.print("Enter url: ");
        Scanner console = new Scanner(System.in);
        String url = console.nextLine();
        page = downloadWebPage(url);
        beginIndex = page.indexOf("<title>") + 7;
        endIndex = page.indexOf("</title>");
        siteTitle = page.substring(beginIndex, endIndex);
    }

    String downloadWebPage(String url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        URLConnection urlConnection = new URL(url).openConnection();
        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    } // downloadWebPage


}
