package Niveau2_logik;

import java.util.Scanner;

public class TerminalInput {
    public static String getString(String s) {
        System.out.println(s + " : ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getInt(String s){
        while (true) {
            try {
                return Integer.parseInt(getString(s));
            } catch (NumberFormatException e) {
                System.out.println("You need to enter a number, not words");
            }
        }
    }
}
