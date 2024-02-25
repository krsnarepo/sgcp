package com.sgcp.Model.FactoryCitas;

import com.sgcp.Model.FactoryPersonas.Cliente;
import com.sgcp.Model.Resultado;

public class Cita {
    private String fecha;
    private Cliente solicitante;
    private Resultado result;

    public Cita(Cliente nuevo, String fecha){
        this.fecha = fecha;
        solicitante = nuevo;
    }

    public void AddResultado(Resultado resultado){
        this.result = resultado;
    }

}
