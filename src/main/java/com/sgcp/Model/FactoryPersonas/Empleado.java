package com.sgcp.Model.FactoryPersonas;

public class Empleado extends Persona implements PersonOP{
    
    protected String Puesto;
    protected String Correo;

    public Empleado(String nombres, String apellidos, String direccion, String telefono, int dni, String puesto, String correo) {
        super(nombres, apellidos, direccion, telefono, dni);
        Puesto = puesto;
        Correo = correo;
    }

    @Override
    public void InsertarBD() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'InsertarBD'");
    }
    @Override
    public void ExtraerBD() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ExtraerBD'");
    }
}
