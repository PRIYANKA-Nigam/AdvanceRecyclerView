package com.example.advancerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerView.LayoutManager layoutManager;
RecyclerView.Adapter adapter;
ArrayList<String> itemarray=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rec);
        layoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter=new RecyclerAdapter(itemarray,MainActivity.this);
        recyclerView.setAdapter(adapter);
        String [] items={"Item 1","Item 2","Item 3","Item 4","Item 5"};
        for (int i=0;i<items.length;i++){
            itemarray.add(items[i]);
        }
        adapter.notifyDataSetChanged();
    }
}