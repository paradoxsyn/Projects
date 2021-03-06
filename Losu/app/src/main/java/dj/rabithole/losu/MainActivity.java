package dj.rabithole.losu;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Rabithole on 10/17/2016.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

        // Explicitly load all shared libraries for Android 4.1 (Jelly Bean)
        // Or we could get a crash from dependencies.

        final Button but1 = (Button) findViewById(R.id.button_1);
        final Button but2 = (Button) findViewById(R.id.button_2);
        final Button but3 = (Button) findViewById(R.id.button_3);
        final Button but4 = (Button) findViewById(R.id.button_4);
        final TextView title = (TextView) findViewById(R.id.titletext);

        Typeface customFont1 = Typeface.createFromAsset(getAssets(), "fonts/GoodDog.otf");
        Typeface customFont2 = Typeface.createFromAsset(getAssets(), "fonts/Capture_it_2.ttf");

        but1.setTypeface(customFont1);
        but2.setTypeface(customFont1);
        but3.setTypeface(customFont1);
        but4.setTypeface(customFont1);
        title.setTypeface(customFont2);

        RunAnimation();


        //Animator titleAnim = AnimatorInflater.loadAnimator(this, R.animator.mainpage_button_move);
        //titleAnim.setTarget(title);



        but1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                Intent intent = new Intent(getApplicationContext(),dj.rabithole.losu.PickChamp.class);
                String strReact = "Reaction";
                intent.putExtra("Res",strReact);
                startActivity(intent);


            }

        }
        );
        but2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),dj.rabithole.losu.Psych.class);
                startActivity(intent);
            }

        }
        );
        but3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(),dj.rabithole.losu.PickChamp.class);
                String strRange = "Range";
                intent.putExtra("Res",strRange);
                startActivity(intent);
            }

        }
        );
        but4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                setContentView(R.layout.about);
            }

        }
        );
    }


    public void selfDestruct(View view) {
        // Kabloey
    }

    private void RunAnimation()
    {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.mainpage_button_move);
        a.reset();
        TextView tv = (TextView) findViewById(R.id.titletext);
        tv.clearAnimation();
        tv.startAnimation(a);
    }
    private void RunAnimationButton(){
        Animation a = AnimationUtils.loadAnimation(this, R.anim.mainpagetext);
        a.reset();
        Button bt = (Button) findViewById(R.id.button_1);
        bt.clearAnimation();
        bt.startAnimation(a);
    }
}

 