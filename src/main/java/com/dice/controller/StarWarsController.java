package com.dice.controller;

import com.dice.DTO.DiceSwDTO;
import com.dice.DTO.ResultadoSwDTO;
import com.dice.DTO.ResultadoSwForceDTO;
import com.dice.service.DiceRollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/dice/sw")
public class StarWarsController {

    private final DiceRollService diceRollService;
    public StarWarsController(DiceRollService diceRollService) {
        this.diceRollService = diceRollService;
    }

    @GetMapping("/force")
    public ResponseEntity<ResultadoSwForceDTO> rollForce(
            @RequestParam(name = "quantity", defaultValue = "1") int quantity
    ) {
        return new ResponseEntity<ResultadoSwForceDTO>(diceRollService.rollForce(quantity), HttpStatus.OK);
    }

    @PostMapping("/roll")
    public ResponseEntity<ResultadoSwDTO> rollDice(@RequestBody DiceSwDTO dice) {
        return new ResponseEntity<ResultadoSwDTO>(diceRollService.rollSwDice(dice), HttpStatus.OK);
    }

}
