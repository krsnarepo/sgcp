package com.sgcp.Model.FactoryPersonas;

public abstract class Persona {
    protected int ID;
    protected String Nombres;
    protected String Apellidos;
    protected String Direccion;
    protected String Telefono;
    protected int DNI;

    public Persona(int id, String nombres, String apellidos, String direccion, String telefono, int dni){
        ID = id;
        Nombres = nombres;
        Apellidos = apellidos;
        Direccion = direccion;
        Telefono = telefono;
        DNI = dni;
    }
}
