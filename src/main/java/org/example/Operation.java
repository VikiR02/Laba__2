package org.example;

public record Operation(OperationType operationType)implements Token {
    @Override
    public TokenType type() {
        return TokenType.OPERATION;
    }
}
