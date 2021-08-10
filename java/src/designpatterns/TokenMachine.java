package designpatterns;

import java.util.ArrayList;
import java.util.List;


public class TokenMachine
{
    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value)
    {
        Token t = new Token(value);
        tokens.add(t);
        return new Memento(tokens);
    }

    public Memento addToken(Token token)
    {
        Token t = new Token(token.getValue());
        this.tokens.add(t);
        return new Memento(this.tokens);
    }

    public void revert(Memento m)
    {
        this.tokens = m.getTokens();
    }
}

class Memento
{
    private List<Token> tokens = new ArrayList<>();

    public Memento(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Token> getTokens() {
        return tokens;
    }
}

class Token
{
    private int value = 0;

    public Token(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

