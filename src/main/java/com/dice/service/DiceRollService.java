package com.dice.service;

import com.dice.DTO.DiceSwDTO;
import com.dice.DTO.ResultadoSwDTO;
import com.dice.DTO.ResultadoSwForceDTO;
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
    };

    public ResultadoSwDTO rollSwDice(DiceSwDTO dice) {
        int success = 0;
        int triumph = 0;
        int advantage = 0;
        int failure = 0;
        int despair = 0;
        int threat = 0;

        // Obter os valores para cada tipo de dado.
        int boost = dice.getAmpliacao();
        int ability = dice.getHabilidade();
        int proficiency = dice.getProficiencia();
        int setback = dice.getContratempo();
        int difficulty = dice.getDificuldade();
        int challenge = dice.getDesafio();

        // Calcular os resultados dos dados.
        for (int i = 0; i < boost; i++) {
            Dice boostDice = new Dice(6);
            int result = boostDice.roll();
            if (result == 1 || result == 2 ) {
                // Do nothing
            } else if (result == 3) {
                success += 1;
            } else if (result == 4) {
                success += 1;
                advantage += 1;
            } else if (result == 5) {
                advantage += 2;
            } else if (result == 6) {
                advantage += 1;
            }
        }

        for (int i = 0; i < ability; i++) {
            Dice abilityDice = new Dice(8);
            int result = abilityDice.roll();
            if (result == 1) {
                // Do nothing
            } else if (result == 2 || result == 3) {
                success += 1;
            } else if (result == 4) {
                success += 2;
            } else if (result == 5 || result == 6) {
                advantage += 1;
            } else if (result == 7) {
                success += 1;
                advantage += 1;
            } else if (result == 8) {
                advantage += 2;
            }
        }

        for (int i = 0; i < proficiency; i++) {
            Dice proficiencyDice = new Dice(12);
            int result = proficiencyDice.roll();
            if (result == 1) {
                // Do nothing
            } else if (result == 2 || result == 3) {
                success += 1;
            } else if (result == 4 || result == 5) {
                success += 2;
            } else if (result == 6) {
                advantage += 1;
            } else if (result == 7 || result == 8 || result == 9) {
                success += 1;
                advantage += 1;
            } else if (result == 10 || result == 11) {
                advantage += 2;
            } else if (result == 12) {
                triumph += 1;
            }
        }

        for (int i = 0; i < setback; i++) {
            Dice setbackDice = new Dice(6);
            int result = setbackDice.roll();
            if (result == 1 || result == 2) {
                // Do nothing
            } else if (result == 3 || result == 4) {
                failure += 1;
            } else if (result == 5 || result == 6) {
                threat += 1;
            }
        }

        for (int i = 0; i < difficulty; i++) {
            Dice difficultyDice = new Dice(8);
            int result = difficultyDice.roll();
            if (result == 1) {
                // Do nothing
            } else if (result == 2) {
                failure += 1;
            } else if (result == 3) {
                failure += 2;
            } else if (result == 4 || result == 5 || result == 6) {
                threat += 1;
            } else if (result == 7) {
                threat += 2;
            } else if (result == 8) {
                failure += 1;
                threat += 1;
            }
        }

        for (int i = 0; i < challenge; i++) {
            Dice challengeDice = new Dice(12);
            int result = challengeDice.roll();
            if (result == 1) {
                // Do nothing
            } else if (result == 2 || result == 3) {
                failure += 1;
            } else if (result == 4 || result == 5) {
                failure += 2;
            } else if (result == 6 || result == 7) {
                threat += 1;
            } else if (result == 8 || result == 9) {
                failure += 1;
                threat += 1;
            } else if (result == 10 || result == 11) {
                threat += 2;
            } else if (result == 12) {
                despair += 1;
            }
        }

        return getResultSwDice(success, triumph, advantage, failure, despair, threat);
    }

    private ResultadoSwDTO getResultSwDice(int success, int triumph, int advantage, int failure, int despair, int threat) {
        ResultadoSwDTO diceResult = new ResultadoSwDTO();
        if (success - failure > 0) {
            diceResult.setSucessos(success - failure);
            diceResult.setFracassos(0);
        } else if (success - failure < 0) {
            diceResult.setSucessos(0);
            diceResult.setFracassos(failure - success);
        } else {
            diceResult.setSucessos(0);
            diceResult.setFracassos(0);
        }

        if (advantage - threat > 0) {
            diceResult.setVantagens(advantage - threat);
            diceResult.setAmeacas(0);
        } else if (advantage - threat < 0) {
            diceResult.setVantagens(0);
            diceResult.setAmeacas(threat - advantage);
        } else {
            diceResult.setVantagens(0);
            diceResult.setAmeacas(0);
        }

        if (triumph - despair > 0) {
            diceResult.setTriunfos(triumph - despair);
            diceResult.setDesesperos(0);
        } else if (triumph - despair < 0) {
            diceResult.setTriunfos(0);
            diceResult.setDesesperos(despair - triumph);
        } else {
            diceResult.setTriunfos(0);
            diceResult.setDesesperos(0);
        }
        return diceResult;
    }

    public ResultadoSwForceDTO rollForce(int quantity) {
        int light = 0;
        int dark = 0;

        for (int i = 0; i < quantity; i++) {
            Dice challengeDice = new Dice(12);
            int result = challengeDice.roll();
            if (result == 1 || result == 2 || result == 3 || result == 4 || result == 5 || result == 6) {
                dark += 1;
            } else if (result == 7) {
                dark += 2;
            } else if (result == 8 || result == 9) {
                light += 1;
            } else if (result == 10 || result == 11 || result == 12) {
                light += 2;
            }
        }

        ResultadoSwForceDTO forceResult = new ResultadoSwForceDTO();
        forceResult.setLuz(light);
        forceResult.setNegro(dark);
        return  forceResult;
    }
}

