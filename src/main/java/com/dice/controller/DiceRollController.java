package com.dice.controller;

import com.dice.DTO.DiceSwDTO;
import com.dice.DTO.ResultadoSwDTO;
import com.dice.service.DiceRollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/sw/roll")
    public ResponseEntity<ResultadoSwDTO> rollDice(@RequestBody DiceSwDTO dice) {
        return new ResponseEntity<ResultadoSwDTO>(diceRollService.rollSwDice(dice), HttpStatus.OK);
    }
}
