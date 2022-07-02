package com.andy.proyectofinalapp.entidad;

public class Registro {
    int id;
    private String MensajeRegistro;

    public Registro(String mensajeRegistro) {
        MensajeRegistro = mensajeRegistro;
    }

    public Registro(int id, String mensajeRegistro) {
        this.id = id;
        this.MensajeRegistro = mensajeRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensajeRegistro() {
        return MensajeRegistro;
    }

    public void setMensajeRegistro(String mensajeRegistro) {
        MensajeRegistro = mensajeRegistro;
    }
}
