import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.Scanner;

public class Lesson35 {
    public static void main(String[] args) throws IOException {
// 1. Пользователь вводит стихотворение из четырёх строк. Соберите их в одну переменную, между каждой строкой вставьте символ переноса строки: «\n»
// Вместо ввода слов и строк воспользуюсь массивами.
        String[] stih = new String[4];
        stih[0] = "В лесу родилась ёлочка.";
        stih[1] = "В лесу она росла.";
        stih[2] = "Зимой и летом стройная,";
        stih[3] = "Зелёная была.";
        StringBuilder builder = new StringBuilder();
        builder.append(stih[0] + "\n");
        builder.append(stih[1] + "\n");
        builder.append(stih[2] + "\n");
        builder.append(stih[3]);
        System.out.println(builder);

// 2. Пользователь вводит три слова, соберите из них строку, где слова будут в обратном порядке
        String[] words = new String[7];
        words[0] = "Первое";
        words[1] = "введённое";
        words[2] = "слово";
        StringBuilder builder2 = new StringBuilder();
        builder2.append(words[2] + " ");
        builder2.append(words[1] + " ");
        builder2.append(words[0] + ".");
        System.out.println(builder2);

// 3. Пользователь вводит слово. Добавьте к нему в начало «вы говорите:» … слово пользователя. И в конец: «.. и что?»
        StringBuilder builder3 = new StringBuilder();
        builder3.append("Вы говорите: «");
        builder3.append(words[2]);
        builder3.append("». И что?");
        System.out.println(builder3);

// 4. Пользователь вводит пять слов, соберите из них целую строку, между каждым словом вставьте «, и»
        words[3] = "плюс";
        words[4] = "два";
        StringBuilder builder4 = new StringBuilder();
        for (int i = 0; i < 4; i++)
            builder4.append(words[i] + ", и ");
        builder4.append(words[4] + ".");
        System.out.println(builder4);

// 5. Пользователь вводит предложение их двух слов (считайте в одну переменную String phrase).
// Вставьте между этими словами «так сказать» используя StringBuilder.insert.
// Было: «Учу Java». Станет: «Учу, так сказать, Java»
        StringBuilder builder5 = new StringBuilder();
        words[5] = "учу";
        words[6] = "Java";
        builder5.append(words[5]);
        builder5.append(words[6]);
        builder5.insert(words[5].length(), ", так сказать, ");
        builder5.append(".");
        System.out.println(builder5);

// 6. Пользователь вводит число, любое. 237, например. Выведите: 237 программистов, окончание должно зависеть от числа. 1 программист, 2 программиста, и так далее
        StringBuilder builder6 = new StringBuilder();
        int number = (int) (Math.random() * 1000);
        String prog = "программистов";
        String str = Integer.toString(number);
        int sw = Integer.parseInt(str.substring(str.length() - 1, str.length()));
        if (sw == 1) prog = "программист";
        else if (sw > 1 && sw < 5) prog = "программиста";
        builder6.append(number);
        builder6.append(" " + prog);
        System.out.println(builder6);

// 7. Пользователь вводит предложение, удалите все пробелы из него
        StringBuilder builder7 = new StringBuilder();
        words = stih[0].split(" ");
        for (int i = 0; i < words.length; i++)
            builder7.append(words[i]);
        words = stih[1].split(" ");
        for (int i = 0; i < words.length; i++)
            builder7.append(words[i]);
        System.out.println(builder7);

// 8. Вернитесь к программе, которая запрашивает курс валют. Напишите генератор даты для запроса к апи, на основе даты, введенной пользователем. Используйте StringBuilder.
        StringBuilder builder8 = new StringBuilder();
        String page = "";
        int beginIndex, endIndex;
        int yearInt = (int) (Math.random() * (Year.now().getValue() - 1 - 1994) + 1994);
        int monthInt = (int) (Math.random() * 12 + 1);
        int[] days31 = new int[]{1, 3, 5, 7, 8, 10, 12};
        int[] days30 = new int[]{4, 6, 9, 11};
        int dayIntMax = 1;
        if (monthInt == 2 && yearInt % 4 == 0) dayIntMax = 29;
        else if ((monthInt == 2 && yearInt % 4 != 0)) dayIntMax = 28;
        for (int i = 0; i < days31.length; i++)
            if (monthInt == days31[i])
                dayIntMax = 31;
        for (int i = 0; i < days30.length; i++)
            if (monthInt == days30[i])
                dayIntMax = 30;
        int dayInt = (int) (Math.random() * dayIntMax + 1);
        String yearString0 = Integer.toString(yearInt);
        String yearString1 = Integer.toString(yearInt + 1);
        String monthString = (monthInt < 10) ? "0" + Integer.toString(monthInt) : Integer.toString(monthInt);
        String dayString = (dayInt < 10) ? "0" + Integer.toString(dayInt) : Integer.toString(dayInt);
        MyClass3 downloadWebPage = new MyClass3();
        builder8.append("https://cbr.ru/scripts/XML_dynamic.asp?date_req1=");
        builder8.append(dayString + "/" + monthString + "/" + yearString0);
        builder8.append("&date_req2=" + dayString + "/" + monthString + "/" + yearString1);
        builder8.append("&VAL_NM_RQ=R01235");
        System.out.println(builder8);
//        url = "https://cbr.ru/scripts/XML_dynamic.asp?date_req1=01/02/" + year + "&date_req2=01/02/" + (year+1) + "";
        String url = builder8.toString();
        page = downloadWebPage.downloadWebPage(url);
        beginIndex = page.lastIndexOf("<Value>");
        endIndex = page.lastIndexOf("</Value>");
        System.out.println("На " + dayString + "." + monthString + "." + yearString1 + " $ = " + page.substring(beginIndex + 7, endIndex) + " руб.");

// 9. Скачайте цитату из breaking bad и замените все плохие слова звёздочками
        StringBuilder builder9 = new StringBuilder();
        url = "https://api.breakingbadquotes.xyz/v1/quotes";
        String[] badWords = new String[]{"fucking", "fuck", "sex", "butts", "f*ck", "masturbating", "bitches", "turds", "bitch"};
        page = downloadWebPage.downloadWebPage(url);
        beginIndex = page.indexOf("[{\"quote\":\"");
        endIndex = page.indexOf("\",\"");
        String quote = (page.substring(beginIndex + 11, endIndex));
        String[] wordArray = quote.split(" ");
        for (int i = 0; i < wordArray.length; i++)
            for (int j = 0; j < badWords.length; j++)
                if (wordArray[i].equals(badWords[j]))
                    wordArray[i] = "*****";
        for (int i = 0; i < wordArray.length; i++)
            builder9.append(wordArray[i] + " ");
        System.out.println(builder9);

// 10. Напишите крестики-нолики, используя StringBuilder

        StringBuilder field = new StringBuilder("1|2|3\n4|5|6\n7|8|9");
        int[] sell = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16};
        boolean isWon = false;
        System.out.println("Введите число от 1 до 9, чтобы сделать Ваш ход: ");
        Scanner console = new Scanner(System.in);
        int num = 0;
        while (!isWon) {
            while (num > 9 || num < 1) {
                System.out.println(field);
                num = console.nextInt();
            } // while
            field.deleteCharAt(sell[num - 1]);
            field.replace(sell[num - 1], sell[num - 1], "X");
            num = 0;
            if (field.charAt(sell[0]) == field.charAt(sell[1]) && field.charAt(sell[1]) == field.charAt(sell[2]) ||
                    field.charAt(sell[3]) == field.charAt(sell[4]) && field.charAt(sell[4]) == field.charAt(sell[5]) ||
                    field.charAt(sell[6]) == field.charAt(sell[7]) && field.charAt(sell[7]) == field.charAt(sell[8]) ||
                    field.charAt(sell[0]) == field.charAt(sell[3]) && field.charAt(sell[3]) == field.charAt(sell[6]) ||
                    field.charAt(sell[1]) == field.charAt(sell[4]) && field.charAt(sell[4]) == field.charAt(sell[7]) ||
                    field.charAt(sell[2]) == field.charAt(sell[6]) && field.charAt(sell[6]) == field.charAt(sell[8]) ||
                    field.charAt(sell[0]) == field.charAt(sell[4]) && field.charAt(sell[4]) == field.charAt(sell[8]) ||
                    field.charAt(sell[2]) == field.charAt(sell[4]) && field.charAt(sell[4]) == field.charAt(sell[6]))
                isWon = true;
        } // while
        System.out.println("Вы выиграли.");

// 11. Пусть пользователь вводит поля класса FileInformation, но в одну строку; формат придумайте сами. Считайте ввод пользователя и из него создайте экземпляр класса.
        System.out.println("Введите имя файла и размер через пробел");
        FileInformation fileInfo = new FileInformation();
        StringBuilder fileName = new StringBuilder(console.next() + console.nextLine());
        int index = fileName.indexOf(" ");
        fileInfo.name = fileName.substring(0, index).toString();
        fileInfo.size = Integer.parseInt(fileName.substring(index+1, fileName.length()).toString());
        System.out.println("Filename = " + fileInfo.name + ", size = " + fileInfo.size);
    } // main

} // Lesson36
