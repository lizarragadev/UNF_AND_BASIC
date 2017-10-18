package com.miramicodigo.p6_animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    /**
     * @author Gustavo Lizarraga
     * @date 18-10-2017
     */

    private Animation animation;
    private ImageView ivOctocat;
    private ImageView ivOctocat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivOctocat = (ImageView) findViewById(R.id.ivOctocat);
        ivOctocat2 = (ImageView) findViewById(R.id.ivOctocat2);

    }

    public void zoomin(View v) {

    }

    public void zoomout(View v) {

    }

    public void fadein(View v) {

    }

    public void fadeout(View v) {

    }

    public void rotate(View v) {

    }

    public void move(View v) {

    }

    public void slideup(View v) {

    }

    public void slidedown(View v) {

    }

    public void blink(View v) {

    }

    public void bounce(View v) {

    }

    public void crossfade(View v) {

    }

    public void sequential(View v) {

    }

    public void together(View v) {

    }

    public void stop(View v) {

    }
}
