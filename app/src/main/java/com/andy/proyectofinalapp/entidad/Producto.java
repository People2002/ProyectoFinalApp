package com.andy.proyectofinalapp.entidad;

public class Producto {

    int id;
    private String codigo;
    private String nombre, detallesNombre;
    private int cantidad, pasillo;

    public Producto(String codigo, String nombre, String detallesNombre, int cantidad, int pasillo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.detallesNombre = detallesNombre;
        this.cantidad = cantidad;
        this.pasillo = pasillo;
    }

    public Producto(int id, String codigo, String nombre, String detallesNombre, int cantidad, int pasillo) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.detallesNombre = detallesNombre;
        this.cantidad = cantidad;
        this.pasillo = pasillo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetallesNombre() {
        return detallesNombre;
    }

    public void setDetallesNombre(String detallesNombre) {
        this.detallesNombre = detallesNombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPasillo() {
        return pasillo;
    }

    public void setPasillo(int pasillo) {
        this.pasillo = pasillo;
    }
}
