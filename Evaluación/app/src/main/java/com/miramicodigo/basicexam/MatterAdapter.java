package com.miramicodigo.basicexam;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 * @author Gustavo Lizarraga
 * @date 12-06-2017
 *
 * */

public class MatterAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Matter> items;

    public MatterAdapter(Activity activity, ArrayList<Matter> data) {
        this.context = activity;
        this.items = data;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Matter itemTemp = (Matter) getItem(position);
        viewHolder.itemTitulo.setText(itemTemp.getName());
        viewHolder.itemSubtitulo.setText(itemTemp.getInitials());
        System.out.println("RES: "+itemTemp.getType());
        if(itemTemp.getType().equals("lab")){
            viewHolder.itemImagen.setImageResource(R.drawable.class_lab);
        } else {
            viewHolder.itemImagen.setImageResource(R.drawable.class_talk);
        }
        return convertView;
    }

    private class ViewHolder {
        TextView itemTitulo;
        TextView itemSubtitulo;
        ImageView itemImagen;

        public ViewHolder(View view) {
            itemTitulo = (TextView)view.findViewById(R.id.tvListTitle);
            itemSubtitulo = (TextView) view.findViewById(R.id.tvListSubtitle);
            itemImagen = (ImageView) view.findViewById(R.id.ivListImage);
        }
    }
}
