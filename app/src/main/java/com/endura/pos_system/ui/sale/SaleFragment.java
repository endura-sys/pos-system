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

import java.util.concurrent.atomic.AtomicInteger;

public class SaleFragment extends Fragment {

    private SaleViewModel saleViewModel;
    EditText textIn;
    Button buttonAdd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        saleViewModel =
                new ViewModelProvider(this).get(SaleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sale, container, false);
        //        final TextView textView = root.findViewById(R.id.text_sale);
//        saleViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

//        textIn = (EditText) root.findViewById(R.id.add);
        buttonAdd = (Button) root.findViewById(R.id.add);
        LinearLayout containerForText = root.findViewById(R.id.container);

        buttonAdd.setOnClickListener(v -> {
            Log.d("test0", "0");

            final View addView = inflater.inflate(R.layout.sales_item, null);
            Log.d("test1", "111");
            TextView textOut = (TextView)addView.findViewById(R.id.productName);
            textOut.setText(buttonAdd.getText().toString());

            // Button add and minus onclick
            TextView quantity = addView.findViewById(R.id.quantity);
            Button add = addView.findViewById(R.id.add);
            Button minus = addView.findViewById(R.id.minus);

            add.setOnClickListener(v1 ->
                quantity.setText(String.valueOf(Integer.parseInt(quantity.getText().toString()) + 1)));

            AtomicInteger currentQuantity = new AtomicInteger();
            minus.setOnClickListener(v2 -> {
                currentQuantity.set(Integer.parseInt(quantity.getText().toString()));
                if (currentQuantity.get() > 1)
                    quantity.setText(String.valueOf(currentQuantity.get() - 1));
                else
                    ((LinearLayout)addView.getParent()).removeView(addView);
            });
            // Button remove
            Button buttonRemove = (Button)addView.findViewById(R.id.remove);
            buttonRemove.setOnClickListener(v3 -> (
                    (LinearLayout)addView.getParent()).removeView(addView));

            containerForText.addView(addView);

        });



        return root;
    }
}