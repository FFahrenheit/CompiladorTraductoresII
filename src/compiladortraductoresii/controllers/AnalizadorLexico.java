/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.controllers;

import compiladortraductoresii.models.TokenLexico;
import compiladortraductoresii.models.TokenType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author ivan
 */
public class AnalizadorLexico {
    
    private ArrayList<String> tokens;
    private ArrayList<TokenLexico> types;
    private Map<String, Integer> summary;

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
    
    public void loadTokenTypes(){
        this.types = new ArrayList<>();
        this.summary = new HashMap<>();
        for(TokenType type : TokenType.values()) {
            this.summary.put(type.getLabel(), 0);
        }
        
        for(String token : this.tokens){
            TokenType tokenType = TokenAnalyzer.getTokenType(token);
            String label = tokenType.getLabel();
            this.summary.put(label, summary.get(label) + 1);
            
            if (tokenType == TokenType.CADENA) {
                label += " de " + token.length() + " caracteres";
            }
            
            this.types.add(new TokenLexico(token, label));
        }
    }
    
    public ArrayList<TokenLexico> getTokenTypes() {
        return this.types;
    }
    
    public Map<String, Integer> getSummary() {
        return this.summary;
    }
   
}
