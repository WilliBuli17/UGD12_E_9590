package com.example.tubes_kelompok_d.databaseUser;


public class UserHelperDatabaseClass {

    String Email,Password,Nama,Phone;

    public UserHelperDatabaseClass() {
    }

    public UserHelperDatabaseClass(String email, String password, String nama, String phone) {
        Email = email;
        Password = password;
        Nama = nama;
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
