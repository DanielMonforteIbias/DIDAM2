/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Danim2205
 */
public class Producto implements Serializable{
    private int codigo;
    private String nombre;
    private String descripcion;
    private int cantidad;
    private float precio;
    private int codigoCategoria;
    private String nitProveedor;

    public Producto() {
        this.codigo=0;
        this.nombre="";
        this.descripcion="";
        this.cantidad=0;
        this.precio=0.0f;
        this.codigoCategoria=0;
        this.nitProveedor="";
    }

    public Producto(int codigo, String nombre, String descripcion, int cantidad, float precio, int codigoCategoria, String nitProveedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.codigoCategoria = codigoCategoria;
        this.nitProveedor = nitProveedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(String nitProveedor) {
        this.nitProveedor = nitProveedor;
    }
    
    
}
