import java.util.Scanner;

public class Lesson32 {

    public static void q1() {
// 1. Напишите метод, который возвращает наиболее из двух целых чисел
        System.out.print("Введите 2 целых числа: ");
        Scanner con = new Scanner(System.in);
        int x = con.nextInt();
        int y = con.nextInt();
        System.out.print("Наибольшее число ");
        if (x > y) System.out.println(x);
        else System.out.println(y);
    } //q1

    public static void q2() {
// 2. Напишите метод, который возвращает наиболее из двух дробных чисел
        System.out.print("Введите 2 дробных числа: ");
        Scanner con = new Scanner(System.in);
        String x1 = con.next();
        String y1 = con.nextLine();
        float x2 = Float.valueOf(x1);
        float y2 = Float.valueOf(y1);
        System.out.print("Наибольшее число ");
        if (x2 > y2) System.out.println(x2);
        else System.out.println(y2);
    } // q2

    public static void q35(int x) {
// 3. Напишите метод, который возвращает самую длинную из X строк
        String strok = (x == 2 || x == 3 || x == 4) ? " строки:" : " строк:";
        System.out.println("Введите " + x + strok);
        String[] str = new String[x];
        Scanner con = new Scanner(System.in);
        for (int i = 0; i < x; i++)
            str[i] = con.nextLine();
        int maxLength = 0;
        int maxIndex = 0;
        for (int i = 0; i < x; i++) {
            if (str[i].length() > maxLength) {
                maxLength = str[i].length();
                maxIndex = i;
            }
        } //for
        System.out.println(str[maxIndex]);
    } // q35

    public static void q6() {
// 6. Напишите метод, который возвращает входящую строку, делая ее ЗаБоРчИкОм
        System.out.println("Введите строку: ");
        Scanner con = new Scanner(System.in);
        String str = con.nextLine();
        int length = str.length();
        char[] ch = new char[length];
        for (int i = 0; i < length; i++) {
            ch[i] = (i % 2 == 0) ? str.toUpperCase().charAt(i) : str.toLowerCase().charAt(i);
            System.out.print(ch[i]);
        } // for
    } //q6

    public static int maxArrayElement(int[] arr) {
        int max = -2147483647;
        for (int i = 0; i < arr.length; i++)
            if (max < arr[i]) max = arr[i];
        return max;
    } // maxArrayElement

    public static void q7() {
// 7. Напишите метод, который возвращает наибольший элемент массива
        int count = 100;
        int[] intArray = new int[count];
        String[] strArray = new String[count];
        Scanner con = new Scanner(System.in);
        System.out.print("Введите целые числа через пробел: ");
        String str = con.nextLine();
        strArray = str.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        System.out.println("Максимальное число из введённых = " + maxArrayElement(intArray));
    } //q7

    public static void q8() {
// 8. Напишите метод, который принимает три массива, а возвращает массив, сумма элементов которого самая большая
        System.out.println("Введите три строки целых чисел через пробел.");
        final int lengthOfArray = 3;
        String[] arrayString = new String[lengthOfArray];
        Scanner con = new Scanner(System.in);
        for (int i = 0; i < lengthOfArray; i++) {
            System.out.print((i + 1) + ": ");
            arrayString[i] = con.nextLine();
        } // for
        String[] words0 = arrayString[0].split(" ");
        String[] words1 = arrayString[1].split(" ");
        String[] words2 = arrayString[2].split(" ");
        int arrInt0[] = new int[words0.length];
        for (int i = 0; i < arrInt0.length; i++) {
            arrInt0[i] = Integer.parseInt(words0[i]);
        } // for
        int arrInt1[] = new int[words1.length];
        for (int i = 0; i < arrInt1.length; i++) {
            arrInt1[i] = Integer.parseInt(words1[i]);
        } // for
        int arrInt2[] = new int[words2.length];
        for (int i = 0; i < arrInt2.length; i++) {
            arrInt2[i] = Integer.parseInt(words2[i]);
        } // for
        int sum0 = 0;
        for (int i = 0; i < words0.length; i++) {
            sum0 = sum0 + arrInt0[i];
        } //for
        int sum1 = 0;
        for (int i = 0; i < words1.length; i++) {
            sum1 = sum1 + arrInt1[i];
        } //for
        int sum2 = 0;
        for (int i = 0; i < words2.length; i++) {
            sum2 = sum2 + arrInt2[i];
        } //for
        if (sum0 > sum1 && sum0 > sum2)
            System.out.println("Наибольшая сумма = " + sum0 + " в строке " + arrayString[0]);
        else if (sum1 > sum0 && sum1 > sum2)
            System.out.println("Наибольшая сумма = " + sum1 + " в строке " + arrayString[1]);
        else if (sum2 > sum1 && sum2 > sum0)
            System.out.println("Наибольшая сумма = " + sum2 + " в строке " + arrayString[2]);
    }// q8

    public static void q9() {
// 9. Напишите метод, который принимает массив чисел, а возвращает исходный массив, но без отрицательных чисел
        Scanner con = new Scanner(System.in);
        System.out.print("Введите строку положительных и отрицательных чисел через пробел: ");
        String str = con.nextLine();
        String[] words = str.split(" ");
        int[] arrayInt = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            arrayInt[i] = Math.abs(Integer.parseInt(words[i]));
            System.out.print(arrayInt[i] + " ");
        }
        System.out.println();
    } // q9

    public static int menu() {
        Scanner con = new Scanner(System.in);
        System.out.print("\n1. Метод возвращает наибольшее из двух целых чисел." +
                "\n2. Метод возвращает наибольшее из двух дробных чисел." +
                "\n3, 4, 5. Метод возвращает наибольшую из 3, 4, 5 строк." +
                "\n6. Вывод введённой строки в верхнем регистре через символ." +
                "\n7. Возврат наибольшего элемента массива." +
                "\n8. Возврат массива с наибольшей суммой элементов." +
                "\n9. Возврат массива без отрицательных чисел." +
                "\nВвод пункта меню. 0 - выход: ");
        int m = con.nextInt();
        return m;
    } // menu

    public static void main(String[] args) {
        int m = 0;
        do {
            m = menu();
            switch (m) {
                case 0:
                    break;
                case 1:
                    q1();
                    break;
                case 2:
                    q2();
                    break;
                case 3:
                    q35(3);
                    break;
                case 4:
                    q35(4);
                    break;
                case 5:
                    q35(5);
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
            } // switch
        } while (m != 0);
    } // main
} // Lesson2
