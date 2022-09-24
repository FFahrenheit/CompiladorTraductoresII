/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.controllers;

import compiladortraductoresii.resources.ErrorList;
import compiladortraductoresii.resources.Tokens;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class AnalizadorSintactico {
    private String codigo;
    private String[] lineas;
    private ArrayList<String> pila;
    
    public AnalizadorSintactico(String fuente)
    {
        this.codigo = fuente;
        this.lineas = fuente.split("\n");
        System.out.println("" + lineas.length + " a analizar");
        pila = new ArrayList<>();
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
                System.out.println("token: " + token);
                System.out.println("resto: " + resto);
                if(!token.equals(""))
                {
                    pila.add(token);    
                }
            }while(!resto.equals(""));
            
            for(int j = 0; j < pila.size(); j++){
                System.out.println(pila.get(j));
            }

        }
        
        
        
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
            //System.out.println("token:::: " + token);
            if(TokenAnalyzer.isGrouping(token) || TokenAnalyzer.isOperator(token) || TokenAnalyzer.isEnd(token))
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
            //System.out.println("t: " + token);
            if(token.equals(""))
            {
                return input.substring(i).trim();
            }
            if(TokenAnalyzer.isGrouping(token) || TokenAnalyzer.isOperator(token) || TokenAnalyzer.isEnd(token))
            {
                return i == 0 ? input.substring(i + 1) : input.substring(i);
            }
        }
        return "";
    }
}
