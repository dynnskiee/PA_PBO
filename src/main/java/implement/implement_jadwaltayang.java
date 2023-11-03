/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package implement;
import java.awt.List;
import model.model_jadwaltayang;
/**
 *
 * @author MaxXz
 */
public interface implement_jadwaltayang {
    public void insert(model_jadwaltayang j);
    
    public void update(model_jadwaltayang j);
    
    public void delete(int id);
    
    public java.util.List<model_jadwaltayang> getALL();
    
    public java.util.List<model_jadwaltayang> getCariNama(Integer id_pemesanan);

}
