package com.dice.controller;

import com.dice.service.DiceRollService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/dice")
public class DiceRollController {
    private final DiceRollService service;
    public DiceRollController(DiceRollService diceRollService) {
        this.service = diceRollService;
    }

    @GetMapping("/roll")
    public int[] rollDice(
            @RequestParam(name = "quantity", defaultValue = "1") int quantity,
            @RequestParam(name = "faces", defaultValue = "20") int faces
    ) {
        return service.rollDice(quantity, faces);
    }

}
