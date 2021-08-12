package com.example.advancerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
ArrayList<String> parentArrayList;
Context context;

    public RecyclerAdapter(ArrayList<String> parentArrayList, Context context) {
        this.parentArrayList = parentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_recycler,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
   holder.textView.setText(parentArrayList.get(position));
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.child.setLayoutManager(layoutManager);
        holder.child.setHasFixedSize(true);
        ArrayList<String> dayarrayList = new ArrayList<>();
        if (parentArrayList.get(position).equals("Item 1")){
            String[] days={"Sat","Sun","Mon","Tues","Wednes"};
            for (int i=0;i<days.length;i++){
                dayarrayList.add(days[i]);
            }
        }
        else {
            String[] days = {"Sat", "Sun", "Mon", "Tues", "Wednes", "Thurs", "Fri"};
            for (int i = 0; i < days.length; i++) {
                dayarrayList.add(days[i]);
            }
        }
        ChildRecyclerAdapter childRecyclerAdapter=new ChildRecyclerAdapter(dayarrayList);
        holder.child.setAdapter(childRecyclerAdapter);
        childRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return parentArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
 TextView textView;RecyclerView child;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tt);
            child=itemView.findViewById(R.id.child);

        }
    }
}
