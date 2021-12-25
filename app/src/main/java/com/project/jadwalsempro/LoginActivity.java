package com.project.jadwalsempro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    TextView admin, mahasiswa, dosen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        admin = findViewById(R.id.login_admin);
        dosen = findViewById(R.id.login_dosen);
        mahasiswa = findViewById(R.id.login_mahasiswa);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, LoginFormActivity.class);
                i.putExtra("user", "admin");
                startActivity(i);
            }
        });

        dosen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, LoginFormActivity.class);
                i.putExtra("user", "dosen");
                startActivity(i);
            }
        });

        mahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, LoginFormActivity.class);
                i.putExtra("user", "mahasiswa");
                startActivity(i);
            }
        });
    }
}
