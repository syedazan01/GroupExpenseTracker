package com.example.projectgroupexpensetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddMembers extends Activity implements View.OnClickListener {
    int i = 1, j = 0;
    Button b1, submit_btn;
    TextView e1;
    EditText e2;
    MyHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_members);
        b1 = findViewById(R.id.bt1_add);
        e1 = findViewById(R.id.tpname);
        e2 = findViewById(R.id.mname);
        myHelper=new MyHelper(this);
        b1.setOnClickListener(this);
        e1.setText("Trip Name : " + getIntent().getStringExtra("tripname"));
        submit_btn = findViewById(R.id.submit_btn);
        j = Integer.parseInt(getIntent().getStringExtra("gsize"));
        submit_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt1_add) {
            if (getIntent().getExtras() != null) {
                if (i <= Integer.parseInt(getIntent().getStringExtra("gsize"))) {
                    Toast.makeText(this, i+" Name Inserted" , Toast.LENGTH_SHORT).show();
                    myHelper.insertData(e2.getText().toString(),getIntent().getStringExtra("tripname"),getIntent().getStringExtra("gsize"),"","");
                }
                if (i == j) {
                    e2.setVisibility(View.INVISIBLE);
                    //e2.setEnabled(false);
                    b1.setVisibility(View.GONE);
                    submit_btn.setVisibility(View.VISIBLE);
                }
                e2.setText("");
                i++;
                if (i <= Integer.parseInt(getIntent().getStringExtra("gsize"))) {
                    e2.setHint(i + " Member Name");
                }
            }
        }
                if (view.getId() == R.id.submit_btn) {
                    Intent i = new Intent(this, homepage.class);
                    startActivity(i);
                }
    }
}
