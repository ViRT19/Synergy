import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Scanner;
import java.util.jar.Pack200;

public class Lesson19 {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        int inChar = 0;
        String s = "";
        int count = 0;
        PrintStream out = System.out;
        PrintStream err = System.err;

//1. Пользователь вводит три строки, выведите в обратном порядке.
        String[] str = new String[3];
        System.out.println("1. Введите 3 строки.");
        for (int i = 0; i<3; i++) {
            System.out.print("Введите "+ (i+1) + " строку: ");
            str[i] = console.nextLine();
        }
        for (int i=2; i>-1; i--) System.out.println(str[i]);


//2. Используя System.in (без сканнера), считайте слово из 5 букв
        System.out.println("2. Ввод строки без сканера. Считаются только 5 символов.");
        try {
            inChar = System.in.read();
            while (System.in.available() > 0) {
                s += (char) inChar;
                inChar = System.in.read();
                count++;
                if (count > 4) break;
            }
        } catch (IOException e) { System.out.println("Ошибка"); }
        System.out.println(s);

        //3. Используя System.in (без сканнера), считайте слово до пробела. Макс размер слова 10 символов.
        System.out.println("3. Считывание строки до первого пробела не более 10 символов:");
        s = "";
        count = 0;
        try {
            inChar = System.in.read();
            while (System.in.available() > 0) {
                s += (char) inChar;
                inChar = System.in.read();
                count++;
                if (count > 9) break;
                if (inChar == ' ') break;
            }
        } catch (IOException e) {System.out.println("Ошибка"); }
        System.out.println(s);

// 4. Используя Scanner на основе FileInputStream, прочесть из файла строку: название другого файла.
// Из этого другого файла прочесть название третьего файла, и в третий файл записать букву,
// которую пользователь введет через System.in (без сканера)

        String file1 = "file1.txt";
        String file2 = "";
        String file3 = "";
        System.out.println("4. Ввод одного символа:");
        try {                                           // Считываем символ с клавиатуры
            inChar = System.in.read();
            s += (char) inChar;
        } catch (IOException e) { System.out.println("Ошибка"); }

        File file = new File(file1);                    // Читаем первый файл
        Charset charset = StandardCharsets.UTF_8;
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            String fileContent = new String(bytes, charset);
            file2 = fileContent;
        } catch (Exception e) { e.printStackTrace(); }

        file = new File(file2);                         // Читаем второй файл
        charset = StandardCharsets.UTF_8;
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            String fileContent = new String(bytes, charset);
            file3 = fileContent;
        } catch (Exception e) { e.printStackTrace(); }

        try(FileWriter writer = new FileWriter(file3, false)) {       // Запись символа в файл с перезаписью содержимого
            writer.write(s);
            writer.flush();
        } catch(IOException ex) { System.out.println(ex.getMessage()); }


        //5. Пользователь вводит 7 символов. Используя System.in (без сканнера), считайте целое число до первой нецифры.
        // (пример: «35 руб», ответ 35.) считаем, что первым пользователь всегда вводит цифру.
        s = "";
        count = 0;
        try {
            inChar = System.in.read();
            while (System.in.available() > 0) {
                if (inChar > 47 && inChar < 55)         // учитываем только цифры
                s += (char) inChar;
                inChar = System.in.read();
                count++;
                if (count > 6) break;
                if (inChar == ' ') break;
            }
        } catch (IOException e) {System.out.println("Ошибка"); }
        System.out.println(s);


        // 6. Аналогично предыдущей задаче, но пользователь всегда вводит дробное число (пример ввода: «3.5 кг»)

        s = "";
        count = 0;
        try {
            inChar = System.in.read();
            while (System.in.available() > 0) {
                if ((inChar > 47 && inChar < 55) || inChar == 44 || inChar == 46)         // учитываем только цифры, точку и запятую
                    s += (char) inChar;
                inChar = System.in.read();
                count++;
                if (count > 7) break;
                if (inChar == ' ') break;
            }
        } catch (IOException e) {System.out.println("Ошибка"); }
        System.out.println(s);


      // 7. Пользователь вводит 10 строк. Те из них, в которых есть восклицательный знак, выведите в stderr. Попробуйте использовать цикл.
        int countLines = 10;
        out.println("Введите " + countLines + " строк.");
        String[] line = new String[countLines];
        for (count = 1; count < countLines + 1; count++) {
            out.print(count + ": ");
            line[count-1] = console.nextLine();
        }
        boolean isExclamationMark = true;
        for (count = 0; count < countLines; count++) {
            if(line[count].contains("!")) {
                System.out.println("В строке есть «!»: " + line[count]);
                isExclamationMark = false;
            }
        }
        if (isExclamationMark) out.println("Не встретилось строк с «!».");


        // 8. Пользователь вводит 10 строк, потом число max. Вывести в stdout те строки, длинна которых меньше max, а в stderr те, длинна которых больше, обрезав по max.
        int countLine = 10;
        out.println("Введите " + countLine + " строк.");
        String[] lines = new String[countLine];
        for (count = 1; count < countLine + 1; count++) {
            out.print(count + ": ");
            lines[count - 1] = console.nextLine();
        }
        out.print("Введите максимальную длину: ");
        int lineMax = console.nextInt();
        for (count = 0; count < countLine; count++) {
            if (lines[count].length() < lineMax)
                out.println(lines[count]);
            else err.println(lines[count].substring(0, lineMax));
        }
    }
}