package com.miramicodigo.aplicacion4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvCantidad;
    private EditText etApellido;
    private TextView tvResumenCantidad;
    private TextView tvResumenPrecioUnitario;
    private TextView tvResumenCostoTotal;
    private TextView tvResumenApellido;
    private int cantidad = 1;
    private double precio = 2.5;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCantidad = (TextView) findViewById(R.id.tvCantidad);
        etApellido = (EditText) findViewById(R.id.etApellido);
        tvResumenCantidad = (TextView) findViewById(R.id.tvResumenCantidad);
        tvResumenPrecioUnitario = (TextView) findViewById(R.id.tvResumenPrecioUnitario);
        tvResumenCostoTotal = (TextView) findViewById(R.id.tvResumenCostoTotal);
        tvResumenApellido = (TextView) findViewById(R.id.tvResumenNombre);

    }

    public void menos(View v) {
        if(cantidad > 1) {
            cantidad = cantidad - 1;
        }
        tvCantidad.setText(cantidad+"");
    }

    public void mas(View v) {
        cantidad = cantidad +1;
        tvCantidad.setText(cantidad+"");
    }
    public void calcular(View v) {
        total = cantidad * precio;
        String apellido = etApellido.getText().toString();
        if(apellido.equals("")) {
            Toast.makeText(this,
                    "Debe colocar su apellido",
                    Toast.LENGTH_SHORT)
                    .show();
        } else {
            tvResumenCantidad.setText(cantidad+"");
            tvResumenPrecioUnitario.setText("Bs. "+ precio);
            tvResumenCostoTotal.setText("Bs. " + total);
            tvResumenApellido.setText(apellido);
        }
    }

}









