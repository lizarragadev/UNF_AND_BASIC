package com.miramicodigo.p11_mediaplayer;

import android.media.MediaPlayer;
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
     * @date 20-10-17
     *
     * */

    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private ImageView ivAlpha;
    private Animation animacion;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnStop = (Button) findViewById(R.id.btnStop);
        ivAlpha = (ImageView) findViewById(R.id.ivAlpha);

        animacion = AnimationUtils.loadAnimation(this, R.anim.blink);

        initUI();
        initMediaPlayer();
    }

    public void initUI() {
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        btnStop.setEnabled(false);
    }

    public void initMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.acdc);
    }

    public void play(View view) {
        try {
            mediaPlayer.start();
            ivAlpha.startAnimation(animacion);
            btnPlay.setEnabled(false);
            btnPause.setEnabled(true);
            btnStop.setEnabled(true);
        } catch (Exception e) {
            System.out.println("Hubo un error en: "+e.getMessage());
        }
    }

    public void pause(View view) {
        try {
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                ivAlpha.clearAnimation();
                btnPlay.setEnabled(true);
                btnStop.setEnabled(false);
            }
        } catch (Exception e) {
            System.out.println("Hubo un error en: "+e.getMessage());
        }
    }

    public void stop(View view) {
        try{
            if(mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                ivAlpha.clearAnimation();
                initMediaPlayer();
                initUI();
            }
        } catch(Exception e) {
            System.out.println("Hubo un error en: "+e.getMessage());
        }
    }
}