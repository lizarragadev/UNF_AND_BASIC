package com.miramicodigo.p10_recyclerview_cardviews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 * @author Gustavo Lizarraga
 * @date 17-10-17.
 */

class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Pokemon> items;

    public RVAdapter(Activity activity, ArrayList<Pokemon> data) {
        this.context = activity;
        this.items = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_grid, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pokemon temp = items.get(position);
        holder.tvTitulo.setText(temp.getNombre());
        holder.tvSubtitulo.setText(temp.getTipo());
        holder.ivImagen.setImageResource(temp.getImagen());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView ivImagen;
        public TextView tvTitulo;
        public TextView tvSubtitulo;

        public ViewHolder(final View itemView) {
            super(itemView);
            ivImagen = (ImageView) itemView.findViewById(R.id.ivImagen);
            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvSubtitulo = (TextView) itemView.findViewById(R.id.tvSubtitulo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicion = getAdapterPosition();
                    Intent intent = new Intent(context, DetalleActivity.class);
                    intent.putExtra("poke", items.get(posicion));
                    context.startActivity(intent);
                }
            });
        }
    }
}
