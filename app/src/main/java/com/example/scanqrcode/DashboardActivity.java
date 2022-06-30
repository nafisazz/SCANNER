package com.example.scanqrcode;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class DashboardActivity extends AppCompatActivity {

    ImageButton btn_product, btn_transaksi, btn_about, btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initlize();
        onClick();
    }

    private void onClick() {
        btn_about.setOnClickListener(view -> {
            startActivity(new Intent(DashboardActivity.this, AboutActivity.class));
        });

        btn_exit.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
            builder.setTitle("Keluar Aplikasi");
            builder.setMessage("Apakah anda yakin ingin keluar dari aplikasi ini?");
            builder.setPositiveButton("Ya", (dialog, which) -> finish());
            builder.setNegativeButton("Tidak", (dialog, which) -> dialog.dismiss());
            builder.show();
        });

        btn_product.setOnClickListener(view -> {
            startActivity(new Intent(DashboardActivity.this, MainActivity.class));
        });
    }

    private void initlize() {
        btn_product = findViewById(R.id.btn_produk);
        btn_transaksi = findViewById(R.id.btn_transaksi);
        btn_about = findViewById(R.id.btn_about);
        btn_exit = findViewById(R.id.btn_exit);
    }
}