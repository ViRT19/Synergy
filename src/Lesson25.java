import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Lesson25 {

    public static void q13() {
        // 1. Пользователь вводит 10 чисел, сохраните их в массив
        //2. Сохраните 10 чисел в массив, выведите их с конца
        //3. Сохраните 10 строк в массив, выведите с конца каждую вторую
        System.out.print("Введите 10 чисел через пробел: ");
        Scanner console = new Scanner(System.in);
        int[] intArray = new int[10];
        for (int i = 0; i < 10; i++) intArray[i] = console.nextInt();
        System.out.print("Массив с конца: ");
        for (int i = 9; i >= 0; i--) System.out.print(intArray[i] + " ");
        System.out.print("\nМассив с конца через 1: ");
        for (int i = 9; i >= 0; i--) if (i % 2 == 0) System.out.print(intArray[i] + " ");
        System.out.println();
    } // q13

    public static void q4() throws IOException {
        // 4. В файле 10 дробных чисел. Считайте в массив, выведите те, что больше числа пи.
        // Сначала создаём файл с 10 дробными числами
        String fileName = "Pi.txt";
        double number;
        String str = "";
        File myFile = new File(fileName);
        FileOutputStream outputStream = new FileOutputStream(myFile);
        for (int i = 1; i < 11; i++) {
            number = Math.random() * 10;
            str = (i < 11) ? String.valueOf(number) + "\n" : String.valueOf(number);
            outputStream.write(str.getBytes());
        }
        outputStream.close();

        // Читаем файл в массив
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        double[] num = new double[10];
        for (int i = 0; i < 10; i++) {
            num[i] = Double.parseDouble(bf.readLine());
            if (num[i] > Math.PI)
                System.out.println(num[i]);
        }
    } //q4

    public static void q5() {
        // 5. Пользователь вводит буквы. Пока не введёт букву ‘ю’, сохраняйте буквы в массив char (пусть в нем будет 100 элементов максимум).
        // Потом создайте новый массив char размером столько, сколько букв ввел пользователь. Скопируйте в него буквы из первого массива
        Scanner console = new Scanner(System.in);
        System.out.print("Введите строку символов. После «ю» все игнорируются: ");
        char[] ch = new char[100];
        char chr;
        int lenStr;
        String str = console.nextLine();
        for (lenStr = 0; lenStr < str.length(); lenStr++) {
            chr = str.charAt(lenStr);
            if (chr != 'ю') ch[lenStr] = chr;
            else break;
        }
        char[] newCh = new char[lenStr];
        System.out.println("Вывод нового массива:");
        for (int i = 0; i < lenStr; i++) {
            newCh[i] = ch[i];
            System.out.print(newCh[i]);
        }
    } // q5

    public static void q6() throws IOException {
        // 6. Есть 2 файла по 5 строк в каждом. Сохраните их в 2 массива. Создайте третий массив из 10 строк, скопируйте в него строки из первых двух массивов.
        String fileName1 = "File1.txt";
        String fileName2 = "File2.txt";
        String[] arr1 = new String[5];
        String[] arr2 = new String[5];
        String[] arr3 = new String[10];
        BufferedReader bf = new BufferedReader(new FileReader(fileName1));
        for (int i = 0; i < 5; i++) {
            arr1[i] = bf.readLine();
            arr3[i] = arr1[i];
        }
        BufferedReader bf2 = new BufferedReader(new FileReader(fileName2));
        for (int i = 0; i < 5; i++) {
            arr2[i] = bf2.readLine();
            arr3[i + 5] = arr2[i];
        }
        System.out.println("Новый массив из 10 элементов:");
        for (int i = 0; i < 10; i++) System.out.println(arr3[i]);
    } // q6

    public static void q7() {
        // 7. Поле чудес. Игрок один пишет слово. Выводится: ##### (по количеству букв). Игрок два пытается угадать буквы. Если угадал, буква открывается: #а#а#, ба#а#, … банан.
        Scanner console = new Scanner(System.in);
        System.out.print("Первый игрок вводит слово: ");
        String word = console.next();
        System.out.println("\n\n\n\n\n\n\n\n");
        int lengthOfWord = word.length();
        char[] ch = new char[lengthOfWord];
        for (int i = 0; i < lengthOfWord; i++) ch[i] = '#';
        char letter;
        boolean good = true;
        do {
            for (int i = 0; i < lengthOfWord; i++) System.out.print(ch[i]);
            System.out.print("\nВторой игрок вводит букву: ");
            String str = console.next();
            letter = str.charAt(0);
            for (int i = 0; i < lengthOfWord; i++) {
                if (letter == word.charAt(i))
                    ch[i] = letter;
            }
            good = true;
            for (int i = 0; i < lengthOfWord; i++) {
                if (ch[i] == '#') {
                    good = false;       // все буквы отгаданы
                }
            }
        }
        while (!good);
        System.out.println("Слово отгадано: " + word);
    } // q7

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

    public static void q8() throws IOException {
        // 8. Поле чудес с соревнованием. Генерируете 1000 случайных слов на сайте-генераторе
        // (пример: https://sanstv.ru/randomWord, но в поисковике есть много подобных).
        // Сохраняете их в файл. Из файла считываете случайное, и выводите ####… игроки по очереди отгадывают букву.
        // Гласная - 1 балл, согласная - 2 балла, если буква встречается несколько раз - больше.
        // Можно угадать слово целиком - за каждую угаданную букву тогда начислять баллы (гласные 1, согласные 2). Если не угадал - минус 3 балла.
        int countWords = 100;
        int count = 10;
        int beginIndex, endIndex;
        int position;
        Scanner console = new Scanner(System.in);
        String page;
        String glasLetters = "аеёиоуыэюя";
        String soglasLetters = "бвгджзйклмнпрстфхцчшщъь";
        String url = "https://sanstv.ru/randomWord";
        String fileName = "FieldOfMiracles.txt";
        File myFile = new File(fileName);
        String[] words = new String[countWords];
        FileOutputStream outputStream = new FileOutputStream(myFile);

        for (int j = 0; j < count; j++) {      // 10 раз по 100 слов
            page = downloadWebPage(url);
            position = 0;
            for (int i = 0; i < countWords; i++) {
                beginIndex = page.indexOf("' target='_blank '>", position) + 19;
                endIndex = page.indexOf("</a></li>", position);
                position = endIndex + 40;
                words[i] = page.substring(beginIndex, endIndex);
                outputStream.write((words[i] + "\n").getBytes());
            }
        }
        outputStream.close();
        System.out.println("\n1000 слов записано в файл " + fileName + ".");

        String[] wordFromFile = new String[countWords * count];
        File file = new File(fileName);
        Scanner scanFile = new Scanner(file);
        int f = 0;
        while (scanFile.hasNextLine()) {
            wordFromFile[f] = scanFile.nextLine();
            f++;
        }
        int random = (int) (Math.random() * 1000);
        String word = wordFromFile[random];
        System.out.println("Выбрано слово № " + random + " (" + word + ").");
        int gamer1 = 0;
        int gamer2 = 0;
        char gameCh;
        String str;

// Начинаем игру.
        char[] ch = new char[word.length()];
        for (int i = 0; i < word.length(); i++)
            ch[i] = '#';
        boolean good;
        boolean netTakoyBukvy;
        int nomerIgroka = 0;
        int counter = 0;
        do {
            good = true;
            counter++;
            nomerIgroka = ((counter % 2) == 0) ? 2 : 1;
            netTakoyBukvy = true;
            System.out.println("\nИгрок 1: " + gamer1 + " Игрок 2: " + gamer2 + ".");
            System.out.print("Игрок " + nomerIgroka + ", Ваша буква: ");
            str = console.next();
            gameCh = str.charAt(0);
            for (int i = 0; i < word.length(); i++) {
                if (gameCh == word.charAt(i)) {
                    netTakoyBukvy = false;
                    ch[i] = gameCh;
                    if (nomerIgroka == 1) {
                        if (glasLetters.indexOf(gameCh) > 0)
                            gamer1++;
                        if (soglasLetters.indexOf(gameCh) > 0)
                            gamer1 = gamer1 + 2;
                    } else if (nomerIgroka == 2) {
                        if (glasLetters.indexOf(gameCh) > 0)
                            gamer2++;
                        if (soglasLetters.indexOf(gameCh) > 0)
                            gamer2 = gamer2 + 2;
                    }
                } // if
            } // for
            for (int i = 0; i < word.length(); i++) {
                System.out.print(ch[i]);
                if (ch[i] == '#')
                    good = false;
            } // for
            if (netTakoyBukvy && nomerIgroka == 1)
                gamer1 = gamer1 - 3;
            if (netTakoyBukvy && nomerIgroka == 2)
                gamer2 = gamer2 - 3;
        } while (!good);
        if (gamer1 > gamer2)
            System.out.println("\nВыиграл игрок 1 со счётом " + gamer1 + ":" + gamer2);
        else if (gamer2 > gamer1)
            System.out.println("\nВыиграл игрок 2 со счётом " + gamer2 + ":" + gamer1);
        else if (gamer2 == gamer1)
            System.out.println("\nНичья! " + gamer1 + ":" + gamer2);
    } //q8

    public static void main(String[] args) throws IOException {
        int menu = -1;
        Scanner console = new Scanner(System.in);
        while (menu != 0) {
            System.out.println("\n1-3. Ввод чисел в массив.\n" +
                    "4. Вывод чисел больше Пи.\n" +
                    "5. Работа с массивом char.\n" +
                    "6. Работа с массивами String из файла.\n" +
                    "7. Поле чудес. Один загадывает, второй отгадывает.\n" +
                    "8. Поле чудес с генератором слов.");
            System.out.print("Выбор задания (выход - 0): ");
            menu = console.nextInt();
            switch (menu) {
                case 0:
                    break;
                case 1:
                    q13();
                    break;
                case 2:
                    q13();
                    break;
                case 3:
                    q13();
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
            } // case menu
        } // while menu !=0
    } // main
} // Lesson5
