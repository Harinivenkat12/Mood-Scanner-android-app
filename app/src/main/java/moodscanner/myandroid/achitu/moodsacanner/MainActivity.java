package moodscanner.myandroid.achitu.moodsacanner;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView resultText;
    private Runnable mRunnable;
    private AnimationDrawable moodAnimation;
    private String[] moodResults={"Happy Camper!","Someone's cranky!","Am I just Great!","Excited!","Is this day over yet?","Bummer!","So far so cool!","In the clouds..!","No Comments!","Not in the mood to let an app ruin my day !"};

    private final Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView) findViewById(R.id.imageViewTopId);
        imageView.setBackgroundResource(R.drawable.animation);        moodAnimation = (AnimationDrawable) imageView.getBackground();

        resultText = (TextView) findViewById(R.id.resultTextId);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                moodAnimation.start();
                showResult();


                return false;
            }
        });
    }

        public void showResult() {
        mRunnable = new Runnable() {
            @Override
            public void run() {
                int random = rand.nextInt(moodResults.length);
                resultText.setText(moodResults[random]);
                moodAnimation.stop();
            }
        };
            Handler mHandler=new Handler();
            mHandler.postDelayed(mRunnable,5000);
    }




    }



