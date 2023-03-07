/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

/**
 *
 * @author Godfather
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class LectorDeArchivo {  
    private String nombreArchivo;
    
    public LectorDeArchivo( String nombreArchivo ){
       this.nombreArchivo = nombreArchivo;
    }
    public ArrayList<String> LeerArchivo(  ){
       ArrayList<String> lectura = new ArrayList<String>();
       File archivo = null;
    
       FileReader fr = null;
       BufferedReader br = null;

       try {// Apertura del archivo y creacion de BufferedReader para poder
             // leer con el metodo readLine()).
          archivo = new File ( nombreArchivo );
          fr = new FileReader (archivo);
          br = new BufferedReader(fr);
          // Lectura del archivo
          String linea;
          while((linea=br.readLine())!=null)
            lectura.add(linea);
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
          // se cierra el archivo tanto para el caso normal
          //  como para la excepción
          try{                    
            if( null != fr ){   
               fr.close();     
            }                  
          }catch (Exception e2){ 
            e2.printStackTrace();
          }
        }  
       return lectura;
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