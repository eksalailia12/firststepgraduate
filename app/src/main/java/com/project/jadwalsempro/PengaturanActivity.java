package com.project.jadwalsempro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.jadwalsempro.mahasiswa.EditProfilMahasiswa;
import com.project.jadwalsempro.mahasiswa.ProfilMahasiswaActivity;

public class PengaturanActivity extends AppCompatActivity {

    TextView btnedit;
    String userid, user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        userid = getIntent().getStringExtra("userid");
        user = getIntent().getStringExtra("user");

        btnedit = findViewById(R.id.btn_edit);

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.equals("mahasiswa")){
                    Intent i = new Intent(PengaturanActivity.this, EditProfilMahasiswa.class);
                    i.putExtra("userid", userid);
                    startActivity(i);
                }
            }
        });

    }
}
