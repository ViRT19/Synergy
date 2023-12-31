import java.util.Scanner;

public class Lesson17 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

// 1. Написать простой булев калькулятор.
        System.out.print("1. Булев калькулятор. Допустимые значения и операнды: «1», «0», «|», «&». Введите слитно значение, операнд, значение: ");
        String str1 = console.nextLine();
        boolean bool1 = false;
        boolean bool2 = false;
        if (str1.charAt(2) == '1') bool1 = true;
        if (str1.charAt(2) == '1') bool2 = true;
        char ch = str1.charAt(1);
        boolean expression = false;
        switch (ch) {
            case '|':
                System.out.println(bool1 || bool2);
                break;
            case '&':
                System.out.println(bool1 && bool2);
                break;
            default:
                System.err.println("Выражение для вычисления некорректно.");
        }

// 2. Альберт и Бернард только что познакомились с Шерил. Они хотят знать, когда у неё день рождения.
// Шерил предложила им десять возможных дат: 15 мая, 16 мая, 19 мая, 17 июня, 18 июня, 14 июля, 16 июля, 14 августа, 15 августа и 17 августа.
// Затем Шерил сказала Альберту месяц своего рождения, а Бернарду - день. После этого состоялся диалог: Альберт:
// Я не знаю, когда у Шерил день рождения, но я знаю, что Бернард тоже не знает. Бернард: Поначалу я не знал, когда у Шерил день рождения, но знаю теперь.
// Альберт: Теперь я тоже знаю, когда у Шерил день рождения. Когда у Шерил день рождения?

/*
1. Все даты: 15 мая, 16 мая, 19 мая, 17 июня, 18 июня, 14 июля, 16 июля, 14 августа, 15 августа и 17 августа.
2. Оставляем только даты, имеющие пару в другом месяце:
    15 мая - 15 августа;
    16 мая - 16 июля;
    17 июня - 17 августа;
    14 июля - 14 августа.
3. Выписываем по месяцам:
    май: 15, 16;
    июнь: 17;
    июль: 14, 16;
    август: 14, 15, 17.
4. июнь вычёркиваем: дата только одна, август 17 вычеркивем. Остаток:
    май: 15, 16;
    июль: 14, 16;
    август: 14, 15.
5. май, июнь исключаем: там были непарные числа (18 и 19).
    июль: 14, 16;
    август: 14, 15.
6. После удаления парных остаётся 16 июля и 15 августа. Почему остаётся только 16 июля, я не понял, т.к. даты равнозначные.
 */

    }
}

