[![Coverage Status](https://coveralls.io/repos/github/grcreutzberg/dice-api/badge.svg?branch=main)](https://coveralls.io/github/grcreutzberg/dice-api?branch=main)
![Repository size](https://img.shields.io/github/repo-size/grcreutzberg/dice-api.svg)
![GitHub last commit](https://img.shields.io/github/last-commit/grcreutzberg/dice-api.svg)

# Projeto RPG Dice Roller

Este projeto é uma API em Java usando o framework Spring Boot para rolagem de dados de RPG.

Com foco no em tornar acessível dados que fogem do padrão e que não estão mais disponíveis no mercado como por exemplo o sistema **Star Wars Fronteiras do Empério**.

*******
## Conteúdo
1. [Dados genéricos](#generaldice)
2. [Star Wars: Fronteiras do Império](#starwars)
3. ~~[Mutant: Ano Zero](#mutant)~~
4. [Exemplo de uso](#example)
5. [Demo](#demo)
6. [Histórico de lançamentos](#history)
7. [Tecnologias utilizadas](#tech)
8. [Contribuições](#contributions)

*******

<div id='generaldice'/>  

## Dados genéricos

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

<div id='starwars'/>  

## Dados Star Wars: Fronteiras do Império

### **GET /v1/dice/sw/force**

Realiza a rolagem dos dados de acordo com os parâmetros (*quantity* e *faces*) recebidos na URL e retorna um JSON com o resultado da rolagem.

- Quantity: quantidade de dados de Força que serão rolados, parâmetro opcional (Default = 1).

```curl
?quantity=3
```

| Dado  | Nome          |
|-------|---------------|
| <img alt="Forca" src="https://user-images.githubusercontent.com/20562320/231884660-abc77c25-43be-4826-bfc9-cc1b3f3416c7.png" width="100"/> | Dado de força |

Exemplo resultado:
```json
{
  "luz": 2,
  "negro": 3
}
```

| Resultado | Resultado            |
|-----------|----------------------|
| <img width="25" alt="Luz" src="https://user-images.githubusercontent.com/20562320/231887229-0896dc10-2269-49e1-8740-e20c0ef1c530.png">     | Pontos do lado Luz   |
| <img width="25" alt="Negro" src="https://user-images.githubusercontent.com/20562320/231887235-c61aae76-b132-4baa-868c-62943dfab90e.png">    | Pontos do lado Negro |

### **POST /v1/dice/sw/roll**

Realiza a rolagem dos dados de acordo com os parâmetros recebidos em um JSON e retorna um objeto JSON com o resultado da rolagem.

| Dado                                                                                                                                            | Nome         | Descrição                                            |
|-------------------------------------------------------------------------------------------------------------------------------------------------|--------------|------------------------------------------------------|
| <img alt="Habilidade" src="https://user-images.githubusercontent.com/20562320/231884534-c9044d45-c9e2-41c3-8685-c42c0d3527c3.png" width="100"/> | Habilidade   | quantidade de dados de Habilidade a serem rolados.   |
| <img alt="Proficiencia" src="https://user-images.githubusercontent.com/20562320/231884544-b391d26b-6d24-4c3c-9165-9ff84eadc1a9.png" width="100"/>                          | Proficiência | quantidade de dados de Proficiência a serem rolados. |
| <img alt="Dificuldade" src="https://user-images.githubusercontent.com/20562320/231884611-a30ed690-2507-4666-b284-dfeb9b2e9469.png" width="100"/>                           | Dificuldade  | quantidade de dados de Dificuldade a serem rolados.  |
| <img alt="Desafio" src="https://user-images.githubusercontent.com/20562320/231884630-9c1ef508-a9c2-46b5-aa44-f75ed71f736f.png" width="100"/>                               | Desafio      | quantidade de dados de Desafio a serem rolados.      |
| <img alt="Ampliacao" src="https://user-images.githubusercontent.com/20562320/231884502-22f66063-babb-4bc0-9fec-7f52d70cec29.png" width="100"/>                             | Ampliação    | quantidade de dados de Ampliação a serem rolados.    |
| <img alt="Contratempo" src="https://user-images.githubusercontent.com/20562320/231884586-39b2df5f-7d46-49bd-b0df-0228d368af2b.png" width="100"/>                           | Contratempo  | quantidade de dados de Contratempo a serem rolados.  |

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

| Dado  | Resultado  |
|-------|------------|
| <img width="36" alt="Sucesso" src="https://user-images.githubusercontent.com/20562320/231886077-b9857f1a-1795-4cd2-a4d3-33c8d7afc456.png"> | Sucessos   |
| <img width="36" alt="Vantagem" src="https://user-images.githubusercontent.com/20562320/231886097-c7d0eb56-2396-4eca-98f5-8a004d399549.png"> | Vantagens  |
| <img width="36" alt="Triunfo" src="https://user-images.githubusercontent.com/20562320/231886106-e2b8fed2-4fa0-4cbe-a7fc-d9810bc288d9.png"> | Triunfos   |
| <img width="36" alt="Fracasso" src="https://user-images.githubusercontent.com/20562320/231886120-9fbbfbdd-b7f8-442d-b553-d796c3a35f2b.png"> | Fracassos  |
| <img width="36" alt="Ameaca" src="https://user-images.githubusercontent.com/20562320/231886148-a21b4665-fc9c-4112-9cb6-9110cf3c67b4.png"> | Ameaças    |
| <img width="36" alt="Desespero" src="https://user-images.githubusercontent.com/20562320/231886154-4a47d73e-193e-4e01-b732-cd30e1ebce55.png"> | Desesperos |








<div id='example'/>

### Exemplo de uso

Alguns exemplos interessantes e úteis sobre como seu projeto pode ser utilizado.

**GET** `https://dice-api.up.railway.app/v1/dice/roll`

**GET** `https://dice-api.up.railway.app/v1/dice/roll?quantity=3&faces=12`

**GET** `https://dice-api.up.railway.app/v1/dice/sw/destiny`

**GET** `https://dice-api.up.railway.app/v1/dice/sw/destiny?quantity=4`

**POST** `https://dice-api.up.railway.app/v1/dice/sw/roll`

_Para mais exemplos, consulte a [Wiki][wiki]._

<div id='demo'/>

### Demo
https://dice-api.up.railway.app/


<div id='history'/>

### Histórico de lançamentos

* 1.0.0
  * Endpoint **GET /v1/dice/roll**
  * Endpoint **POST /v1/dice/sw/roll**
  * Endpoint **GET /v1/dice/sw/destiny**


<div id='tech'/>

### Tecnologias utilizadas

- Java 19
- Spring Boot
- ~~JUnit 5~~
- ~~Mockito~~

<div id='contributions'/>

### Contribuições

1. Faça o _fork_ do projeto (<https://github.com/grcreutzberg/dice-api/fork>)
2. Crie uma _branch_ para sua modificação (`git checkout -b feature/newChange`)
3. Faça o _commit_ (`git commit -am 'Add some feature'`)
4. _Push_ (`git push origin feature/newChange`)
5. Crie um novo _Pull Request_


[wiki]: https://github.com/grcreutzberg/dice-api/wiki