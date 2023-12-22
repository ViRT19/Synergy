import java.util.Scanner;

public class Lesson26 {
    public static void main(String[] args) {
        // 1. Создайте final массив чисел. Увеличьте каждый его элемент вдвое.
        final int[] arr = new int[3];
        for (int i=0; i<3; i++) {
            arr[i] = i * 2;
            arr[i] = arr[i] * 2;
            System.out.println(arr[i]);
        } // for

        // 2. Найдите наибольшее число из трех, используя только final-переменные.
        final double[] array = new double[3];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            array[i] = Math.random() * 1000;
            System.out.print((int) array[i] + ", ");
            if (array[i] > max) max = (int) array[i];
        } // for
        System.out.println("максимальное число: " + max);

        // 3. Измените final переменную. Получилось? Нет.
//        final int a = 100;
//        a = 200;
//        System.out.println("Final a = " + a);

        // 4. Пользователь вводит слово, подсчитайте количество уникальных букв в этом слове.
        // (Повторяющиеся считаем за одну, в слове окно - три уникальные буквы, окн). Используйте только final-переменные. Подсказка: используйте массив.
        Scanner console = new Scanner(System.in);
        System.out.print("4. Поиск уникальных букв. Введите слово: ");
        final String word = console.next();
        String unikum = "";
        char ch;
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (!unikum.contains(""+ch))
                unikum = unikum + ch;
        }
        System.out.println(unikum);

    } // main
} // Lesson6
