package Lesson2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class StrBuild {
    int beginIndex = 0;
    int endIndex = 0;
    int count = 4;
    StringBuilder str = new StringBuilder();


    public StrBuild() throws IOException {
        String[] words = new String[count];
        words = returnRandomWords(count);
        for (int i = 0; i < this.count; i++)
            str.append(words[i] + " ");
    }
    public StrBuild(int count) throws IOException {
        String[] words = new String[count];
        words = returnRandomWords(count);
        for (int i = 0; i < count; i++)
            str.append(words[i] + " ");
    }

    String[] returnRandomWords(int num) throws IOException {
        String page = this.downloadWebPage("https://sanstv.ru/randomWord/lang-ru/strong-2/count-" + num + "/word-*");
        String[] words = new String[num];
        this.beginIndex = 0;
        this.endIndex = 0;
        for (int i = 0; i < num; i++) {
            this.beginIndex = page.indexOf("href='/dict/", this.beginIndex) + 12;
            this.endIndex = page.indexOf("'", this.beginIndex);
            words[i] = page.substring(this.beginIndex, this.endIndex);
        } // for
        return words;
    } // returnRandomWords

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
