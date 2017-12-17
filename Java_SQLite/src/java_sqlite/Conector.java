
package java_sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conector {
    String URL = "D:\\YoinerPaila\\ProyectoDB\\Database\\Linea1";
    Connection connect;
    Statement stm = null;
    private List <String>listaDescripcion = new ArrayList<>();
    private List <Integer> listaCodigo = new ArrayList<>();

    public void connect(){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + URL);
            if (connect != null) System.out.println("Conectado");
        } catch (SQLException e) { System.err.println("No se ha podido conectar a la base de datos \n" + e.getMessage());}
    }
    
    public void close(){
        try {
            connect.close();
        } catch (SQLException e) { Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, e);}
    }
    
    public void buscarTodo(String tabla){
        try {
            stm = connect.createStatement();
            ResultSet resultSet;
            
            resultSet = stm.executeQuery("SELECT * FROM " + tabla + " ORDER BY descripcion" + ";");
            while (resultSet.next()) {                
                int cod = resultSet.getInt("codigo");
                String descripcion = resultSet.getString("descripcion");
                
                listaCodigo.add(cod);
                listaDescripcion.add(descripcion);
            }
            stm.close();
        } catch (SQLException e) { System.out.println(e.getMessage());}
    }
    
    public List getListaDescripcion(){
        return listaDescripcion;
    }
    
    public List getListaCodigo(){
        return listaCodigo;
    }
}

