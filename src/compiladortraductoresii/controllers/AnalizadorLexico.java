/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.controllers;

import compiladortraductoresii.models.TokenLexico;
import java.util.ArrayList;
import java.util.Arrays;
import compiladortraductoresii.resources.TokenTypes.TokenType;

/**
 *
 * @author Usuario
 */
public class AnalizadorLexico {
    
    private ArrayList<String> tokens;
    private ArrayList<TokenLexico> types;

    public ArrayList<String> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<String> tokens) {
        this.tokens = tokens;
    }
    
    public AnalizadorLexico(String input){
        String[] partes = input.split("[\\n| |\t]");
        
        this.tokens = new ArrayList<>(Arrays.asList(partes));
        
        this.tokens.removeIf(t -> t.isEmpty());
        

    }
    
    public ArrayList<TokenLexico> getTokenTypes(){
        this.types = new ArrayList<>();
        
        for(String token : this.tokens){
            TokenLexico type;
            if(TokenAnalyzer.isReserved(token)){
                type = new TokenLexico(token, "Palabra reservada");
            }else if(TokenAnalyzer.isOperator(token)){
                type = new TokenLexico(token, "Operador");
            }else if(TokenAnalyzer.isNumber(token)){
                type = new TokenLexico(token, "Numero entero");
            }else if(TokenAnalyzer.isRealNumber(token)){
                type = new TokenLexico(token, "Numero real");
            }else if(TokenAnalyzer.isString(token)){
                type = new TokenLexico(token, "Cadena de " + token.length() + " caracteres");
            }else if(TokenAnalyzer.isIdentifier(token)){
                type = new TokenLexico(token, "Identificador");
            }else if(TokenAnalyzer.isGrouping(token)){
                type = new TokenLexico(token, "Caracter de agrupacion");
            }else{
                type = new TokenLexico(token, "Caracteres no validos");
            }
            
            this.types.add(type);
        }
        return this.types;
    }
    
    public TokenType getType(String token){
        if(TokenAnalyzer.isReserved(token)){
            return TokenType.RESERVADA;
        }else if(TokenAnalyzer.isOperator(token)){
            return TokenType.OPERADOR;
        }else if(TokenAnalyzer.isNumber(token)){
            return TokenType.ENTERO;
        }else if(TokenAnalyzer.isRealNumber(token)){
            return TokenType.REAL;
        }else if(TokenAnalyzer.isString(token)){
            return TokenType.CADENA;
        }else if(TokenAnalyzer.isIdentifier(token)){
            return TokenType.IDENTIFICADOR;
        }else if(TokenAnalyzer.isGrouping(token)){
            return TokenType.AGRUPACION;
        }else if(token.equals(";")){
            return TokenType.FIN;
        }else{
            return TokenType.NO_VALIDO;
        }
    }
}
