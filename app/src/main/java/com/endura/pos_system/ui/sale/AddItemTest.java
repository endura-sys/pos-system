package com.endura.pos_system.ui.sale;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.endura.pos_system.R;

public class AddItemTest extends Activity {

        EditText textIn;
        Button buttonAdd;
        LinearLayout container;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            textIn = (EditText)findViewById(R.id.textin);
            buttonAdd = (Button)findViewById(R.id.add);
            container = (LinearLayout)findViewById(R.id.container);

            buttonAdd.setOnClickListener(new OnClickListener(){

                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View arg0) {
                    LayoutInflater layoutInflater =
                            (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View addView = layoutInflater.inflate(R.layout.sales_item, null);
                    TextView textOut = (TextView)addView.findViewById(R.id.productName);
                    textOut.setText(textIn.getText().toString());
                    Button buttonRemove = (Button)addView.findViewById(R.id.remove);
                    buttonRemove.setOnClickListener(new OnClickListener(){

                        @Override
                        public void onClick(View v) {
                            ((LinearLayout)addView.getParent()).removeView(addView);
                        }});

                    container.addView(addView);
                }});

        }

    }