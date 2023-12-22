import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MyClass3 {
    int max = -2147483647;
    String str = "";
    String stroka = "";
    int summa = 0;
    String fileName = "src\\MyClass.java";
    int beginIndex, endIndex;
    static String glasLetters = "аеёиоуыэюя";
    static String soglasLetters = "бвгджзйклмнпрстфхцчшщъь";



    public int maxOfArray(int[] arrayInt) {
        for (int i = 0; i < arrayInt.length; i++) {
            if (this.max < arrayInt[i]) this.max = arrayInt[i];
        }
        return this.max;
    } // maxOfArray

    public String concatenation(String[] arrString) {
        for (int i = 0; i < arrString.length; i++)
            this.str = this.str + arrString[i];
        return this.str;
    } // concatenation

    public int Min (int x, int y) {
        if (x < y) return x;
        else return y;
    } //Min

    public int Sum (String str) {
        String[] arrString = new String[100];
        arrString = str.split(" ");
        for (int i = 0; i < arrString.length; i++)
            this.summa = this.summa + Integer.parseInt(arrString[i]);
        return this.summa;
    } // Sum

    public String EndToBegin (String str) {
        for (int i = str.length()-1; i >= 0; i--)
            this.stroka = this.stroka + str.charAt(i);
        return this.stroka;
    } // EndToBegin

    public static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    } // readFile

    public void PrintMethod (String stroka) {
        this.str = "";
        try {
            this.str = readFile(this.fileName, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.beginIndex = str.indexOf(stroka) - 20;
        this.beginIndex = str.indexOf("public", this.beginIndex);
        this.endIndex = str.indexOf(stroka,this.beginIndex + stroka.length() + 20);
        System.out.println(str.substring(this.beginIndex, this.endIndex + stroka.length()));
    } // PrintMethod

    static String downloadWebPage(String url) throws IOException {
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

    static void writeImageFromUrl(String urlImage, String fileName) {
        File file = new File(fileName);
        if (file.isFile()) file.delete();
        try (InputStream in = new URL(urlImage).openStream()) {
            Files.copy(in, Paths.get(fileName));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } // writeImageFromUrl

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
    }

} // MyClass

