package com.dice.DTO;

public class ResultadoSwDTO {

    private int sucessos = 0;
    private int triunfos = 0;
    private int vantagens = 0;
    private int fracassos = 0;
    private int desesperos = 0;
    private int ameacas = 0;

    public int getSucessos() {
        return sucessos;
    }

    public void setSucessos(final int sucessos) {
        this.sucessos = sucessos;
    }

    public int getTriunfos() {
        return triunfos;
    }

    public void setTriunfos(final int triunfos) {
        this.triunfos = triunfos;
    }

    public int getVantagens() {
        return vantagens;
    }

    public void setVantagens(final int vantagens) {
        this.vantagens = vantagens;
    }

    public int getFracassos() {
        return fracassos;
    }

    public void setFracassos(final int fracassos) {
        this.fracassos = fracassos;
    }

    public int getDesesperos() {
        return desesperos;
    }

    public void setDesesperos(final int desesperos) {
        this.desesperos = desesperos;
    }

    public int getAmeacas() {
        return ameacas;
    }

    public void setAmeacas(final int ameacas) {
        this.ameacas = ameacas;
    }
}
