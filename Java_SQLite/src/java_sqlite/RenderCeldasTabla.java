
package java_sqlite;
/* Creamos esta clse la cual extiende de DefaultTableCellRenderer, modidificamos el metodo getTableCellRendererComponent para 
** poder cambiar el color de las filas en la tabla*/

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderCeldasTabla extends DefaultTableCellRenderer{
    private  Component componente;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if(row%2 == 0)componente.setBackground(new java.awt.Color(220, 220, 220));
        else componente.setBackground(new java.awt.Color(255, 255, 255));
        
        return componente;
    }
    
}
