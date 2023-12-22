import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.time.Year;
import java.util.Scanner;

public class Lesson23 {

    public static void q1() {
        for (int i = 2; i <= 10; i++) {
            for (int j = 10; j >= 4; j--) {
                System.out.println(Math.pow(i, j));
            }
        }
    } // q1

    public static void q2() throws IOException {
        int count = 1;
        int countFiles = 10;
        while (count <= countFiles) {
            File file = new File("DeleteMe\\file" + count + ".txt");
            file.createNewFile();
            count++;
        }
        System.out.println(countFiles + " файлов создано.");
    } // q2

    public static void q3() {
        // 3. Выведите буквы от а до я (подсказка: for (char letter=’а’; letter<=’я’; letter++) )
        int count;
        char ch = 'а';
        count = (int) ch;
        while (count <= (int) 'я') {
            System.out.print(ch + " ");
            count++;
            ch = (char) count;
        }
        System.out.println();
    }  // q3

    public static void q4() {
        // 4. выведите десять букв в алфавите после буквы й
        int i = (int) 'й';
        for (int count = 1; count < 11; count++)
            System.out.print((char) (i + count) + " ");
    } // q4

    public static void q5() {
        // 5. выведите десять букв в алфавите, идущие до буквы ю
        int i = (int) 'ю';
        for (int count = 1; count < 11; count++)
            System.out.print((char) (i + count - 11) + " ");
    } // q5

    public static void q6() {
        // 6. выведите каждую вторую букву алфавита (а, в, д)
        int i = (int) 'а';
        for (int count = 0; count < 32; count++)
            if (count % 2 == 0)
                System.out.print((char) (i + count) + " ");
    } // q6

    public static void q7() {
        // 7. выведите каждую третью букву латинского алфавита
        int i = (int) 'а';
        for (int count = 0; count < 32; count++)
            if (count % 3 == 0)
                System.out.print((char) (i + count) + " ");
    } // q7

    public static void q8() {
        // 8. выведите греческий алфавит (коды с 945 по 969) через запятую (α, β, …)
        for (int i = 945; i < 970; i++)
            if (i != 969) System.out.print((char) i + ", ");
            else System.out.println((char) i + ".");
    } // q8

    public static void q9() throws IOException {
        // 9. Выведите в файл list.html список :
        //<ul>
        //<li> 1 element </li>
        //<li> 2 element </li>
        //…
        //<li> 100 element </li>
        //</ul>
        String fileName = "list.html";
        File myFile = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(myFile);
        outputStream.write("<ul>".getBytes());
        for (int i = 1; i < 101; i++)
            outputStream.write(("<li> " + i + " element </li>").getBytes());
        outputStream.write("</ul>".getBytes());
        outputStream.close();
    } // q9

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

    public static void q10() throws IOException {
        // 10. Выведите курс валют за 1 число каждого месяца в 2014 году
//        String url = "https://cbr.ru/scripts/XML_dynamic.asp?date_req1=01/01/2014&date_req2=01/12/2014&VAL_NM_RQ=R01235";
        String monthStr = "";
        String url = "";
        String year0 = "2013";
        String year = "2014";
        String page = "";
        String[] month = new String[]{"января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа", "сентября", "октября", "ноября", "декабря"};
        int beginIndex, endIndex;
        for (int monthInt = 1; monthInt < 13; monthInt++) {
            monthStr = (monthInt < 10) ? "0" + String.valueOf(monthInt) : "" + String.valueOf(monthInt);
            url = "https://cbr.ru/scripts/XML_dynamic.asp?date_req1=01/" + monthStr + "/" + year0 + "&date_req2=01/" + monthStr + "/" + year + "&VAL_NM_RQ=R01235";
            page = downloadWebPage(url);
            beginIndex = page.lastIndexOf("<Value>");
            endIndex = page.lastIndexOf("</Value>");
            System.out.println("На 1 " + month[monthInt - 1] + " " + year + " года $ = " + page.substring(beginIndex + 7, endIndex) + " руб.");
        }
    } // q10

    public static void q11() throws IOException {
        // 11. Выведите курс валют за 1 февраля каждого года с 1994 до текущего года
        int beginIndex, endIndex;
        int currentYear = Year.now().getValue();
        String url = "";
        String page = "";
        int year0;
        for (int year = 1994; year <= currentYear; year++) {
            year0 = year - 1;
            url = "https://cbr.ru/scripts/XML_dynamic.asp?date_req1=01/02/" + year0 + "&date_req2=01/02/" + year + "&VAL_NM_RQ=R01235";
            page = downloadWebPage(url);
            beginIndex = page.lastIndexOf("<Value>");
            endIndex = page.lastIndexOf("</Value>");
            System.out.println("На 1 февраля " + year + " года $ = " + page.substring(beginIndex + 7, endIndex) + " руб.");
        }
    } // q11

    public static void main(String[] args) throws IOException {
        int menu = -1;
        Scanner console = new Scanner(System.in);
        while (menu != 0) {
            System.out.println("\n1. Вывод чисел от двух в десятой степени до десяти в четвертой степени.\n" +
                    "2. Сохранение миллиона файлов в папку DeleteMe (После 990 тыс. начались проблемы с буферизацией отображения, но все файлы появилмсь. Оставил 10 файлов).\n" +
                    "3. Вывод букв от а до я.\n" +
                    "4. Вывод 10 букв после й.\n" +
                    "5. Вывод 10 букв до ю.\n" +
                    "6. Вывод каждй второй буквы алфавита (а, в, д).\n" +
                    "7. Вывод каждой третьей буквы алфавита.\n" +
                    "8. Вывод греческого алфавита.\n" +
                    "9. Создание html-списка в файле.\n" +
                    "10. Курс валют за 1 число каждого месяца в 2014 году.\n" +
                    "11. Курс валют за 1 февраля с 1994 года по текущий.");
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
                case 8:
                    q8();
                    break;
                case 9:
                    q9();
                    break;
                case 10:
                    q10();
                    break;
                case 11:
                    q11();
                    break;
            } // case menu
        } // while menu !=0

    } // main
} // Lesson3