package javaapplication1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ddomiroj
 */
public class Parser {

    private File file;

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    //Debido a que no se realiza ningún tipo de control sobre la lectura de 
    //caracteres, la salida está algo sucia y se ve ofuscada, generando un cambio
    //en posibles valores realmente importantes.
    public String getContent() throws IOException {
        FileInputStream i = new FileInputStream(file);
        String output = "";
        int data;
        while ((data = i.read()) > 0) {
            output += (char) data;
        }
        return output;
    }

    //Debido a que la validación se realiza unicamente a caracteres cubiertos
    //a un rango inferior a 0x080 se podrían perder caracteres especiales 
    //necesarios o vocales tildadas o con algún acento especifico
    
    //Al realizar la validación caracter por caracter la aplicación será 
    //Muy lenta, ya que esto no es algo que se esté trabajando de manera 
    //asincrona si hay procesos independientes que se puedan ejecutar sin 
    //depender de este resultado estarán en stand-by hastaque este finalice
    public String getContentWithoutUnicode() throws IOException {
        FileInputStream i = new FileInputStream(file);
        String output = "";
        int data;
        while ((data = i.read()) > 0) {
            if (data < 0x80) {
                output += (char) data;
            }
        }
        return output;
    }

    //El método saveContent debe lanzar una excepción FileOutputStream 
    //ya que el llamado del archivo se realiza por fuera del bloque trycatch
    //O en su defecto se debe ingresar este al bloque y manejar la excepción
    public void saveContent(String content) {
        FileOutputStream o = new FileOutputStream(file);
        try {

            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

}
