package com.example.projectgroupexpensetracker;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Modify_Expanse_Fragment extends Fragment {
    Spinner name_spinner,type_spinner;
    EditText amount;
    Button update_btn;
    MyHelper myHelper;
    String[] name_arr={};
    String[] type_arr={};

    public Modify_Expanse_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myHelper=new MyHelper(getActivity());
        name_arr=myHelper.getAllName();
        type_arr=myHelper.getAllType();
        ArrayAdapter adapter=new ArrayAdapter(getActivity(),android.R.layout.simple_dropdown_item_1line,name_arr);
        name_spinner.setAdapter(adapter);
        ArrayAdapter adapter1=new ArrayAdapter(getActivity(),android.R.layout.simple_dropdown_item_1line,type_arr);
        type_spinner.setAdapter(adapter1);
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myHelper.updateUser(name_spinner.getSelectedItem().toString(),type_spinner.getSelectedItem().toString(),amount.getText().toString());
                Toast.makeText(getActivity(), "Updated", Toast.LENGTH_SHORT).show();
                amount.setText("");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_modify__expanse_, container, false);
        name_spinner=view.findViewById(R.id.name_spinner);
        type_spinner=view.findViewById(R.id.type_spinner);
        amount=view.findViewById(R.id.amount);
        update_btn=view.findViewById(R.id.update_btn);
        return view;
    }

}
