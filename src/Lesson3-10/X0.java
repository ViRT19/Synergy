package Lesson10;

import java.util.Scanner;

public class X0 {
    final int countCell = 3;
    final int countX = 3;
    char[][] field;
    char x = 'X';
    Scanner console = new Scanner(System.in);

    void initField() {
        field = new char[this.countCell][this.countCell];
        for (int row = 0; row < this.countCell; row++)
            for (int col = 0; col < this.countCell; col++)
                this.field[row][col] = ' ';
    } // initField

    void printField() {
        System.out.print("   ");
        for (int col = 0; col < this.countCell; col++)
            System.out.print((col + 1) + "   ");
        System.out.println();
        for (int row = 0; row < this.countCell; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < this.countCell; col++) {
                System.out.print("[" + this.field[row][col] + "] ");
            }
            System.out.println();
        }
    } // printField

    boolean isWrongCell(int row, int col) {
        boolean bool = false;
        bool = (bool || row < 0);
        bool = (bool || row >= this.countCell);
        bool = (bool || col < 0);
        bool = (bool || col >= this.countCell);
        return bool;
    } // isWrongCell

    void readX() {
        String str;
        boolean isTrue = false;
        while (!isTrue) {
            str = console.nextLine();
            int row = Integer.parseInt(str.charAt(0) + "") - 1;
            int col = Integer.parseInt(str.charAt(str.length() - 1) + "") - 1;
            if (this.isWrongCell(row, col)) {
                System.out.print("Нет такой ячейки. Ход " + this.x + ": ");
                continue;
            } else if (this.field[row][col] != ' ') {
                System.out.print("Ячейка уже занята. Ход " + this.x + ": ");
                continue;
            } else if (this.field[row][col] == ' ') {
                isTrue = true;
                this.field[row][col] = this.x;
                this.printField();
                this.x = (this.x == 'X') ? '0' : 'X';
                break;
            }
        } // while
    } // readX

    boolean isWin() {
        boolean bool = false;
        for (int row = 0; row <= this.countCell - this.countX; row++) { // Horizont
            for (int col = 0; col <= this.countCell - this.countX; col++) {
                for (int i = 0; i < this.countX; i++)
                if (this.field[row][col] == this.field[row][col + 1] && this.field[row][col + 1] == this.field[row][col + 2] && this.field[row][col] != ' ')
                    bool = true;
            }
        }
        for (int col = 0; col <= this.countCell - this.countX; col++) { // Vertical
            for (int row = 0; row <= this.countCell - this.countX; row++) {
                if (this.field[row][col] == this.field[row + 1][col] && this.field[row + 1][col] == this.field[row + 2][col] && this.field[row][col] != ' ')
                    bool = true;
            }
        }
        for (int row = 0; row <= this.countCell - this.countX; row++) { // Diagonal
            for (int col = 0; col <= this.countCell - this.countX; col++) {
                if (this.field[row][col] == this.field[row + 1][col + 1] && this.field[row + 1][col + 1] == this.field[row + 2][col + 2] && this.field[row][col] != ' ')
                    bool = true;
            }
        }
        for (int row = 0; row <= this.countCell - this.countX; row++) { // BackDiagonal
            for (int col = 0; col <= this.countCell - this.countX; col++) {
                if (this.field[row + 2][col + 2] == this.field[row + 1][col + 1] && this.field[row + 1][col + 1] == this.field[row][col] && this.field[row + 2][col + 2] != ' ')
                    bool = true;
            }
        }
        return bool;
    } // isWin

    boolean isAllFull() {
        boolean bool = true;
        for (int row = 0; row < this.countCell; row++) {
            for (int col = 0; col < this.countCell; col++) {
                if (this.field[row][col] == ' ')
                    bool = false;
            }
        }
        return bool;
    } // isAllFull

    void game() {
        while (!isWin()) {
            System.out.print("Ход " + this.x + ": ");
            this.readX();
        }
        if (isAllFull() && !isWin()) System.out.println("Ничья.");
        else {
            this.x = (this.x == 'X') ? '0' : 'X';
            System.out.println("Выиграл " + this.x + ".");
        }
    } // game
}
