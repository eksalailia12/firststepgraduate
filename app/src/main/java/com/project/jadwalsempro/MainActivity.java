package com.project.jadwalsempro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.jadwalsempro.mahasiswa.BerandaActivity;
import com.project.jadwalsempro.mahasiswa.EditProfilMahasiswa;
import com.project.jadwalsempro.mahasiswa.NotifikasiActivity;
import com.project.jadwalsempro.mahasiswa.ProfilMahasiswaActivity;

public class MainActivity extends AppCompatActivity {

    View beranda, profil, notifikasi, pengaturan, informasi, tutorial, faq, logout;
    ImageView icberanda, icprofil, icnotifikasi, icinformasi, ictutorial, icfaq, iclogout, icpengaturan;
    TextView title, titleberanda, titleprofil, titlenotifikasi, titleinformasi, titletutorial, titlefaq, titlepengaturan, titlelogout;
    String userid, username, user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userid = getIntent().getStringExtra("userid");
        username = getIntent().getStringExtra("username");
        user = getIntent().getStringExtra("user");

        beranda = findViewById(R.id.menu_beranda);
        profil = findViewById(R.id.menu_profil);
        notifikasi = findViewById(R.id.menu_notifikasi);
        pengaturan = findViewById(R.id.menu_pengaturan);
        informasi = findViewById(R.id.menu_informasi);
        tutorial = findViewById(R.id.menu_tutorial);
        faq = findViewById(R.id.menu_faq);
        logout = findViewById(R.id.menu_logout);
        title = findViewById(R.id.txt_title);

        title.setText("Selamat Datang, " + username + "!");

        icberanda = beranda.findViewById(R.id.img_menu);
        titleberanda = beranda.findViewById(R.id.txt_title);
        icberanda.setImageResource(R.drawable.ic_home);
        titleberanda.setText("Beranda");

        icprofil = profil.findViewById(R.id.img_menu);
        titleprofil = profil.findViewById(R.id.txt_title);
        icprofil.setImageResource(R.drawable.ic_user);
        titleprofil.setText("Profil Akun");

        icnotifikasi = notifikasi.findViewById(R.id.img_menu);
        titlenotifikasi = notifikasi.findViewById(R.id.txt_title);
        icnotifikasi.setImageResource(R.drawable.ic_alarm);
        titlenotifikasi.setText("Notifikasi");

        icinformasi = informasi.findViewById(R.id.img_menu);
        titleinformasi = informasi.findViewById(R.id.txt_title);
        icinformasi.setImageResource(R.drawable.ic_info);
        titleinformasi.setText("Informasi");

        ictutorial = tutorial.findViewById(R.id.img_menu);
        titletutorial = tutorial.findViewById(R.id.txt_title);
        ictutorial.setImageResource(R.drawable.ic_classroom);
        titletutorial.setText("Tutorial");

        icfaq = faq.findViewById(R.id.img_menu);
        titlefaq = faq.findViewById(R.id.txt_title);
        icfaq.setImageResource(R.drawable.ic_chat);
        titlefaq.setText("FAQ");

        iclogout = logout.findViewById(R.id.img_menu);
        titlelogout = logout.findViewById(R.id.txt_title);
        iclogout.setImageResource(R.drawable.ic_shutdown);
        titlelogout.setText("Logout");

        icpengaturan = pengaturan.findViewById(R.id.img_menu);
        titlepengaturan = pengaturan.findViewById(R.id.txt_title);
        icpengaturan.setImageResource(R.drawable.ic_setting);
        titlepengaturan.setText("Pengaturan");

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BerandaActivity.class);
                i.putExtra("userid", userid);
                startActivity(i);
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ProfilMahasiswaActivity.class);
                i.putExtra("userid", userid);
                startActivity(i);
            }
        });

        notifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NotifikasiActivity.class);
                i.putExtra("userid", userid);
                startActivity(i);
            }
        });

        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PengaturanActivity.class);
                i.putExtra("userid", userid);
                i.putExtra("user", user);
                startActivity(i);
            }
        });

        informasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}