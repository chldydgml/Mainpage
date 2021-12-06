package com.example.mainpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter <MainAdapter.MyViewHolder> {

    public interface OnItemClickListener{
        void onItemClick(View v, int pos);
    }
    private OnItemClickListener clistener = null;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.clistener = listener;
    }

    private ArrayList<Policy> arrayList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        protected ImageView mainImg;
        protected TextView p_title;
        protected TextView timeline;
        protected TextView age;
        private TextView gender;
        private TextView local;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mainImg = itemView.findViewById(R.id.p_image1);
            this.p_title = (TextView) itemView.findViewById(R.id.p_title);
            this.timeline = (TextView) itemView.findViewById(R.id.timeline);
            this.age = (TextView) itemView.findViewById(R.id.age);
            gender = itemView.findViewById(R.id.tv_gender);
            local = itemView.findViewById(R.id.tv_local);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        if(clistener != null){
                            clistener.onItemClick(v, pos);
                        }
                    }
                }
            });
        }
    }

    public MainAdapter(ArrayList<Policy> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_listview, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mainImg.setImageResource(arrayList.get(position).getImage());
        holder.p_title.setText(arrayList.get(position).getP_title());
        holder.timeline.setText(arrayList.get(position).getTimeline());
        holder.age.setText(arrayList.get(position).getAge());
        holder.gender.setText(arrayList.get(position).getGender());
        holder.local.setText(arrayList.get(position).getLocal());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public Policy getItem(int position) {
        return arrayList.get(position);
    }

    public void  filterList(ArrayList<Policy> filteredList) {
        arrayList = filteredList;
        notifyDataSetChanged();
    }
}