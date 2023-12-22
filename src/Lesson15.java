import java.util.Arrays;
import java.util.Scanner;

public class Lesson15 {
    private static double MyCalc(double x, char ch, double y) {
        double res = 0;
        switch (ch) {
            case ('+'):
                res = x + y;
                break;
            case ('-'):
                res = x - y;
                break;
            case ('*'):
                res = x * y;
                break;
            case ('/'):
                res = x / y;
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int int1Value = 0; // Определение переменных для корректного закомментирования
        int int2Value = 0; // участков кода с выполненными заданиями
        int int3Value = 0;
        String str1Value = "";
        String str2Value = "";
        String str3Value = "";
        char char1Value = 'o';
        char char2Value = 'o';
        int i = 0;
        double double1Value = 0;

        //1. Пользователь вводит два числа. Возвести второе в степень первого
        System.out.print("1. Введите 2 целых числа через пробел для возведения второго в степень первого: ");
        int1Value = console.nextInt();
        int2Value = console.nextInt();
        System.out.println(int2Value + "^" + int1Value + " = " + (int) Math.pow(int2Value, int1Value));

        //2. Пользователь вводит три числа. Возвести 1 в степень 2, и результат в степень 3.
        //3. Решить предыдущую задачу, но Math.pow можно использовать только на одной строчке вашей программы(хоть и много раз)
        System.out.print("2, 3. Введите 3 целых числа через пробел: ");
        int1Value = console.nextInt();
        int2Value = console.nextInt();
        int3Value = console.nextInt();
        System.out.println("(" + int1Value + "^" + int2Value + ")^" + int3Value + " = " + (long) Math.pow(Math.pow(int1Value, int2Value), int3Value));

        //4. Пользователь вводит, две строки. Найти разницу в длине.
        System.out.print("4. Найти разницу в длине строк. Введите первую строку: ");
        str1Value = console.next();
        System.out.print("Введите вторую строку: ");
        str2Value = console.next();
        System.out.println("Разница в длине строк = " + Math.abs(str2Value.length() - str1Value.length()));

        //5. Пользователь вводит три строки. Найти разницу в длине самой короткой и самой длинной.
        //6. Решить предыдущую задачу, не используя операторы >,< итд.
        System.out.print("5. Найти разницу между самой длинной и самой короткой строкой из трёх.\nВведите первую строку: ");
        str1Value = console.next();
        System.out.print("Введите вторую строку: ");
        str2Value = console.next();
        System.out.print("Введите третью строку: ");
        str3Value = console.next();
        int[] intArray = new int[3];
        intArray[0] = str1Value.length();
        intArray[1] = str2Value.length();
        intArray[2] = str3Value.length();
        int maxLength = 0;
        int minLength = 1000;
        for (i = 0; i < 3; i++) {
            if (intArray[i] > maxLength) maxLength = intArray[i];
            if (intArray[i] < minLength) minLength = intArray[i];
        }
        Arrays.sort(intArray);
        System.out.println("Разница длин между самой длинной и самой короткой строкой = " + Math.abs(maxLength - minLength) + " или (другой метод вычисления) " + (intArray[2] - intArray[0]));

        //7. Сделать калькулятор для трех чисел: пользователь вводит первое, потом оператор, второе, оператор, третье. Посчитать первое на второе, потом результат с третьим. Пример:
        //11 + 4 * 20
        //Вывод: 300
        double resultat = 0.0;
        System.out.println("7. Последовательный калькулятор из трёх чисел. Построчный ввод целых чисел и операндов («+», «-», «/», «*»).");
        System.out.print("Введите первое число: ");
        int1Value = console.nextInt();
        System.out.print("Операнд 1: ");
        char1Value = console.next().charAt(0);
        System.out.print("Введите второе число: ");
        int2Value = console.nextInt();
        System.out.print("Операнд 2: ");
        char2Value = console.next().charAt(0);
        System.out.print("Введите третье число: ");
        int3Value = console.nextInt();
        resultat = MyCalc(int1Value, char1Value, int2Value);
        resultat = MyCalc(resultat, char2Value, int3Value);
        System.out.println("Результат = " + resultat);
        System.out.println("8. Математический калькулятор. \nРезультат: ");
        if ((char2Value == '*' | char2Value == '/') & (char1Value == '+' | char1Value == '-')) {
            resultat = MyCalc(int2Value, char2Value, int3Value);
            resultat = MyCalc(int1Value, char1Value, resultat);
        } else {
            resultat = MyCalc(int1Value, char1Value, int2Value);
            resultat = MyCalc(resultat, char2Value, int3Value);
        }
        System.out.println(resultat);

        //9. Вывести английский алфавит
        System.out.println("9. Английский алфавит.");
        for (i=1; i<27;i++) System.out.print((char) (i+64) + " ");
        System.out.println("");

        //10. Пользователь вводит N. Вывести букву английского алфавита по счету N.
        while(i!=0) {
            System.out.print("10. int --> char. Введите код символа. Выход «0»: ");
            i = console.nextInt();
            System.out.println((char) i);
        }

        //11. Вывести случайную букву английского алфавита.
        int1Value = 92;
        while (int1Value > 91) {
            double1Value = Math.floor(Math.random() * 10 + 65);
            int1Value = (int) double1Value;
            char1Value = (char) int1Value;
            System.out.println("11. Случайная буква английского алфавита: «" + char1Value + "».");
        }

        //12. Вывести случайное число от 11 до 22
        System.out.println("12. Случайное число от 11 до 22.");
        for (i = 1; i < 200; i++) { // Вывод 200 псевдослучайных чисел в заданном диапазоне
            double1Value = Math.random();
            int1Value = (int) Math.floor(double1Value * 22 - 11) + 12;
            System.out.print(int1Value + " ");
            if (i % 50 == 0) System.out.println(""); // Новая строка через 50 значений
        }

    }
}