package applications.arithmetic;
import datastructures.sequential.Stack;

/**
 * This class implements the Evaluator interface. This goal of this class is to take postfix expressions and evaluate them
 *
 * @author Nikhil Meruva
 */

public class PostFixEvaluator implements Evaluator {
    /**
     * Using a stack and a string, this method will pop and push strings of the given input to calculate the given postFix expression
     *
     * @param expression the given postfix expression
     * @return String value of a evaluation of the given expression
     */
    public String evaluate(String expression) {
        Stack<String> temp = new Stack<String>();
        String token = "";
        int i = 0;
        float value = 0;

        while (i < expression.length()) {
            if (expression.substring(i, i + 1).equals(" ")) {
                i += 1;
                continue;
            }
            token = nextToken(expression, i);
            if(isOperand(token)){
                temp.push(token);
            }
            else{
                String op2 = temp.pop();
                String op1 = temp.pop();

                switch (token){
                    case "+":
                        value = Float.parseFloat(op1) + Float.parseFloat(op2);
                        break;
                    case "-":
                        value = Float.parseFloat(op1) - Float.parseFloat(op2);
                        break;
                    case "*":
                        value = Float.parseFloat(op1) * Float.parseFloat(op2);
                        break;
                    case "/":
                        value = Float.parseFloat(op1) / Float.parseFloat(op2);
                }
                temp.push(Float.toString(value));
            }
            i += token.length();
        }
        return temp.pop();
    }

    /**
     * This method takes the given string input and returns the Operator, Bracket, Integer, and Float at the given index
     * This method is the exact same found in the ToPostfixConverter class but made private
     *
     * @param s - a given string statement
     * @param start - the given index
     * @return a String that could be a Operator, Bracket, Integers, and Floats.
     */
    private String nextToken(String s, int start) {
        int x = start;
        Converter.TokenBuilder token = new Converter.TokenBuilder();
        while (s.substring(x, x+1).equals(" ")) x++;

        if (Operator.isOperator(s.substring(x, x + 1)) ||Brackets.isRightBracket(s.substring(x, x+1)) || Brackets.isLeftBracket(s.substring(x, x+1))) {
            return s.substring(x, x + 1).trim();
        }
        else {
            while (!Operator.isOperator(s.substring(x, x + 1)) && !Brackets.isRightBracket(s.substring(x, x+1)) && !Brackets.isLeftBracket(s.substring(x, x+1)) && !(s.substring(x, x+1).equals(" "))) {
                token.append(s.charAt(x));
                x++;
            }
            String operand = token.build();
            return operand.trim();
        }

    }
    /**
     *This method basically checks if the given input is a valid Operand by checking against methods specified in the Brackets and Operator Enum
     *This method is the exact same found in the ToPostfixConverter class but made private
     *
     * @param s the given string
     * @return a true or false value(boolean)
     */
    private boolean isOperand(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Brackets.isLeftBracket(s.substring(i, i + 1)) || Brackets.isRightBracket(s.substring(i, i + 1)) || Operator.isOperator(s.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }

}
