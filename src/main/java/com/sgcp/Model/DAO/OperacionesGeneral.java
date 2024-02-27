package com.sgcp.Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class OperacionesGeneral {

    private static Connection bd;

    public static void executeUpdateQuery(String query, Object... params) {
        try (PreparedStatement ps = bd.prepareStatement(query)) {
            // Set parameters
            for (int i = 0; i < params.length; i++) {
                Object param = params[i];
                if (param instanceof String) {
                    ps.setString(i + 1, (String) param);
                } else if (param instanceof Long) {
                    ps.setLong(i + 1, (Long) param);
                } 
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public static boolean existsEntity(String id, String entityName, String entityNameID) {
        String query = "SELECT COUNT(*) FROM " + entityName + " WHERE " + entityNameID + " = ?";

        try (PreparedStatement ps = bd.prepareStatement(query)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
        }
        return false;
    }

    public static void setConnection(Connection con) {
        bd = con;
    }

    public static void Close() {
        try {
            bd.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
