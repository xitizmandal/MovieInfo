package com.xitiz.recycler;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private Toolbar toolbar;
    private RelativeLayout mRelativeLayout;

    private int oldColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        oldColor = Color.WHITE;

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.mainRelativeLayout);
        setCustomBackground(R.drawable.warcraft);

        mAdapter = new MoviesAdapter(movieList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),3);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();


    }


    private void prepareMovieData() {
        Movie movie = new Movie(R.drawable.kabaddi,"Loot", "Action, Comedy", "2013", (float) 4.2);
        movieList.add(movie);

        movie = new Movie(R.drawable.kabaddi,"Kabadi", "Love, Comedy", "2014", (float) 4.5);
        movieList.add(movie);

        movie = new Movie(R.drawable.warcraft,"Bhirkhe lai chinchas", "Unknown", "2015", (float) 2);
        movieList.add(movie);

        movie = new Movie(R.drawable.warcraft,"Kabadi Kabadi", "Love, Comedy", "2016",(float) 3.8);
        movieList.add(movie);

        movie = new Movie(R.drawable.kabaddi, "6 ekan 6", "Comedy", "2015", (float) 4);
        movieList.add(movie);

        movie = new Movie(R.drawable.kabaddi, "Pashupati Prasad", "Serious, Reality", "2016", (float) 4.6);
        movieList.add(movie);

        movie = new Movie(R.drawable.warcraft, "WarCraft", "Animation, Fantasy", "2016", (float) 4.3);
        movieList.add(movie);

        movie = new Movie(R.drawable.conj, "Conjuring 2", "Horror", "2016", (float) 4);
        movieList.add(movie);

        movie = new Movie(R.drawable.minions, "Minions", "Animation", "2014", (float) 4.4);
        movieList.add(movie);

        movie = new Movie(R.drawable.kabaddi, "Iron Man", "Action & Adventure", "2008", (float) 3.8);
        movieList.add(movie);

        movie = new Movie(R.drawable.warcraft, "Back to the Future", "Science Fiction", "1985", (float) 4.3);
        movieList.add(movie);


        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Toast.makeText(getApplicationContext(),"Recycler View",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.exit:
                System.exit(1);
                return true;

            case R.id.favourite:
                Toast.makeText(getApplicationContext(),"Favourites view",Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void backgroundTransistion(int newColor){
        View v = findViewById(R.id.mainRelativeLayout);
        Bitmap bmp;
        ObjectAnimator anim = ObjectAnimator.ofInt(v, "backgroundColor", oldColor, newColor);


        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatCount(0);
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setDuration(3000);
        anim.start();

//        Toast.makeText(this,oldColor,Toast.LENGTH_SHORT).show();
        oldColor = newColor;

    }

    public void setCustomBackground(int drawable) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),drawable);
        BlurEffect blurEffect = new BlurEffect(this);
        Bitmap blurredBitmap = blurEffect.blur(bitmap);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),blurredBitmap);
//        mRelativeLayout.setBackground(bitmapDrawable);
        mRelativeLayout.setBackgroundColor(oldColor);

    }

    public void ImageViewAnimatedChange(final int drawable) {
        final Context c = getApplicationContext();
        final Animation anim_out = AnimationUtils.loadAnimation(c, android.R.anim.fade_out);
        final Animation anim_in  = AnimationUtils.loadAnimation(c, android.R.anim.fade_in);
        anim_out.setAnimationListener(new Animation.AnimationListener()
        {
            @Override public void onAnimationStart(Animation animation) {}
            @Override public void onAnimationRepeat(Animation animation) {}
            @Override public void onAnimationEnd(Animation animation)
            {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),drawable);
                BlurEffect blurEffect = new BlurEffect(c);
                Bitmap blurredBitmap = blurEffect.blur(bitmap);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),blurredBitmap);
                mRelativeLayout.setBackground(bitmapDrawable);
                anim_in.setAnimationListener(new Animation.AnimationListener() {
                    @Override public void onAnimationStart(Animation animation) {}
                    @Override public void onAnimationRepeat(Animation animation) {}
                    @Override public void onAnimationEnd(Animation animation) {}
                });
                mRelativeLayout.startAnimation(anim_in);
            }
        });
        mRelativeLayout.startAnimation(anim_out);
    }

}