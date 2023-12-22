package Lesson1;

public class filmHeroes extends Film {
    static boolean whoIsWho(String name) {
        switch (name) {
            case "Buratino": return true;
            case "Artemon" : return true;
            case "Pierro"  : return true;
            case "Karabas" : return true;
            default: return false;
        }
    }

    public static void main(String[] args) {
        bool[0] = whoIsWho("Buratino");
        bool[1] = whoIsWho("Pinokkio");
        bool[2] = whoIsWho("Rambo");
        bool[3] = whoIsWho("Karabas");
        for (int i=0; i < 4; i++) System.out.println(bool[i]);
    }
}


