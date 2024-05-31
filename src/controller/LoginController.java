package controller;

import model.Customer;
import model.Pegawai;
import view.MenuCustomer;
import view.MenuPegawai;

public class LoginController {

    public static boolean Login(String nama, String password) {
        Pegawai pgw = new Pegawai(nama,password);
        int login = pgw.login(nama, password);
        if (login == 1) {
//            Pegawai Pegawai = new Pegawai(nama, password);
            UserSession.getInstance().setUserRole(pgw.getRole());
            UserSession.getInstance().setUserNama(pgw.getNama());
            MenuPegawai dashboardPegawai = new MenuPegawai();
            dashboardPegawai.setVisible(true);
            return true;
        }
        Customer cst = new Customer(nama,password);
        login = cst.login(nama, password);
        if (login == 1) {
//            Customer Customer = new Customer(nama, password);
            UserSession.getInstance().setUserRole(cst.getRole());
            UserSession.getInstance().setUserNama(cst.getNama());
            MenuCustomer dashboardCustomer = new MenuCustomer();
            dashboardCustomer.setVisible(true);
            return true;
        }
        return false;
        
    }
}
