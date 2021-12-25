package com.project.jadwalsempro.admin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.jadwalsempro.R;
import com.project.jadwalsempro.adapter.MahasiswaAdapter;
import com.project.jadwalsempro.model.Mahasiswa;

import java.util.ArrayList;

public class BerandaAdmin extends AppCompatActivity {

    ArrayList<Mahasiswa> list;
    FirebaseDatabase database;
    DatabaseReference myRef;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda_admin);

        recyclerView = findViewById(R.id.rv_mahasiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        myRef = FirebaseDatabase.getInstance().getReference().child("mahasiswa");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Mahasiswa mList = dataSnapshot.getValue(Mahasiswa.class);
                    list.add(mList);
                }
                MahasiswaAdapter adapter = new MahasiswaAdapter(BerandaAdmin.this, list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
