package com.sgcp.Model;

public class Inventario {
    private int ID;
    private String nombre;
    private String precioCompra;
    private String precioVenta;
    private String stock;
    private String idProveedor;
    private String idEmpleado;
    private String descripcion;
    
    public Inventario(int iD, String nombre, String precioCompra, String precioVenta, String stock, String idProveedor,
            String idEmpleado, String descripcion) {
        ID = iD;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.idProveedor = idProveedor;
        this.idEmpleado = idEmpleado;
        this.descripcion = descripcion;
    }

    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public String getStock() {
        return stock;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    
}
