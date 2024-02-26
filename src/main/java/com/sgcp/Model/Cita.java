package com.sgcp.Model;

public class Cita {
    private int id_cita;
    private String fecha;
    private Cliente solicitante;
    private int id_empleado;

    public Cita(int id_c, Cliente nuevo, String fecha, int id_e){
        id_cita = id_c;
        this.fecha = fecha;
        solicitante = nuevo;
        id_empleado = id_e;
    }

}
