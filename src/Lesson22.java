import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Lesson22 {
    public static void q1() {
        // 1. Выведите числа от 0 до миллиона
        int count = 1;
        while (count <= 1000000) {
            System.out.println(count);
            count++;
        }
    } // q1

    public static void q2() {
        // 2. Выведите числа от 1.5 до 101.5: 1.5,2,2.5,3,3.5…101.5
        double dvar = 0.0;
        while (dvar <= 101.5) {
            System.out.println(dvar);
            dvar = dvar + 0.5;
        }
    } // q2

    public static void q3() {
        // 3. Выведите латинский алфавит от a до z
        int count;
        char ch = 'a';
        count = (int) ch;
        while (count <= (int) 'z') {
            System.out.print(ch);
            count++;
            ch = (char) count;
        }
        System.out.println();
    } // q3

    public static void q4() {
        // 4. Выведите русский алфавит от а до я
        int count;
        char ch = 'а';
        count = (int) ch;
        while (count <= (int) 'я') {
            System.out.print(ch);
            count++;
            ch = (char) count;
        }
        System.out.println();
    } // q4

    public static void q5() throws IOException {
        // 5. Создайте 10 тысяч файлов (или 10, например)
        int count = 1;
        int countFiles = 10;
        while (count <= countFiles) {
            File file = new File("DeleteMe\\file" + count + ".txt");
            file.createNewFile();
            System.out.println("\\DeleteMe\\file" + count + ".txt is created.");
            count++;
        }
        System.out.println(countFiles + " файлов создано.");
    } // q5

    public static void q67(int q) throws IOException {
        // 6. В файле две строки: секретное слово и подсказка. Вывести подсказку.
        // Считывать строку за строкой, пока игрок не отгадает секретное слово (не введёт его).
        // 7. Предыдущее задание, но если пользователь ввел хотя бы часть слова верно, то писать: горячо.
        // (Проверять с помощью str.contains).

        Scanner console = new Scanner(System.in);
        String fileName = "GameFile.txt";
        String str1, str2, answer;
        File file = new File(fileName);
        byte[] bytes = new byte[(int) file.length()];
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        str1 = reader.readLine();
        str2 = reader.readLine();
        System.out.print("Input world " + str1 + ": ");
        answer = console.nextLine();
        String hot = "";
        while (!answer.equals(str2)) {
            hot = (str2.contains(answer) && q == 1) ? "Hot!!! " : "";
            System.out.print(hot + "It's wrong. Input world " + str1 + ": ");
            answer = console.nextLine();
        }
        System.out.print("It's right! ");
        System.out.println(str2);
    } // q76

    public static void q8() throws IOException {
// 8. Первый игрок сохраняет слово и подсказку в первый файл, второй игрок во второй.
// Игра начинается, выводятся подсказки, игроки по-очереди пытаются отгадать слово противника.
        String gameFile1 = "GameFile1.txt";
        String gameFile2 = "GameFile2.txt";
        Scanner console = new Scanner(System.in);

        // Запись в файл слова и подсказки первого игрока
        System.out.print("1 игрок, введите одной строкой секретное слово и подсказку через пробел, можно несколько слов: ");
        String secret1 = console.next();
        String hint1 = console.nextLine();
        File file1 = new File(gameFile1);
        file1.createNewFile();
        try (FileWriter writer = new FileWriter(gameFile1, false)) {
            writer.write(secret1);
            writer.write(hint1);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // Запись в файл слова и подсказки второго игрока
        System.out.print("2 игрок, введите одной строкой секретное слово и подсказку через пробел, можно несколько слов: ");
        String secret2 = console.next();
        String hint2 = console.nextLine();
        File file2 = new File(gameFile2);
        file2.createNewFile();
        try (FileWriter writer = new FileWriter(gameFile2, false)) {
            writer.write(secret2);
            writer.write(hint2);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // Читаем переменные из файлов
        String newSecret1 = null;
        String newHint1 = null;
        try (FileReader reader = new FileReader(gameFile1)) {
            int c;
            newSecret1 = "";
            while ((c = reader.read()) != -1) newSecret1 = newSecret1 + (char) c;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        newHint1 = newSecret1.substring(newSecret1.indexOf(" ") + 1, newSecret1.length());
        newSecret1 = newSecret1.substring(0, newSecret1.indexOf(" "));
        String newSecret2 = null;
        String newHint2 = null;
        try (FileReader reader = new FileReader(gameFile2)) {
            int c;
            newSecret2 = "";
            while ((c = reader.read()) != -1) newSecret2 = newSecret2 + (char) c;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        newHint2 = newSecret2.substring(newSecret2.indexOf(" ") + 1, newSecret2.length());
        newSecret2 = newSecret2.substring(0, newSecret2.indexOf(" "));

        // Собственно игра, повторение и модификация пункта 7.
        System.out.println("Начинаем игру. Игроки по очереди вводят загаданные слова.");
        boolean gamer1True = false;
        boolean gamer2True = false;
        String gamer1Answer = "";
        String gamer2Answer = "";
        while (!gamer1True && !gamer2True) {
            System.out.print("Игрок 1, Ваш ход. Подсказка – «" + newHint1 + "»: ");
            gamer1Answer = console.next();
            gamer1True = gamer1Answer.equals(newSecret1);
            System.out.print("Игрок 2, Ваш ход. Подсказка – «" + newHint2 + "»: ");
            gamer2Answer = console.next();
            gamer2True = gamer2Answer.equals(newSecret2);
            if (!gamer1True && !gamer2True) System.out.println("Никто не угадал. Попробуйте ещё раз.\n");
        }
        if (gamer1True && !gamer2True) System.out.println("Победил игрок 1. Слово «" + newSecret1 + "».");
        else if (gamer2True && !gamer1True) System.out.println("Победил игрок 2. Слово «" + newSecret2 + "».");
        else if (gamer1True && gamer2True)
            System.out.println("Ничья! Угаданы слова «" + newSecret1 + "» и «" + newSecret2 + "».");
    } // q8

    public static void q9() {
        // 9. Пока пользователь не введёт строку, содержащую пробел, считывайте строки и выводите их первые буквы
        Scanner console = new Scanner(System.in);
        String str = "";
        System.out.println("Вводите строки. Окончание - содержание пробела в строке. Вывод первого символа.");
        while (!str.contains(" ")) {
            str = console.nextLine();
            System.out.println(str.substring(0, 1));
        }
    } // q9

    public static void q10() {
        // 10. Пользователь вводит полный путь и название файла. Пока пользователь не ввел путь к существующему файлу, повторять ввод.
        // Проверить, что файл существует, можно так: File f = new File(); boolean isExists = f.exists();
        String fileName;
        System.out.print("Введите имя файла: ");
        Scanner console = new Scanner(System.in);
        fileName = console.nextLine();
        File f = new File(fileName);
        String existFile = (f.exists()) ? "Есть такой файл!" : "Нет такого файла!";
        System.out.println(existFile);
    } // q10

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

    public static void q11() throws IOException {
        // 11. Сохраните снимки NASA за январь 2022 года. Тема 1 Урок 9.
        // т.к. сайт NASA недоступен, будет использовано API с собаками https://dog.ceo/api/breeds/image/random
        String webAddr = "https://dog.ceo/api/breeds/image/random";
        String fileName;
        String page, urlImage;
        for (int i=1; i<11; i++) {
            page = downloadWebPage(webAddr);
            urlImage = page.substring(page.indexOf("https"), page.indexOf(".jpg") + 4);
            urlImage = urlImage.replace("\\", "");      // Удаляем лишние \
            fileName = "Images\\" + urlImage.substring(urlImage.lastIndexOf("/") + 1, urlImage.length());
            try (InputStream in = new URL(urlImage).openStream()) {
                Files.copy(in, Paths.get(fileName));
            }
        }
        System.out.println("10 файлов записаны.");
    } // q11

    public static void main(String[] args) throws IOException {
        int menu = -1;
        Scanner console = new Scanner(System.in);
        while (menu != 0) {
            System.out.println("\n1. Вывод чисел от 0 до миллиона.\n" +
                    "2. Выведите числа от 1.5 до 101.5: 1.5,2,2.5,3,3.5…101.5.\n" +
                    "3. Вывод латинского алфавита от a до z.\n" +
                    "4. Вывод русского алфавита от а до я.\n" +
                    "5. Создани 10 тысяч файлов.\n" +
                    "6. Отгадать слово по подсказке (англ., прописные).\n" +
                    "7. То же самое, но с подсказкой, если часть слова совпадает.\n" +
                    "8. 2 игрока загадывают слова с подсказкой.\n" +
                    "9. Ввод строк, пока не встретится пробел.\n" +
                    "10. Проверка наличия файла по введённому имени.\n" +
                    "11. Сохранение 10 случайных снимков с собаками.");
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
                    q67(0);
                    break;
                case 7:
                    q67(1);
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
} // class Lesson2
