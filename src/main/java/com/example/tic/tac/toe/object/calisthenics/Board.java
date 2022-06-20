package com.example.tic.tac.toe.object.calisthenics;

import com.example.tic.tac.toe.object.calisthenics.enums.Symbol;

import java.util.Arrays;


public class Board {
    private Symbol[][] board = new Symbol[3][3];

    Board() {
        for (Symbol[] row : board) Arrays.fill(row, Symbol.Empty);
    }

    boolean isFilled(Location location) {
        return !board[location.row - 1][location.col - 1].equals(Symbol.Empty);
    }

    void fill(Move move) {
        board[move.location.row - 1][move.location.col - 1] = move.symbol;
    }

    boolean isWon(Move move) {
        return isWonHorizontally(move) || isWonVertically(move) || isWonDiagonally(move);

    }

    boolean isWonHorizontally(Move move) {
        for (int i = 0; i < board.length; i++) {
            if (!board[move.location.row - 1][i].equals(move.symbol)) return false;
        }
        return true;
    }

    boolean isWonVertically(Move move) {
        for (int i = 0; i < board.length; i++) {
            if (!board[i][move.location.col - 1].equals(move.symbol)) return false;
        }
        return true;
    }

    boolean isWonDiagonallyStraight(Move move) {
        for (int i = 0; i < board.length; i++) {
            if (!board[i][i].equals(move.symbol)) return false;
        }

        return true;
    }

    boolean isWonDiagonallyReversed(Move move) {
        int j = board.length - 1;
        for (int i = 0; i < board.length; i++) {
            if (!board[j][i].equals(move.symbol)) return false;
            j--;
        }
        return true;
    }

    boolean isWonDiagonally(Move move) {
        return isWonDiagonallyStraight(move) || isWonDiagonallyReversed(move);
    }
}