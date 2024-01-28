/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.controllers;

import compiladortraductoresii.models.TokenType;
import compiladortraductoresii.resources.Tokens;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ivan
 */
public class TokenAnalyzer {
    
    public static TokenType getTokenType(String token) {
        switch(token) {
            case "#define":
                return TokenType.CONSTANTE;
            case ";":
                return TokenType.PUNTO_Y_COMA;
            case ",":
                return TokenType.COMA;
            case "(":
                return TokenType.PARENTESIS_ABRIENDO;
            case ")":
                return TokenType.PARENTESIS_CERRANDO;
            case "{":
                return TokenType.LLAVE_ABRIENDO;
            case "}":
                return TokenType.LLAVE_CERRANDO;
            case "if":
                return TokenType.IGUAL;
            case "while":
                return TokenType.WHILE;
            case "return":
                return TokenType.RETURN;
            case "else":
                return TokenType.ELSE;
            case "for":
                return TokenType.FOR;
            case "+":
            case "-":
                return TokenType.OP_ADICION;
            case "*":
            case "/":
            case "<<":
            case ">>":
                return TokenType.OP_MULTIPLICACION;
            case "&&":
            case "||":
                return TokenType.OP_LOGICO;            
        }
        if (getOptions("int", "char", "double", "void", "float", "bool", "string").contains(token)) {
            return TokenType.TIPO_DE_DATO;
        }
        if (getOptions("<", ">", "<=", ">=", "==", "!=").contains(token)) {
            return TokenType.OP_RELACIONAL;
        }
        if (isNumber(token)) {
            return TokenType.NUMERO_ENTERO;
        }
        if (isRealNumber(token)) {
            return TokenType.NUMERO_REAL;
        }
        if (isIdentifier(token)) {
            return TokenType.IDENTIFICADOR;
        }
        if (isString(token)) {
            return TokenType.CADENA;
        }
        return TokenType.DESCONOCIDO;
    }
    
    public static ArrayList<String> getOptions(String... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }
    
    public static boolean isReserved(String token){
        return Tokens.palabrasReservadas.contains(token);
    }
    
    public static boolean isOperator(String token){
        return Tokens.operaciones.contains(token);
    }
    
    public static boolean isNumber(String token){
        try{
            Integer.parseInt(token);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    public static boolean isRealNumber(String token){
        try{
            Double.parseDouble(token);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    public static boolean isString(String token){
        return token.startsWith("\"") && token.endsWith("\"");
    }
    
    public static boolean isGrouping(String token){
        return Tokens.caracteresAgrupacion.contains(token);
    }
    
    public static boolean isIdentifier(String token){
        String ID_REGEX = "[_a-zA-Z]{1}[_a-zA-Z0-9]*";
        return token.matches(ID_REGEX);
    }
}
