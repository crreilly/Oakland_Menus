package com.oaklandmenus.sophomoreproject.oakland_menus;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;
import java.text.DecimalFormat;

public class RatingActivity2 extends Activity implements RatingBar.OnRatingBarChangeListener {

    RatingBar R_Bar ;
    int count;
    float curRate;
    Boolean val = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratings_layout2);

        R_Bar = (RatingBar) findViewById(R.id.ratingBar2);

        R_Bar.setOnRatingBarChangeListener(this);


        SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(RatingActivity2.this);
        curRate = sharePref.getFloat("Get_Rating", 0.0f);


        if (val) {
            R_Bar.setRating(curRate);

        } else {
            R_Bar.setRating(curRate);
        }

        final Button switchact = (Button) findViewById(R.id.btn3);

        switchact.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent act1 = new Intent(view.getContext(),RatingActivity3.class);
                startActivity(act1);


            }

        });

        final Button switchact2 = (Button) findViewById(R.id.btn4);

        switchact2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent act2 = new Intent(view.getContext(),RatingActivity.class);
                startActivity(act2);


            }

        });

        final Button switchact3 = (Button) findViewById(R.id.btn12);

        switchact3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent act3 = new Intent(view.getContext(),RatingActivity4.class);
                startActivity(act3);


            }

        });

        final Button switchact4 = (Button) findViewById(R.id.btn30);

        switchact4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent act4 = new Intent(view.getContext(),RatingActivity5.class);
                startActivity(act4);


            }

        });






    }


    public void onRatingChanged (RatingBar ratingBar,float rating,
                                 boolean fromUser){
        // TODO Auto-generated method stub


        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        curRate = Float.valueOf(decimalFormat.format((curRate
                *count + rating)
                / ++count));


        R_Bar.setRating(curRate);



        // Showing a toast of current rating
        Toast.makeText(RatingActivity2.this,
                "New Rating: " + curRate, Toast.LENGTH_SHORT)
                .show();





        SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(RatingActivity2.this);
        SharedPreferences.Editor edit = sharePref.edit();
        edit.putFloat("Get_Rating", curRate);

        edit.commit();
        val = false;





    }



}