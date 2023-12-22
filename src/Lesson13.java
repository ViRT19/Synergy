import java.util.Scanner;

public class Lesson13 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int count = 0;

        System.out.println("1. Где хранятся переменные? Сколько переменных можно задать в программе? Чем ограничен размер?");
        double freeMemory = 31.9 * 1024 * 1024 * 1024 / 100 * 80; // Free memory at bytes. 20 % is occupation.
        System.out.println("Переменных типа Integer в свободной памяти теоретически может поместиться " + (freeMemory / 4) + " штук.");

        System.out.print("2. Длина введённой строки. Введите строку: ");
        String str1 = console.next();
        System.out.println("Длина введённой строки = " + str1.length());

        // 3. Пользователь вводит две строки, выведите сумму их длин
        System.out.print("3. Вычисление суммы длин двух строк.\nВведите первую строку: ");
        str1 = console.next();
        System.out.print("Введите вторую строку: ");
        String str2 = console.next();
        System.out.println("Сумма длин введённых строк = " + (str1.length() + str2.length()) + ".");

        // 4. Пользователь вводит три строки. Найти, какая из них короче всех.
        System.out.print("4. Поиск самой короткой строки из трёх введённых. Введите первую строку: ");
        str1 = console.next();
        System.out.print("Введите вторую строку: ");
        str2 = console.next();
        System.out.print("Введите третью строку: ");
        String str3 = console.next();
        System.out.print("Самая короткая строка из введённых: «");
        if ((str1.length() < str2.length()) & (str1.length() < str3.length()))
            System.out.print(str1);
        else if ((str2.length() < str1.length() & (str2.length() < str3.length())))
            System.out.print(str2);
        else System.out.print(str3);
        System.out.println("».");

        // 5. Пользователь вводит три дробных числа. Вывести те из них, квадратный корень которых меньше 2.
        float[] f = new float[4];
        System.out.print("5. Вычисление квадратного корня меньше 2 из трёх введённых чисел.\nВведите первое число: ");
        f[1] = console.nextFloat();
        System.out.print("Введите второе число: ");
        f[2] = console.nextFloat();
        System.out.print("Введите третье число: ");
        f[3] = console.nextFloat();
        for (int i = 1; i < 4; i++)
            if (Math.sqrt(f[i]) < 2)
                System.out.println("Введено " + f[i] + ". Квадратный корень = " + Math.sqrt(f[i]));

        // 6. Пройдите в дебаге программу:
        // int x = 1;
        // while (x>=-3) {
        // System.out.print(x);
        // x = x - 1;
        // }
        // Сколько раз выводится икс?
        System.out.println("6. Прохождение через debugger – 1.");
        int x = 1;
        while (x >= -3) {
            System.out.println(x);
            x = x - 1;
            count++;
        }
        System.out.println("x выводится " + count + " раз.");

        // 7. Пройдите в дебаге программу:
        // String str = “Hell”;
        // while (str.length()<10) {
        // str = str + “o”;
        // } Сколько раз вызывается метод str.length() ?
        System.out.println("7. Прохождение через debugger – 2.");
        count = 0;
        String sstr = "Hell";
        while (sstr.length() < 10) {
            sstr = sstr + "o";
            count++;
        }
        System.out.println("Метод str.length() используется " + count + " раз. " + sstr);

        // 8. Пользователь вводит два числа. Разделить меньшее на большее и вывести результат.
        System.out.print("8. Вычисление результата деления мéньшего введённого числа на бóльшее.\nВведите первое число: ");
        float i1 = console.nextFloat();
        System.out.print("Введите второе число: ");
        float i2 = console.nextFloat();
        if (i1 < i2) System.out.println(i1 + " делим на " + i2 + ". Результат = " + i1 / i2);
        else System.out.println(i2 + " делим на " + i1 + ". Результат = " + i2 / i1);

        // 9. Пользователь вводит строку. Используя substring, вывести первые 5 символов.
        count = 5;
        String str5 = "";
        while (count > str5.length()) {
            System.out.print("9. Вывод первых пяти символов введённой строки: ");
            str5 = console.next();
        }
        System.out.println(str5.substring(0, 5));

        // 10. Считайте boolean-переменную. Если пользователь ввел true, вывести “истина”, иначе ничего не стоит выводить.
        System.out.print("10. Введите «true» или «false»: ");
        Boolean inputBoolean = console.nextBoolean();
        if (inputBoolean) System.out.println("истина");

        // 11. Пользователь вводит 3 числа. Сделайте три boolean переменных: есть ли среди введённых четное, есть ли среди введённых отрицательное, есть ли число больше тысячи
        System.out.print("11. Работа с boolean и тремя целыми числами.\nВведите первое: ");
        float[] boolFloat = new float[3];
        boolean[] boolBoolean = new boolean[9];
        boolFloat[0] = console.nextFloat();
        System.out.print("Введите второе число: ");
        boolFloat[1] = console.nextFloat();
        System.out.print("Введите третье число: ");
        boolFloat[2] = console.nextFloat();
        for (count = 0; count < 3; count++) {
            boolBoolean[count] = (boolFloat[count] % 2) == 0;
            boolBoolean[count + 3] = boolFloat[count] < 0;
            boolBoolean[count + 6] = boolFloat[count] > 1000;
        }
        if (boolBoolean[0] | boolBoolean[1] | boolBoolean[2])
            System.out.println("Среди введённых есть чётное число.");
        if (boolBoolean[3] | boolBoolean[4] | boolBoolean[5])
            System.out.println("Среди введённых чисел есть отрицательное.");
        if (boolBoolean[6] | boolBoolean[7] | boolBoolean[8])
            System.out.println("Среди введённых есть число более 1000.");

        // 12. Пользователь вводит три строки, используя .substring(0, x) выведите эти строки, обрезав те, что длиннее самой короткой. Пример ввода: «повар», «поделка», «лампочка».
        // Вывод: «повар», «подел», «лампо».
        String[] stroka = new String[3];
        System.out.println("12. Ввести три строки, обрезать их по длине самой короткой.");
        System.out.print("Введите первую строку: ");
        stroka[0] = console.next();
        System.out.print("Введите вторую строку: ");
        stroka[1] = console.next();
        System.out.print("Введите третью строку: ");
        stroka[2] = console.next();
        int countMinSymbols = 32767;
        for (count = 0; count < 3; count++)
            if (stroka[count].length() < countMinSymbols)
                countMinSymbols = stroka[count].length();
        for (count = 0; count < 3; count++)
            System.out.println(stroka[count].substring(0, countMinSymbols));

        // 13. Мини-игра в слова. Первый игрок вводит слово. Потом второй игрок вводит два числа,
        // с какого по какой символ можно найти слово внутри исходного, используя substring.
        // Потом первый игрок вводит два числа. Побеждает тот, чье слово длиннее. Пример:
        //1: революционный
        //2: 0 3 (вывод: рев)
        //1: 7 13 (вывод: ионный)
        //Победил игрок 1
        System.out.println("13. Игра «Чьё слово длиннее».");
        System.out.print("Введите слово, содержащее несколько слов: ");
        String slovo = console.next();
        int igrok1_1 = 100;
        int igrok1_2 = 100;
        while (igrok1_1 > slovo.length() | igrok1_2 > slovo.length() | igrok1_2 <= igrok1_1) {
            System.out.print("Первый игрок. Введите два числа через «пробел», соответствующие начальной (первый символ = 1) и конечной букве: ");
            igrok1_1 = console.nextInt();
            igrok1_2 = console.nextInt();
        }
        int igrok2_1 = 100;
        int igrok2_2 = 100;
        while (igrok2_1 > slovo.length() | igrok2_2 > slovo.length() | igrok2_2 <= igrok2_1) {
            System.out.print("Второй игрок. Введите два числа через «пробел», соответствующие начальной (первый символ = 1) и конечной букве: ");
            igrok2_1 = console.nextInt();
            igrok2_2 = console.nextInt();
        }
        String slovo1 = (slovo.substring(igrok1_1 - 1, igrok1_2));
        String slovo2 = (slovo.substring(igrok2_1 - 1, igrok2_2));
        int slovoLength1 = slovo1.length();
        int slovoLength2 = slovo2.length();
        if (slovoLength1 > slovoLength2) System.out.println("Первый игрок победил.");
        else if (slovoLength1 < slovoLength2) System.out.println("Второй игрок победил.");
        else if (slovoLength1 == slovoLength2) System.out.println("Ничья.");
    }
}