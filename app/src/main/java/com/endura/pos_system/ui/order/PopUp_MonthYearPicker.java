package com.endura.pos_system.ui.order;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.endura.pos_system.MainActivity;
import com.endura.pos_system.R;

public class PopUp_MonthYearPicker extends AppCompatActivity {

    private TextView textview2, textview3;
    private NumberPicker monthPicker, yearPicker;
    private Button cancel, confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.7),(int)(height*.5));

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        monthPicker = (NumberPicker) findViewById (R.id.monthPicker);
        yearPicker = (NumberPicker) findViewById (R.id.yearPicker);
        textview2 = (TextView) findViewById(R.id.textViewNumberPicker2);
        textview3 = (TextView) findViewById(R.id.textViewNumberPicker3);

        yearPicker.setMaxValue(2021);
        yearPicker.setMinValue(2000);
        yearPicker.setValue(2021);

        yearPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
        {
            @SuppressLint("SetTextI18n")
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue)
            {
                textview3.setText(" " + newValue);
            }
        });

        Month.initMonths();
        monthPicker.setMaxValue(Month.getMonthArrayList().size() - 1);
        monthPicker.setMinValue(0);
        monthPicker.setDisplayedValues(Month.monthNames());

        monthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal)
            {
                textview2.setText(Month.getMonthArrayList().get(newVal).getName() + " ");
            }
        });

        cancel = (Button) findViewById(R.id.buttonCancel);
        confirm = (Button) findViewById(R.id.buttonConfirm);

        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
                finish();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V) {
//                sendData();
                finish();
            }

            private void sendData() {
                String wholeDate = textview2.getText().toString() +", "+ textview3.getText().toString().trim();
                Intent i = new Intent(PopUp_MonthYearPicker.this, MainActivity.class);
                i.putExtra("MonthYearPicker", wholeDate);
                startActivity(i);
            }
        });
    }
}