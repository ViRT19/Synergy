import java.io.IOException;

public class Lesson38 {
    public static int max(int x, int y) {
        if (x > y) return x;
        else return y;
    }

    public static double max(double x, double y) {
        if (x > y) return x;
        else return y;
    }

    public static String max(String x, String y) {
        if (x.length() > y.length()) return x;
        else if (x.length() == y.length()) return "Length is equel";
        else return y;
    }

    public static boolean and(boolean x, boolean y) {
        return x & y;
    }

    public static boolean and(boolean x, int i) {
        boolean y = (i == 0) ? false : true;
        return x & y;
    }

    public static boolean and(int i, boolean x) {
        boolean y = (i == 0) ? false : true;
        return x & y;
    }

    public static String join(String s1, String s2) {
        return s1 + s2;
    }

    public static String join(String s1, String s2, String s3) {
        return s1 + s2 + s3;
    }

    public static String join(String s1, String s2, String s3, String s4) {
        return s1 + s2 + s3 + s4;
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int length = arr1.length + arr2.length;
        int[] array = new int[length];
        for (int i = 0; i < arr1.length; i++)
            array[i] = arr1[i];
        int j = 0;
        for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
            array[i] = arr2[j];
            j++;
        }
        return array;
    }

    public static int[] merge(int[] arr1, int[] arr2, int[] arr3) {
        int length = arr1.length + arr2.length + arr3.length;
        int[] array = new int[length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < arr1.length; i++)
            array[i] = arr1[i];
       for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
           array[i] = arr2[j];
           j++;
       }
       for (int i = arr1.length + arr2.length; i < arr1.length + arr2.length + arr3.length; i++) {
           array[i] = arr3[k];
           k++;
       }
        return array;
    }

    public static int[] merge(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
        int length = arr1.length + arr2.length + arr3.length + arr4.length;
        int[] array = new int[length];
        int j = 0;
        int k = 0;
        int l = 0;
        for (int i = 0; i < arr1.length; i++)
            array[i] = arr1[i];
        for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
            array[i] = arr2[j];
            j++;
        }
        for (int i = arr1.length + arr2.length; i < arr1.length + arr2.length + arr3.length; i++) {
            array[i] = arr3[k];
            k++;
        }
        for (int i = arr1.length + arr2.length + arr3.length; i < arr1.length + arr2.length + arr3.length + arr4.length; i++) {
            array[i] = arr4[l];
            l++;
        }
        return array;
    }

    public static void main(String[] args) throws IOException {

// 1. Реализуйте методы, max(x,y) - для целых, вещественных чисел, и для строк (в случае строк - возвращает самую длинную)
        MyClass3 myClass = new MyClass3();
        int xInt = (int) (Math.random() * 1000) - 500;
        int yInt = (int) (Math.random() * 1000) - 500;
        System.out.println("Max of int " + xInt + " or " + yInt + " = " + max(xInt, yInt));
        double xDouble = Math.random() * 1000 - 500;
        double yDouble = Math.random() * 1000 - 500;
        System.out.println("Max of double " + xDouble + " or " + yDouble + " = " + max(xDouble, yDouble));
        String[] xString = new String[2];
        xString = myClass.returnRandomWords(2);
        System.out.println("Max length of «" + xString[0] + "» or «" + xString[1] + "» = " + max(xString[0], xString[1]));

// 2. Реализуйте методы and(boolean x, boolean y), and(boolean x, int y), and(int x, boolean y), который будет возвращать логическое И.
// Целые числа равные 0 трактовать как false, остальные true.
        System.out.println("True & False = " + and(true, false));
        System.out.println("True & True = " + and(true, true));
        System.out.println("False & False = " + and(false, false));
        System.out.println("1 & True = " + and(1, true));
        System.out.println("True & 2 = " + and(true, 2));
        System.out.println("True & 0 = " + and(true, 0));

// 3. Реализуйте методы join(String s1, String s2), join(String s1, String s2, String s3), …. join(String s1, String s2, String s3, String s4) - которые склеивают строки
        String[] words = new String[4];
        words = myClass.returnRandomWords(4);
        System.out.println(join(words[0], words[1]));
        System.out.println(join(words[0], words[1]));
        System.out.println(join(words[0], words[1], words[2]));
        System.out.println(join(words[0], words[1], words[2], words[3]));

// 4. Реализуйте методы merge(int[] array1, int[] array2), merge(int[] array1, int[] array2,int[] array3), merge(int[] array1, int[] array2, int[] array3, int[] array4) - который возвращает новый массив,
// в котором он соединяет все предыдущие (было 3 массива по 10 элементов, станет массив с 20 элементами)
        int[] arr1 = new int[]{2, 4, 6};
        int[] arr2 = new int[]{20, 30, 40, 50};
        int[] arr3 = new int[]{7, 9, 1000};
        int[] arr4 = new int[]{3, 33, 333};
        int[] array = merge(arr1, arr2);
        for (int i = 0; i < array.length; i++)
        System.out.print(array[i] + " ");
        System.out.println();
        int[] array1 = merge(arr1, arr2, arr3);
        for (int i = 0; i < array1.length; i++)
            System.out.print(array1[i] + " ");
        System.out.println();
        int[] array2 = merge(arr1, arr2, arr3, arr4);
        for (int i = 0; i < array2.length; i++)
            System.out.print(array2[i] + " ");
        System.out.println();
    } // main
} // Lesson38
