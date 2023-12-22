import java.util.Scanner;

public class Lesson27 {
    static String glasLetters = "аеёиоуыэюя";
    static String soglasLetters = "бвгджзйклмнпрстфхцчшщъь";

    public static void q1() {
        // 1. Пользователь вводит пять строк. Выведите слово, состоящие из первой буквы каждый строки
        Scanner console = new Scanner(System.in);
        String[] str = new String[5];
        System.out.println("Введите 5 строк:");
        String word = "";
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + ". ");
            str[i] = console.nextLine();
            word = word + str[i].charAt(0);
        }
        System.out.println(word);
    } // q1

    public static void q2() {
        // 2. Посчитайте количество нулей в числе
        Scanner console = new Scanner(System.in);
        String str;
        int countZero = 0;
        System.out.print("Введите число, содержащее нули: ");
        str = console.nextLine();
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == '0')
                countZero++;
        System.out.println("Количество нулей в числе = " + countZero);
    } // q2

    public static void q3() {
        // 3. Найдите первую гласную букву в слове
        Scanner console = new Scanner(System.in);
        System.out.println("Введите слово: ");
        String word = console.nextLine();
        boolean glasn = false;
        char ch;
        int count = 0;
        while (!glasn && count < word.length()) {
            ch = word.charAt(count);
            if (glasLetters.contains("" + ch))
                glasn = true;
            count++;
        } // while
        if (!glasn) System.out.println("В слове нет гласных.");
        else System.out.println("Первая гласная – " + word.charAt(count - 1) + ".");
    } //q3

    public static void q4() {
        // 4. Посчитайте количество согласных букв в слове
        Scanner console = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String word = console.nextLine();
        int count = 0;
        char ch;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (soglasLetters.contains("" + ch))
                count++;
        }
        System.out.println("Количество согласных: " + count);
    } // q4

    public static void q5() {
        // 5. Выведите слово наоборот, при этом столбиком
        Scanner console = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String word = console.nextLine();
        for (int i = word.length(); i > 0; i--) {
            System.out.println(word.charAt(i - 1));
        }
    } //q5

    public static void q6() {
        // 6. Замените все гласные в слове на ‘у’
        Scanner console = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String word = console.nextLine();
        String newWord = "";
        char ch;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (glasLetters.contains("" + ch))
                newWord = newWord + "у";
            else newWord = newWord + ch;
        }
        System.out.println(newWord);
    } // q6

    public static void q7() {
        // 7. Пользователь вводит дробное число, выведите его дробную часть
        Scanner console = new Scanner(System.in);
        System.out.print("Введите дробное число: ");
        String word = console.nextLine();
        boolean point = false;
        char ch;
        String newWord = "";
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (ch == '.' || ch == ',')
                point = true;
            newWord = (point) ? (newWord + ch) : newWord;
        }
        System.out.println(newWord.substring(1));
    } // q7

    public static void q8() {
        // 8. Пользователь вводит предложение. Замените в каждом слове этого предложения, последн** д** бук** на **
        Scanner console = new Scanner(System.in);
        System.out.print("Введите предложение: ");
        String words = console.nextLine();
        String[] parts= words.split (" ");
        int length;
        for (int j = 0; j < parts.length; j++) {
            length = parts[j].length();
            parts[j] = parts[j].substring(0,length-1) + "**";
            System.out.print(parts[j] + " ");
        }
        System.out.println();
    } // q8

    public static void main(String[] args) {
        int menu = -1;
        Scanner console = new Scanner(System.in);
        while (menu != 0) {
            System.out.println("\n1. Ввод строк, вывод первых букв строк." +
                    "\n2. Подсчёт количества нулей в числе." +
                    "\n3. Нахождение первой гласной в слове." +
                    "\n4. Подсчёт количества согласных в слове." +
                    "\n5. Вывод слова наоборот столбиком." +
                    "\n6. Замена всех гласных в слове на «у»." +
                    "\n7. Вывод дробной части числа." +
                    "\n8. Замена последних букв слов на **.");
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
            } // case menu
        } // while menu !=0

    }
}
