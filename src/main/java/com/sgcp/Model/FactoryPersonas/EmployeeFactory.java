package com.sgcp.Model.FactoryPersonas;

public class EmployeeFactory extends GeneralPersonFactory{

    @Override
    public PersonOP CrearPersona() {
        return new Empleado(0, null, null, null, null, 0, null, null);
    }
    
}
