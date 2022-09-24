/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.resources;

import compiladortraductoresii.models.ErrorSintactico;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ErrorList {
    private ArrayList<ErrorSintactico> errores;

    public ErrorList() {
        errores = new ArrayList<>();
    }

    public ArrayList<ErrorSintactico> getErrores() {
        return errores;
    }

    public void setErrores(ArrayList<ErrorSintactico> errores) {
        this.errores = errores;
    }
    
    public void pushError(ErrorSintactico error){
        this.errores.add(error);
    }
    
}
