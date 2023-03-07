/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado;

/**
 *
 * @author Godfather
 */

 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileReader;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.io.PrintWriter;
 import java.util.ArrayList;
 

public class Producto {

    int    cveProd;
    String nombre;
    String proveedor;
    
    public Producto(){      
    }    
    public Producto(int cveProd, String nombre, String proveedor) {
        this.cveProd = cveProd;
        this.nombre = nombre;
        this.proveedor = proveedor;
    }
    public Boolean guardarEnArchivo( File f ){
    Boolean exito = false;
    try{
      FileWriter w = new FileWriter( f, true ); // append = true para 
			              		      // agregar sin sobreescribir
      BufferedWriter bw = new BufferedWriter(w);
      PrintWriter salida = new PrintWriter( bw );  
      // Escribimos los datos en archivo separando los campos por comas
      salida.println( cveProd + ", " + nombre + ", " + proveedor ); 
      salida.close();
      bw.close();
      exito = true;
    }catch(IOException e){};
      return exito;
    }
    
    public int getcveProd() {
        return cveProd;
    }

    public void setcveProd(int cveProd) {
        this.cveProd = cveProd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
}

/**
▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
▓▓▓▓▓-....:▓▓▓▓▓▓▓+................-▓▓▓▓▓▓▓
▓▓▓▓▓-....:▓▓▓▓▓▓▓+.................#▓▓▓▓▓▓
▓▓▓▓▓-....:▓▓▓▓▓▓▓#===========+.....#▓▓▓▓▓▓
▓▓▓▓▓-....:▓▓▓▓▓▓▓+.....▓▓▓▓▓▓=.....#▓▓▓▓▓▓
▓▓▓▓▓-....:@...........######*......#▓▓▓▓▓▓
▓▓▓▓▓-....:@........................#▓▓▓▓▓▓
▓▓▓▓▓-....:@+++++-.................@▓▓▓▓▓▓▓
▓▓▓▓▓-....:▓▓▓▓▓▓▓+.....###-.....:@▓▓▓▓▓▓▓▓
▓▓▓▓▓-....:▓▓▓▓▓▓▓+.....▓▓▓▓+.....-░▓▓▓▓▓▓▓
▓▓▓▓▓-....:▓▓▓▓▓▓▓+.....▓▓▓▓▓=......#▓▓▓▓▓▓
▓▓▓▓▓:----+▓▓▓▓▓▓▓*-----▓▓▓▓▓▓@------*▓▓▓▓▓
▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
*/