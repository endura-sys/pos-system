package com.endura.pos_system.ui.sale;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.endura.pos_system.R;

public class SaleFragmentTest extends Fragment {

    private SaleViewModel saleViewModel;
    EditText textIn;
    Button buttonAdd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        saleViewModel =
                new ViewModelProvider(this).get(SaleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sale_test, container, false);

        textIn = (EditText) root.findViewById(R.id.textin);
        buttonAdd = (Button) root.findViewById(R.id.add);
        LinearLayout containerForText = root.findViewById(R.id.container);

        buttonAdd.setOnClickListener(v -> {
            Log.d("test0", "0");

            final View addView = inflater.inflate(R.layout.sales_item_test, null);
            Log.d("test1", "111");
                TextView textOut = (TextView)addView.findViewById(R.id.productName);
                textOut.setText(textIn.getText().toString());
                Button buttonRemove = (Button)addView.findViewById(R.id.remove);
                buttonRemove.setOnClickListener(v1 -> (
                        (LinearLayout)addView.getParent()).removeView(addView));
            Log.d("test2", "2");

                containerForText.addView(addView);
            Log.d("test3", "3");

        });



        return root;
    }
}
