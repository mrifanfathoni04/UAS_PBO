package model;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Customer extends User implements login{

    private final String role = "Customer";

    public Customer(String nama, String password) {
        super(nama, password);
    }

    @Override
    public final String getRole() {
        return this.role;
    }

    @Override
    public final String getNama() {
        return this.nama;
    }

    public static final boolean registrasi(String nama, String password) {
        Database.connect();
        try {
            String query = "INSERT INTO customer VALUES ( ?, ?)";
            Database.pst = Database.conn.prepareStatement(query);
//            Database.pst.setString(1, (id + 1) + "-CST");
            Database.pst.setString(1, nama);
            Database.pst.setString(2, password);

            int rowsAffected = Database.pst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Registrasi Berhasil");
                Database.disconnect();
                return true;
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Registrasi Gagal, Terjadi Error Saat Registrasi! ");
            System.out.println("Registrasi Gagal, Terjadi Error Saat Registrasi");
            Database.disconnect();
        }
        return false;
    }

    public static final int cekNama(String namar) {
        Database.connect();
        try {
            String query = "SELECT * FROM customer";
            Database.pst = Database.conn.prepareStatement(query);
            Database.rs = Database.pst.executeQuery();
            while (Database.rs.next()) {
                String nama = Database.rs.getString("nama");
                if (namar.equals(nama)) {
                    System.out.println("Nama Sudah Digunakan Customer");
                    Database.disconnect();
                    return 1;
                }

            }
            System.out.println("Nama Belum Digunakan Customer");
            Database.disconnect();
            return 0;
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi Error Saat Pengecekan Nama! ");
            System.out.println("Terjadi Error Saat Pengecekan Nama");
            Database.disconnect();
            return -1;
        }
    }

    public int login(String nama, String password) {
        Database.connect();
        try {
            String query = "SELECT * FROM customer WHERE nama = ? AND password = ?";
            Database.pst = Database.conn.prepareStatement(query);
            Database.pst.setString(1, nama);
            Database.pst.setString(2, password);
            Database.rs = Database.pst.executeQuery();

            if (Database.rs.next()) {
                Database.disconnect();
                return 1;
            } else {
                Database.disconnect();
                return 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ada Masalah Koneksi ke Database! ");
            System.out.println("Ada Masalah Koneksi ke Database");
            Database.disconnect();
            return -1;
        }
    }
}
