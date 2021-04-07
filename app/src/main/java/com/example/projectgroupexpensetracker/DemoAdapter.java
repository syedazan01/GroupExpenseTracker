package com.example.projectgroupexpensetracker;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class DemoAdapter extends ArrayAdapter<Module> {
    private AppCompatActivity context;
    Bitmap bitmap;
    private List<Module> moduleList=new ArrayList<Module>();
    MyHelper dbHelper;
    public DemoAdapter(AppCompatActivity context,List<Module> moduleList) {
        super(context,R.layout.activity_show_data,moduleList);
        this.context=context;
        this.moduleList=moduleList;
        dbHelper=new MyHelper(context);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
           LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_show_data, parent, false);
            final Module demoModule = moduleList.get(position);
            final TextView name = (TextView) convertView.findViewById(R.id.name_value);
            final TextView expanse_type_value = (TextView) convertView.findViewById(R.id.expanse_type_value);
        ImageButton image=(ImageButton)convertView.findViewById(R.id.image);
          Module module=moduleList.get(position);
          name.setText(demoModule.getName());
           expanse_type_value.setText(demoModule.getExpanse());
          return convertView;
    }
}
