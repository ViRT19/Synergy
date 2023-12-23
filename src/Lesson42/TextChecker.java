package Lesson2;

public class TextChecker {
    public TextChecker (String str) {
        String[] words = new String[str.split(" ").length];
        words = str.split(" ");
        boolean exeption;
        System.out.print("Исключения: ");
        for (int i = 0; i < words.length; i++) {
            exeption = false;
            char ch;
            for (int j = 0; j < words[i].length(); j++) {
                ch = words[i].charAt(j);
                if ((ch > '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) exeption = true;
            }
            if (exeption) System.out.print(words[i] + " ");
        }
    }
}
