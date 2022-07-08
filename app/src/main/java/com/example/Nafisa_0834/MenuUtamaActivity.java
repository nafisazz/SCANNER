package com.example.Nafisa_0834;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuUtamaActivity extends AppCompatActivity {

    ImageButton btn_product, btn_transaksi, btn_about, btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        hideNavigationBar();

        initlize();
        onClick();
    }

    private void hideNavigationBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        );
    }

    private void onClick() {
        btn_about.setOnClickListener(view -> {
            startActivity(new Intent(MenuUtamaActivity.this, AboutActivity.class));
        });

        btn_transaksi.setOnClickListener(view -> {
            startActivity(new Intent(MenuUtamaActivity.this, TransaksiActivity.class));
        });

        btn_exit.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MenuUtamaActivity.this);
            builder.setTitle("Keluar Aplikasi");
            builder.setMessage("Apakah anda yakin ingin keluar dari aplikasi ini?");
            builder.setPositiveButton("Ya", (dialog, which) -> System.exit(1));
            builder.setNegativeButton("Tidak", (dialog, which) -> dialog.dismiss());
            builder.show();
        });

        btn_product.setOnClickListener(view -> {
            startActivity(new Intent(MenuUtamaActivity.this, BarangActivity.class));
        });
    }

    private void initlize() {
        btn_product = findViewById(R.id.btn_produk);
        btn_transaksi = findViewById(R.id.btn_transaksi);
        btn_about = findViewById(R.id.btn_about);
        btn_exit = findViewById(R.id.btn_exit);
    }
}