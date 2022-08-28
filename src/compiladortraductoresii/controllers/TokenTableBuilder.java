/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.controllers;

import compiladortraductoresii.models.TokenLexico;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class TokenTableBuilder {
    
    private ArrayList<TokenLexico> tokens;
    private Vector cabeceras;
    
    public TokenTableBuilder(){}
    
    public Vector getCabeceras()
    {
        return this.cabeceras;
    }
    
    public TokenTableBuilder(ArrayList<TokenLexico> tokens)
    {
        this.tokens = tokens;
    }
    
    public void setTokens(ArrayList<TokenLexico> tokens){
        this.tokens = tokens;
    }
    
    private String[][] getRows()
    {
        String[][] rows = new String[tokens.size()][3];
        
        for(Integer i = 0; i < tokens.size(); i++){
            TokenLexico token = tokens.get(i);
            String[] row = {i.toString(), token.getValue(), token.getType()};
            rows[i] = row;
        }
        
        return rows;
    }

    public DefaultTableModel getTable() {
        cabeceras = new Vector();
        cabeceras.add("Indice");
        cabeceras.add("Token");
        cabeceras.add("Tipo");

        DefaultTableModel modelo_tabla = new DefaultTableModel(cabeceras, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            
        };

        try 
        {
            String[][] cells = this.getRows();
            for (int i = 0; i < cells.length; i++) 
            {
                modelo_tabla.addRow(cells[i]);
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Empty");
        }
        return modelo_tabla;
    }
}
