package model;

public abstract class User {
    protected final String nama;
    private final String password;

    public User(String nama, String password){
        this.nama = nama;
        this.password = password;
    }

    public abstract String getRole();
    public abstract String getNama();
}
