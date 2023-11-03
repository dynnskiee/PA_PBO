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
import database.Database;
import model.model_pemesanan;
import implement.implement_pemesanan;
/**
 *
 * @author MaxXz
 */
public abstract class DAO_pemesanan implements implement_pemesanan {
    Connection connection;
    final String insert = "insert into pemesanan (id_pemesanan, jumlah_tiket, total_harga) VALUES (?,?,?);";
    final String update = "update pemesanan set id_pemesanan=?, jumlah_tiket=?, total_harga=?;";
    final String delete = "delete from pemesanan where id_pemesanan=? ;";
    final String select = "select * from pemesanan;";
    final String carinama = "select * from pemesanan where id_pemesanan like ?";
    
    public DAO_pemesanan(){
        connection = Database.connection();
    }
    
    @Override
    public void insert(model_pemesanan p){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setInt(1, p.getId());
            statement.setInt(2, p.getJumlah_tiket());
            statement.setInt(3, p.getTotal_harga());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                p.setId(rs.getInt(1));
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
    public void update(model_pemesanan p){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setInt(1, p.getId());
            statement.setInt(2, p.getJumlah_tiket());
            statement.setInt(3, p.getTotal_harga());
            statement.setInt(4, p.getId());
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
    public void delete(int id_pemesanan){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id_pemesanan);
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
    public List<model_pemesanan> getALL(){
        List<model_pemesanan> lp = null;
        try{
            lp = new ArrayList<model_pemesanan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                model_pemesanan p = new model_pemesanan();
                p.setId(rs.getInt("id"));
                p.setJumlah_tiket(rs.getInt("jumlah_tiket"));
                p.setTotal_harga(rs.getInt("total_harga"));
                lp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return lp;
    }
    
    @Override
    public List<model_pemesanan> getCariNama(Integer id_pemesanan){
        List<model_pemesanan> lp = null;
        try{
            lp = new ArrayList<model_pemesanan>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setInt(1,id_pemesanan);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                model_pemesanan p = new model_pemesanan();
                p.setId(rs.getInt("id"));
                p.setJumlah_tiket(rs.getInt("jumlah_tiket"));
                p.setTotal_harga(rs.getInt("total_harga"));
                lp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return lp;
    }
}
