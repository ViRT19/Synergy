package Lesson3;

public class Lesson3 {
    public static void main(String[] args) {
// 1. Добавьте конструкторы в классы: директория, файл. Самое главное, в базовый класс.
//2. Добавьте конструкторы в классы с наследованием: пользователь, администратор, модератор
    FileNew fileNew = new FileNew("c:\\", "book.txt", 500);
// 3. Добавьте конструкторы в классы с наследованием: персонаж, главный герой, злодей, друг главного героя
        Friend friend = new Friend("Artemon");
    }
}
