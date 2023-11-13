package org.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ExpressionTest {

    @Test
    public void getAllTokensRightAndSizeRight(){
        String str="3+ 4";
        Expression exp =new Expression();
        List<Token> tokens=exp.getTokens(str);
        assertEquals(new NumberToken(3), tokens.get(0));
        assertEquals(new Operation(OperationType.PlUS), tokens.get(1));
        assertEquals(new NumberToken(4),tokens.get(2));

        assertEquals(3, tokens.size());
    }
}