package Lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;

public class Url {
    String url = "";
    LocalDateTime now = LocalDateTime.now();
    int year = now.getYear();
    int month = now.getMonthValue();
    int day = now.getDayOfMonth();

    Url() {
        url = "https://cbr.ru/scripts/XML_dynamic.asp?date_req1="+ day +"/"+ month +"/" + (year-1) + "&date_req2="+ day +"/"+ month +"/" + year + "&VAL_NM_RQ=R01235";
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
