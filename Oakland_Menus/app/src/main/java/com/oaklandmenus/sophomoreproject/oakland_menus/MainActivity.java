package com.oaklandmenus.sophomoreproject.oakland_menus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class GreatAndroidAppActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.restaurants:
                startActivity(new Intent(this, Restaurants.class));
                return true;
            case R.id.Coffee:
                startActivity(new Intent(this, Coffee.class));
                return true;
            case R.id.Map:
                startActivity(new Intent(this, Maps.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
