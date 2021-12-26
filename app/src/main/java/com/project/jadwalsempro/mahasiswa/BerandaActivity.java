package com.project.jadwalsempro.mahasiswa;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.project.jadwalsempro.MainActivity;
import com.project.jadwalsempro.R;

public class BerandaActivity extends AppCompatActivity {
    TextView status_sidang, jadwal, alur, daftar;
    ImageView btnBack, btnMenu, btnFilter;
    Dialog menu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        status_sidang = findViewById(R.id.txt_status_sidang);
        btnBack = findViewById(R.id.btn_back);
        btnMenu = findViewById(R.id.btn_menu);
        btnFilter = findViewById(R.id.btn_filter);

        Animation marquee = AnimationUtils.loadAnimation(this, R.anim.marquee);
        status_sidang.setSelected(true);
        status_sidang.setAnimation(marquee);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                menu = new Dialog(BerandaActivity.this);
                menu.requestWindowFeature(Window.FEATURE_NO_TITLE);
                menu.setContentView(R.layout.dialog_menu);
                menu.setCancelable(true);
                Window window = menu.getWindow();
                window.setGravity(Gravity.END|Gravity.TOP);

                jadwal = menu.findViewById(R.id.menu_jadwal);
                daftar = menu.findViewById(R.id.menu_daftar);
                alur = menu.findViewById(R.id.menu_alur);

                menu.show();

            }
        });
}

}
