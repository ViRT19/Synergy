package Lesson2;

import java.io.IOException;
import java.util.Scanner;

public class Lesson2 {
    public static void main(String[] args) throws IOException {
// 1. Что такое конструктор по-умолчанию?
// 2. Как сделать так, чтобы при каждом создании экземпляра класса, в консоль что-то выводилось? (Слежка за классом :) )
        Constructor constructor = new Constructor();

// 3. Сделайте класс, отображающий операционную систему; сделайте конструктор для него. Создайте несколько экземпляров
        OS os = new OS();
        OS os1 = new OS();
        System.out.println(os1.os);

// 4. Сделайте класс WebSite, и несколько конструкторов для него; продемонстрируйте использование
        WebSite title = new WebSite("https://ya.ru");
        System.out.println(title.siteTitle);
//        WebSite webSite = new WebSite();      // Конструктор работает. При вызове https://google.com title = "Google".
//        System.out.println(webSite.siteTitle);

// 5. Создайте экземпляры StringBuilder, используя несколько конструкторов
        StrBuild s1 = new StrBuild();
        StrBuild s2 = new StrBuild(5);
        System.out.println(s1.str);
        System.out.println(s2.str);

// 6. Сделайте класс Url(ссылка) с несколькими конструкторами; сделайте класс CurrencyCourse (курс валют)
// с несколькими конструкторами; внутри конструктора CurrencyCourse
// вызывайте также конструктор Url - инициализируйте ссылку, по которой будете получать курс валют; запросите курс валют.
        new CurrencyCourse();

// 7. Создайте класс TextChecker. Его конструктор принимает строку и внутри него будет происходить:
// Проверка текста на наличие инностранных букв вместо русской раскладки и цифр вместо нуля и буквы «з».
// Если обнаружена такая подмена - выбрасывается исключение
        String text = "1988" +
                "  МЕДИЦИНА БУДУЩЕГО - ОТ МЕХАHИКИ К СФЕРЕ РАЗУMА И ДУХА\n" +
                "  Доктор Ричард Гербер приводит обширную, тщательно подoбранную инфoрмацию о тонкoэнергетической анатомии человека... ";
        new TextChecker(text);

// 8. Создайте класс KeyboardSwitch. Его конструктор принимает строку и внутри него происходит: Перевод текста в нужный язык (забыл переключить клавиатуру и напечатал другим языком).
        System.out.print("\nВвод: ");
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        new KeyboardSwitch(str);
    }
}
