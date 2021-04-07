package com.example.projectgroupexpensetracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class AddExpense extends Activity implements AdapterView.OnItemSelectedListener {
    Spinner spinner1;
    String arr[]={};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        spinner1=(Spinner)findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);
        loadSpinnerData();
        
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

    }

    private void loadSpinnerData() {

        MyHelper db = new MyHelper(getApplicationContext());
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
