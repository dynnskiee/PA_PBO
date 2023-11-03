/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MaxXz
 */
public class model_tabel_jadwaltayang extends AbstractTableModel {
    
    java.util.List<model_jadwaltayang> list_jadwaltayang;
    
    public model_tabel_jadwaltayang(java.util.List<model_jadwaltayang> list_jadwaltayang){
        this.list_jadwaltayang = list_jadwaltayang;
    }

    @Override
    public int getRowCount() {
        return list_jadwaltayang.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Id/Kode";
            case 1:
                return "Tanggal";
            case 2:
                return "Jam_Tayang";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return list_jadwaltayang.get(row).getId();
            case 1:
                return list_jadwaltayang.get(row).getTanggal();
            case 2:
                return list_jadwaltayang.get(row).getJam_tayang();
            default:
                return null;
        }
    }    
}
