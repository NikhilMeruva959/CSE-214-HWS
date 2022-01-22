package applications.arithmetic;
import datastructures.sequential.Stack;

/**
 * @author Ritwik Banerjee
 * @author Nikhil Meruva
 */

import applications.arithmetic.Brackets;

import java.util.ArrayList;

public class DyckWord {

    private final String word;

    public DyckWord(String word) {
        if (isDyckWord(word))
            this.word = word;
        else
            throw new IllegalArgumentException(String.format("%s is not a valid Dyck word.", word));
    }

    /**
     * This method takes the given word expression and checks if there are the correct amount of Brackets using a stack
     *
     * @param word (the given expression)
     * @return true or false value(boolean)
     */

    public static Boolean isDyckWord(String word) {
        Stack<Character> temp = new Stack<Character>();
        String brack = "";
        for (int i = 0; i <= word.length() - 1; i++) {
            if (Brackets.isLeftBracket(word.substring(i, i + 1))) {
                brack = brack + word.substring(i, i + 1);
            }
            if (Brackets.isRightBracket(word.substring(i, i + 1))) {
                brack = brack + word.substring(i, i + 1);
            }
        }
        for (int i = 0; i < brack.length(); i++) {
            if (Brackets.isLeftBracket(brack.substring(i, i + 1))) {
                char c = brack.charAt(i);
                temp.push(c);
            }

            if (Brackets.isRightBracket(brack.substring(i, i + 1))) {
                if (temp.isEmpty()) return false;
                char x = temp.pop();
                char c = brack.charAt(i);
                if (x == Brackets.LEFT_PARENTHESIS.getSymbol() && c != Brackets.RIGHT_PARENTHESIS.getSymbol()) {
                    return false;
                }
                if (x == Brackets.LEFT_BRACE.getSymbol() && c != Brackets.RIGHT_BRACE.getSymbol()) {
                    return false;
                }
                if (x == Brackets.LEFT_SQUARE_BRACKET.getSymbol() && c != Brackets.RIGHT_SQUARE_BRACKET.getSymbol()) {
                    return false;
                }
            }
        }
        return temp.isEmpty();
    }

    public String getWord() {
        return word;
    }

}
