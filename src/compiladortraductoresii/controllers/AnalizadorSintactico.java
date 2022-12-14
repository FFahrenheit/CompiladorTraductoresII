/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.controllers;

import compiladortraductoresii.models.TokenSintactico;
import compiladortraductoresii.resources.ErrorList;
import java.util.ArrayList;
import compiladortraductoresii.resources.TokenTypes.TokenType;


/**
 *
 * @author Usuario
 */
public class AnalizadorSintactico {
    private String codigo;
    private String[] lineas;
    private ArrayList<TokenSintactico> tokens;
    private int index;
    
    public AnalizadorSintactico(String fuente)
    {
        this.codigo = fuente;
        this.lineas = fuente.split("\n");
        System.out.println("" + lineas.length + " a analizar");
        tokens = new ArrayList<>();
    }
    
    public ErrorList analyze()
    {
        ErrorList errores = new ErrorList();
        
        for(int i = 0; i < lineas.length; i++)
        {
            String linea = lineas[i];
            System.out.println(linea);
            linea = linea.trim();
            
            if(linea.equals(""))
            {
                continue;
            }
            
            String resto = linea;
            do
            {
                String token = getTokenUntil(resto);
                resto = getTokenFrom(resto);
                System.out.println("Token: " + token);
                System.out.println("Resto: " + resto);
                if(!token.equals(""))
                {
                    tokens.add(new TokenSintactico(token, i + 1));
                }
            }while(!resto.equals(""));
            
        }
        
        for(int j = 0; j < tokens.size(); j++){
            System.out.println("[" + (j+1) +  "]" + tokens.get(j));
        }
        
        this.index = 0;
        
//        while(!tokens.isEmpty())
//        {
//        }
        
        return errores;
    }
    
    public String getTokenUntil(String input)
    {
        String out = "";
        for(int i = 0; i < input.length(); i++)
        {
            String token = "" + input.charAt(i);
            token = token.trim();
            
            if(token.equals(""))
            {
                return out;
            }
            if(TokenAnalyzer.isOperator(token))
            {
                String next = "" + input.charAt(i + 1);
                if(next.equals("=") && (token.equals("=") || token.equals("<") || token.equals(">") || token.equals("!")))
                {
                    return out.equals("") ? token + next : out;
                }
            }
            if(TokenAnalyzer.isGrouping(token) || TokenAnalyzer.isEnd(token))
            {
                return out.equals("") ? token : out;
            }
            out += token;
        }
        return out;
    }
    
    public String getTokenFrom(String input)
    {
        
        for(int i = 0; i < input.length(); i++)
        {
            String token = "" + input.charAt(i);
            token = token.trim();
            System.out.println("t: " + token);
            if(token.equals(""))
            {
                return input.substring(i).trim();
            }
            if(TokenAnalyzer.isOperator(token))
            {
                String next = "" + input.charAt(i + 1);
                if(next.equals("=") && (token.equals("=") || token.equals("<") || token.equals(">") || token.equals("!")))
                {
                    System.out.println("Mayor");
                    System.out.println(input);
                    System.out.println(i);
                    return i == 0 ? input.substring(i + 2).trim() : input.substring(i).trim();
                }
            }
            if(TokenAnalyzer.isGrouping(token) || TokenAnalyzer.isEnd(token))
            {
                return i == 0 ? input.substring(i + 1).trim() : input.substring(i).trim();
            }
        }
        return "";
    }
}
