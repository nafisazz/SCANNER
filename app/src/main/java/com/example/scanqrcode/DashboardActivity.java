package com.example.scanqrcode;

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
            finish();
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