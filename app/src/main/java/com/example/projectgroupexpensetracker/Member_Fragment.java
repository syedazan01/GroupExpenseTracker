package com.example.projectgroupexpensetracker;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Member_Fragment extends Fragment {

   ListView listView;
   List<Module> list;
    public Member_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list=new ArrayList<>();
        listView=getActivity().findViewById(R.id.listview);
         MyHelper myHelper=new MyHelper(getActivity());
         list=myHelper.getAllUser();
         DemoAdapter demoAdapter=new DemoAdapter((AppCompatActivity)getActivity(),list);
          listView.setAdapter(demoAdapter);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_member_, container, false);
    }
}
