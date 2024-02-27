package com.sgcp.Model;

public class Resultado {
    private int id_resultado;
    private int id_cita;
    private String result;
    
    public Resultado(int id_resultado, int id_cita, String result) {
        this.id_resultado = id_resultado;
        this.id_cita = id_cita;
        this.result = result;
    }

    public int getId_resultado() {
        return id_resultado;
    }

    public int getId_cita() {
        return id_cita;
    }

    public String getResult() {
        return result;
    }

}
