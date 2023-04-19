package com.dice.service;

import com.dice.model.Dice;
import org.springframework.stereotype.Service;

@Service
public class DiceRollService {

    public DiceRollService() {}

    public int[] rollDice(int numberOfDice, int faces) {
        if (numberOfDice <= 0) {
            throw new IllegalArgumentException("A quantidade de dados deve ser maior que zero.");
        }

        int[] results = new int[numberOfDice];
        Dice dice = new Dice(faces);

        for (int i = 0; i < numberOfDice; i++) {
            results[i] = dice.roll();
        }

        return results;
    }

}

