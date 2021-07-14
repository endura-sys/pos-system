package com.endura.pos_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OrdersActivity extends AppCompatActivity {

    private Button monthyearpickerpopup_confirm, monthyearpickerpopup_cancel, btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        btn = (Button) findViewById(R.id.monthYearPicker);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPopUpWindow();
            }
        });
        Intent intent = getIntent();
        String name = intent.getStringExtra("MonthYearPicker");

        btn.setText(name);
    }

    private void openPopUpWindow() {
        Intent popUpWindow = new Intent(OrdersActivity.this, PopUp_MonthYearPicker.class);
        startActivity(popUpWindow);
    }
}