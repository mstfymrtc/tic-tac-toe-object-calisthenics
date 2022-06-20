package com.example.tic.tac.toe.object.calisthenics;

import com.example.tic.tac.toe.object.calisthenics.enums.Symbol;

public class Move {
    public Symbol symbol;
    public Location location;

    public Move(Symbol symbol, Location location) {
        this.symbol = symbol;
        this.location = location;
    }

}
