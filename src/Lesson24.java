import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Lesson24 {

    public static void q1() {
        // 1. С помощью цикла do..while, выведите римские цифры (код начинается с 8544). Начало: char c = 8544; …
        int code = 8544;
        char ch;
        do {
            ch = (char) code;
            System.out.print(ch + " ");
            code++;
        } while (code != 8560);

    } //q1

    public static void q2() {
        // 2. С помощью цикла do..while, выведите числа от -0.9 до 0.9
        int var = -9;
        String str;
        do {
            str = (var < 0) ? "-0." : "0.";
            System.out.print(str + Math.abs(var) + " ");
            var++;
        } while (var < 10);
    } // q2

    public static void q3() {
        // 3. Пользователь вводит строку, выведите каждый второй символ (подсказка: str.charAt(i) )
        Scanner console = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = console.nextLine();
        int count = 0;
        do {
            if (count % 2 == 1)
                System.out.print(str.charAt(count));
            count++;
        } while (count <= str.length() - 1);
    } // q3

    public static void q4() {
        // 4. Пользователь вводит строку. Выводите все слова на разных строках (подсказка : if (str.charAt(i)==‘ ‘) System.out.println(); )
        Scanner console = new Scanner(System.in);
        System.out.print("Введите строку с пробелами: ");
        String str = console.nextLine();
        String space;
        for (int i = 0; i < str.length(); i++) {
            space = (str.charAt(i) == ' ') ? "\n" : String.valueOf(str.charAt(i));
            System.out.print(space);
        }
        System.out.println();
    } // q4

    public static void q5() {
        // 5. Пользователь вводит строку. Выведите первые 3 слова
        Scanner console = new Scanner(System.in);
        System.out.print("Введите строку с пробелами: ");
        String str = console.nextLine();
        String space = "";
        int count = 0;
        int i = 0;
        do {
            if (str.charAt(i) == ' ') count++;
            space = String.valueOf(str.charAt(i));
            System.out.print(space);
            i++;
        } while (i < str.length() && count < 3);
        System.out.println();
    } // q5

    public static void q6() {
        // 6. Пользователь вводит строку, выведите ее задом-наперёд.
        Scanner console = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = console.nextLine();
        for (int i = str.length(); i > 0; i--)
            System.out.print(str.charAt(i - 1));
        System.out.println();
    } // q6

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

    public static void q7() throws IOException {
        // 7. Пользователь вводит букву. Выведите любое слово, начинающуюся на эту букву
        String webAddr = "https://sanstv.ru/randomWord/lang-ru/";
        System.out.print("Введите русскую букву, будет случайное слово на эту букву: ");
        Scanner console = new Scanner(System.in);
        String str = console.next();
        char c = str.charAt(0);
        String page = downloadWebPage(webAddr);
        int beginIndex = page.indexOf("target=\'_blank \'>" + c);
        int endIndex = page.indexOf("</a>", beginIndex);
        System.out.println(page.substring(beginIndex+17, endIndex));
    } //q7

    public static void main(String[] args) throws IOException {
        int menu = -1;
        Scanner console = new Scanner(System.in);
        while (menu != 0) {
            System.out.println("\n1. Вывод римских цифр.\n" +
                    "2. Вывод чисел от -0.9 до 0.9.\n" +
                    "3. Вывод каждого второго символа введённой строки.\n" +
                    "4. Разделение строки на слова.\n" +
                    "5. Вывод первых трёх слов из введённой строки.\n" +
                    "6. Вывод строки в обратном порядке.\n" +
                    "7. Вывод слова, начинающегося с заданной буквы.");
            System.out.print("Выбор задания (выход - 0): ");
            menu = console.nextInt();
            switch (menu) {
                case 0:
                    break;
                case 1:
                    q1();
                    break;
                case 2:
                    q2();
                    break;
                case 3:
                    q3();
                    break;
                case 4:
                    q4();
                    break;
                case 5:
                    q5();
                    break;
                case 6:
                    q6();
                    break;
                case 7:
                    q7();
                    break;
            } // case menu
        } // while menu !=0
    }
}