package com.miramicodigo.basicexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 *
 * @author Gustavo Lizarraga
 * @date 12-06-2017
 *
 * */

public class MatterActivity extends AppCompatActivity {

    private ArrayList<Matter> data;
    private MatterAdapter adapter;
    private ListView lvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matter);

        lvData = (ListView) findViewById(R.id.lvData);
        populateList();
        adapter = new MatterAdapter(this, data);
        lvData.setAdapter(adapter);

        lvData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Matter temp = data.get(position);
                Toast.makeText(
                        getApplicationContext(),
                        "Materia: "+ temp.getName()+"\nSigla: "+temp.getInitials(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    public void populateList() {
        data = new ArrayList<Matter>();
        String[] arrayTitle = getResources().getStringArray(R.array.matterName);
        String[] arraySubtitle = getResources().getStringArray(R.array.matterInitial);
        String[] arrayType = getResources().getStringArray(R.array.matterType);
        for (int i = 0; i < arrayTitle.length; i++) {
            Matter temp = new Matter(arrayTitle[i], arraySubtitle[i], arrayType[i]);
            data.add(temp);
        }
    }

}
