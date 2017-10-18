package com.miramicodigo.sj_a_1_17_java_3_intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    /**
     * @author Gustavo Lizarraga
     * @date 16-10-17
     * */
    private TextView tvTexto1;
    private TextView tvTexto2;

    private EditText etCajaTexto;
    private Button btnRespuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        tvTexto1 = (TextView) findViewById(R.id.tvTextoUno);
        tvTexto2 = (TextView) findViewById(R.id.tvTextoDos);
        etCajaTexto = (EditText) findViewById(R.id.etCajaTexto);
        btnRespuesta = (Button) findViewById(R.id.btnRespuesta);

        Bundle bundle = getIntent().getExtras();

        try {
            tvTexto1.setText(bundle.getString("valor1", ""));
            tvTexto2.setText(bundle.getString("valor2", ""));
        } catch (Exception c) {
            System.out.println("El error es: "+c);
        }

        try {
            etCajaTexto.setText(bundle.getString("valor3", ""));
        }catch (Exception e) {
            System.out.println("El error es: "+e);
        }

        btnRespuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(
                        "respuesta",
                        etCajaTexto.getText().toString()
                );
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

}
