package org.example;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostfixConverter {

    /**
     * Функция конвертирования в постфиксную форму
     *  @param source -Список токенов
     * @return List<Token> cписок токенов в постфиксной форме
     **/
    public List<Token> convertToPostfix(List<Token> source) {
        List<Token> postfixExpression = new ArrayList<>();
        Deque<Token> operationStack = new LinkedList<>();
        for (Token token : source) {
            switch (token.type()) {
                case NUMBER -> postfixExpression.add(token);
                case OPEN -> operationStack.push(token);
                case CLOSE -> {
                    while (!operationStack.isEmpty() && operationStack.peek().type() != TokenType.OPEN) {
                        postfixExpression.add(operationStack.pop());
                    }
                }
                case OPERATION -> {
                    while (!operationStack.isEmpty() && getPriority(operationStack.peek()) >= getPriority(token)) {
                        postfixExpression.add(operationStack.pop());
                    }
                    operationStack.push(token);
                }
            }
        }
        while (!operationStack.isEmpty()){
            postfixExpression.add(operationStack.pop());
        }return postfixExpression;
    }
    /**
     * Функция установки приоритета операций
     *  @param token -Список токенов
     * @return приоритет операции
     **/
    private int getPriority(Token token){
        if (token instanceof Operation operation){
            return switch (operation.operationType()){
                case PlUS,MINUS-> 1;
                case MULTIPLY,DIVIDE -> 2;
            };
        }
        return 0;
    }
}
