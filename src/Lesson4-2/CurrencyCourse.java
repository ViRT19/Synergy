package Lesson2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CurrencyCourse {
    CurrencyCourse() throws IOException {
        Url u = new Url();
        int beginIndex, endIndex;
//        int currentYear = Year.now().getValue();
//        int currentMonth = Month.of().getValue();
//        String url = "";
//        url = "https://cbr.ru/scripts/XML_dynamic.asp?date_req1="+ day +"/"+ month +"/" + (year-1) + "&date_req2="+ day +"/"+ month +"/" + year + "&VAL_NM_RQ=R01235";
        String page = u.downloadWebPage(u.url);
        beginIndex = page.lastIndexOf("<Value>");
        endIndex = page.lastIndexOf("</Value>");
        System.out.println("На " + u.day + "." + u.month + "." + u.year + " $ = " + page.substring(beginIndex + 7, endIndex) + " руб.");
    }

}
