package Lesson2;

public class KeyboardSwitch {
    String eng = "qwertyuiop[]asdfghjkl;'zxcvbnm,.QWERTYUIOP{}ASDFGHJKL:\"ZXCVBNM<>";
    String rus = "йцукенгшщзхъфывапролджэячсмитьбюЙЦУКЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";

    public KeyboardSwitch(String str) {
        for (int i = 0; i < str.length(); i++) {
            int index = eng.indexOf(str.charAt(i));
            if (index > 0) System.out.print(rus.substring(index, index+1));
            else System.out.print(str.charAt(i));
        }
    }
}

