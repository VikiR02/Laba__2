package org.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Stack {
    /**
     * Функция вычисления выражения
     *  @param postfixExpression -Список токенов в постфиксной форме
     * @return значение выражения
     **/
    public int evaluate(List<Token> postfixExpression){
        Deque<Integer> valueStack =new LinkedList<>();
        for(Token token:postfixExpression){
            if(token instanceof NumberToken number){
                valueStack.push(number.value());
            }else if(token instanceof Operation operation){
                var right =valueStack.pop();
                var left =valueStack.pop();
                var result =switch (operation.operationType()){
                    case PlUS -> left+right;
                    case MINUS -> left-right;
                    case MULTIPLY -> left*right;
                    case DIVIDE -> {
                        if(right==0){
                            throw  new RuntimeException("zero");
                        }
                        yield  left/right;
                    }
                };
                valueStack.push(result);
            }
        }
        return valueStack.pop();
    }
}
