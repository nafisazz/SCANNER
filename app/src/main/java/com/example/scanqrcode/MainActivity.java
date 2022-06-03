package com.example.scanqrcode;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


import com.blikoon.qrcodescanner.QrCodeActivity;
import com.example.scanqrcode.Adapter.BarangAdapter;
import com.example.scanqrcode.Model.BarangModel;
import com.example.scanqrcode.Utill.DataApi;
import com.example.scanqrcode.Utill.InterfaceBarang;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.BasePermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.LayoutManager layoutManager;
    private BarangAdapter barangAdapter;
    private List<BarangModel> barangModelList;
    private InterfaceBarang interfaceBarang;

    androidx.recyclerview.widget.RecyclerView recyclerView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Fungsi untuk menyembunyikan navbar

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        setContentView(R.layout.activity_main);

        recyclerView    =   findViewById(R.id.rcylrBarang);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        interfaceBarang= DataApi.getClient().create (InterfaceBarang.class);

        tampilkanData();


    }

    private void tampilkanData() {
        Call<List<BarangModel>> call = interfaceBarang.getBarang();

        call.enqueue(new Callback<List<BarangModel>>() {

            @Override
            public void onResponse(Call<List<BarangModel>> call, Response<List<BarangModel>> response) {

                barangModelList = response.body();
                barangAdapter= new BarangAdapter(MainActivity.this, barangModelList);
                recyclerView.setAdapter(barangAdapter);
            }


            @Override
            public void onFailure(Call<List<BarangModel>> call, Throwable t) {

                // Menampilkan toast saat no connection

                Toast.makeText(MainActivity.this, "No connection, please try again", Toast.LENGTH_LONG).show();


//                Toast.makeText(MainActivity.this, "Error : "+ t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }





    public void scanner(View view) {
        startActivity(new Intent(MainActivity.this, ScanQrCode.class));
    }

    public void addData(View view) {
        startActivity(new Intent(MainActivity.this, TambahBarang.class));
    }
}

