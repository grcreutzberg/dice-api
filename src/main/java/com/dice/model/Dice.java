package com.dice.model;

public class Dice {
    private int nFaces;

    public Dice(int nFaces) {
        if (nFaces < 2) {
            throw new IllegalArgumentException("O dado deve ter pelo menos duas faces.");
        }
        this.nFaces = nFaces;
    }

    public int roll() {
        return (int) (Math.random() * nFaces) + 1;
    }
}

