package applications.arithmetic;

/**
 * This class provides the fixed enumerable types of brackets in order to prevent misuse of hard-coded
 * character or string values throughout the application. It also provides helper methods to check the
 * correspondence between left and right brackets of the same type. Since the method names are obvious,
 * additional documentation has not been provided for each method individually.
 *
 * @author Ritwik Banerjee
 */
public enum Brackets {

    LEFT_PARENTHESIS('('),
    RIGHT_PARENTHESIS(')'),
    LEFT_BRACE('{'),
    RIGHT_BRACE('}'),
    LEFT_SQUARE_BRACKET('['),
    RIGHT_SQUARE_BRACKET(']');

    private char symbol;

    Brackets(char c) {
        this.symbol = c;
    }

    public char getSymbol() {
        return symbol;
    }

    public static boolean isLeftBracket(char c) {
        return LEFT_PARENTHESIS.symbol == c || LEFT_BRACE.symbol == c || LEFT_SQUARE_BRACKET.symbol == c;
    }

    public static boolean isLeftBracket(String c) {
        return isLeftBracket(c.charAt(0));
    }

    public static boolean isRightBracket(char c) {
        return RIGHT_PARENTHESIS.symbol == c || RIGHT_BRACE.symbol == c || RIGHT_SQUARE_BRACKET.symbol == c;
    }

    public static boolean isRightBracket(String c) {
        return isRightBracket(c.charAt(0));
    }

    public static boolean correspond(char left, char right) {
        return (LEFT_PARENTHESIS.symbol == left && RIGHT_PARENTHESIS.symbol == right) ||
                (LEFT_BRACE.symbol == left && RIGHT_BRACE.symbol == right) ||
                (LEFT_SQUARE_BRACKET.symbol == left && RIGHT_SQUARE_BRACKET.symbol == right);
    }
}
