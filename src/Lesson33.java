public class Lesson33 {
    public static void main(String[] args) {
// 1. Напишите программу, в которой переменная x объявляется 10 раз
        for (int i = 0; i < 10; i++) {
            int x = 0;
            System.out.print((i + 1) + " ");
            while (x < 10) {
                x++;
            } // while
        } //for

// 2. Напишите программу из одной строчки, в которой переменная x объявляется 10 раз
        for (int i = 0; i < 10; i++) { int x = 0;}

// 3. Что такое область видимости переменной? Что происходит с переменной, после того, как начал выполняться код вне ее области видимости?
        // Переменная объявляется в своём потоке (со своим участком памяти). Вне области видимости задействован другой поток (с другим участком памяти).

// 4. Зачем нужна область видимости переменной? Было бы удобно, если б переменная, объявленная хоть где, была доступна в любом другом месте?
        // Такие синтаксис и правила Java. Их просто надо знать.

    } // main
} // Lesson3