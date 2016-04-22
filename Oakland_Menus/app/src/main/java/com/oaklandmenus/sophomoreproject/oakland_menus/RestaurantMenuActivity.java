package com.oaklandmenus.sophomoreproject.oakland_menus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class RestaurantMenuActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurantmenu_layout);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public void buttonOnClick(View view)
    {

        switch (view.getId())
        {

            case R.id.Chick:
                startActivity(new Intent(this, CkFilAMenu.class));

                break;

            case R.id.Subway:
                startActivity(new Intent(this, SubwayMenu.class));

                break;

            case R.id.Panda:
                startActivity(new Intent(this, PandaEMenu.class));

                break;


        }
    }
}