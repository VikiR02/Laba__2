package org.example;

import java.util.List;

public class Calculator {
    private final Expression expression=new Expression();
    private final PostfixConverter converter=new PostfixConverter();
    private final Stack stack=new Stack();
    public int calculate(String exp){
        List<Token> tokens=expression.getTokens(exp);
        var postfixExpression=converter.convertToPostfix(tokens);
        var result =stack.evaluate(postfixExpression);
        System.out.println(result);
        return result;
    }
}
