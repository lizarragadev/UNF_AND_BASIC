package com.miramicodigo.p6_animations;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashscreenActivity extends AppCompatActivity {

    /**
     * @author Gustavo Lizarraga
     * @date 18-10-2017
     */

    private Animation animation;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        ivLogo = (ImageView) findViewById(R.id.ivLogotipo);


    }
}







