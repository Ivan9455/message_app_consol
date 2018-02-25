package TextGenerate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Tgenerate tgenerate = new Tgenerate();
//        System.out.println(tgenerate.ru);
//        for (int i = 0; i < tgenerate.ru.length; i++) {
//            for (int j = 0; j < tgenerate.ru[i].length; j++) {
//                System.out.println(tgenerate.ru[i][j]);
//                System.out.println(Math.pow(16,3));
//            }
//        }
        //String str = "Тут будет текстовое сообщение";
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
        //System.out.print(str);

    }
}
