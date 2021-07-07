package com.endura.pos_system;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PopUp_MonthYearPicker extends AppCompatActivity {

    private TextView textview2;
    private TextView textview3;
    private NumberPicker monthPicker;
    private NumberPicker yearPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_monthyearpicker);

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
    }
}