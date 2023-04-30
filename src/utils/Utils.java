package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public static String arrayListToNumbericText(ArrayList texts) {
        String tempText = "";
        for (int i = 0; i < texts.size(); i++) {
            tempText += String.valueOf(i + 1) + texts.get(i);
        }
        return tempText;
    }

    public static String putTextInSquareBrackets(String text) {
        return " [" + text + "] ";
    }

    public static boolean askYesOrNoQuestion(String question, Scanner input) {
        if (input == null) {
            input = new Scanner(System.in);
        }

        question += "[y/n]?:";
        char tempYesOrNoTextInput;
        boolean yesForThisOperation = false;
        do {
            System.out.print(question);
            tempYesOrNoTextInput = input.next().trim().toUpperCase().charAt(0);
        } while (tempYesOrNoTextInput != 'Y' && tempYesOrNoTextInput != '1' && tempYesOrNoTextInput != 'N' && tempYesOrNoTextInput != '0');
        yesForThisOperation = tempYesOrNoTextInput == 'Y' || tempYesOrNoTextInput == '1';

        return yesForThisOperation;
    }
}
