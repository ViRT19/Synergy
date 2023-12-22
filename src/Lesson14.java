import java.util.Scanner;

public class Lesson14 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        //1. Составьте программу, которая переводит переменную из byte в short
        //2. Составьте программу, которая переводит переменную из short в int
        //3. Составьте программу, которая переводит переменную из int в long
        //4. Составьте программу, которая переводит переменную из long в int
        //5. Составьте программу, которая переводит переменную из float в double
        //6. Составьте программу, которая переводит переменную из double в float
        //7. Придумайте способ переводить из int в boolean и наоборот.
        byte byteVariable = 100;
        short shortVariable = byteVariable;
        int intVariable = shortVariable;
        long longVariable = intVariable;
        double doubleVariable = longVariable;
        float floatVariable = (float) doubleVariable;
        boolean boolVariable = (intVariable % 2) != 0;  // чётное - true, нечётное - false
        if (boolVariable) intVariable = 1;
        else intVariable = 0;
        System.out.println("1-7. преобразование типов переменных.");
        System.out.println("byte = " + byteVariable);
        System.out.println("byte --> short = " + shortVariable);
        System.out.println("short --> int = " + intVariable);
        System.out.println("int --> long = " + longVariable);
        System.out.println("long --> double = " + doubleVariable);
        System.out.println("double --> float = " + floatVariable);
        System.out.println(boolVariable);
        System.out.println(intVariable);

        //8. Придумайте способ переводить из String в boolean.
        System.out.print("8. Введите корректное значение истина или ложь: ");
        String strVariable = console.next();
        strVariable = strVariable.toUpperCase();
        String strTrue = "1 TRUE ИСТИНА YES ДА";
        String strFalse = "0 FALSE ЛОЖЬ NO НЕТ";
        if (strTrue.contains(strVariable)) {
            boolVariable = true;
            System.out.println("Введено «" + boolVariable + "».");
        }
        else if (strFalse.contains(strVariable)) {
            boolVariable = false;
            System.out.println("Введено «" + boolVariable + "».");
        }
        else System.err.println("Введённые данные некорректны.");

        //9. Переведите переменную из char в string
        //10. Переведите переменную из char в int и наоборот.
        char chrVariable = 'R';
        strVariable = String.valueOf(chrVariable);
        intVariable = Character.getNumericValue(chrVariable);
        strVariable = Integer.toString(intVariable);
        System.out.println("9. intVariable = " + intVariable + ". Символ «" + chrVariable + "».");
    }
}