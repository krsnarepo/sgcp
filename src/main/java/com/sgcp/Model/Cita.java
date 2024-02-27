package com.sgcp.Model;

public class Cita {
    private int id_cita;
    private String fecha;
    private int id_cliente;
    private int id_empleado;

    public Cita(int id_c, int id_client, String fecha, int id_e){
        id_cita = id_c;
        this.fecha = fecha;
        id_cliente = id_client;
        id_empleado = id_e;
    }

    public int getID() {
        return id_cita;
    }

    public String getFecha() {
        return fecha;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    

}
