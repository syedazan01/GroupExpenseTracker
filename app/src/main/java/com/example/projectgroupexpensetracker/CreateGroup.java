package com.example.projectgroupexpensetracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateGroup extends Activity {
    Button b1;
    EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        b1=findViewById(R.id.bt1_nxt);
        et1=findViewById(R.id.et_id);
        et2=findViewById(R.id.et2_tpname);
        et3=findViewById(R.id.et3_gsize);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CreateGroup.this,AddMembers.class);
                i.putExtra("tripname",et2.getText().toString());
                i.putExtra("gsize",et3.getText().toString());
                startActivity(i);


            }
        });
        Bundle bundle =getIntent().getExtras();
        String data = bundle.getString("Trip Name");
        et2.setText(data);

    }
}
