package com.project.jadwalsempro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View beranda, profil, notifikasi, pengaturan, informasi, tutorial, faq, logout;
    ImageView icberanda, icprofil, icnotifikasi, icinformasi, ictutorial, icfaq, iclogout, icpengaturan;
    TextView titleberanda, titleprofil, titlenotifikasi, titleinformasi, titletutorial, titlefaq, titlepengaturan, titlelogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beranda = findViewById(R.id.menu_beranda);
        profil = findViewById(R.id.menu_profil);
        notifikasi = findViewById(R.id.menu_notifikasi);
        pengaturan = findViewById(R.id.menu_pengaturan);
        informasi = findViewById(R.id.menu_informasi);
        tutorial = findViewById(R.id.menu_tutorial);
        faq = findViewById(R.id.menu_faq);
        logout = findViewById(R.id.menu_logout);

        icberanda = beranda.findViewById(R.id.img_menu);
        titleberanda = beranda.findViewById(R.id.txt_title);
        icprofil = profil.findViewById(R.id.img_menu);
        titleprofil = profil.findViewById(R.id.txt_title);
        icnotifikasi = notifikasi.findViewById(R.id.img_menu);
        titlenotifikasi = notifikasi.findViewById(R.id.txt_title);
        icinformasi = informasi.findViewById(R.id.img_menu);
        titleinformasi = informasi.findViewById(R.id.txt_title);
        ictutorial = tutorial.findViewById(R.id.img_menu);
        titletutorial = tutorial.findViewById(R.id.txt_title);
        icfaq = faq.findViewById(R.id.img_menu);
        titlefaq = faq.findViewById(R.id.txt_title);
        iclogout = logout.findViewById(R.id.img_menu);
        titlelogout = logout.findViewById(R.id.txt_title);
        icpengaturan = pengaturan.findViewById(R.id.img_menu);
        titlepengaturan = pengaturan.findViewById(R.id.txt_title);

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        notifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

            }
        });

    }
}