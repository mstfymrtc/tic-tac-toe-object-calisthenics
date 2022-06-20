package com.example.tic.tac.toe.object.calisthenics;

import com.example.tic.tac.toe.object.calisthenics.enums.GameState;
import com.example.tic.tac.toe.object.calisthenics.enums.Symbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToeTests {

    private TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        this.ticTacToe = new TicTacToe();
    }

    @Test
    void should_return_invalid_operation_when_plays_o_first() {
        assertEquals(GameState.INVALID_OPERATION, ticTacToe.play(new Move(Symbol.O, new Location(2, 2))));
    }

    @Test
    void should_return_success_state_when_plays_x_first() {
        assertEquals(GameState.SUCCESS, ticTacToe.play(new Move(Symbol.X, new Location(2, 2))));
    }

    @Test
    void should_return_success_state_when_plays_x_first_and_then_plays_o() {
        // when
        ticTacToe.play(new Move(Symbol.X, new Location(2, 2)));

        // then
        assertEquals(GameState.SUCCESS, ticTacToe.play(new Move(Symbol.O, new Location(1, 1))));
    }

    @Test
    void should_return_invalid_operation_when_plays_x_consequently() {
        // when
        ticTacToe.play(new Move(Symbol.X, new Location(2, 2)));

        // then
        assertEquals(GameState.INVALID_OPERATION, ticTacToe.play(new Move(Symbol.X, new Location(1, 1))));
    }

    @Test
    void should_return_invalid_operation_when_plays_O_consequently() {
        // when
        ticTacToe.play(new Move(Symbol.O, new Location(2, 2)));

        // then
        assertEquals(GameState.INVALID_OPERATION, ticTacToe.play(new Move(Symbol.O, new Location(1, 1))));
    }

    @Test
    void should_return_invalid_operation_when_plays_to_already_filled_area() {
        // when
        ticTacToe.play(new Move(Symbol.X, new Location(2, 2)));

        // then
        assertEquals(GameState.INVALID_OPERATION, ticTacToe.play(new Move(Symbol.O, new Location(2, 2))));
    }

    @Test
    void should_return_won_state_when_player_x_wins_horizontally() {
        // when
        ticTacToe.play(new Move(Symbol.X, new Location(2, 1)));
        ticTacToe.play(new Move(Symbol.O, new Location(3, 2)));
        ticTacToe.play(new Move(Symbol.X, new Location(2, 2)));
        ticTacToe.play(new Move(Symbol.O, new Location(1, 1)));

        // then
        assertEquals(GameState.WON, ticTacToe.play(new Move(Symbol.X, new Location(2, 3))));
    }

    @Test
    void should_return_won_state_when_player_x_wins_vertically() {
        // when
        ticTacToe.play(new Move(Symbol.X, new Location(1, 1)));
        ticTacToe.play(new Move(Symbol.O, new Location(2, 2)));
        ticTacToe.play(new Move(Symbol.X, new Location(2, 1)));
        ticTacToe.play(new Move(Symbol.O, new Location(3, 2)));

        // then
        assertEquals(GameState.WON, ticTacToe.play(new Move(Symbol.X, new Location(3, 1))));
    }

    @Test
    void should_return_won_state_when_player_x_wins_diagonally() {
        // when
        ticTacToe.play(new Move(Symbol.X, new Location(2, 1)));
        ticTacToe.play(new Move(Symbol.O, new Location(1, 1)));
        ticTacToe.play(new Move(Symbol.X, new Location(1, 2)));
        ticTacToe.play(new Move(Symbol.O, new Location(2, 2)));
        ticTacToe.play(new Move(Symbol.X, new Location(3, 1)));

        // then
        assertEquals(GameState.WON, ticTacToe.play(new Move(Symbol.O, new Location(3, 3))));
    }
}