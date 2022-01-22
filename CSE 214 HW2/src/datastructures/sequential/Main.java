package datastructures.sequential;
import applications.arithmetic.*;

public class Main {

    public static void main (String[] args) {
//        Stack<Integer> stack = new Stack<Integer>();
//        stack.push(37);
//        stack.push(99);
//        stack.push(12);
//
//        System.out.println("After push, size of the stack: " + stack.size());
//        System.out.println("Top is: " + stack.peek());
//
//        System.out.println("*** Testing pop ***");
//        while (!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
//
//        System.out.println("After pop, size of the stack: " + stack.size());



       System.out.println(DyckWord.isDyckWord("2 **{5 + (7 - 1)}"));

       ToPostfixConverter myConverter = new ToPostfixConverter();
       PostFixEvaluator evaluator = new PostFixEvaluator();
       ArithmeticExpression myExpression = new ArithmeticExpression("2++");


        String postFix = myConverter.convert(myExpression);
        String value = evaluator.evaluate(postFix);
        System.out.println(postFix);
        System.out.println(value);


        //System.out.println(myConverter.nextToken("2 *(5.0+(7−1))", 2));
    }
}

