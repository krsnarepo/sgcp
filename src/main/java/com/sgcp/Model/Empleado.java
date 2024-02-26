package com.sgcp.Model;

import java.sql.Connection;
import java.util.ArrayList;

import com.sgcp.Model.DAO.OperacionesBD;

public class Empleado extends Persona {
    
    private String Puesto;
    private String Correo;

    public String getPuesto() {
        return Puesto;
    }
    public void setPuesto(String puesto) {
        Puesto = puesto;
    }
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String correo) {
        Correo = correo;
    }

}
