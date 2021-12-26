package com.project.jadwalsempro.mahasiswa;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.jadwalsempro.R;
import com.project.jadwalsempro.model.Mahasiswa;

public class ProfilMahasiswaActivity extends AppCompatActivity {

    String userid;
    DatabaseReference myRef;
    TextView nama, nim, username, password, hp, email, kelas, judul, dospem, dospen;
    ImageView img_profil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_mahasiswa);

        userid = getIntent().getStringExtra("userid");

        nama = findViewById(R.id.txt_nama);
        nim = findViewById(R.id.txt_nim);
        username = findViewById(R.id.txt_username);
        password = findViewById(R.id.txt_password);
        hp = findViewById(R.id.txt_hp);
        email = findViewById(R.id.txt_email);
        kelas = findViewById(R.id.txt_kelas);
        judul = findViewById(R.id.txt_judul);
        dospem = findViewById(R.id.txt_dospem);
        dospen = findViewById(R.id.txt_dospen);
        img_profil = findViewById(R.id.profile_image);

        myRef = FirebaseDatabase.getInstance().getReference().child("mahasiswa").child(userid);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Mahasiswa mhs = snapshot.getValue(Mahasiswa.class);
                nama.setText(mhs.getNama());
                nim.setText(mhs.getNim());
                username.setText(mhs.getUsername());
                password.setText(mhs.getPassword());
                hp.setText(mhs.getHp());
                email.setText(mhs.getEmail());
                kelas.setText(mhs.getKelas());
                judul.setText(mhs.getJudul());
                dospem.setText(mhs.getDospem());
                dospen.setText(mhs.getDospen());
                Log.d("tesdata", mhs.getImage());
                if (mhs.getImage() != null){
                    Glide.with(ProfilMahasiswaActivity.this)
                            .load(mhs.getImage())
                            .circleCrop()
                            .into(img_profil);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
