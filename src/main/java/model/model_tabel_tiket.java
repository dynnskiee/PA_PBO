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
public class model_tabel_tiket extends AbstractTableModel {
    
    java.util.List<model_tiket> list_tiket;
    
    public model_tabel_tiket(java.util.List<model_tiket> list_tiket){
        this.list_tiket = list_tiket;
    }

    @Override
    public int getRowCount() {
        return list_tiket.size();
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
                return "Harga Tiket";
            case 2:
                return "Nomor_Kursi";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return list_tiket.get(row).getId();
            case 1:
                return list_tiket.get(row).getHarga_tiket();
            case 2:
                return list_tiket.get(row).getNo_kursi();
            default:
                return null;
        }
    }
    
}
