/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package bioskop;

/**
 *
 * @author NITRO 5
 */

import javax.swing.JOptionPane;
import view.login;
public class PA_BIOSKOP {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Selamat Datang di Bioskop Inforsa");
        login login = new login();
        login.setSize(800, 500);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}
