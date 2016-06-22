package com.xitiz.recycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by xitiz on 6/22/16.
 */
public class PictureActivity extends AppCompatActivity{
    ImageView imageView;
    int imgSrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        Intent intent = this.getIntent();
        imgSrc = intent.getExtras().getInt("imageReference");

        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(imgSrc);

    }

}
