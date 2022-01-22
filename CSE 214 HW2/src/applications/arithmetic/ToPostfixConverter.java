package applications.arithmetic;
import datastructures.sequential.*;

/**
 * This class is the algorithm to convert infix expressions to postfix expressions.
 * The main method convert uses the nextToken method implemented as well to complete the calculation.
 *
 * @author Nikhil Meruva
 */

public class ToPostfixConverter implements Converter {
    /**
     * The method uses a stack to push or pop Operators, Brackets, and Integer values to return a valid postfix String
     *
     * @param expression  the given arithmetic expression which is a valid DyckWord
     * @return String postfix expression
     */
    public String convert(ArithmeticExpression expression) {

        Stack<String> temp = new Stack<String>();
        String input = expression.getExpression();
        String x = "";
        String output = "";
        int i = 0;

        while(i < input.length()) {
            if(input.substring(i, i+1).equals(" ")) {
                i+=1;
                continue;
            }
            x = nextToken(input, i);

            if(isOperand(x)){
                output += x + " ";
            }
            if(Brackets.isLeftBracket(x)){
                temp.push(x);
            }
            if (Brackets.isRightBracket(x)){
                while(!temp.isEmpty() && !Brackets.isLeftBracket(temp.peek())){
                    output += temp.pop() + " ";
                }
                temp.pop();
            }
            if(Operator.isOperator(x)){
                if(temp.isEmpty()){
                    temp.push(x);
                    i+= x.length();
                    continue;
                }
                String top = temp.peek();
                if(Brackets.isLeftBracket(top) || Brackets.isRightBracket(top)){
                    temp.push(x);
                    i+=x.length();
                    continue;
                }
                int precedenceX = Operator.of(x).getRank();
                int precedenceTop = Operator.of(top).getRank();
                if(precedenceTop > precedenceX){
                    temp.push(x);
                }
                else{
                    while (!temp.isEmpty()){
                        top = temp.peek();
                        precedenceTop = Operator.of(top).getRank();
                        if(precedenceX >= precedenceTop){
                            output += temp.pop() + " ";
                        }
                        else break;
                    }
                    temp.push(x);
                }
            }
            i+= x.length();
        }
        while (!temp.isEmpty()){
            output += temp.pop() + " ";
        }
        return output.trim();
    }

    /**
     *This method takes the given string input and returns the Operator, Bracket, Integer, and Float at the given index
     *
     * @param s - a given string statement
     * @param start the given index
     * @return a String that could be a Operator, Bracket, Integers, and Floats.
     */
    public String nextToken(String s, int start) {
        int x = start;
        Converter.TokenBuilder token = new Converter.TokenBuilder();
        while (s.substring(x, x+1).equals(" ")) x++;

        if (Operator.isOperator(s.substring(x, x + 1)) ||Brackets.isRightBracket(s.substring(x, x+1)) || Brackets.isLeftBracket(s.substring(x, x+1))) {
            return s.substring(x, x + 1).trim();
        }
        else {
            while (x < s.length() &&!Operator.isOperator(s.substring(x, x + 1)) && !Brackets.isRightBracket(s.substring(x, x+1)) && !Brackets.isLeftBracket(s.substring(x, x+1))) {
                token.append(s.charAt(x));
                x++;
            }
            String operand = token.build();
            return operand.trim();
        }
    }

    /**
     *This method basically checks if the given input is a valid Operand by checking against methods specified in the Brackets and Operator Enum
     *
     * @param s the given string
     * @return a true or false value(boolean)
     */
    public boolean isOperand(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Brackets.isLeftBracket(s.substring(i, i + 1)) || Brackets.isRightBracket(s.substring(i, i + 1)) || Operator.isOperator(s.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }
}
