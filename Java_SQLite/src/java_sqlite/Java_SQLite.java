package java_sqlite;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import javax.swing.*;

public class Java_SQLite {

    public static void main(String[] args) {
        
    /*----------------------------------------------------------------------------
    * Importanto el jar del look and feel y luego llamandolo en el import podemos
    * usar diferentes skins o temas, hay que rodearlo de un bloque try catch   */
        try {UIManager.setLookAndFeel(new TextureLookAndFeel());} 
        catch (Exception e) { JOptionPane.showMessageDialog(null, e.getMessage());}
    //-----------------------------------------------------------------------------
        
        Ventana_1 v = new Ventana_1();
        v.setVisible(true);
    }
    
}
