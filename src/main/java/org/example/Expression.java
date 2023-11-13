package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Expression {
    private final static String DEL = " +-*/()";
    /**
     * Функция получения строку с выражение
     *  @param source - заданная строка
     * @return возвращает список всех нужных элементов , с помощью которых будет посчитано выражение
     */
    public List<Token> getTokens(String source) {
        var tokenizer = new StringTokenizer(source, DEL, true);
        List<Token> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            var token = tokenizer.nextToken();
            if (token.isBlank()) {
                continue;
            } else if (isNumber(token)) {
                tokens.add(new NumberToken(Integer.parseInt(token)));
                continue;
            }
            tokens.add(
                    switch (token) {
                        case "+" -> new Operation(OperationType.PlUS);
                        case "-" -> new Operation(OperationType.MINUS);
                        case "*" -> new Operation(OperationType.MULTIPLY);
                        case "/" -> new Operation(OperationType.DIVIDE);
                        case "(" -> new OtherToken(TokenType.OPEN);
                        case ")" -> new OtherToken(TokenType.CLOSE);
                        default -> throw new RuntimeException();
                    }
            );
        }
        return tokens;
    }
    /**
     * Функция проверки на число
     *  @param token- проверяемая строка
     * @return false если это не число и true если число
     */
    private boolean isNumber(String token) {
        for (int i = 0; i < token.length();i++) {
            if(!Character.isDigit(token.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
