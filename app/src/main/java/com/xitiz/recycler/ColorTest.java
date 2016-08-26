package com.xitiz.recycler;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * Created by xitiz on 8/26/16.
 */
public class ColorTest extends Activity {

    public int color1, color2, red1, red2, blue1, blue2, green1, green2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_test);

        // Generate color1 before starting the thread
        startAnim();
    }

    public void startAnim(){
        red1 = (int)(Math.random() * 128 + 127);
        green1 = (int)(Math.random() * 128 + 127);
        blue1 = (int)(Math.random() * 128 + 127);
        color1 = 0xff << 24 | (red1 << 16) |
                (green1 << 8) | blue1;


        new Thread() {
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ColorTest.this.runOnUiThread(new Runnable() {
                        public void run() {

                            //generate color 2

                            red2 = (int)(Math.random() * 128 + 127);
                            green2 = (int)(Math.random() * 128 + 127);
                            blue2 = (int)(Math.random() * 128 + 127);
                            color2 = 0xff << 24 | (red2 << 16) |
                                    (green2 << 8) | blue2;

                            //start animation
                            View v = findViewById(R.id.viewA);
                            ObjectAnimator anim = ObjectAnimator.ofInt(v, "backgroundColor", color1, color2);


                            anim.setEvaluator(new ArgbEvaluator());
                            anim.setRepeatCount(ValueAnimator.INFINITE);
                            anim.setRepeatMode(ValueAnimator.REVERSE);
                            anim.setDuration(3000);
                            anim.start();

                            // Now set color1 to color2
                            // This way, the background will go from
                            // the previous color to the next color
                            // smoothly
                            color1 = color2;

                        }
                    });
                }
            }
        }.start();

    }
}