/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import javax.swing.JOptionPane;
import DAO.DAO_jadwaltayang;
import implement.implement_jadwaltayang;
import model.model_jadwaltayang;
import model.model_tabel_jadwaltayang;
import view.jadwaltayang;
import java.util.List;
/**
 *
 * @author MaxXz
 */
public class controller_pemesanan {
    karyawan frame_pemesanan;
    implement_pemesanan implemet_pemesanan;
    List<model_pemesanan> list_pemesanan;
    
    public controller_pemesanan(karyawan frame_pemesanan){
        this.frame_pemesanan = frame_pemesanan;
        implemet_pemesanan = new DAO_pemesanan() {};
        list_pemesanan = implemet_pemesanan.getALL();
    }
    
    //Tombol Reset
    public void reset(){
        frame_pemesanan.getTxtIdPemesanan().setText("");
        frame_pemesanan.getTxtHargaTiket().setText("");
        frame_pemesanan.getTxtNoKursi().setText("");
        frame_pemesanan.getTxtCariData().setText("");
    }
    
    //Tampil Data Ke Tabel
    public void isiTable(){
        list_pemesanan = implemet_pemesanan.getALL();
        model_tabel_pemesanan tmb = new model_tabel_pemesanan(list_pemesanan);
        frame_pemesanan.getTabelDataPemesanan().setModel(tmb);
    }
    
    //Menampilkan Data Ke Form Ketika Data DI Klik
    public void isiField(int row){
        frame_pemesanan.getTxtIdPemesanan().setText(list_pemesanan.get(row).getIdPemesanan());
        frame_pemesanan.getTxtHargaTiket().setText(list_pemesanan.get(row).getHargaTiket());
        frame_pemesanan.getTxtNoKursi().setText(list_pemesanan.get(row).getNoKursi());
    }
    
    //Insert Data Dari Form Ke Database
    public void insert(){
        if(!frame_pemesanan.getTxtNoKursi().getText().trim().isEmpty()& !frame_pemesanan.getTxtHargaTiket().getText().trim().isEmpty()
            model_pemesanan p = new model_pemesanan();
            p.setHargaTiket(frame_pemesanan.getTxtHargaTiket().getText());
            p.setNoKursi(frame_pemesanan.getTxtNoKursi().getText());
            
            implemet_pemesanan.insert(p);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
        } else {
            JOptionPane.showMessageDialog(frame_pemesanan, "Data Tidak Boleh Kosong");
        }
    }
    
    //Update Data Dari Tabel Ke Database
    public void update(){
        if(!frame_pemesanan.getTxtIdPemesanan().getText().trim().isEmpty()){
            model_pemesanan p = new model_pemesanan();
            p.setHargaTiket(frame_pemesanan.getTxtHargaTiket().getText());
            p.setNoKursi(frame_pemesanan.getTxtNoKursi().getText());
            p.setIdPemesanan(Integer.parseInt(frame_pemesanan.getTxtIdPemesanan().getText()));
            
            implemet_pemesanan.update(p);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        } else {
            JOptionPane.showMessageDialog(frame_pemesanan, "Silahkan Pilih Data Yang Akan Di Update");
        }
    }
    
    //Hapus Data Pada Tabel
    public void delete(){
        if(!frame_pemesanan.getTxtIdPemesanan().getText().trim().isEmpty()){
            int id = Integer.parseInt(frame_pemesanan.getTxtIdPemesanan().getText());
            implemet_pemesanan.delete(IdTiket);
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } else {
            JOptionPane.showMessageDialog(frame_pemesanan, "Silahkan Pilih Data Yang Akan Di Hapus");
        }
    }
    
    //Cari Data
    public void isiTableCariNama(){
        list_pemesanan = implemet_pemesanan.getCariNama(frame_pemesanan.getTxtCariData().getText());
        model_tabel_pemesanan tmb = new model_tabel_pemesanan(list_pemesanan);
        frame_pemesanan.getTabelDataPemesanan().setmodel(tmb);
    }
    
    public void carinama(){
        if(!frame_pemesanan.getTxtCariData().getText().trim().isEmpty()){
            implemet_pemesanan.getCariNama(frame_pemesanan.getTxtCariData().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame_pemesanan, "Silahkan Pilih Data !!!");
        }
    }
}
