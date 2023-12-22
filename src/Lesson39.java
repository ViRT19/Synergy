import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Lesson39 {

    public static void mult(int row, int col) {
        int[][] field = new int[row][col]; // Создаём и заполняем матрицу
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                field[i][j] = (i + 1) * (j + 1);
            }
        }
        System.out.println();
        for (int j = 0; j < row; j++) {     // Рассчёт количества пробелов и вывод матрицы
            for (int i = 0; i < col; i++) {
                if (field[j][i] < 10)
                    System.out.print(field[j][i] + "   ");
                else if (field[j][i] > 9 && field[j][i] < 100)
                    System.out.print(field[j][i] + "  ");
                else if (field[j][i] > 99)
                    System.out.print(field[j][i] + " ");
            } // for
            System.out.println();
        } // for
    } // mult


    private static Calendar calendar = Calendar.getInstance();

    // ------------------ високосный год ------------------
    private static boolean isBissextile() {
        int y = calendar.get(Calendar.YEAR);
        return ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0);
    } // isBissextile

    // --------- максимальное число дней в месяце ---------
    private static int maxMonth() {
        int month = calendar.get(Calendar.MONTH);
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 1 && isBissextile()) days[1] = 29;
        return days[month];
    } // maxMonth

    // ------- с какого дня недели начинается месяц -------
    private static int firstDay() {
        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        while (day-- > 0)
            if (--dayWeek < 1) dayWeek = 7;
        return dayWeek;
    } // firstDay

    private static void alphaChar(char a, char z) {
        char[][] ch = new char[6][10];
        int cnt = 0;
        int count = z - a;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 10; col++) {
                ch[row][col] = (cnt <= count) ? (char) (a + cnt) : ' ';
                cnt++;
            }
        }
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 10; col++) {
                System.out.print(ch[row][col] + " ");
            }
            System.out.println();
        }
    } //alphaChar

    public static void main(String[] args) {
// 1. Выведите таблицу умножения 1-9
// 6. создайте матрицу(двумерный массив) int[][], заполните ее таблицей умножения 1-9. Выведите ее.
        mult(9, 9);

// 2. Выведите таблицу умножения 1-20
// 3. Создайте двумерный массив, задайте для него значения, выведите его элементы.
        mult(20, 20);

// 4. Создайте двумерный массив. Выведите его предпоследнюю строчку // В методе mult for (int i=0; i < col; i++) System.out.print(field[row-1][i]);
//5. Создайте двумерный массив. Выведите его первый столбец // В методе mult for (int i=0; i < row; i++) System.out.print(field[i][0]);


// 7. Создайте матрицу int[][], заполните ее календарем на текущий месяц:
//пн вт ср чт пт сб вс
        System.out.println();
        String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        System.out.printf("%14s, %d\n", months[month], year);
        System.out.println("  Пн  Вт  Ср  Чт  Пт  Сб  Вс");
        int[][] day = new int[5][7];
        int c, i = 1, first = firstDay();
        int maxDay = maxMonth();
        for (c = 1; c < first; ++c)
            day[0][c - 1] = 0;
        int row = 0;
        while (i <= maxDay) {
            int d = (c++ == first) ? first : 1;
            while (d++ <= 7 && i <= maxDay)
                day[row][d - 2] = i++;
            row++;
        } // while
        for (int k = 0; k < 5; k++) {
            for (int j = 0; j < 7; j++) {
                if (day[k][j] == 0)
                    System.out.print("    ");
                else if (day[k][j] < 10)
                    System.out.print("   " + day[k][j]);
                else
                    System.out.print("  " + day[k][j]);
            } // for
            System.out.println();
        } // for

// 8. Создайте матрицу char[][], проинициализируйте ее латинским алфавитом, выведите его.
// Подсказка - можно получить первую букву как char ch = ‘a’, следующую - как ch + 1, и так далее.
        System.out.println();
        alphaChar('A', 'Z');
        alphaChar('a', 'z');


// 9. Предыдущее задание, но с русским алфавитом.
        alphaChar('а', 'я');
        System.out.println();
        alphaChar('А', 'Я');

    } // main
} // Lesson9
