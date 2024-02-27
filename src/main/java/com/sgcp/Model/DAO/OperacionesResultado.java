package com.sgcp.Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sgcp.Model.Resultado;

public class OperacionesResultado {
    private Connection bd;

    public OperacionesResultado(Connection bd) {
        this.bd = bd;
    }

    public ArrayList<Resultado> getAllResultado() {
        String query = "SELECT * FROM RESULTADO";
        ArrayList<Resultado> resultados = new ArrayList<>();

        try {
            Statement statement = bd.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int idResultado = resultSet.getInt("ID_RESULTADO");
                int idCita = resultSet.getInt("ID_CITA");
                String result = resultSet.getString("RESULTADO");

                Resultado resultado = new Resultado(idResultado, idCita, result);
                resultados.add(resultado);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los resultados: " + e.getMessage());
        }

        return resultados;
    }
}
