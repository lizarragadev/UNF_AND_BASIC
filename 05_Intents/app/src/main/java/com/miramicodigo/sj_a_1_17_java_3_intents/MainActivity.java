package com.miramicodigo.sj_a_1_17_java_3_intents;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * @author Gustavo Lizarraga
     * @date 16-10-17
     * */

    private ImageButton ibAbrirActivity;
    private ImageButton ibEnviarDatos;
    private ImageButton ibDevolverDatos;
    private ImageButton ibAbrirMarcado;
    private ImageButton ibLlamar;
    private ImageButton ibAbrirGoogleMaps;
    private ImageButton ibAbrirPaginaWeb;
    private ImageButton ibCompartirTexto;
    private ImageButton ibCompartirImagen;
    private ImageButton ibEnviarMail;
    private ImageButton ibAbrirApp;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ibAbrirActivity = (ImageButton) findViewById(R.id.ibAbrirActivity);
        ibEnviarDatos = (ImageButton) findViewById(R.id.ibEnviarDatos);
        ibDevolverDatos = (ImageButton) findViewById(R.id.ibDevolverDatos);
        ibAbrirMarcado = (ImageButton) findViewById(R.id.ibAbrirMarcado);
        ibLlamar = (ImageButton) findViewById(R.id.ibLlamar);
        ibAbrirGoogleMaps = (ImageButton) findViewById(R.id.ibAbrirGoogleMaps);
        ibAbrirPaginaWeb = (ImageButton) findViewById(R.id.ibAbrirPaginaWeb);
        ibCompartirTexto = (ImageButton) findViewById(R.id.ibCompartirTexto);
        ibCompartirImagen = (ImageButton) findViewById(R.id.ibCompartirImagen);
        ibEnviarMail = (ImageButton) findViewById(R.id.ibEnviarEmail);
        ibAbrirApp = (ImageButton) findViewById(R.id.ibAbrirApp);

        ibAbrirActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivity();
            }
        });

        ibEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarDatos();
            }
        });

        ibDevolverDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                devolverDatos();
            }
        });

        ibAbrirMarcado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirMarcadoTelefonico();
            }
        });

        ibLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamar();
            }
        });

        ibAbrirGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirGoogleMaps();
            }
        });

        ibAbrirPaginaWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirPaginaWeb();
            }
        });

        ibCompartirTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compartirTexto();
            }
        });

        ibCompartirImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compartirImagen();
            }
        });

        ibEnviarMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarMail();
            }
        });

        ibAbrirApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirApp();
            }
        });
    }

    public void abrirActivity() {
        intent = new Intent(
                getApplicationContext(),
                SegundaActivity.class);
        startActivity(intent);
    }

    public void enviarDatos() {
        intent = new Intent(
                getApplicationContext(),
                SegundaActivity.class);
        intent.putExtra("valor1", "Hola Unifranz.");
        intent.putExtra("valor2", "Curso Android.");
        startActivity(intent);
    }

    public void devolverDatos() {
        intent = new Intent(
                getApplicationContext(),
                SegundaActivity.class);
        intent.putExtra("valor3", "Mi nombre es ");
        startActivityForResult(intent, 2);
    }

    public void abrirMarcadoTelefonico() {
        intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:77752810"));
        startActivity(intent);
    }

    public void llamar() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if(permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 123);
        } else {
            intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:77752810"));
            startActivity(intent);
        }
    }

    public void abrirGoogleMaps() {
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:-16.504014,-68.130906"));
        startActivity(intent);
    }

    public void abrirPaginaWeb() {
        intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com"));
        startActivity(intent);
    }

    public void compartirTexto() {
        intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Hola a todos!");
        startActivity(intent);
    }

    public void compartirImagen() {
        intent = new Intent(Intent.ACTION_SEND);
        Uri uri = Uri.parse("android.resource://com.miramicodigo.sj_a_1_17_java_3_intents/"+R.drawable.googlemaps);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setType("image/*");
        startActivity(intent);
    }

    public void enviarMail() {
        String [] TO = {"lizarraga.gux@gmail.com", "luisperez@gmail.com"};
        String [] CC = {"juanloza@gmail.com"};
        String asunto = "Solicitud de permiso";
        String contenido = "Mediante la presente solicito permiso para tal fecha.";

        intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, TO);
        intent.putExtra(Intent.EXTRA_CC, CC);
        intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        intent.putExtra(Intent.EXTRA_TEXT, contenido);

        startActivity(Intent.createChooser(intent, "Enviar correoooooo"));
    }

    public void abrirApp() {
        intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName(
                "com.facebook.katana",
                "com.facebook.katana.LoginActivity");
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2) {
            if(resultCode == RESULT_OK) {
                String resultado = data.getStringExtra("respuesta").toString();
                Toast.makeText(
                        getApplicationContext(),
                        resultado,
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(
                        getApplicationContext(),
                        "Se cancelo la respuesta.",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 123:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    llamar();
                } else {
                    Log.d("TAG", "Permiso de llamada no concedido");
                }
                break;
            default:
                break;
        }
    }
}
