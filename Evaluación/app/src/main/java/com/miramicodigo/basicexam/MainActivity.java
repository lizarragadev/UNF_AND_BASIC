package com.miramicodigo.basicexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 *
 * @author Gustavo Lizarraga
 * @date 12-06-2017
 *
 * */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvTitle;
    private ImageView ivStudent;
    private TextView tvFullName;
    private TextView tvUser;
    private TextView tvAge;

    private TextView tvGender;

    private LinearLayout llMatter;
    private LinearLayout llTeacher;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        Student student = (Student) getIntent().getSerializableExtra("student");

        if(student.getGender().equals("masculino")){
            tvTitle.setText(getResources().getString(R.string.main_tv_title_man));
            ivStudent.setImageResource(R.drawable.man);
        } else {
            tvTitle.setText(getResources().getString(R.string.main_tv_title_woman));
            ivStudent.setImageResource(R.drawable.woman);
        }
        tvFullName.setText(student.getFullName());
        tvUser.setText("@"+student.getUser());
        tvGender.setText(student.getGender());
        tvAge.setText(student.getAge()+" años");

    }

    public void initUI() {
        tvTitle = (TextView)findViewById(R.id.tv_main_title);
        ivStudent = (ImageView) findViewById(R.id.iv_main_student);
        tvFullName = (TextView) findViewById(R.id.tv_main_fullname);
        tvUser = (TextView) findViewById(R.id.tv_main_user);
        tvGender = (TextView) findViewById(R.id.tv_main_gender);
        tvAge = (TextView) findViewById(R.id.tv_main_age);
        llMatter = (LinearLayout) findViewById(R.id.llMatter);
        llTeacher = (LinearLayout) findViewById(R.id.llTeachers);

        llMatter.setOnClickListener(this);
        llTeacher.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llMatter:
                intent = new Intent(getApplicationContext(), MatterActivity.class);
                break;
            case R.id.llTeachers:
                intent = new Intent(getApplicationContext(), TeacherActivity.class);
                break;
        }
        startActivity(intent);
    }
}
