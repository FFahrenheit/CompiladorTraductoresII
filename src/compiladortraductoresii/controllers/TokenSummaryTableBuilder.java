/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.controllers;

import java.util.Map;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ivan
 */
public class TokenSummaryTableBuilder {
    
    private Map<String, Integer> tokens;
    private Vector cabeceras;
    
    public TokenSummaryTableBuilder(){}
    
    public Vector getCabeceras()
    {
        return this.cabeceras;
    }
    
    public TokenSummaryTableBuilder(Map<String, Integer>  tokens)
    {
        this.tokens = tokens;
    }
    
    public void setTokens(Map<String, Integer> tokens){
        this.tokens = tokens;
    }
    
    private String[][] getRows()
    {
        String[][] rows = new String[tokens.size()][2];
        int index = 0;
        
        for(Map.Entry<String,Integer> token : this.tokens.entrySet()){
            String[] row = { token.getKey(), token.getValue().toString()};
            rows[index++] = row;
        }
        
        return rows;
    }

    public DefaultTableModel getTable() {
        cabeceras = new Vector();
        cabeceras.add("Tipo");
        cabeceras.add("Tokens");

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
