/*
    Clase creada para gestionar la conexion a una base de datos access
   y ejecutar consultas, comandos y cargar modelos de datos para tablas


 */
package ejerciciofinal;

import java.sql.*; // Importamos todas las clases del paquete sql
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Integral Capacitando
 */
public class ConexionBD {
    private Connection conexion; // la clase Connection modela la conexion a la base de datos
    private Statement comando; // la clase Statement representa las sentencias s asociados a una conexion
    
    
    // Constructor de la clase, abre la conexion y crea un objeto Statement
    public ConexionBD()
    {
        try
        {           
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Linea que carga el driver
            conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Walkiria\\Documents\\NetBeansProjects\\EjercicioFinal\\Inmobiliaria.accdb");
            //En esta parte tenemos que cambiar la ruta en la que se encuentra nuestra base de datos 
            comando = conexion.createStatement();

        }
        catch (Exception e)
        {
            System.out.println("Error al contectar a la base de datos");
        }
        
    }
    
    public void cerrarConexion()
    {
        try
        {
            conexion.close();
        }
        catch (Exception e)
        {
            System.out.println("Error al cerrar la base");
        }
    }
    
    // Metodo que ejecuta un comando SQL que se le pasa por parametro
    public void ejecutarComando (String sentencia)
    {
        try
        {
            comando.execute(sentencia);
        }

        catch (Exception e)
        {
            System.out.println ("Comando Incorrecto - " + sentencia);
        }    
    }
    
    // Metodo que ejecuta una consulta SQL que se le pasa por parametro y devuelve el resultado en un ResultSet 
    public  ResultSet ejecutarConsulta (String sentencia)
    {
       ResultSet rs ;       
     
       try{
           rs = comando.executeQuery (sentencia);
        }
        catch (Exception e)
        {
            rs = null;
            System.out.println ("Comando Incorrecto");
        } 
       return rs;
    }
    
    public static DefaultTableModel cargarDatosTabla(DefaultTableModel modeloDatos, String sql) {
        int cantidad_datos = modeloDatos.getColumnCount();
        String datos[] = new String[cantidad_datos];    //Variable que almacena los datos de la consulta
      
        
        ConexionBD base;
        base = new ConexionBD();
        try {
            ResultSet resultado = base.ejecutarConsulta(sql);  
            //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) { //Bucle que recorre la consulta obtenida
                
                //recorremos cada columna de la tabla cargando el dato
                for (int i = 0;i<cantidad_datos;i++)
                {
                    datos[i] = resultado.getString(i + 1 );
                }
                modeloDatos.addRow(datos);
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        
        return modeloDatos;
    }
 } //fin de la clase
            

