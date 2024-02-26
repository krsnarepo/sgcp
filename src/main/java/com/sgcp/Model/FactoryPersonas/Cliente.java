package com.sgcp.Model.FactoryPersonas;

public class Cliente extends Persona implements PersonOP{

    public Cliente(int id, String nombres, String apellidos, String direccion, String telefono, int dni) {
        super(id,nombres,apellidos,direccion,telefono,dni);
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
