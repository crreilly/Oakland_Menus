package com.oaklandmenus.sophomoreproject.oakland_menus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Chick:
                startActivity(new Intent(this, CkFilAMenu.class));
                return true;
            /*case R.id.Subway:
                startActivity(new Intent(this, Subway.class));
                return true;
            case R.id.Other:
                startActivity(new Intent(this, Other.class));
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}