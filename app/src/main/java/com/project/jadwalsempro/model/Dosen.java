package com.project.jadwalsempro.model;

public class Dosen {
    private String nama, nik, username, password, hp, email, nidn, riset;

    public Dosen(){}

    public Dosen(String nama, String nik, String username, String password, String hp, String email, String nidn, String riset){
        this.email = email;
        this.hp = hp;
        this.nama = nama;
        this.nidn = nidn;
        this.nik = nik;
        this.password = password;
        this.riset = riset;
        this.username = username;
    }

    public String getHp() {
        return hp;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNidn() {
        return nidn;
    }

    public String getNik() {
        return nik;
    }

    public String getPassword() {
        return password;
    }

    public String getRiset() {
        return riset;
    }

    public String getUsername() {
        return username;
    }
}
