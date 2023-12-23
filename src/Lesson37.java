import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;

public class Lesson37 {
    public static int Div3(int[] num) {
        boolean isGood = false;
        int temp;
        for (int i = 0; i < num.length - 1; i++) {
            if (num[0] % num[1] == 0 && num[0] % num[2] == 0) {
                isGood = true;
                return num[0];
            } // if
            temp = num[0];
            for (int j = 0; j < num.length - 1; j++)    // круговой сдвиг массива на элемент
                num[j] = num[j + 1];
            num[num.length - 1] = temp;
        } // for
        if (!isGood) return -1;
        return 0;
    } // Div3

    private static String[] arr3(String[] arr1, String[] arr2, int countArr) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int res = 0;
        String[] arr3 = new String[countArr * 2];
        while (count3 < countArr * 2) {
            arr3[count3] = arr1[count1];
            count3++;
            count1++;
            arr3[count3] = arr2[count2];
            count3++;
            count2++;
        } // while
        return arr3;
    } //arr3

    private static String quoteWalterWhite() throws IOException {
        String url = "http://www.procitaty.ru/blog/citaty-uoltera-uayta";
        MyClass3 myClass = new MyClass3();
        String page = myClass.downloadWebPage(url);
        final int countQuotes = 15;
        String[] quote = new String[countQuotes];
        int index = 0;
        String str = "";
        int beginIndex = 0;
        int endIndex = 0;
        while (index < countQuotes) {
            beginIndex = page.indexOf("<p>", endIndex) + 3;
            endIndex = page.indexOf("</p>", beginIndex);
            str = page.substring(beginIndex, endIndex);
            if (str.contains("***") || str.contains("цитаты Уолтера Уайта"))
                beginIndex = endIndex;
            else {
                quote[index] = str;
                index++;
            } // else
        } // while
        str = quote[(int) (Math.random() * countQuotes)];
        return str;
    } // quoteWalterWhite

    private static String PhotoDayNasaExplanation(String date) throws IOException {
        MyClass3 myClass = new MyClass3();
        String url1 = "https://apod.nasa.gov/apod/ap";
        String url2 = date + ".html";
        String page = myClass.downloadWebPage(url1 + url2);
        String str = "";
        int beginIndex = page.indexOf("<IMG SRC=\"");
        int endIndex = page.indexOf(".jpg\"", beginIndex);
        beginIndex = page.indexOf("<b>", endIndex) + 3;
        endIndex = page.indexOf("</b>", beginIndex);
        str = page.substring(beginIndex, endIndex);
        return str;
    } // PhotoDayNasaExplanation

    private static void PhotoDayNasaToFile(String date, int count) throws IOException {
        String str = "";
        String url1 = "";
        String url2 = "";
        String page = "";
        str = date.substring(4, 6);
        int dayInt = Integer.parseInt(date.substring(4, 6));
        int monthInt = Integer.parseInt(date.substring(2, 4));
        int yearInt = Integer.parseInt(date.substring(0, 2));
        for (int i = 0; i < count; i++) {
            MyClass3 myClass = new MyClass3();
            url1 = "https://apod.nasa.gov/apod/";
            url2 = "ap" + date + ".html";
            page = myClass.downloadWebPage(url1 + url2);
            if (page.contains("<h1>Not Found</h1>")) {
                i--;
                continue;
            }
            str = "";
            int beginIndex = page.indexOf("<IMG SRC=\"") + 10;
            int endIndex = page.indexOf("\"", beginIndex);
            url2 = page.substring(beginIndex, endIndex);
            myClass.writeImageFromUrl(url1 + url2, "nasa\\photo" + i + ".jpg");
            System.out.print("Writed file " + i + ".  ");
            dayInt++;
            if ((monthInt == 2 && dayInt > 28) || dayInt > 30) {
                dayInt = 1;
                monthInt++;
            } // if
            if (monthInt > 12) {
                monthInt = 1;
                yearInt++;
            } // if
            date = Integer.toString(yearInt) +
                    ((monthInt<10) ? "0" + Integer.toString(monthInt) : Integer.toString(monthInt)) +
                     ((dayInt<10) ? "0" + Integer.toString(dayInt) : Integer.toString(dayInt));
        } // for
    } // PhotoDayNasaToFile

    public static int randomYear() {
        return (int) (Math.random() * (Year.now().getValue() - 1 - 1994) + 1994);
    } // rendomYear

    public static int randomMonth() {
        return (int) (Math.random() * 12 + 1);
    } // randomMonth

    public static int randomDay(int yearInt, int monthInt) {
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
        return (int) (Math.random() * dayIntMax + 1);
    } // randomDay

    public static void main(String[] args) throws IOException {
// 1. Реализуйте метод, который находит из трех чисел то, которое делится на 2 остальных; или возвращает -1, если такого нет
        int countInt = 3;
        int[] num = new int[countInt];
        int res;
        System.out.print("Из чисел ");
        for (int i = 0; i < countInt; i++) {
            num[i] = (int) (Math.random() * 15 + 1);
            System.out.print(num[i] + " ");
        } // for
        res = Div3(num);
        if (res == -1) System.out.println("делимых на остальные два не обнаружено.");
        else System.out.println("найдено число " + res + ", которое делится на остальные.");

// 2. Реализуйте метод, который из двух массивов строк собирает третий, в котором чередуются элементы первых двух
        final int countWordsAtArrays = 5;
        MyClass3 myClass = new MyClass3();
        String[] array1 = new String[countWordsAtArrays];
        array1 = myClass.returnRandomWords(countWordsAtArrays);
        String[] array2 = new String[countWordsAtArrays];
        array2 = myClass.returnRandomWords(countWordsAtArrays);
        String[] array3 = new String[countWordsAtArrays * 2];
        array3 = arr3(array1, array2, countWordsAtArrays);
        System.out.print("Массив 1: ");
        for (int i = 0; i < countWordsAtArrays; i++)
            System.out.print(array1[i] + " ");
        System.out.println();
        System.out.print("Массив 2: ");
        for (int i = 0; i < countWordsAtArrays; i++)
            System.out.print(array2[i] + " ");
        System.out.println();
        System.out.print("Массив 3: ");
        for (int i = 0; i < countWordsAtArrays * 2; i++)
            System.out.print(array3[i] + " ");
        System.out.println();

// 3. Возьмите любую программу, которую вы писали до этого.. какая сердцу ближе. Отрефакторите ее (улучшите читабельность кода) -
// путем разбиения крупных частей на методы поменьше. Стало лучше? (надеюсь, да)
// 4. Отрефакторите (улучшите читабельность) кода вашей реализации анализа курса валют.
// Курс валюты от случаной даты.
        StringBuilder builder8 = new StringBuilder();
        String page = "";
        int beginIndex, endIndex;
        int yearInt = randomYear();
        int monthInt = randomMonth();
        int dayInt = randomDay(yearInt, monthInt);
        String yearString0 = Integer.toString(yearInt);
        String yearString1 = Integer.toString(yearInt + 1);
        String monthString = (monthInt < 10) ? "0" + Integer.toString(monthInt) : Integer.toString(monthInt);
        String dayString = (dayInt < 10) ? "0" + Integer.toString(dayInt) : Integer.toString(dayInt);
        MyClass3 downloadWebPage = new MyClass3();
        builder8.append("https://cbr.ru/scripts/XML_dynamic.asp?date_req1=");
        builder8.append(dayString + "/" + monthString + "/" + yearString0);
        builder8.append("&date_req2=" + dayString + "/" + monthString + "/" + yearString1);
        builder8.append("&VAL_NM_RQ=R01235");
//        System.out.println(builder8);
        String url = builder8.toString();
        page = downloadWebPage.downloadWebPage(url);
        beginIndex = page.lastIndexOf("<Value>");
        endIndex = page.lastIndexOf("</Value>");
        System.out.println("На " + dayString + "." + monthString + "." + yearString1 + " $ = " + page.substring(beginIndex + 7, endIndex) + " руб.");

// 5. Реализуйте метод, который возвращает случайную цитату Уолтера Уайта.
        System.out.println(quoteWalterWhite());

// 6. Реализуйте метод, который выводит explanation сегодняшнего снимка дня NASA.
        Date date = new Date(); // This object contains the current date value
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        System.out.println("Explanation сегодняшнего снимка дня NASA: " + PhotoDayNasaExplanation(formatter.format(date)));

// 7. Реализуйте метод, который возвращает explanation снимка дня NASA, в качестве параметра принимайте LocalDate - дату, на которую нужно брать снимок.
        yearInt = randomYear();
        String yearString = Integer.toString(yearInt).substring(2, 4);
        monthInt = randomMonth();
        monthString = (monthInt < 10) ? "0" + Integer.toString(monthInt) : Integer.toString(monthInt);
        dayInt = randomDay(yearInt, monthInt);
        dayString = (dayInt < 10) ? "0" + Integer.toString(dayInt) : Integer.toString(dayInt);
        System.out.println("Explanation на " + dayString + "." + monthString + "." + yearInt + ": " + PhotoDayNasaExplanation(yearString + monthString + dayString));

// 8. Реализуйте метод, который принимает два LocalDate, и сохраняет все снимки дня NASA в указанный промежуток
// Первый снимок - June 16 1995.
        date = new Date();
        countInt = date.getYear() - 100 + 2000 - 1995; // Промежуток между текущим годом и 1995.
        yearInt = (int) (Math.random() * countInt) + 1995;
        monthInt = randomMonth();
        dayInt = randomDay(yearInt, monthInt);
        yearString = Integer.toString(yearInt).substring(2, 4);
        monthString = (monthInt < 10) ? "0" + Integer.toString(monthInt) : Integer.toString(monthInt);
        dayString = (dayInt < 10) ? "0" + Integer.toString(dayInt) : Integer.toString(dayInt);
        PhotoDayNasaToFile(yearString + monthString + dayString, 10);
    } // main
} // Lesson37
