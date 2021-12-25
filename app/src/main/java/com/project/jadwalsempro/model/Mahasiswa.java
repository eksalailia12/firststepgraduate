package com.project.jadwalsempro.model;

public class Mahasiswa {
    private String nama, nim, username, password, hp, email, kelas, judul, dospem, dospen, status, id, user;

    public Mahasiswa(){}

    public Mahasiswa(String id, String status, String nama, String nim, String username, String password, String hp, String email, String kelas, String judul, String dospem, String dospen, String user){
this.user = user;
        this.email = email;
        this.hp = hp;
        this.nama = nama;
        this.password = password;
        this.username = username;
        this.nim = nim;
        this.kelas = kelas;
        this.judul = judul;
        this.dospem = dospem;
        this.id = id;
        this.status = status;
        this.dospen = dospen;
    }

    public String getUser() {
        return user;
    }

    public String getStatus() {
        return status;
    }

    public String getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getJudul() {
        return judul;
    }

    public String getDospem() {
        return dospem;
    }

    public String getDospen() {
        return dospen;
    }

    public String getKelas() {
        return kelas;
    }

    public String getNim() {
        return nim;
    }
}
