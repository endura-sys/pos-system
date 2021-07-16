package com.endura.pos_system.ui.barcode;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.endura.pos_system.R;

public class barcodeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barcode_scanner);
    }
}