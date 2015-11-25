package com.oaklandmenus.sophomoreproject.oakland_menus;

import java.text.DecimalFormat;
import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends Activity implements OnRatingBarChangeListener {

    RatingBar R_Bar ;

    TextView R_status;
    int count;
    float curRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ratings_layout);
        R_Bar = (RatingBar) findViewById(R.id.ratingBar);
        R_status = (TextView) findViewById(R.id.rateStatus);
        R_Bar.setOnRatingBarChangeListener(this);


    }




    @Override
    public void onRatingChanged (RatingBar ratingBar,float rating,
                                 boolean fromUser){
        // TODO Auto-generated method stub


        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        curRate = Float.valueOf(decimalFormat.format((curRate
                * count + rating)
                / ++count));

        Toast.makeText(RatingActivity.this,
                "New Rating: " + curRate, Toast.LENGTH_SHORT)
                .show();


        R_Bar.setRating(curRate);
        R_status.setText(count + "  Ratings");



    }
}
