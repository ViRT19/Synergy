import java.io.IOException;

public class Lesson36 {
    public static void main(String[] args) throws IOException {
// 1. Пользователь вводит 10 слов в массив. Найдите первое слово, в котором есть две гласные буквы подряд
// Чтобы не вводить 10 слов каждый раз - берём из генератора слов 10 слов.
// Из-за того, что две гласные подряд встречаются реже, будем искать согласные.
        MyClass myClass = new MyClass();
        final int countWords = 10;
        String[] words = new String[countWords];
        boolean isTwoLetters = false;
        String page = myClass.downloadWebPage("https://sanstv.ru/randomWord/lang-ru/strong-2/count-20/word-*");
        for (int i = 0; i < countWords; i++) {
            myClass.beginIndex = page.indexOf("href='/dict/", myClass.beginIndex) + 12;
            myClass.endIndex = page.indexOf("'", myClass.beginIndex);
            words[i] = page.substring(myClass.beginIndex, myClass.endIndex);
            System.out.print(words[i] + " ");
            myClass.beginIndex = myClass.endIndex + 1;
            for (int j = 0; j < words[i].length() - 1; j++) {
                if (myClass.soglasLetters.contains(words[i].charAt(j) + "")) {
                    if (words[i].charAt(j) == words[i].charAt(j + 1)) {
                        System.out.println("\nДве согласных подряд в слове «" + words[i] + "».");
                        isTwoLetters = true;
                        break;
                    }
                }
            }// for
            if (isTwoLetters) break;
        } // for
        if (!isTwoLetters) System.out.println("\nСлова с двумя согласными подряд не обнаружены.");

// 2. Пользователь вводит массив чисел. Найдите первое четное число.
// Чтобы не вводить массив каждый раз - числа будем генерировать.
        int[] intArray = new int[countWords];
        isTwoLetters = false;
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) (Math.random() * 1000);
            System.out.print(intArray[i] + " ");
            if (intArray[i] % 2 == 0) {
                isTwoLetters = true;
                System.out.println("\nПервое чётное число = " + intArray[i] + ".");
                break;
            } // if
        } // for
        if (!isTwoLetters) System.out.println("\nЧётные числа не обнаружены.");

// 3. Найдите первое чётное число в массиве, которое больше 100.
        isTwoLetters = false;
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) (Math.random() * 120);
            System.out.print(intArray[i] + " ");
            if (intArray[i] > 100 && intArray[i] % 2 == 0) {
                isTwoLetters = true;
                System.out.print("\nПервое чётное число больше 100 = " + intArray[i] + ".");
                break;
            } // if
        } // for
        if (!isTwoLetters) System.out.print("\nЧётных чисел больше 100 не обнаружено.");
        System.out.println();

// 4. Найдите последнее слово в массиве, которое написано ЗаБоРчИкОм (что б узнать, заглавная ли буква, используйте Character.isUpperCase(letter) ).
        int r1 = (int) (Math.random() * countWords);
        int r2 = (int) (Math.random() * countWords);
        words = myClass.returnRandomWords(20);
        // Делаем два случайных слова заборчиком.
        String str = "";
        String str2;
        for (int i = 0; i < words[r1].length(); i++) {
            str2 = "" + words[r1].charAt(i);
            if (i % 2 == 0)
                str = str + str2.toUpperCase();
            else str = str + str2;
        } // for
        words[r1] = str;
        str = "";
        for (int i = 0; i < words[r2].length(); i++) {
            str2 = "" + words[r2].charAt(i);
            if (i % 2 == 0)
                str = str + str2.toUpperCase();
            else str = str + str2;
        } // for
        words[r2] = str;

        for (int i = 0; i < countWords; i++)
            System.out.print(words[i] + " ");

        // Поиск последнего слова заборчиком.
        isTwoLetters = false;
        for (int i = words.length - 1; i >= 0; i--) {
            if (Character.isUpperCase(words[i].charAt(0))) {
                isTwoLetters = true;
                str = words[i];
                break;
            } // if
        } // for
        if (isTwoLetters)
            System.out.println("\nПоследнее слово в массиве заборчиком - " + str);
        else System.out.println("Слов «заборчиком» не обнаружено.");

// 5. Выводите числа от 1 до того момента, как сумма всех цифр в числе не будет равна 20 (пример такого числа - 875)
        int sum;
        isTwoLetters = false;
        for (int i = 0; i < 10; i++) {
            if (isTwoLetters) break;
            for (int j = 0; j < 10; j++) {
                if (isTwoLetters) break;
                for (int k = 0; k < 10; k++) {
                    sum = i + j + k;
                    if (sum == 20) {
                        System.out.println("Сумма цифр " + i + "+" + j + "+" + k + " = 20");
                        isTwoLetters = true;
                        break;
                    }
                } // for
            } // for
        } // for

// 6. Выведите все даты невисокосного года. В январе 31 день, феврале - 28, далее чередуется - в марте 31, в апреле 30…
    int[] month = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    String[] monthString = new String[] {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
    for (int i = 0; i < 12; i++) {
        System.out.print(monthString[i] + ": ");
        for (int j = 0; j < month[i]; j++)
            System.out.print((j+1) + " ");
        System.out.println();
    } // for

// 7. Сохраняйте снимки NASA с 1 января того момента, пока в поле Explanation нет слова “Earth”.
        final String fixLink = "https://apod.nasa.gov/apod/";
        page = myClass.downloadWebPage(fixLink + "archivepixFull.html");
        String link = "";
        String description = "";
        myClass.endIndex = 0;
        isTwoLetters = false;
        while (myClass.endIndex != -1) {
            myClass.beginIndex = page.indexOf("<a href=\"", myClass.endIndex) + 9;
            myClass.endIndex = page.indexOf("\">", myClass.beginIndex);
            link = page.substring(myClass.beginIndex, myClass.endIndex);
            myClass.beginIndex = myClass.endIndex + 2;
            myClass.endIndex = page.indexOf("</a><br>", myClass.beginIndex);
            description = page.substring(myClass.beginIndex, myClass.endIndex);
//            System.out.print(link);
//            System.out.println(" – " + description);
            if (description.contains("Earth")) {
                if (isTwoLetters) break;
                else isTwoLetters = true; // Пропускаем первое упоминание о Земле, т.к. там не фото, а клип. Берём второе упоминание.
            }
        } // while
        System.out.println(fixLink + link + " – " + description);
        page = myClass.downloadWebPage(fixLink + link);
        myClass.beginIndex = page.indexOf("<IMG SRC=\"") + 10;
        myClass.endIndex = page.indexOf("\"", myClass.beginIndex);
        link = page.substring(myClass.beginIndex, myClass.endIndex);
        myClass.writeImageFromUrl(fixLink + link, "nasa.jpg");
        System.out.println("Файл " + fixLink + link + " записан в nasa.jpg.");

    } // main
} // Lesson6
