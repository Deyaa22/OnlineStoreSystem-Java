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

    public static String putTextInBox(String text) {
        int textLength = text.trim().length();
        text = text.trim()+ Constants.SPACE_BOX_15;
        String tempText = "";
        for (int i = 0; i < textLength && i < Constants.SPACE_BOX_15.length(); i++) {
            tempText += text.charAt(i);
        }
        String tempText2 = tempText;
        for (int i = tempText.length(); i < Constants.SPACE_BOX_15.length(); i++) {
            tempText2 += " ";
        }
        text = tempText2;
        return text;
    }
    public static String putSequanceOfTextsInBoxes(String[] texts){
        String tempText = "|";
        for (int i = 0; i < texts.length; i++) {
            tempText = tempText.concat(putTextInBox(texts[i])).concat("| ");
        }
        return tempText;
    }
    
    public static String lineOfSymbole(char symbole){
        String tempText = "";
        for (int i = 0; i < (Constants.SPACE_BOX_15 .length()); i++) {
            for (int j = 0; j < 5; j++) {
                tempText = tempText.concat(String.valueOf(symbole));
            }
            tempText = tempText.concat(String.valueOf(symbole));
        }
        return tempText;
    }
}
