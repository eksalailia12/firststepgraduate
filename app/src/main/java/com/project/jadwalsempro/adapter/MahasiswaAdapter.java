package com.project.jadwalsempro.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.jadwalsempro.R;
import com.project.jadwalsempro.model.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {
    ArrayList<Mahasiswa> mList;
    Context context;
    private LayoutInflater mInflater;
    FirebaseDatabase database;
    DatabaseReference myRef;

    // data is passed into the constructor
    public MahasiswaAdapter(Context context, ArrayList<Mahasiswa> mList) {
        this.mList = mList;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_mahasiswa, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.nama.setText(mList.get(position).getNama());
        holder.nim.setText(mList.get(position).getNim());

        if (mList.get(position).getStatus().equals("Belum Verifikasi")){
            holder.btnVerif.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myRef = FirebaseDatabase.getInstance().getReference().child("mahasiswa").child(mList.get(position).getId());
                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Mahasiswa mahasiswa = new Mahasiswa(mList.get(position).getId(), "Verifikasi", mList.get(position).getNama(),
                                    mList.get(position).getNim(), mList.get(position).getUsername(),
                                    mList.get(position).getPassword(),
                                    "",mList.get(position).getEmail(),"","","","", "mahasiswa", "");
                            myRef.setValue(mahasiswa);
                            holder.btnVerif.setVisibility(View.GONE);
                            Toast.makeText(context.getApplicationContext(), "Akun Mahasiswa sudah terverifikasi!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            });
        } else {
            holder.btnVerif.setVisibility(View.GONE);
        }
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mList.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama, nim, btnVerif;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.txt_nama);
            nim = itemView.findViewById(R.id.txt_nim);
            btnVerif = itemView.findViewById(R.id.btn_verifikasi);



        }
    }
}