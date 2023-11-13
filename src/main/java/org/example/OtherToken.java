package org.example;

public record OtherToken(TokenType tokenType)implements Token {
    @Override
    public TokenType type() {
        return tokenType;
    }
}