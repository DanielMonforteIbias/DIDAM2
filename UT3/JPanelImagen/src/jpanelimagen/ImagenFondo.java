/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimagen;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Tarde
 */
public class ImagenFondo implements Serializable{
    private File rutaImagen;
    private float opacidad;
    private float saturacion;
    public ImagenFondo(){
        
    }

    public ImagenFondo(File rutaImagen, float opacidad, float saturacion) {
        this.rutaImagen = rutaImagen;
        this.opacidad = opacidad;
        this.saturacion = saturacion;
        System.out.println(rutaImagen);
    }
    
    public File getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(File rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public float getOpacidad() {
        return opacidad;
    }

    public void setOpacidad(float opacidad) {
        this.opacidad = opacidad;
    }

    public float getSaturacion() {
        return saturacion;
    }

    public void setSaturacion(float saturacion) {
        this.saturacion = saturacion;
    }
    
}
