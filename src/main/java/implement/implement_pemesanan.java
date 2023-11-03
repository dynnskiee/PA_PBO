/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package implement;
import java.awt.List;
import model.model_pemesanan;
/**
 *
 * @author MaxXz
 */
public interface implement_pemesanan {
    public void insert(model_pemesanan p);
    
    public void update(model_pemesanan p);
    
    public void delete(int id);
    
    public java.util.List<model_pemesanan> getALL();
    
    public java.util.List<model_pemesanan> getCariNama(Integer id_pemesanan);

}
