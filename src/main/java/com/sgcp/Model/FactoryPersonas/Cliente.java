package com.sgcp.Model.FactoryPersonas;

public class Cliente extends Persona implements PersonOP{

    public Cliente(String nombres, String apellidos, String direccion, String telefono, int dni) {
        super(nombres,apellidos,direccion,telefono,dni);
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
