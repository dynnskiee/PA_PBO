/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import implement.implement_tiket;
import database.Database;
import model.model_tiket;
/**
 *
 * @author MaxXz
 */
public abstract class DAO_tiket implements implement_tiket {
    Connection connection;
    final String insert = "insert into tiket (id_tiket, harga_tiket, no_kursi) VALUES (?,?,?);";
    final String update = "update tiket set id_tiket=?, harga_tiket=?, no_kursi=?;";
    final String delete = "delete from tiket where id_tiket=? ;";
    final String select = "select * from tiket;";
    final String carinama = "select * from tiket where id_tiket like ?";
    
    public DAO_tiket(){
        connection = Database.connection();
    }
    
    @Override
    public void insert(model_tiket t){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setInt(1, t.getId());
            statement.setInt(2, t.getHarga_tiket());
            statement.setInt(3, t.getNo_kursi());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                t.setId(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void update(model_tiket t){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setInt(1, t.getId());
            statement.setInt(2, t.getHarga_tiket());
            statement.setInt(3, t.getNo_kursi());
            statement.setInt(4, t.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete(int id_tiket){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id_tiket);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public List<model_tiket> getALL(){
        List<model_tiket> lt = null;
        try{
            lt = new ArrayList<model_tiket>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                model_tiket t = new model_tiket();
                t.setId(rs.getInt("id"));
                t.setHarga_tiket(rs.getInt("harga_tiket"));
                t.setNo_kursi(rs.getInt("no_kursi"));
                lt.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_tiket.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return lt;
    }
    
    @Override
    public List<model_tiket> getCariNama(Integer id_tiket){
        List<model_tiket> lt = null;
        try{
            lt = new ArrayList<model_tiket>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setInt(1,id_tiket);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                model_tiket t = new model_tiket();
                t.setId(rs.getInt("id"));
                t.setHarga_tiket(rs.getInt("harga_tiket"));
                t.setNo_kursi(rs.getInt("no_kursi"));
                lt.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_tiket.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return lt;
    }
}
