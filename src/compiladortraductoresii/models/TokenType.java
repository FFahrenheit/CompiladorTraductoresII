/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.models;

/**
 *
 * @author ivan_
 */
public enum TokenType {
    TIPO_DE_DATO ("Tipo de dato"),
    IDENTIFICADOR ("Identificador"),
    CONSTANTE ("Constante"),
    PUNTO_Y_COMA ("Punto y coma"),
    COMA ("Coma"),
    PARENTESIS_ABRIENDO ("Parentesis abriendo"),
    PARENTESIS_CERRANDO ("Parentesis cerrando"),
    LLAVE_ABRIENDO ("Llave abriendo"),
    LLAVE_CERRANDO ("Llave cerrando"),
    IGUAL ("Operador igual"),
    IF ("Sentencia if"),
    WHILE ("Sentencia while"),
    RETURN ("Sentencia return"),
    ELSE ("Sentencia else"),
    FOR ("For"),
    OP_ADICION ("Operador adición"),
    OP_MULTIPLICACION ("Operador multiplicacion"),
    OP_LOGICO ("Operardor logico"),
    OP_ASIGNACION ("Operador de asignacion"),
    OP_RELACIONAL ("Operador relacional"),
    SIGNO_DOLAR ("Signo de dolar"),
    NUMERO_ENTERO ("Numero entero"),
    NUMERO_REAL ("Numero real"),
    CADENA ("Cadena"),
    DESCONOCIDO ("Desconocido");
    
    private final String label;
    
    private TokenType(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return this.label;
    }
}
