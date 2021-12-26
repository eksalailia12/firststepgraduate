package com.project.jadwalsempro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.jadwalsempro.model.Mahasiswa;

import java.util.Locale;

public class RegistrasiActivity extends AppCompatActivity {

    EditText username, nim, email, password, nama;
    TextView btnRegister;
    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.edt_username);
        nama = findViewById(R.id.edt_nama);
        nim = findViewById(R.id.edt_nim);
        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        btnRegister = findViewById(R.id.btn_register);

         database = FirebaseDatabase.getInstance();
         myRef = database.getReference("mahasiswa");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = myRef.push().getKey();
                Mahasiswa mahasiswa = new Mahasiswa(id, "Belum Verifikasi", nama.getText().toString(), nim.getText().toString(), username.getText().toString(),
                        password.getText().toString(),
                        "",email.getText().toString(),"","","","", "mahasiswa", "");
                myRef.child(id).setValue(mahasiswa);
                Toast.makeText(RegistrasiActivity.this, "Berhasil Registrasi! Tunggu validasi admin.", Toast.LENGTH_LONG).show();
                Intent i = new Intent(RegistrasiActivity.this, LoginFormActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}
