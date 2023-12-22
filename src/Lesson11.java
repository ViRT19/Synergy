import java.util.Scanner;

public class Lesson11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Имя: Роман");
        System.out.println("2. Стихотворение.\nНас водила молодость В сабельный поход.");
        System.out.println("Нас бросала молодость На кронштадтский лед.\nБоевые лошади " +
                "Уносили нас,\nНа широкой площади Убивали нас.");
        System.out.println("4. Вывести значение 2+2*2. Результат: " + (2 + 2 * 2) + ".");
        System.out.println("5. Вывести значение (2+2)*2. Результат: " + ((2 + 2) * 2) + ".");
        double result6 = (float) (100 / Math.PI);
        System.out.print("6. Вывести значение деления 100 на Пи. Результат: ");
        System.out.println(result6);
        double result7 = Math.pow(12345, 3);
        System.out.print("7. Вывести значение 12345 в третьей степени. Результат: ");
        System.out.println(result7);
        double result8 = Math.sqrt(Math.pow(2, 10));
        System.out.print("8. Вывести квадратный корень от двух в 10 степени. Результат: ");
        System.out.println(result8);
        float result9 = (float) Math.pow(Math.sqrt(2), 10);
        System.out.print("9. Вывести корень из двух, возведенный в 10 степень. Результат: ");
        System.out.println(result9);
        System.out.println("10. Деление на 0: \"... Create breakpoint: / by zero\".");
        String str1 = "Строка-1";
        String str2 = "_string2_";
        System.out.println("11. Сложение строк str1 + str2: " + str1 + str2);
        System.out.println("12. Вычитание, деление строк str1 + str2: \"java: bad operand types for binary operator\".");
        System.out.println("13. Попробуйте сложить строку str2 с числом Пи: " + str2 + Math.PI + "\n");
        System.out.print("14. Решение линейного уравнения ax+b=0.\nВведите \"a\": ");
        double a = scanner.nextDouble();
        System.out.print("Введите \"b\": ");
        double b = scanner.nextDouble();
        if (a == 0 && b == 0) System.out.println("Х = любое число.");
        else if (a == 0 && b != 0) System.out.println("Уравнение не имеет решения.");
        else {
            double x = -b / a;
            System.out.println("X = " + x);
        }

        // D = b*b – 4ас. В зависимости от того какое значение имеет дискриминант, мы и запишем ответ. Если дискриминант отрицательное число (D < 0), то корней нет.
        // Если же дискриминант равен нулю, то х = (-b)/2a. Когда дискриминант положительное число (D > 0), тогда х1= (- b - √D)/2a, и х2= (- b + √D)/2a.
        // Например. Решить уравнение х 2 – 4х + 4= 0. D = 4 2– 4 · 4 = 0 x = (- (-4))/2 = 2 Ответ: 2. Решить уравнение 2 х 2 + х + 3 = 0.

        System.out.print("15, 16. Решение уравнения (ax+b)*(cx+d)=0\nВведите значение a: ");
        a = scanner.nextDouble();
        System.out.print("Введите значение b: ");
        b = scanner.nextDouble();
        System.out.print("Введите значение c: ");
        double c = scanner.nextDouble();
        System.out.print("Введите значение d: ");
        double d = scanner.nextDouble();
        double x1, x2;
        if (a * c == 0) {
            if (b * d == 0) {
                System.out.println("x =  любое число");
            } else {
                if (a == 0) {
                    x1 = -d / c;
                    System.out.println("x = " + x1);
                } else {
                    x1 = -b / a;
                    System.out.println("x = " + x1);
                }
            }
        } else {
            double discr = b * b - 4 * a * c;
            if (discr < 0) {
                System.out.println("Уравнения не имеет решения.");
            } else if (discr == 0) {
                x1 = -b / (2 * a);
                System.out.println("x = " + x1);
            } else {
                x1 = (-b - Math.sqrt(discr)) / (2 * a);
                x2 = (-b + Math.sqrt(discr)) / (2 * a);
                System.out.println("x1 = " + x1 + " и x2 = " + x2);
            }
        }
    }
}