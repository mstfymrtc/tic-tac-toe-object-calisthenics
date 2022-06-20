package com.example.tic.tac.toe.object.calisthenics;

import com.example.tic.tac.toe.object.calisthenics.enums.GameState;
import com.example.tic.tac.toe.object.calisthenics.enums.Symbol;

public class TicTacToe {
    private Symbol lastSymbol = Symbol.O;
    private Board board = new Board();

    public GameState play(Move move) {
        if (lastSymbol.equals(move.symbol)) return GameState.INVALID_OPERATION;
        
        if (board.isFilled(move.location)) return GameState.INVALID_OPERATION;
        board.fill(move);

        lastSymbol = move.symbol;

        if (board.isWon(move))
            return GameState.WON;

        return GameState.SUCCESS;
    }
}
