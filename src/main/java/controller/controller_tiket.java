/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import javax.swing.JOptionPane;
import DAO.DAO_tiket;
import implement.implement_tiket;
import model.model_tiket;
import model.model_tabel_tiket;
import view.tiket;
import java.util.List;
/**
 *
 * @author MaxXz
 */
public class controller_tiket {
    tiket frame_tiket;
    implement_tiket implemet_tiket;
    List<model_tiket> list_tiket;
    
    public controller_tiket(tiket frame_tiket){
        this.frame_tiket = frame_tiket;
        implemet_tiket = new DAO_tiket();
        list_tiket = implemet_tiket.getALL();
    }
    
    //Tombol Reset
    public void reset(){
        frame_tiket.getTxtIdTiket().setText("");
        frame_tiket.getTxtHargaTiket().setText("");
        frame_tiket.getTxtNoKursi().setText("");
        frame_tiket.getTxtPaketPelanggan().setSelectedItem("--- Pilih Paket ---");
        frame_tiket.getTxtCariData().setText("");
    }
    
    //Tampil Data Ke Tabel
    public void isiTable(){
        list_tiket = implemet_tiket.getALL();
        model_tabel_tiket tmb = new model_tabel_tiket(list_tiket);
        frame_tiket.getTabelDataTiket().setModel(tmb);
    }
    
    //Menampilkan Data Ke Form Ketika Data DI Klik
    public void isiField(int row){
        frame_tiket.getTxtIdTiket().setText(list_member.get(row).getId().toString());
        frame_tiket.getTxtNamaPelanggan().setText(list_tiket.get(row).getNama());
        frame_tiket.getTxtNoTelp().setText(list_tiket.get(row).getNo_telp());
        frame_tiket.getTxtAlamat().setText(list_tiket.get(row).getAlamat());
        frame_tiket.getTxtPaketPelanggan().setSelectedItem(list_tiket.get(row).getPaket());
    }
    
    //Insert Data Dari Form Ke Database
    public void insert(){
        if(!frame_tiket.getTxtNamaPelanggan().getText().trim().isEmpty()& !frame_tiket.getTxtNoTelp().getText().trim().isEmpty()& !frame_tiket.getTxtAlamat().getText().trim().isEmpty()){
            model_tiket t = new Model_Member();
            t.setNama(frame_tiket.getTxtNamaPelanggan().getText());
            t.setNo_telp(frame_tiket.getTxtNoTelp().getText());
            t.setAlamat(frame_tiket.getTxtAlamat().getText());
            t.setPaket(frame_tiket.getTxtPaketPelanggan().getSelectedItem().toString());
            
            implemet_tiket.insert(t);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
        } else {
            JOptionPane.showMessageDialog(frame_tiket, "Data Tidak Boleh Kosong");
        }
    }
    
    //Update Data Dari Tabel Ke Database
    public void update(){
        if(!frame_tiket.getTxtIdTiket().getText().trim().isEmpty()){
            model_tiket t = new model_tiket();
            t.setNama(frame_tiket.getTxtNamaPelanggan().getText());
            t.setNo_telp(frame_tiket.getTxtNoTelp().getText());
            t.setAlamat(frame_tiket.getTxtAlamat().getText());
            t.setPaket(frame_tiket.getTxtPaketPelanggan().getSelectedItem().toString());
            t.setId(Integer.parseInt(frame_tiket.getTxtIdTiket().getText()));
            
            implemet_tiket.update(t);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        } else {
            JOptionPane.showMessageDialog(frame_tiket, "Silahkan Pilih Data Yang Akan Di Update");
        }
    }
    
    //Hapus Data Pada Tabel
    public void delete(){
        if(!frame_tiket.getTxtIdTiket().getText().trim().isEmpty()){
            int id = Integer.parseInt(frame_tiket.getTxtIdTiket().getText());
            implemet_tiket.delete(id);
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        } else {
            JOptionPane.showMessageDialog(frame_tiket, "Silahkan Pilih Data Yang Akan Di Hapus");
        }
    }
    
    //Cari Data
    public void isiTableCariNama(){
        list_tiket = implemet_tiket.getCariNama(frame_tiket.getTxtCariData().getText());
        model_tabel_tiket tmb = new model_tabel_tiket(list_tiket);
        frame_tiket.getTabelDataTiket().setModel(tmb);
    }
    
    public void carinama(){
        if(!frame_tiket.getTxtCariData().getText().trim().isEmpty()){
            implemet_tiket.getCariNama(frame_tiket.getTxtCariData().getText());
            isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame_tiket, "Silahkan Pilih Data !!!");
        }
    }
}
