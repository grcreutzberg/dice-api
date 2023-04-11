[![Coverage Status](https://coveralls.io/repos/github/grcreutzberg/dice-api/badge.svg?branch=main)](https://coveralls.io/github/grcreutzberg/dice-api?branch=main)

# Projeto RPG Dice Roller

Este projeto é uma API em Java usando o framework Spring Boot para rolagem de dados de RPG com foco no sistema **Star Wars Fronteiras do Empério**.

## Endpoints

### *GET /v1/dice/roll*

Realiza a rolagem dos dados de acordo com os parâmetros (*quantity* e *faces*) recebidos na URL e retorna um JSON com o resultado da rolagem.

- Quantity: quantidade de dados que serão rolados, parâmetro opcional (Default = 1).
- Faces: quantidade de faces dos dados que serão rolados, parâmetro opcional (Default = 20).

Exemplo parâmatro:
```curl
?quantity=3&faces=12
```

Exemplo resultado:
```json
[3,10,8]
```

### *GET /v1/dice/sw/destiny*

Realiza a rolagem dos dados de acordo com os parâmetros (*quantity* e *faces*) recebidos na URL e retorna um JSON com o resultado da rolagem.

- Quantity: quantidade de dados de Destino que serão rolados, parâmetro opcional (Default = 1).

```curl
?quantity=3
```

Exemplo resultado:
```json
{
  "luz": 2,
  "negro": 3
}
```

### *POST /v1/dice/sw/roll*

Realiza a rolagem dos dados de acordo com os parâmetros recebidos em um JSON e retorna um objeto JSON com o resultado da rolagem.


Exemplo parâmatro JSON:
```json
{
  "habilidade": 3,
  "proficiencia": 1,
  "dificuldade": 2,
  "desafio": 1,
  "ampliacao": 1,
  "contratempo": 2
}
```

- Habilidade: quantidade de dados de Habilidade a serem rolados.
- Proficiência: quantidade de dados de Proficiência a serem rolados.
- Dificuldade: quantidade de dados de Dificuldade a serem rolados.
- Desafio: quantidade de dados de Desafio a serem rolados.
- Ampliação: quantidade de dados de Ampliação a serem rolados.
- Contratempo: quantidade de dados de Contratempo a serem rolados.


Exemplo retorno JSON:
```json
{
    "sucessos": 3,
    "triunfos": 0,
    "vantagens": 0,
    "fracassos": 0,
    "desesperos": 1,
    "ameacas": 2
}
```

- Sucessos: quantidade de Sucessos.
- Triunfos: quantidade de Triunfos.
- Vantagens: quantidade de Vantagens.
- Fracassos: quantidade de Fracassos.
- Ameaças: quantidade de Ameaças.
- Desesperos: quantidade de Desesperos.

## Tecnologias utilizadas

- Java 19
- Spring Boot
- ~~JUnit 5~~
- ~~Mockito~~

