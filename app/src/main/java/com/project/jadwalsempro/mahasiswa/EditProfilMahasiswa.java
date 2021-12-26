package com.project.jadwalsempro.mahasiswa;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.project.jadwalsempro.R;
import com.project.jadwalsempro.model.Mahasiswa;

import java.io.IOException;
import java.util.UUID;

public class EditProfilMahasiswa extends AppCompatActivity {

    DatabaseReference databaseReference;
    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 22;

    // instance for firebase storage and StorageReference
    FirebaseStorage storage;
    StorageReference storageReference;
    ImageView imgProfil;
    EditText username, password, hp, email, kelas, judul, dospem, dospen;
    TextView btnUpdate, nama, nim;
    String userid, img;
    DatabaseReference myRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil_mahasiswa);

        userid = getIntent().getStringExtra("userid");

        imgProfil = findViewById(R.id.profile_image);
        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);
        hp = findViewById(R.id.edt_hp);
        email = findViewById(R.id.edt_email);
        kelas = findViewById(R.id.edt_kelas);
        judul = findViewById(R.id.edt_judul);
        dospem = findViewById(R.id.edt_dospem);
        dospen = findViewById(R.id.edt_dospen);
        btnUpdate = findViewById(R.id.btn_update);
        nama = findViewById(R.id.txt_nama);
        nim = findViewById(R.id.txt_nim);


        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

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
                if (mhs.getImage() != null){

                    Glide.with(EditProfilMahasiswa.this)
                            .load(mhs.getImage())
                            .circleCrop()
                            .into(imgProfil);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        imgProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upload(filePath);
            }
        });



    }
    private void upload(Uri uri){
        StorageReference reference = storageReference.child(UUID.randomUUID().toString()+ "." + getFileExtention(uri));
        reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        img = uri.toString();
                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                Mahasiswa mhs = snapshot.getValue(Mahasiswa.class);
                                Mahasiswa mahasiswa = new Mahasiswa(userid,
                                        mhs.getStatus(),
                                        mhs.getNama(),
                                        mhs.getNim(),
                                        username.getText().toString(),
                                        password.getText().toString(),
                                        hp.getText().toString(),
                                        email.getText().toString(),
                                        kelas.getText().toString(),
                                        judul.getText().toString(),
                                        dospem.getText().toString(),
                                        dospen.getText().toString(),
                                        "mahasiswa",
                                        img);
                                myRef.setValue(mahasiswa);
                                Toast.makeText(EditProfilMahasiswa.this, "Update data berhasil!", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                    }
                });
            }
        });
    }
    private String getFileExtention(Uri uri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }
    private void selectImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data)
    {

        super.onActivityResult(requestCode,
                resultCode,
                data);
        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {

            // Get the Uri of data
            filePath = data.getData();
            try {

                // Setting image on image view using Bitmap
                Bitmap bitmap = MediaStore
                        .Images
                        .Media
                        .getBitmap(
                                getContentResolver(),
                                filePath);
                imgProfil.setImageBitmap(bitmap);
            }

            catch (IOException e) {
                // Log the exception
                e.printStackTrace();
            }
        }
    }
}
