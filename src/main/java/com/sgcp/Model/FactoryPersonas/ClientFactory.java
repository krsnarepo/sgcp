package com.sgcp.Model.FactoryPersonas;

public class ClientFactory extends GeneralPersonFactory{

    @Override
    public PersonOP CrearPersona() {
        return new Cliente(null, null, null, null, 0);
    }

}
