/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author ddomiroj
 */
public class Util {
    
    public static void printInfo(String... mensaje){        
        for (int i = 0; i < mensaje.length; i++) {
            System.out.print(mensaje[i]);
            System.out.print(" ");            
        }
    }
    
    public static void printInfoln(String... mensaje){
        for (int i = 0; i < mensaje.length; i++) {
            System.out.println(mensaje[i]);          
        }
    }
    
}
