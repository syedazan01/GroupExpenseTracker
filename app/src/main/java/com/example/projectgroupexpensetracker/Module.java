package com.example.projectgroupexpensetracker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class Module {
    String id,name,expanse;

    public Module(String id, String name, String expanse) {
        this.id = id;
        this.name = name;
        this.expanse = expanse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpanse() {
        return expanse;
    }

    public void setExpanse(String expanse) {
        this.expanse = expanse;
    }
}
