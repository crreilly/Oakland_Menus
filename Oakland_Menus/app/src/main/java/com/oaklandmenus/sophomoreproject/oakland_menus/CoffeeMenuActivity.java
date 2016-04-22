package com.oaklandmenus.sophomoreproject.oakland_menus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

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

    public void buttonOnClick(View view)
    {

        switch (view.getId())
        {

            case R.id.einstein:
                startActivity(new Intent(this, EnBrosMenu.class));

                break;

            case R.id.CafeOBears:
                startActivity(new Intent(this, AuBoPaMenu.class));

                break;

        }
    }
}

