package com.endura.pos_system.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.endura.pos_system.R;

public class OrderFragment extends Fragment {

    private OrderViewModel orderViewModel;
    private Button monthyearpickerpopup_confirm, monthyearpickerpopup_cancel, btn;
    private String myStr;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        orderViewModel =
//                new ViewModelProvider(this).get(OrderViewModel.class);
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

                    Bundle data = getArguments();

                    if (data != null) {

                        myStr = data.getString("String");

                    }
                    btn.setText(myStr);
                }
            });

//            PopUp_MonthYearPicker monthYearPicker = (PopUp_MonthYearPicker) getActivity();

//        myStr = getActivity().getIntent().getStringExtra("monthYearPicker");
//        startActivityForResult(intent, someIntValue); //I always put 0 for someIntValue

//In your class
//        @Override
//        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//            super.onActivityResult(requestCode, resultCode, data);
//            //Retrieve data in the intent
//            String editTextValue = intent.getStringExtra("valueId");
//        }
//
////            myStr = this.getString("MonthYearPicker");


//            btn.setText(myStr);

            return root;
    }
}