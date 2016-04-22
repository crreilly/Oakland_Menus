package com.oaklandmenus.sophomoreproject.oakland_menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class PriceAndCal extends AppCompatActivity
{

    private List<priceAndCaloriesItem> myPAC = new ArrayList<priceAndCaloriesItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_price_and_cal);

        //needed in order to chnge the text in the calcPrice and calcCal text boxes
        TextView priceView = (TextView) findViewById(R.id.calcPrice);
        TextView calView = (TextView) findViewById(R.id.calcCal);

        //this is where any intents passed to this class are caught. Three arrays are then made out
        //of the passed intents
        Intent intent = getIntent();
        String[] myStrings = intent.getStringArrayExtra("FoodName");
        int[] foodcal = intent.getIntArrayExtra("CaloriesPerUnit");
        double[] foodprice = intent.getDoubleArrayExtra("PricePerUnit");

        //populates the myPAC arrayList
        int itemCount = 0;
        while (itemCount < myStrings.length)
        {
            myPAC.add(new priceAndCaloriesItem(myStrings[itemCount], foodcal[itemCount],
                    foodprice[itemCount]));
            itemCount++;
        }

        //private method within this class
        populateListView();

        //the counters for both loops
        int priceCount = 0;
        int calorieCount = 0;

        //the total price and calories of the selected items
        double sumPrice = 0;
        int sumCalorie = 0;

        while(priceCount < foodprice.length)
        {
            sumPrice+= foodprice[priceCount];
            priceCount++;
        }

        while(calorieCount < foodcal.length)
        {
            sumCalorie+=foodcal[calorieCount];
            calorieCount++;
        }

        //text boxes only display text, so the sums must be concatenated to the end of a string
        priceView.setText(String.format("%.2f",sumPrice));
        calView.setText("" + sumCalorie);
    }

    //-------------------------------------private methods/classes--------------------------------------

    //uses the template found in price_and_cal_item_view to generate a list of templates by using myListAdapter
    private void populateListView()
    {
        ArrayAdapter<priceAndCaloriesItem> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.priceAndCalListView);
        list.setAdapter(adapter);
    }

    //dynamically populates the list based off of the items in the arrayList
    private class MyListAdapter extends ArrayAdapter<priceAndCaloriesItem>
    {
        public MyListAdapter()
        {
            super(PriceAndCal.this, R.layout.price_and_cal_item_view, myPAC);
        }

        @Override
        public View getView(int position,View convertView, ViewGroup parent)
        {
            //finds the viewing template (the listview template created)
            View itemView = convertView;
            if(itemView == null)
            {
                itemView = getLayoutInflater().inflate(R.layout.price_and_cal_item_view, parent, false);
            }

            //selecting the PAC item
            priceAndCaloriesItem currentPACItem = myPAC.get(position);

            //set the text value for item name
            TextView makeName = (TextView) itemView.findViewById(R.id.price_foodName);
            makeName.setText(currentPACItem.getItemName());

            //set the value for the number of calories
            TextView makeCalories = (TextView) itemView.findViewById(R.id.price_foodCal);
            makeCalories.setText("" + currentPACItem.getCalories());

            //set the value for the item price
            TextView makePrice = (TextView) itemView.findViewById(R.id.price_foodPrice);
            makePrice.setText(String.format("%.2f", currentPACItem.getPrice()));

            return itemView;
        }

    }


}