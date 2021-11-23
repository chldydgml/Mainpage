package com.example.mainpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter <MainAdapter.MyViewHoler> {

    private ArrayList<Policy> arrayList;

    public class MyViewHoler extends RecyclerView.ViewHolder{
        protected ImageView mainImg;
        protected TextView p_title;
        protected TextView timeline;
        protected TextView age;


        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            this.mainImg = itemView.findViewById(R.id.p_image1);
            this.p_title = (TextView) itemView.findViewById(R.id.p_title);
            this.timeline = (TextView) itemView.findViewById(R.id.timeline);
            this.age = (TextView) itemView.findViewById(R.id.age);
        }
    }

    public MainAdapter(ArrayList<Policy> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_listview, parent, false);

        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        holder.mainImg.setImageResource(arrayList.get(position).getImage());
        holder.p_title.setText(arrayList.get(position).getP_title());
        holder.timeline.setText(arrayList.get(position).getTimeline());
        holder.age.setText(arrayList.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
