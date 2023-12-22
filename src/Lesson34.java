import java.util.Scanner;

public class Lesson34 {
    public static void main(String[] args) {
// 1. Зачем нужно ключевое слово this?
        // Ключевое слово this — используется для ссылки на текущий класс с учетом метода или конструктора экземпляра.
// 2. Можно ли обратиться к полям класса, не используя ключевое слово this? Как?
// 3. Когда стоит использовать слово this?
        // Внутри класса, используя поле или метод класса.
// 4. Создайте класс, который находит наибольшее из трех чисел. Ко всем переменным обращаться можно ТОЛЬКО используя this.
        int length = 3;
        int[] arrInt = new int[length];
        System.out.print("Из трёх чисел: ");
        for (int i = 0; i < length; i++) {
            arrInt[i] = (int) (Math.random() * 1000);
            System.out.print(arrInt[i] + " ");
        }
        MyClass max = new MyClass();
        System.out.println("наибольшее " + max.maxOfArray(arrInt));

// 5. Создайте класс, который делает из трех маленьких строк одну большую. Ко всем переменным обращаться можно ТОЛЬКО используя this.
        Scanner con = new Scanner(System.in);
        System.out.println("Введите " + length + " строки:");
        String[] arrString = new String[length];
        for (int i = 0; i < length; i++) {
            System.out.print((i+1) + ". ");
            arrString[i] = con.nextLine();
        } // for
        MyClass concatenation = new MyClass();
        System.out.println("Конкатенация " + length + " строк: " + concatenation.concatenation(arrString));

// 6. Создайте класс, который принимает аргументом, какую задачу он должен решить: “найти минимум из 2 чисел”, “найти сумму элементов массива”, “вывести строку с конца”.
// На выходе этот класс пишет в консоль Java-код, который решает заданную задачу. Ко всем переменным обращаться можно ТОЛЬКО используя this.
        System.out.print("1. Нахождение минимума из двух чисел." +
                "\n2. Сумма элементов массива." +
                "\n3. Вывод строки с конца." +
                "\nВаш выбор: ");
        int menuItem = con.nextInt();
        MyClass javaCode = new MyClass();
        switch (menuItem) {
            case 1: {
                System.out.print("Введите 2 числа через пробел: ");
                int x = con.nextInt();
                int y = con.nextInt();
                System.out.println("Наименьшее число = " + javaCode.Min(x, y));
                javaCode.PrintMethod("Min");
                break;
            } // 1
            case 2: {
                System.out.print("Введите ряд чисел через пробел: ");
                String str = con.next() + con.nextLine();
                System.out.println("Сумма = " + javaCode.Sum(str));
                javaCode.PrintMethod("Sum");
                break;
            } // 2
            case 3: {
                System.out.print("Введите строку: ");
                String str  = con.next() + con.nextLine();
                System.out.println(javaCode.EndToBegin(str));
                javaCode.PrintMethod("EndToBegin");
                break;
            } // 3
        } // switch

    } // main
} // Lesson4
