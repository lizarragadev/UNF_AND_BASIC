package com.miramicodigo.basicexam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 * @author Gustavo Lizarraga
 * @date 12-06-2017
 *
 * */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etUser;
    private EditText etPassword;
    private Button btnCancel;
    private Button btnLonIn;
    private Student studentMan;
    private Student studentWoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        initUI();
    }

    public void initUI() {
        etUser = (EditText) findViewById(R.id.etUser);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnLonIn = (Button) findViewById(R.id.btnLogIn);

        btnCancel.setOnClickListener(this);
        btnLonIn.setOnClickListener(this);

        initObjects();
    }

    public void initObjects() {
        studentMan = new Student();
        studentMan.setFullName("Gustavo Lizarraga");
        studentMan.setGender("masculino");
        studentMan.setAge(25);
        studentMan.setUser("gus");
        studentMan.setPass("12345");

        studentWoman = new Student();
        studentWoman.setFullName("Maria Loza");
        studentWoman.setGender("femenino");
        studentWoman.setAge(19);
        studentWoman.setUser("maria");
        studentWoman.setPass("12345");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCancel:
                finish();
                break;
            case R.id.btnLogIn:
                logIn();
                break;
        }
    }

    public void logIn() {
        String userTemp = etUser.getText().toString();
        String passTemp = etPassword.getText().toString();
        if(!userTemp.equals(    "") || !passTemp.equals("")) {
            if(userTemp.equals(studentMan.getUser()) && passTemp.equals(studentMan.getPass())){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("student", studentMan);
                startActivity(intent);
            } else {
                if(userTemp.equals(studentWoman.getUser()) && passTemp.equals(studentWoman.getPass())){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("student", studentWoman);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.login_toast_invalid), Toast.LENGTH_SHORT).show();
                }
            }
        }else {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.login_toast_camposvacios), Toast.LENGTH_SHORT).show();
        }
    }

    public void goWebSite(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.unifranz.edu.bo"));
        startActivity(intent);
    }
}
