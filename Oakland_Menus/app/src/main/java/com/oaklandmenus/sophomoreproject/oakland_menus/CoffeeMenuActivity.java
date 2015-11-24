package com.oaklandmenus.sophomoreproject.oakland_menus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class CoffeeMenuActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coffeemenu_layout);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.starbucks:
                startActivity(new Intent(this, starbucks.class));
                return true;
            case R.id.einstein:
                startActivity(new Intent(this, einstein.class));
                return true;
            case R.id.other:
                startActivity(new Intent(this, other.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

