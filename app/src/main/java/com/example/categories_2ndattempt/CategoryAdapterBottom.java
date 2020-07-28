package com.example.categories_2ndattempt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapterBottom extends RecyclerView.Adapter<CategoryAdapterBottom.newViewHolder> {

    private ArrayList<HomeCats> cats;

    sendonItemclickbottom activity;

    public interface sendonItemclickbottom{
        void sendonclickbottom(int i);
    }

    public CategoryAdapterBottom(Context context, ArrayList<HomeCats> list){
        cats=list;
        activity=(sendonItemclickbottom) context;
    }

    public class newViewHolder extends RecyclerView.ViewHolder {
        public ImageView iwdisp;
        public TextView title;

        public newViewHolder(@NonNull View itemView) {
            super(itemView);

            iwdisp=itemView.findViewById(R.id.iw1);
            title=itemView.findViewById(R.id.tv1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.sendonclickbottom(cats.indexOf(view.getTag()));
                }
            });

        }

    }


    @NonNull
    @Override
    public CategoryAdapterBottom.newViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_bottom,parent,false);
        return new newViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapterBottom.newViewHolder holder, int position) {

        holder.itemView.setTag(cats.get(position));
        holder.iwdisp.setImageResource(cats.get(position).getIwDisp());

        holder.title.setText(cats.get(position).getCat_title());
    }

    @Override
    public int getItemCount() {
        return cats.size();
    }
}

