package Lesson45;
public class Lesson45 {
    public static void main(String[] args) {
// 1. Выведите все даты текущего года.
        Cal cal = new Cal();
//        cal.allDatesPrint();

// 2. “Нарисуйте” календарь: январь пн вт ср чт пт сб вс 1 2 3 4 5 6 … и так далее
        cal.initCal(cal.localDate.getYear());
        cal.printCal();
    }
}
