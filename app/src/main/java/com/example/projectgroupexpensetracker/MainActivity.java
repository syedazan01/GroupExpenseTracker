package com.example.projectgroupexpensetracker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button b1,b2;
    EditText e1;
    long backpressedTime;
    Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (Button) findViewById(R.id.add_btn);
        b2 =(Button) findViewById(R.id.addtrip_btn);
        e1 = findViewById(R.id.tripname);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String data = e1.getText().toString();
                Intent inte = new Intent(MainActivity.this, CreateGroup.class);
                inte.putExtra("Trip Name", data);

                    startActivity(inte);

            }
        } );

    }
    public void OnBackpressed(){
        if (backpressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            finishAffinity();
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backpressedTime = System.currentTimeMillis();
    }
    public void addtrip(View view) {
        b2.setVisibility(View.GONE);
        b1.setVisibility(View.VISIBLE);
        e1.setVisibility(View.VISIBLE);
    }
}


