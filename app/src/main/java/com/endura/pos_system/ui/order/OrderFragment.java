package com.endura.pos_system.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.endura.pos_system.R;

public class OrderFragment extends Fragment {

    private OrderViewModel orderViewModel;
    private Button monthyearpickerpopup_confirm, monthyearpickerpopup_cancel, btn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        orderViewModel =
                new ViewModelProvider(this).get(OrderViewModel.class);
        View root = inflater.inflate(R.layout.fragment_order, container, false);
//        final TextView textView = root.findViewById(R.id.text_order);
//        orderViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

            btn = (Button) root.findViewById(R.id.monthYearPicker);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openPopUpWindow();
                }

                private void openPopUpWindow() {
                    Intent popUpWindow = new Intent(getActivity(), PopUp_MonthYearPicker.class);
                    startActivity(popUpWindow);
                }
            });
//            Intent intent = getIntent();
//            String name = intent.getStringExtra("MonthYearPicker");

//            btn.setText(name);


            return root;
    }
}