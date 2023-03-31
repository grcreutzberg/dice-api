package com.dice.controller;

import com.dice.service.DiceRollService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dice")
public class DiceRollController {
    private final DiceRollService diceRollService;
    public DiceRollController(DiceRollService diceRollService) {
        this.diceRollService = diceRollService;
    }

    @GetMapping("/roll")
    public int[] rollDice(
            @RequestParam(name = "quantity", defaultValue = "1") int quantity,
            @RequestParam(name = "faces", defaultValue = "6") int faces
    ) {
        return diceRollService.rollDice(quantity, faces);
    }
}
