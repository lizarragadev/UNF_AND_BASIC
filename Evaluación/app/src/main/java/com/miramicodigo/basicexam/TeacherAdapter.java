package com.miramicodigo.basicexam;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 *
 * @author Gustavo Lizarraga
 * @date 12-06-2017
 *
 * */

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Teacher> items;

    public TeacherAdapter(Activity a, ArrayList<Teacher> data) {
        this.context = a;
        this.items = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TeacherAdapter.ViewHolder holder, int position) {
        Teacher temp = items.get(position);
        holder.tvTitle.setText(temp.getFullName());
        holder.tvSubtitle.setText(temp.getCareer());
        if(temp.getGender().equals("femenino")) {
            holder.ivImage.setImageResource(R.drawable.teacher_woman);
        } else {
            holder.ivImage.setImageResource(R.drawable.teacher_man);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvSubtitle;
        public ImageView ivImage;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvCardTitulo);
            tvSubtitle = (TextView) itemView.findViewById(R.id.tvCardSubtitulo);
            ivImage = (ImageView) itemView.findViewById(R.id.ivCardImagen);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Teacher temp = items.get(getAdapterPosition());
                    Toast.makeText(
                            context.getApplicationContext(),
                            "Nombre: "+ temp.getFullName()+"\nProfesion: "+temp.getCareer(),
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
