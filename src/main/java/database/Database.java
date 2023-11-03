/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.*;
/**
 *
 * @author MaxXz
 */
public class Database {
    private static Connection mysqlconfig;
    public static Connection configDB(){
        try{
            String url = "jdbc:mysql://localhost:3306/bioskop";
            String user = "root";
            String password = "";
            mysqlconfig = DriverManager.getConnection(url, user, password);
        } catch(Exception e){
            System.err.println("Koneksi gagal"+e.getMessage());
        }
        return mysqlconfig;
    }

    public static Connection connection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
