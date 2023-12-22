package Lesson5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Cal {
    LocalDate localDate = LocalDate.now();
    public String dateFormat (LocalDate localDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(dateTimeFormatter);
    } // dateFormat

    public boolean isVisokos (int year) {
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) return true;
        else return false;
    } // isVisokos

    void allDatesPrint () {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        int year = localDate.getYear();
        int countDays = 365;
        localDate = LocalDate.of(year, 1, 1);
        if (isVisokos(year)) countDays = 366;
        Month mon = localDate.getMonth();
        System.out.print(mon + " ");
        for (int i = 0; i < countDays; i++) {
            if (mon != localDate.plusDays(i).getMonth()) {
                mon = localDate.plusDays(i).getMonth();
                System.out.print("\n" + mon + " ");
            }
            System.out.print(localDate.plusDays(i).format(pattern) + " ");
        } // for
    }

    String[][][] cal = new String[12][7][7];
    int[] countDaysInMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int numDayOfWeek(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY: return 0;
            case TUESDAY: return 1;
            case WEDNESDAY: return 2;
            case THURSDAY: return 3;
            case FRIDAY: return 4;
            case SATURDAY: return 5;
            case SUNDAY: return 6;
            default: return -1;
        } // switch
    }

    void initCal(int year) {
        if (isVisokos(year)) countDaysInMonth[1] = 29;
        for (int i = 0; i < 12; i++)        // Всё заполняем двойными прробелами.
            for (int j = 0; j < 7; j++)
                for (int k = 0; k < 7; k++)
                    cal[i][j][k] = "  ";
        for (int m = 0; m < 12; m++) {      // 1-й ряд - дни недели
            for (int x = 0; x < 7; x++) {
                cal[m][x][0] = "Пн";
                cal[m][x][1] = "Вт";
                cal[m][x][2] = "Ср";
                cal[m][x][3] = "Чт";
                cal[m][x][4] = "Пт";
                cal[m][x][5] = "Сб";
                cal[m][x][6] = "Вс";
            }
        }
        localDate = LocalDate.of(year, 1, 1);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        for (int k = numDayOfWeek(dayOfWeek); k < 7; k++)
            for (int j = 0; j < countDaysInMonth[k]; k++) {

            }


    void printCal() {
        for (int k = 0; k < 7; k++)
            System.out.print(cal[0][0][k] + " ");
    } // printCal
}
