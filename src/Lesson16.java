import java.util.Scanner;

public class Lesson16 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String str1;

        //1. Пользователь вводит дробное число. Если оно больше пи, вывести “pimore”
        System.out.print("1. Введите дробное число (можно использовать как «.», так и «,»): ");
        str1 = console.next();
        str1 = str1.replace(',','.');
        double double1Var;
        double1Var = Double.parseDouble(str1);
        if (double1Var > Math.PI) System.out.println("pimore");

        //2. Пользователь вводит строку. Используя метод .contains(‘ ‘) пробел, определите,
        // ввел пользователь одно слово, или больше
        System.out.print("2. Введите строку: ");
        str1 = console.next();
        str1 = str1 + console.nextLine();
        if (str1.contains(" ")) System.out.println("Введено несколько слов.");
        else System.out.println("Введено одно слово.");

        //3. Пользователь вводит четыре числа. Найти наибольшее из них.
        System.out.print("3. Найти наибольшее из 4-х чисел. Введите 4 целых числа через «пробел»: ");
        int[] intArray = new int[4];
        for (int i = 0; i < 4; i++) intArray [i] = console.nextInt();
        int max = -64565;
        for (int i=0; i<4; i++) if (max < intArray[i]) max = intArray[i];
        System.out.println("Наибольшее число = " + max);
    }
}
