package com.example.projectgroupexpensetracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

public class homepage extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;


    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Fragment fragment4=new Home_Fragment();
        FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction4.add(R.id.frame,fragment4);
        fragmentTransaction4.commit();
        navigationView = findViewById(R.id.nav);
        toolbar=findViewById(R.id.toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(homepage.this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                     //   getSupportFragmentManger().beginTransaction().replace(R.id.fragment_container, new MessageFragment()).commit();
                        Fragment fragment4=new Home_Fragment();
                        FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction4.replace(R.id.frame,fragment4);
                        fragmentTransaction4.commit();
                        break;

                    case R.id.members:
                        Toast.makeText(homepage.this, "Clicked Members", Toast.LENGTH_SHORT).show();
//                       startActivity(new Intent(homepage.this,Members.class));
                        Fragment fragment=new Member_Fragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame,fragment);
                        fragmentTransaction.addToBackStack("Home_Fragment");
                        fragmentTransaction.commit();

                        break;

                    case R.id.Expense:
                        Toast.makeText(homepage.this, "Clicked Add Expense", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(homepage.this,AddExpense.class));
                        Fragment fragment1=new AddExpense_Fragment();
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.frame,fragment1);
                        fragmentTransaction1.addToBackStack("Home_Fragment");
                        fragmentTransaction1.commit();
                        break;

                    case R.id.Modify:
                        Toast.makeText(homepage.this, "Clicked Add Expense", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(homepage.this,AddExpense.class));
                        Fragment fragment3=new Modify_Expanse_Fragment();
                        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.frame,fragment3);
                        fragmentTransaction3.addToBackStack("Home_Fragment");
                        fragmentTransaction3.commit();
                        break;

                    case R.id.calculater:
                        Toast.makeText(homepage.this, "Clicked Calculater", Toast.LENGTH_SHORT).show();
                        Fragment fragment6=new Calculater();
                        FragmentTransaction fragmentTransaction6 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction6.replace(R.id.frame,fragment6);
                        fragmentTransaction6.addToBackStack("Home_Fragment");
                        fragmentTransaction6.commit();
//                        startActivity(new Intent(homepage.this));
                        break;

                    case R.id.details:
                        Fragment fragment7=new Tripdetails ();
                        FragmentTransaction fragmentTransaction7 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction7.replace(R.id.frame,fragment7);
                        fragmentTransaction7.addToBackStack("Home_Fragment");
                        fragmentTransaction7.commit();
                        Toast.makeText(homepage.this, "Clicked Trip Details", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.aboutus:
                        Fragment fragment5=new Aboutus();
                        FragmentTransaction fragmentTransaction5 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction5.replace(R.id.frame,fragment5);
                        fragmentTransaction5.addToBackStack("Home_Fragment");
                        fragmentTransaction5.commit();
                        Toast.makeText(homepage.this, "Clicked About Us", Toast.LENGTH_SHORT).show();
                        break;

                }
                drawerLayout.closeDrawer(Gravity.START);
                return true;
            }
        });
    }


}
