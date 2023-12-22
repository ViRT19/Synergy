import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;

public class Lesson18 {
    private static String downloadWebPage (String url) throws IOException {
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
    }
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);

        // 1, 2. Тернарный оператор. Поиск бóльшего числа.
        System.out.print("Введите 2 числа через пробел: ");
        int x = console.nextInt(), y = console.nextInt();
        int max = x > y ? x : y;
        System.out.println("Наибóльшее число = " + max);

        //3. Поиск максимума из трёх чисел.
        System.out.print("Введите три числа через пробел: ");
        x = console.nextInt();
        y = console.nextInt();
        int z = console.nextInt();
        max = x > y ? x : y;
        max = max < z ? z : max;
        System.out.println("аибóльшее число из трёх = " + max);

        //4. Научимся получать случайную цитату из сериала в java
        String randomLetter = "https://knife.media/random/";    //Ссылка из задания не работает, взял другую
        String content = downloadWebPage(randomLetter);
        int beginIndex = content.indexOf("<h1 class=\"entry-header__title\">");
        int endIndex = content.indexOf("</h1>");
        String title = content.substring(beginIndex + 32, endIndex - 5);
        title = title.replace("<em>", "");      // Удаление выделения текста
        title = title.replace("&nbsp;", " ");   //Замена неразрывного пробела на обычный
        title = title.replace("&laquo;", "«");  //Замена левых кавычек
        title = title.replace("&raquo;", "»");  //Замена правых кавычек
        System.out.println(title);

        //5, 6. Возьмем код с 4 задания и добавим определение длины цитаты.
        int maxLengh = 50;
        title = title.length() > maxLengh ? title.substring(0, maxLengh) + "..." : title;
        System.out.println(title);

        //7. Добавление автора цитаты (в моём случае - статьи)
        int authorBeginIndex = content.indexOf("rel=\"author\">");
        String tempContent = content.substring(authorBeginIndex + 13, authorBeginIndex + 50);
        int authorEndIndex = tempContent.indexOf("</a>");
        String author = tempContent.substring(0, authorEndIndex - 4);
        System.out.println("Автор: " + author);

        //Задание 8. Самостоятельно добавьте вывод цитат только Walter White, используя тернарные операторы.
        //Т.к. Walter White у меня не встречается, добавлю реакцию на совпадение с автором «Илья Чик».
        String authorIlia = author.equals("Илья Чик") ? "совпало!" : "не совпало.";
        System.out.println("\n" + authorIlia);
    }
}
