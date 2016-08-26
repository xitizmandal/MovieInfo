package com.xitiz.recycler;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by xitiz on 6/22/16.
 */
public class PictureActivity extends AppCompatActivity{
    ImageView imageView;
    int imgSrc;
    private RelativeLayout mRelativeLayout;
    public static final String EXTRA_PARAM_IMAGE = "image";
    public static final String EXTRA_PARAM_TITLE = "title";
    public static final String EXTRA_PARAM_GENRE = "genre";
    public static final String EXTRA_PARAM_YEAR = "year";
    public static final String EXTRA_PARAM_RATING = "rating";
    private static final float BLUR_RADIUS = 25f;
    FloatingActionButton floatingActionButton;
    CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        Intent intent = this.getIntent();
        imgSrc = intent.getExtras().getInt(EXTRA_PARAM_IMAGE);

        imageView = (ImageView) findViewById(R.id.imageView);
        mRelativeLayout= (RelativeLayout) findViewById(R.id.relativeLayout);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cdrLayout);



        imageView.setImageResource(imgSrc);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imgSrc);

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.nature);
        BlurEffect blurEffect = new BlurEffect(this);
        Bitmap blurredBitmap = blurEffect.blur(bitmap);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),blurredBitmap);
//        coordinatorLayout.setBackground(bitmapDrawable);

        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                int bgColor = palette.getVibrantColor(getResources().getColor(android.R.color.black));
                mRelativeLayout.setBackgroundColor(bgColor);

//                getActionBar().setBackgroundDrawable(new ColorDrawable(palette.getMutedColor(
//                        getResources().getColor(R.color.colorPrimary))));
            }
        });

    }



}
