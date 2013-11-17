/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Fernando
 */
public class Eleccion {
    private String nombre, tipo, nucleo;
    
    Eleccion(){
        nombre = "";
        tipo ="";
        nucleo = "";
    }
    
    Eleccion(String nombre, String tipo, String nucleo){
        this.nombre = nombre;
        this.tipo = tipo;
        this.nucleo = nucleo;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
    
    public String toString2(){
        return "(eleccion (tipo \"" + tipo.toLowerCase() + "\") (nucleo \"" + nucleo.toLowerCase() + "\"))";
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nucleo
     */
    public String getNucleo() {
        return nucleo;
    }

    /**
     * @param nucleo the nucleo to set
     */
    public void setNucleo(String nucleo) {
        this.nucleo = nucleo;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
