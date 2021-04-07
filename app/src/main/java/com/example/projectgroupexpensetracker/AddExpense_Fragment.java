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
public class AddExpense_Fragment extends Fragment {

    MyHelper myHelper;
    Spinner spinner1;
    String arr[]={};
    Button submit_btn;
    EditText expanse_type,amount;
    public AddExpense_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myHelper=new MyHelper(getActivity());
        arr=myHelper.getAllName();
        spinner1=(Spinner)getActivity().findViewById(R.id.spinner1);
        submit_btn=getActivity().findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myHelper.updateUser(spinner1.getSelectedItem().toString(),expanse_type.getText().toString(),amount.getText().toString());
                Toast.makeText(getActivity(), " Expense Added ", Toast.LENGTH_SHORT).show();
                expanse_type.setText("");
                amount.setText("");

            }
        });
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_expense_, container, false);
        expanse_type=view.findViewById(R.id.expanse_type);
        amount=view.findViewById(R.id.amount);
    return view;
    }

}
