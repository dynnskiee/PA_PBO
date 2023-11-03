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
import implement.implement_jadwaltayang;
import database.Database;
import model.model_jadwaltayang;
/**
 *
 * @author MaxXz
 */
public abstract class DAO_jadwaltayang implements implement_jadwaltayang {
    Connection connection;
    final String insert = "insert into jadwaltayang (id_jadwaltayang, tanggal, jam_tayang) VALUES (?,?,?);";
    final String update = "update jadwaltayang set id_jadwaltayang=?, tanggal=?, jam_tayang=?;";
    final String delete = "delete from jadwaltayang where id_jadwaltayang=? ;";
    final String select = "select * from jadwaltayang;";
    final String carinama = "select * from jadwaltayang where id_jadwaltayang like ?";
    
    public DAO_jadwaltayang(){
        connection = Database.connection();
    }
    
    @Override
    public void insert(model_jadwaltayang j){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setInt(1, j.getId());
            statement.setInt(2, j.getTanggal());
            statement.setInt(3, j.getJam_tayang());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                j.setId(rs.getInt(1));
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
    public void update(model_jadwaltayang j){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setInt(1, j.getId());
            statement.setInt(2, j.getTanggal());
            statement.setInt(3, j.getJam_tayang());
            statement.setInt(4, j.getId());
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
    public void delete(int id_jadwaltayang){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id_jadwaltayang);
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
    public List<model_jadwaltayang> getALL(){
        List<model_jadwaltayang> lj = null;
        try{
            lj = new ArrayList<model_jadwaltayang>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                model_jadwaltayang j = new model_jadwaltayang();
                j.setId(rs.getInt("id"));
                j.setTanggal(rs.getInt("tanggal"));
                j.setJam_tayang(rs.getInt("jam_tayang"));
                lj.add(j);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_jadwaltayang.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return lj;
    }
    
    @Override
    public List<model_jadwaltayang> getCariNama(Integer id_jadwaltayang){
        List<model_jadwaltayang> lj = null;
        try{
            lj = new ArrayList<model_jadwaltayang>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setInt(1,id_jadwaltayang);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                model_jadwaltayang j = new model_jadwaltayang();
                j.setId(rs.getInt("id"));
                j.setTanggal(rs.getInt("tanggal"));
                j.setJam_tayang(rs.getInt("jam_tayang"));
                lj.add(j);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_jadwaltayang.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return lj;
    }
}
