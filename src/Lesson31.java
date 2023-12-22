import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Lesson31 {
    public static class Addrs {
        String addr1 = "Ленинградский проспект, 80, корп. Г";
        String addr2 = "Ленинские горы, 1";
    }

    public static class Os {
        String nameOs;
        boolean network;
    }

    public static class Language {
        boolean type;
        String name;
        String version;
        String[] keyWord = new String[10];
    }

    public static class MyPictureClass {
        String fileName = "temp.jpg";
        String path = "";
        String page;
    }

    private static String downloadWebPage(String url) throws IOException {
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

    public static void main(String[] args) throws IOException {

        // 1. Создайте классы с полями для описания структуры университета. Комбинируйте! Пусть одни классы будут полями других.
        University mgu = new University();
        University syn = new University();
        Addrs adr = new Addrs();
        syn.name = "Синергия";
        syn.city = "Москва";
        syn.addr = adr.addr1;
        mgu.name = "МГУ";
        mgu.city = "Москва";
        mgu.addr = adr.addr2;
        System.out.println("Университет: " + syn.name + ". Адрес: " + syn.city + ", " + syn.addr + ".");
        System.out.println("Университет: " + mgu.name + ". Адрес: " + mgu.city + ", " + mgu.addr + ".");

// 2. Создайте классы для описания операционных систем
        Os os1 = new Os();
        Os os2 = new Os();
        os1.nameOs = "DOS";
        os1.network = false;
        os2.nameOs = "Linux";
        os2.network = true;
        String str;
        System.out.print("Операционная система: " + os1.nameOs);
        str = os1.network ? "сетевая" : "не сетевая";
        System.out.print(". " + str + ".\n");
        System.out.print("Операционная система: " + os2.nameOs);
        str = os2.network ? "Сетевая" : "Не сетевая";
        System.out.print(". " + str + ".\n");

//3. Создайте классы для описания языков программирования (типизации, версии, массив ключевых слов..)
        Language php = new Language();
        php.name = "PHP";
        php.type = true;
        php.keyWord = new String[]{"break", "case", "array", "private", "return", "while"};
        php.version = "8.2.30";
        Language pascal = new Language();
        pascal.name = "Pascal";
        pascal.type = true;
        pascal.keyWord = new String[]{"procedure", "function", "begin", "end", "const", "var", "program", "repeat", "until"};
        pascal.version = "Turbo Pascal 5.5";

// 4. Сохраните информацию о всех файлах в заданной директории в массив FileInformation
        String path = "src";
        File dir = new File(path);
        File[] files = dir.listFiles();
        int fileCount = files.length;
        FileInformation[] info = new FileInformation[fileCount];
        File currentFile;
        for (int i = 0; i < fileCount; i++) {
            currentFile = files[i];
            info[i] = new FileInformation();
            info[i].size = currentFile.length();
            info[i].name = currentFile.getName();
            info[i].path = currentFile.getPath();
            System.out.println(info[i].path + " " + info[i].size);
        } // for

// 5. Сохраните снимок из Интернета в свой созданный класс
        String webAddr = "https://dog.ceo/api/breeds/image/random";
        MyPictureClass myClass = new MyPictureClass();
        myClass.page = downloadWebPage(webAddr);
        String urlImage;
        urlImage = myClass.page.substring(myClass.page.indexOf("https"), myClass.page.indexOf(".jpg") + 4);
        urlImage = urlImage.replace("\\", "");      // Удаляем лишние \
        File file = new File(myClass.path + myClass.fileName);
        if (file.isFile()) file.delete();
            try (InputStream in = new URL(urlImage).openStream()) {
                Files.copy(in, Paths.get(myClass.path + myClass.fileName));
            }
        System.out.println("Файл записан.");

// 6. Сделайте класс для цитаты из breaking bad: цитата и автор. Сохраните в массив таких классов 10 цитат.
// https://api.breakingbadquotes.xyz/v1/quotes
        MyQuote bb = new MyQuote();
        for (bb.i = 0; bb.i < bb.count; bb.i++) {
            bb.page = downloadWebPage(bb.webAddr);
            bb.begin = bb.page.indexOf("[{\"quote\":\"");
            bb.end = bb.page.indexOf("\",\"");
            bb.textQuote[bb.i] = bb.page.substring(bb.begin + 11, bb.end);
            bb.begin = bb.page.indexOf("\",\"author\":\"");
            bb.end = bb.page.indexOf("\"}]");
            bb.authorQuote[bb.i] = bb.page.substring(bb.begin + 12, bb.end - 3);
            bb.page = (bb.i < 9) ? (bb.i + 1) + ".  " : (bb.i + 1) + ". ";
            System.out.println(bb.page + bb.textQuote[bb.i] + " (" + bb.authorQuote[bb.i] + ")");
        } // for
    } // main

    public static class MyQuote {
        String webAddr = "https://api.breakingbadquotes.xyz/v1/quotes";
        String page;
        int count = 10;
        String[] textQuote = new String[count];
        String[] authorQuote = new String[count];
        int begin, end, i;
    }
} // Lesson1
