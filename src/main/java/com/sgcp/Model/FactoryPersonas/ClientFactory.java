package com.sgcp.Model.FactoryPersonas;

public class ClientFactory extends GeneralPersonFactory{

    @Override
    public PersonOP CrearPersona() {
        return new Cliente(0,null, null, null, null, 0);
    }

}
