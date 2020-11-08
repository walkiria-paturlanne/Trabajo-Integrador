/*
Los atributos correspondientes a la clase Agentes son:
String : nombre, apellido, telefono, direccion,
int : legajo, dni
float : sueldo
 */
package ejerciciofinal;


public class Agente {
    
    private String nombre, apellido, telefono, direccion;
    private int legajo, dni;
    private float sueldo;
    
    
     Agente()
    {
        nombre = apellido = telefono = direccion = "";
        legajo = dni = 0;
        sueldo = 0.0f;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
    
    public void guardar()
    { 
        ConexionBD base;
        base = new ConexionBD();
    
        String sql;
        sql = "INSERT INTO Vendedores (nombre, apellido, telefono, direccion, dni, sueldo)"
                + "Values ('"+ nombre + "', '"+ apellido + "', '" + telefono + "'," 
                + "'"+ direccion + "'," + dni + ", " + sueldo + ")";
        
        base.ejecutarComando(sql);
                
    
    }
    
    /*UPDATE nombre_tabla
      SET columna1 = valor1, columna2 = valor2
      WHERE columna3 = valor3  */
    
    public void editar()
    {
        ConexionBD base;
        base = new ConexionBD();
        
        String sql;
        sql = "UPDATE Vendedores SET apellido='"+ apellido +"', telefono='"+ telefono +"', direccion='"+ direccion +"', dni='"+ dni +"', sueldo='"+ sueldo +"' WHERE nombre='"+ nombre +"'";
               
        
        base.ejecutarComando(sql);
        
    
    }
    /*DELETE FROM nombre_tabla
      WHERE nombre_columna = valor */
    public void eliminar()
    {
        ConexionBD base;
        base = new ConexionBD();
        
        String sql;
        sql = "DELETE FROM Vendedores WHERE nombre='"+ nombre +"'";
               
        
        base.ejecutarComando(sql);
        
    
    }
    
} //final de clase
