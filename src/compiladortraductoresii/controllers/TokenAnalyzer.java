/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.controllers;

import compiladortraductoresii.resources.Tokens;

/**
 *
 * @author Usuario
 */
public class TokenAnalyzer {
    
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
    
    public static boolean isEnd(String token){
        return token.equals(";");
    }
}
