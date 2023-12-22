package Lesson2;

public class OS {
    String os = "";
    OS () {
        this.os = System.getProperty("os.name");
    }
}
