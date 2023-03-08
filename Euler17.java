//Program służy rozwiązaniu problemu Euler nr.17
//Program sumuje ilość znaków zapisu słownego cyfr w języku angielskim. Działa dla wartości od 1-1000.
//Program nie bierze pod uwagę spójników, myślników, spacji. Zlicza wyłącznie słowa tworzące liczebniki.
//Therefore the usage is not British.

import java.util.Scanner;
import java.lang.String;

public class Euler17 {
    public static int[] everydigitbehind(int number) {
        int result[] = new int[number];
        for (int i = 1; i < number + 1; i++ ) {
            result[i-1] = i;
        }
        return result;
    }
    public static int [] decompose(int number) {
        String wn = String.valueOf(number);
        int strlength = wn.length();
        int analysed_num[] = new int[strlength];
        for (int x = 0; x < strlength; x ++) {
            char tmp1 = wn.charAt(x);
            String wn_n = String.valueOf(tmp1);
            int num = Integer.valueOf(wn_n);
            analysed_num[x] = num;
        }
        return analysed_num;
    }
    public static int charnumber_1_9(int first_num) {
        int charnum_1_10 = 0;
        if (first_num == 0) {
            charnum_1_10 = 0;
        } else if (first_num == 1) {
            charnum_1_10 = 3; 
        } else if (first_num == 2) {
            charnum_1_10 = 3;
        } else if (first_num == 3) {
            charnum_1_10 = 5;
        } else if (first_num == 4) {
            charnum_1_10 = 4;
        } else if (first_num == 5) {
            charnum_1_10 = 4;
        } else if (first_num == 6) {
            charnum_1_10 = 3;
        } else if (first_num == 7) {
            charnum_1_10 = 5;
        } else if (first_num == 8) {
            charnum_1_10 = 5;
        } else if (first_num == 9) {
            charnum_1_10 = 4;
        }
        return charnum_1_10;
    }
    public static int charnumber_10_19(int first_num) {
        int charnum_10_19 = 0;
        int cht = 4; //charnum for -teen;
        if (first_num == 0) {
            charnum_10_19 = 3;
        } else if (first_num == 1) {
            charnum_10_19 = 6; 
        } else if (first_num == 2) {
            charnum_10_19 = 6;
        } else if (first_num == 3) {
            charnum_10_19 = 8;
        } else if (first_num == 5) {
            charnum_10_19 = 7;
        } else if (first_num == 8) {
            charnum_10_19 = 8;
        } else {
            charnum_10_19 = charnumber_1_9(first_num) + cht;
        }
        return charnum_10_19;
    }
    public static int charnumber_20_90(int second_num) {
        int charnum_20_90 = 0;
        int ty = 2;
        if (second_num == 0) {
            charnum_20_90 = 0;
        } else if (second_num == 2) {
            charnum_20_90 = 6; 
        } else if (second_num == 3) {
            charnum_20_90 = 6;
        } else if (second_num == 4) {
            charnum_20_90 = 5;
        } else if (second_num == 5) {
            charnum_20_90 = 5;
        } else if (second_num == 8) {
            charnum_20_90 = 6;
        } else {
           charnum_20_90 = charnumber_1_9(second_num) + ty; 
        }
        return charnum_20_90;
    }
    public static int givedouble(int first_num, int second_num) {
        int varia = 0;
        if (second_num == 1) {
            varia = charnumber_10_19(first_num);
        } else {
            int varia1 = charnumber_20_90(second_num);
            int varia2 = charnumber_1_9(first_num);
            varia = varia1 + varia2;
        }
        return varia;
    }
    public static int givehoundreads(int third_num) {
        int first_num = third_num;
        int hund = 7;
        int csh = charnumber_1_9(first_num) + hund;
        return csh;
        
    }
    public static int charcounter(int number_a) {
        int arr2[] = decompose(number_a);
        int to_be_added = 0;
       // System.out.println(Arrays.toString(arr2));
        int arr_ln = arr2.length;
        //System.out.println(arr_ln);
        
        if (arr_ln == 1) {
            int first_num = arr2[0]; 
            to_be_added = charnumber_1_9(first_num);
        } else if (arr_ln == 2) {
            int first_num = arr2[1];
            int second_num = arr2[0];
            to_be_added = givedouble(first_num, second_num);
        } else if (arr_ln == 3) {
            int first_num = arr2[2];
            int second_num = arr2[1];
            int third_num = arr2[0];
            int doubles = givedouble(first_num, second_num);
            int houndreads = givehoundreads(third_num);
            to_be_added = houndreads + doubles;
        } else {
            to_be_added = 11;
        }

        return to_be_added;
    }
    public static int sum_arr(int arr3[], int number_a) {
        int sum = 0;
        for (int q = 0; q < number_a; q++) {
            sum += arr3[q];
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("Podaj wartosc do sumy znakow kazdej z kolejnych liczb, w zakresie 1-1000");
        System.out.println("Program nie sumuje znakow 'and' oraz spacji, myslnikow itd.");
        Scanner input = new Scanner(System.in);
        int number_a = input.nextInt();
        if (number_a >= 1 && number_a <= 1000) {
            int arr[] = everydigitbehind(number_a);
            int arr3[] = new int[number_a];
            for (int b = 0; b < number_a; b ++) {
                arr3[b] = charcounter(arr[b]);
                //System.out.println(arr3[b]);
            }
            int view = sum_arr(arr3, number_a);
            System.out.println("Szukana wartosc to:");
            System.out.println(view);
        } else {
            System.out.println("Szukana wartosc poza zakresem, podaj liczbe od 1-1000.");
        }
    }
}