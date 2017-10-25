package com.miramicodigo.basicexam;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 *
 * @author Gustavo Lizarraga
 * @date 12-06-2017
 *
 * */

public class TeacherActivity extends AppCompatActivity {

    private ArrayList<Teacher> data;
    private RecyclerView rvData;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        populate();
        activity = this;

        rvData = (RecyclerView) findViewById(R.id.rvData);
        layoutManager = new GridLayoutManager(activity, 2);
        rvData.setLayoutManager(layoutManager);

        adapter = new TeacherAdapter(activity, data);
        rvData.setAdapter(adapter);

    }

    public void populate() {
        data = new ArrayList<Teacher>();
        String[] arrayTitle = getResources().getStringArray(R.array.teacherFullname);
        String[] arraySubtitle = getResources().getStringArray(R.array.teacherCareer);
        String[] arrayGender = getResources().getStringArray(R.array.teacherGender);
        for (int i = 0; i < arrayTitle.length; i++) {
            Teacher temp = new Teacher(arrayTitle[i], arraySubtitle[i], arrayGender[i]);
            data.add(temp);
        }
    }
}
