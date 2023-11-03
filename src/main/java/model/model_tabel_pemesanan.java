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
public class model_tabel_pemesanan extends AbstractTableModel {
    
    java.util.List<model_pemesanan> list_pemesanan;
    
    public model_tabel_pemesanan(java.util.List<model_pemesanan> list_pemesanan){
        this.list_pemesanan = list_pemesanan;
    }

    @Override
    public int getRowCount() {
        return list_pemesanan.size();
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
                return "Jumlah_Tiket";
            case 2:
                return "Total_Harga";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return list_pemesanan.get(row).getId();
            case 1:
                return list_pemesanan.get(row).getJumlah_tiket();
            case 2:
                return list_pemesanan.get(row).getTotal_harga();
            default:
                return null;
        }
    }
}
