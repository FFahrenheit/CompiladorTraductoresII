/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.resources;

/**
 *
 * @author ivan_
 */
public class TokenTypes {
    public static enum TokenType{
        RESERVADA,
        OPERADOR,
        ENTERO,
        REAL,
        CADENA,
        IDENTIFICADOR,
        AGRUPACION,
        NO_VALIDO,
        FIN
    };
}
