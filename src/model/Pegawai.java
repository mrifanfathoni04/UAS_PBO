package model;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Pegawai extends User implements login{

    private final String role = "Pegawai";

    public Pegawai(String nama, String password) {
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

    public static final int cekNama(String namar) {
        Database.connect();
        try {
            String query = "SELECT * FROM pegawai";
            Database.pst = Database.conn.prepareStatement(query);
            Database.rs = Database.pst.executeQuery();
            while (Database.rs.next()) {
                String nama = Database.rs.getString("nama");
                if (namar.equals(nama)) {
                    System.out.println("Nama Sudah Digunakan Pegawai");
                    Database.disconnect();
                    return 1;
                }

            }
            System.out.println("Nama Belum Digunakan Pegawai");
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
            String query = "SELECT * FROM pegawai WHERE nama = ? AND password = ?";
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
