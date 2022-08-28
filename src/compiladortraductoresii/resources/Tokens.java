/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladortraductoresii.resources;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Usuario
 */
public class Tokens {
    public static ArrayList<String> palabrasReservadas 
            = new ArrayList<String>(
                    Arrays.asList(
                            "while",
                            "for",
                            "print",
                            "if",
                            "else",
                            "do",
                            "bool",
                            "int",
                            "float",
                            "char",
                            "string",
                            "switch",
                            "case",
                            "break",
                            "return",
                            "false",
                            "true",
                            "void"
                    )
            );
    
    public static ArrayList<String> operaciones 
            = new ArrayList<>(
                    Arrays.asList(
                            "+",
                            "-",
                            "=",
                            "*",
                            "/",
                            "==",
                            "&&",
                            "||",
                            ">",
                            "<",
                            ">=",
                            "<=",
                            "!",
                            "!="
                    )
            );
    
    public static ArrayList<String> caracteresAgrupacion
            = new ArrayList<>(
                    Arrays.asList(
                            "{",
                            "}",
                            "(",
                            ")"
                    )
                );
}
