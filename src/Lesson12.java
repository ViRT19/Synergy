import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Lesson12 {
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
    }
    private static void writeToFile(String str, String fName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fName));
        writer.write(str);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        System.out.print("1. Если 5 в 15 степени больше миллиарда, вывести: ");
        if (Math.pow(5, 15) > 1000000000) System.out.print("«Степень это мощь. Power is a power». Результат: ");
        System.out.println(Math.pow(5, 15));
        // 2. Задайте переменную. Если она больше 0, вывести «позитив», если меньше 0, вывести «отрицательно»
        float x = (float) Math.random() * 32768 - 16384;
        System.out.print("2. Псевдослучайное число больше или меньше нуля. x = " + x + ". Это ");
        if (x >= 0) System.out.println("> 0.");
        else System.out.println("< 0.");
        // 3. Если квадратный корень из 15 миллионов меньше 5 тысяч, вывести - «два измерения лучше, чем одно».
        if (Math.sqrt(15000000) < 5000) System.out.print("3. Два измерения лучше, чем одно. ");
        else System.out.print("3. Два измерения хуже, чем одно. ");
        System.out.println(Math.sqrt(15000000));
        // 4. Если 2 в 10 степени меньше 512 вывести - «Pentium 2», иначе вывести - «ARM»
        if (Math.pow(2, 10) < 512) System.out.println("4. «Pentium 2»");
        else System.out.println("4. «ARM»");
        // 5. Задать две дробных переменных. Вывести наибольшую из них.
        float y = (float) Math.random() * 100000 - 50000;
        System.out.print("5. Заданы переменные x = " + x + " и y = " + y + ". Наибольшая: ");
        if (x > y) System.out.println("x.");
        else System.out.println("y.");
        // 6. Задать две переменных - first и second. Вывести first в степени second, second в степени first.
        float first = (float) Math.random() * 100;
        float second = (float) Math.random() * 10;
        System.out.println("6. " + first + " в степени " + second + " = " + Math.pow(first, second) + ".");
        System.out.println("6. " + second + " в степени " + first + " = " + Math.pow(second, first) + ".");
        // 7. Задать две переменных - икс и игрек. Вывести, что больше - икс в степени игрек, или наоборот.
        x = first;
        y = second;
        if (Math.pow(x, y) > Math.pow(y, x))
            System.out.println("7. " + x + "^" + y + " > " + y + "^" + x + ".");
        else
            System.out.println("7. " + x + "^" + y + " < " + y + "^" + x + ".");
        // 8. Вывести числа от 1 до 100
        int i = 1;
        System.out.println("8. Вывести числа от 1 до 100:");
        while (i <= 100) {
            if (i < 100)
                System.out.print(i + ", ");
            else
                System.out.print(i + ".");
            if (i % 25 == 0) System.out.println();
            i++;
        }
        System.out.println("9. Вывести числа от 50 до 100:");
        for (i = 50; i <= 100; i++)
            System.out.print(i + " ");
        System.out.println("\n10. Вывести числа от 100 до 1:");
        for (i = 100; i >= 1; i--) {
            System.out.print(i + " ");
            if (i == 53) System.out.println();
        }
        System.out.println("\n11. Вывести числа от 0 до -100:");
        for (i = 0; i >= -100; i--) {
            System.out.print(i + " ");
            if (i == -51) System.out.println();
        }

        // 12. Задать строковую переменную. Заменить в ней все буквы «о» на «обро».
        String str = "Какая-то строка для отработки строковых действий. Это длинная строка...";
        System.out.println("\n12. Замена «о» на «обро»: " + str.replaceAll("о", "обро"));
        System.out.println("13. Задать строковую переменную. Вывести ее в верхнем регистре: " + str.toUpperCase());

        // 14. Задать строковую переменную. Заменить в ней буквы а на @, а буквы о на 0.
        String str1 = str.replaceAll("а", "@");
        str1 = str1.replaceAll("о", "0");
        System.out.println("14. Задать строковую переменную. Заменить в ней буквы а на @, а буквы о на 0: " + str1);

        // 15. Задать две строковых переменных. Найти, какая из них длиннее.
        str1 = "Вторая строка в качестве строковой переменной";
        System.out.print("15. srt1 = " + str1 + ". Сравнение длин: ");
        if (str.length() > str1.length()) System.out.println("Первая строка длиннее.");
        else System.out.println("Вторая строка длиннее.");

        // 16. Задать три переменных, найти наибольшую из них
        double[] num = new double[3];
        num[0] = Math.random() * 1000;
        num[1] = Math.random() * 1000;
        num[2] = Math.random() * 1000;
        double big = 0;
        i = 0;
        while (i < 3) {
            if (num[i] > big)
                big = num[i];
            i++;
        }
        System.out.println("16. Из трёх переменных: " + (int) num[0] + ", " + (int) num[1] + ", " + (int) num[2] + " наибольшая = " + (int) big + ".");

        // 17. Напишите программу, сохраняющую в файл статью из википедии «Проблема 2000 года». Прочитайте её.
        String urlName = "https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D0%B1%D0%BB%D0%B5%D0%BC%D0%B0_2000_%D0%B3%D0%BE%D0%B4%D0%B0";
        String fileName = "myViki-2000.html";
        String fileName2 = "myViki2-2000.html";
        String sourceCode = downloadWebPage(urlName);
        writeToFile(sourceCode, fileName);
        System.out.println("17. Статья «" + urlName + "» записана в файл " + fileName);
        /* 18. Напишите программу, сохраняющую в файл статью из википедии «Дональд Кнут». Перед сохранением в файл замените все слова "Кнут" на "Пряник".
        Используется метод sourceCode.replaceall ("Кнут", "Пряник"); Но сделаем задачку поинтереснее... */

        // Search "<title>" tag and delete all text before it
        int indexBeginTitle = sourceCode.indexOf("<title>");
        String target = sourceCode.substring(0, indexBeginTitle);
        sourceCode = sourceCode.replace(target, "");
        String endOfLetter = "<div id=\"toc\" class=\"toc\" role=\"navigation\"";
        System.out.println("18. В статье удалены подстроки заменой на \"\" текст до тега \"<title>\" и текст после и вкючая \"См. также\"");
        int indexEndTitle = sourceCode.indexOf(endOfLetter);
        int lengthOfSourceCode = sourceCode.length();
        target = sourceCode.substring(indexEndTitle, lengthOfSourceCode);
        sourceCode = sourceCode.replace(target, "");
        writeToFile(sourceCode, fileName2);
        System.out.println("Лишние фрагменты удалены.");

        System.out.println("19, 20.  Сохранить 50 случайных статей из Википедии.");
        urlName = "https://ru.wikipedia.org/wiki/Служебная:Случайная_страница";
        String title;
        int titleLength;
        for (i=1; i<=50; i++) {
            sourceCode = downloadWebPage(urlName);
            indexBeginTitle = sourceCode.indexOf("<title>");
            titleLength = sourceCode.indexOf(" — Википедия");
            fileName = "50Viki\\0" + i + "_" + sourceCode.substring(indexBeginTitle + 7, titleLength) + ".html"; //Директория должна быть создана перед запуском программы
            System.out.println(fileName);
//  Следующая строка закомментирована, чтобы не плодить скачанные файлы в папке «50Viki».
//            writeToFile(sourceCode, fileName);
        }
    }
}