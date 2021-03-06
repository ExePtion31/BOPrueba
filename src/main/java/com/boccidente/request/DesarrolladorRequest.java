package com.boccidente.request;

import javax.validation.constraints.*;

public class DesarrolladorRequest {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    @Min(0)
    private int edad;
    @NotBlank
    private String correo;
    @NotBlank
    private long telefono;

    public DesarrolladorRequest() {
    }

    public DesarrolladorRequest(String nombre, String apellido, int edad, String correo, long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
    
}
