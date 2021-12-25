package com.project.jadwalsempro;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.jadwalsempro.admin.BerandaAdmin;
import com.project.jadwalsempro.model.Admin;
import com.project.jadwalsempro.model.Mahasiswa;

public class LoginFormActivity extends AppCompatActivity {

    String user;
    TextView loginas, btnLogin, btnRegister;
    EditText username, password;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        user = getIntent().getStringExtra("user");

        loginas = findViewById(R.id.txt_login_as);
        btnLogin = findViewById(R.id.btn_login);
        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);
        btnRegister = findViewById(R.id.btn_register);

        loginas.setText("("+user+")");


        database = FirebaseDatabase.getInstance();

        if (user.equals("admin")){

            myRef = database.getReference().child("admin");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        btnLogin.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                                    Intent i = new Intent(LoginFormActivity.this, BerandaAdmin.class);
                                    startActivity(i);
                                    finish();
                                } else {
                                    Toast.makeText(LoginFormActivity.this, "Username / Password salah!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        Admin admin = new Admin("admin", "admin");
                        myRef.setValue(admin);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        } else if (user.equals("dosen")){


        }   else if (user.equals("mahasiswa")){
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (username.getText().toString().equals("") || password.getText().toString().equals("")){
                        Toast.makeText(LoginFormActivity.this, "Username / Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    } else if (username.getText().toString().equals("") && password.getText().toString().equals("")){
                        Toast.makeText(LoginFormActivity.this, "Username &amp; Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                        
                    } else {

                        myRef = database.getReference().child("mahasiswa");
                        myRef.orderByChild("username").equalTo(username.getText().toString()).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                    Mahasiswa mhs =dataSnapshot.getValue(Mahasiswa.class);
                                    if (password.getText().toString().equals(mhs.getPassword())){
                                        if (mhs.getStatus().equals("Belum Verifikasi")){
                                            Toast.makeText(LoginFormActivity.this, "Akun belum verifikasi!", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Intent i = new Intent(LoginFormActivity.this, MainActivity.class);
                                            i.putExtra("userid", mhs.getUser());
                                            startActivity(i);
                                            finish();
                                        }
                                    } else {
                                        Toast.makeText(LoginFormActivity.this, "Username / Password tidak terdaftar", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                }
            });



            btnRegister.setVisibility(View.VISIBLE);
            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(LoginFormActivity.this, RegistrasiActivity.class);
                    startActivity(i);
                }
            });
        }


    }
}
