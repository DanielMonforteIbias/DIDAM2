/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.logica;

/**
 *
 * @author Tarde
 */
public class Proveedor {
    private int numeroProveedor;
    private String nombreEmpresa;
    private String direccion;
    private String email;
    private String telefono;
    private String nacionalidad;

    public Proveedor(int numeroProveedor, String nombreEmpresa, String direccion, String email, String telefono, String nacionalidad) {
        this.numeroProveedor = numeroProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.nacionalidad = nacionalidad;
    }

    public int getNumeroProveedor() {
        return numeroProveedor;
    }

    public void setNumeroProveedor(int numeroProveedor) {
        this.numeroProveedor = numeroProveedor;
    }


    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
}
