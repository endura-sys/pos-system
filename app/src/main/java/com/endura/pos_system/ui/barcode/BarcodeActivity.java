package com.endura.pos_system.ui.barcode;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.endura.pos_system.R;

public class BarcodeActivity extends AppCompatActivity {
    Button barcode_back_btn;

    protected void onCreate(Bundle savedInstanceState) {
        barcode_back_btn = findViewById(R.id.barcode_back_btn);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.barcode_scanner);
//
//        barcode_back_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(BarcodeActivity.this, SaleFragment.class);
//                startActivity(intent);
//            }
//        });



    }


}
