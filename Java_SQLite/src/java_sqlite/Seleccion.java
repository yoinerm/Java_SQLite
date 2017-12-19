/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_sqlite;

public class Seleccion {
    private String[] equipos_L1 = {"Alumbrado", "Pasteurizado", "Posimat", "Rinser", "Robopack", "Via de botellas", "Via de cajas",
                                    "Transporte de tapas", "Bulk", "Codificadores", "Etiquetado", "Inspectores", "Llenadora", "Ocme",
                                    "Paletizado", "Paster flash"};
    private String[] equipos_L3 = {"Alumbrado", "Pasteurizado", "Posimat", "Rinser", "Robopack", "Via de botellas", "Via de cajas",
                                    "Transporte de tapas", "Bulk", "Codificadores", "Etiquetado", "Inspectores", "Llenadora", "Ocme",
                                    "Paletizado"};
    private String[] lineas = {"Linea 1", "Linea 3"};

    public Seleccion() {
    }

    public String[] getEquipos_L1() {
        return equipos_L1;
    }

    public String[] getEquipos_L3() {
        return equipos_L3;
    }

    public String[] getLineas() {
        return lineas;
    }
        
}
