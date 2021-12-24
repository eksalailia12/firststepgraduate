package com.project.jadwalsempro.beranda;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.jadwalsempro.R;

public class BerandaActivity extends AppCompatActivity {
    TextView status_sidang;
    ImageView btnBack, btnMenu, btnFilter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        status_sidang = findViewById(R.id.txt_status_sidang);
        btnBack = findViewById(R.id.btn_back);
        btnMenu = findViewById(R.id.btn_menu);
        btnFilter = findViewById(R.id.btn_filter);

        status_sidang.setSelected(true);



    }
}
