package Lesson4;

public class Lesson4 {
    public static void main(String[] args) {
// Почему наследник всегда можно преобразовать к родителю?
// У наследника есть все поля и методы родителя. Он скопирован.

// 2. Реализуйте метод, который выводит имя пользователя. Передайте в этот метод также и модератора, и админа
        Permission vasya = new Permission("Vasya", "User");
        Permission petya = new Permission("Petya", "Moderator");
        Permission seva = new Permission("Seva", "Administrator");
        vasya.printPermission();
        petya.printPermission();
        seva.printPermission();

//3. Возможно ли преобразовать родителя к наследнику? Попробуйте
// 4. Реализуйте метод, который возвращает родителя, а не наследника. Какой в этом смысл?
// Преобразование класса-наследника к классу-родителю используется, когда нужно работать
// с объектами на основе их общего родительского класса, не обращая внимания на их специфические характеристики, доступные только в классе-наследнике.
        Permission vasya2 = new Perm2("Slava", "Moderator");
        vasya2.printPermission();

    }
}
