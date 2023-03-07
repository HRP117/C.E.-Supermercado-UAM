/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercado;

/**
 *
 * @author Godfather
 */
import utilerias.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;





public class Supermercado {
    /**
     * Sistema que administra productos de un super
     */
    public static void main(String[] args) {
        MenuMain  menuMain = new MenuMain();     
        File f = new File("Productos.txt" );
        while( true ){
            int opcion = menuMain.opcion();
            
            switch( opcion ){
                case 1: productos(f);
                        break;
                case 2: deptos();
                        break;
                case 3: asignacionProds();
                        break;
                case 4: precios();
                        break;
                case 5: return;  
            }
       }
    }
    
    /**
     * 1.- PRODUCTOS
     */
    
     private static void productos(File f) {
        MenuProductos  menuProductos = new MenuProductos();        
        while( true ){
            int opcion = menuProductos.opcion();           
            switch( opcion ){
                case 1: altaProducto(f);
                        break;
                case 2: consultarProductos();
                        break;
                case 3: bajaProducto();
                        break;
                case 4: return;               
            }
        }
    }
    private static void altaProducto(File f) {
        int    cveProd;
        String nombre;
        String proveedor; 
        Scanner input = new Scanner( System.in );
        
        System.out.println("Producto:");
        nombre = input.nextLine();
        System.out.println("Provedor:");
        proveedor = input.nextLine();
        
        cveProd = generaCveProd();
        
        Producto producto = new Producto(cveProd, nombre, proveedor);

        if( producto.guardarEnArchivo( f ) )
            System.out.println("El producto fue dado de alta con exito."
                + "\nClave: " + cveProd
                + "\n-----------------------------------------------------");
        else
            System.out.println("Error, el producto no fue dado de alta."
                + "\n-----------------------------------------------------");    
            
    }
   
    private static int generaCveProd() {
        int cveProd = 0;
        ArrayList<String> productosString = new ArrayList<String>();
        ArrayList<Producto> productos = new ArrayList<Producto>();
        
        LectorDeArchivo lectorDeArchivo = new LectorDeArchivo("Productos.txt" );
        productosString = lectorDeArchivo.LeerArchivo();
        
        // extraer las cadenas de caracteres a objetos
        productos = extraerDatos( productosString );
        
        if( productos.size() == 0 )
            cveProd = 1;
        else{
            cveProd = productos.get(productos.size()-1).getcveProd();
		     cveProd = cveProd + 1;
        }
        return (cveProd);    
    }

    private static ArrayList<Producto> extraerDatos( ArrayList<String> productosString) {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        Producto producto;        
        String linea=null;
        String [] tokensLinea = null;
        String matr;
        tokensLinea = new String[8];
        
        for( int i=0; i < productosString.size() ; i++ ){
            // Se lee una línea completa, luego se separan los tokens 
            // y se guardan en un arreglo de Strings. 
            linea= productosString.get(i);          
           
            producto = new Producto();
            //Cuando se escribió en el archivo los campos se separaron con coma 
            tokensLinea = linea.split(",");
           
            String cveProd = tokensLinea[0];
            producto.setcveProd( Integer.parseInt(cveProd) );
            producto.setNombre( tokensLinea[1] );
            producto.setProveedor( tokensLinea[2] );
          
            productos.add(producto);
        }
       return productos;   
    }

    private static void consultarProductos() {
        ArrayList<String> productos = new ArrayList<String>();
        LectorDeArchivo lectorDeArchivo = new LectorDeArchivo( "Productos.txt" );
        productos = lectorDeArchivo.LeerArchivo();
        
        System.out.println(" Los productos existentes son: "); 
        for( int i=0; i< productos.size() ; i++){
          System.out.println(productos.get(i));
        }
        System.out.println("\n-----------------------------------------------------");
    }
    
    private static void bajaProducto() {
        int cveProd;
        Scanner input = new Scanner( System.in );
        ArrayList<String> productosString = new ArrayList<String>();
        ArrayList<Producto> productos = new ArrayList<Producto>();       
        LectorDeArchivo lectorDeArchivo = new LectorDeArchivo("Productos.txt" );
        productosString = lectorDeArchivo.LeerArchivo(); 
      
        productos = extraerDatos( productosString );
        System.out.println( "Clave del producto a dar de baja:");
        cveProd = input.nextInt(); 
       
        Boolean encontrado = false;
        int indice = 0;
        for( int i=0; i < productos.size() ; i++ ){
            if( productos.get(i).getcveProd() == cveProd ){
                encontrado = true;
                indice = i;
            }
        }
        if( encontrado ){
            productosString.remove(indice);
            productos.remove( indice );
            actualizarProductos( productos );
            System.out.println("El producto fue dado de baja."
                + "\n-----------------------------------------------------");
        }
        else 
            System.out.println( "No se encontró un producto con la clave proporcionada."
                + "\n-----------------------------------------------------");

    }

        
    private static void actualizarProductos( ArrayList<Producto> productos ) {
        File file = new File( "Productos.txt" );
        File archivo = file;
        file.delete();  // Se borra el archivo anterior
        Producto producto = new Producto();
        
        for( int i=0; i < productos.size(); i++ ){
            producto = productos.get(i);
		     // Se guardan en “Productos.txt" los datos actualizados
            producto.guardarEnArchivo( archivo);
        }
        
    }

    /**
     * 2.- DEPARTAMENTOS
     */

     private static void deptos() {
        MenuDeptos menuDeptos = new MenuDeptos();
        while( true ){
           int opcion = menuDeptos.opcion();
           
           switch( opcion ){
               case 1: altaDepto();
                       break;
               case 2: consultaDeptos();
                       break;
            case 3: return;               
           }
       }               
   }
   
    private static void altaDepto() {
        System.out.println("El departamento se creó con éxito"
            + "\n-----------------------------------------------------");
    }

    private static void consultaDeptos() {
        System.out.println("Los departamentos existentes son:"
            + "\n-----------------------------------------------------");   
    }

    /**
     * 3.- ASIGNACIONES
     */
    
    private static void asignacionProds(  ) {
        MenuAsignacionProds menuAsignacionProds = new MenuAsignacionProds ();
        while( true ){
           int opcion = menuAsignacionProds.opcion();
           
           switch( opcion ){
               case 1: altaProdEnDepto();
                       break;
               case 2: bajaProdEnDepto();
                       break;
               case 3: return;               
           }
       }               
    }
   
   
    private static void altaProdEnDepto() {
        System.out.println("El producto quedó asignado al depto.");
    }

    private static void bajaProdEnDepto() {
        System.out.println("El producto fue dado de baja del depto.");        
    }

    /**
     * 4.- PRECIOS
     */
    
    private static void precios() {
        MenuPrecios menuPrecios = new MenuPrecios();
        
        while( true ){
            int opcion = menuPrecios.opcion();
            
            switch( opcion ){
                case 1: asignarPrecio();
                        break;
                case 2: preciosDeProductosEnDepto();
                        break;
                case 3: return;               
            }
        }
    }

    private static void asignarPrecio() {
       System.out.println("El precio se asignó al producto");
    }

    private static void preciosDeProductosEnDepto() {
        System.out.println("Los precios de los productos son:");
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


