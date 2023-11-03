/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package implement;
import java.awt.List;
import model.model_tiket;

/**
 *
 * @author MaxXz
 */
public interface implement_tiket {
    public void insert(model_tiket t);
    
    public void update(model_tiket t);
    
    public void delete(int id);
    
    public java.util.List<model_tiket> getALL();
    
    public java.util.List<model_tiket> getCariNama(Integer id_tiket);
}
