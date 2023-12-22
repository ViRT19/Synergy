package Lesson10;

public class x0Game {
    public static void main(String[] args) {
        X0 x0 = new X0();
        x0.initField();
        x0.printField();
        System.out.println("Игроки ходят по очереди. Номера вводятся одной строкой. Сначала номер строки, затем номер колонки." +
                "\nПобеждает игрок, построивший " + x0.countX + " фишки (Х или 0) в одну линию.");
        x0.game();
    }
}
