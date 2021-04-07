package com.example.projectgroupexpensetracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ModifyExpense extends Activity {

    Spinner name_spinner,type_spinner;
    EditText amount;
    Button update_btn;
    MyHelper myHelper;
    String[] name_arr={};
    String[] type_arr={};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_expense);
        name_spinner=findViewById(R.id.name_spinner);
        type_spinner=findViewById(R.id.type_spinner);
        myHelper=new MyHelper(this);
        name_arr=myHelper.getAllName();
        type_arr=myHelper.getAllType();
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,name_arr);
        name_spinner.setAdapter(adapter);
        ArrayAdapter adapter1=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,type_arr);
        type_spinner.setAdapter(adapter1);
        amount=findViewById(R.id.amount);
        update_btn=findViewById(R.id.update_btn);
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              myHelper.updateUser(name_spinner.getSelectedItem().toString(),type_spinner.getSelectedItem().toString(),amount.getText().toString());
                Toast.makeText(ModifyExpense.this, "Updated", Toast.LENGTH_SHORT).show();
                amount.setText("");
            }
        });
    }
}
