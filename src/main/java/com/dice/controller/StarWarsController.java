package com.dice.controller;

import com.dice.DTO.DiceSwDTO;
import com.dice.DTO.ResultadoSwDTO;
import com.dice.DTO.ResultadoSwForceDTO;
import com.dice.service.StarWarsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/dice/sw")
public class StarWarsController {

    private final StarWarsService service;
    public StarWarsController(StarWarsService starWarsService) {
        this.service = starWarsService;
    }

    @GetMapping("/force")
    public ResponseEntity<ResultadoSwForceDTO> rollForce(
            @RequestParam(name = "quantity", defaultValue = "1") int quantity
    ) {
        return new ResponseEntity<ResultadoSwForceDTO>(service.rollForce(quantity), HttpStatus.OK);
    }

    @PostMapping("/roll")
    public ResponseEntity<ResultadoSwDTO> rollDice(@RequestBody DiceSwDTO dice) {
        return new ResponseEntity<ResultadoSwDTO>(service.rollSwDice(dice), HttpStatus.OK);
    }

}
