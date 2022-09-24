/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.models;

/**
 *
 * @author Usuario
 */
public class ErrorSintactico {
    private String error;
    private int linea;

    public ErrorSintactico(String error, int linea) {
        this.error = error;
        this.linea = linea;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }
    
    public String getMensaje(){
        return "Error en linea " + this.linea + " > " + this.error;
    }
}
