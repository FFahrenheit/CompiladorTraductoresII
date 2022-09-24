/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class CodeCleaner {
    private String cleanCode;
    private String originalCode;
    private String error;

    private Boolean finished = false;
    
    public CodeCleaner(File source)
    {
        String line;
        originalCode = "";
        cleanCode = "";
        
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(source));
            while ((line = reader.readLine()) != null) {
                originalCode += line+"\n";
                line = line.replaceAll("/+$", "");
                cleanCode += line + "\n";
            }
            finished = true;
        }
        catch (FileNotFoundException ex) 
        {
            System.out.println("No se pudo leer");
            this.error = "No se encontró el archivo";
        }
        catch (IOException ex) 
        {
            System.out.println("Error al leer");
            this.error = "No se pudo leer el archivo";
        }
    }
    
    public String getCleanCode() 
    {
        return cleanCode;
    }
    
    public Boolean getFinished()
    {
        return finished;
    }

    public String getOriginalCode() 
    {
        return originalCode;
    }
    
    public String getError() {
        return error;
    }
}
