package controller;

import model.Customer;
import model.Pegawai;

public class RegistrasiController {

    public static String Registrasi(String nama, String Password) {
        int cekNama = Customer.cekNama(nama);
        if (cekNama == 1) {
            return "Nama Sudah Digunakan!";}
        cekNama = Pegawai.cekNama(nama);
        if (cekNama == 1) {
            return "Nama Sudah Digunakan!";
        }

        boolean regis = Customer.registrasi(nama, Password);
        if (regis == true) {
            return "Registrasi Berhasil !";
        }
        return "Registrasi Gagal";
    }
}
