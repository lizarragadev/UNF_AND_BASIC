package com.miramicodigo.p10_recyclerview_cardviews;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {
    /**
     *
     * @author Gustavo Lizarraga
     * @date 17/10/2017
     *
     * */

    private ImageView ivImagen;
    private TextView tvNombre;
    private TextView tvHAbilidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        tvNombre = (TextView) findViewById(R.id.tvDetalleNombre);
        tvHAbilidades = (TextView) findViewById(R.id.tvDetalleHabilidades);
        ivImagen = (ImageView) findViewById(R.id.ivDetalleImagen);

        Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra("poke");

        tvNombre.setText(pokemon.getNombre());
        tvHAbilidades.setText(pokemon.getTipo());
        ivImagen.setImageResource(pokemon.getImagen());

    }
}











