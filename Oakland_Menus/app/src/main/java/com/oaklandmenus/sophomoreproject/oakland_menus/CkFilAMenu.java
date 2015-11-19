//Name(s): Calvin Reilly
//Project: CSE280 Group Project
//Description: The main java class for the CkFilAMenu activity, this will construct the listview
//seen in the UI for the Chick-fil-A menu and will hold all values associated with the menu items
//it will also send selected values to the price and nutrition calculator.
//Last Modified: November 18, 2015

package com.oaklandmenus.sophomoreproject.oakland_menus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;

public class CkFilAMenu extends AppCompatActivity
{

    //------------------------ Chick-fil-A Arrays --------------------------------------------------
    String[] foodArray = {"Grilled Chicken Sandwich","Chick-fil-A Sandwich","Spicy Chicken Sandwich"
            ,"Chick-n-Strips (3-count)","Chick-n-Strips (4-count)","Chick-fil-A Nuggets (8-count)"
            ,"Chick-fil-A Nuggets (12-count)","Grilled Chicken Cool Wrap","Grilled Market Salad"
            ,"Waffle Potato Fries","Fruit Cup","Yogurt Parfait (Granola)","Yogurt Parfait (Chocolate)"
            ,"Lemonade","Iced Tea","Hot Coffee"};

    int[] caloriesArray = {320,440,490,360,470,270,400,360,240,390,70,120,150,230,130,5};

    double[] priceArray = {4.10,3.35,3.70,3.55,4.79,3.25,4.80,5.40,7.09,1.85,2.85,2.55,2.55,
            1.79,1.79,2.09};
    //----------------------------------------------------------------------------------------------


    //array will be false unless user wants an item, then that item's false will turn into a true
    boolean[] ItemYesNo = {false,false,false,false,false,false,false,false,false,false,false,false
            ,false,false,false,false};

    //array holding the picture id (either checked or unchecked)
    int[] picId = {R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox,};

    private List<foodItem> myFood = new ArrayList<foodItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ck_fil_amenu);

        //private methods within this class
        populateFoodList();
        populateListView();
        registerItemSelect();

        //listener for the Price and Nutrition Calculator button
        /* REVISE ONCE PRICE AND NUTRITION CALCULATOR IS COMPLETE (JUST NEED THE NAME)
        Button priceAndNutrition = (Button) findViewById(R.id.btnPaNCalc);
        priceAndNutrition.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int count = 0, totLength = 0, arrayPlace = 0;
                while(count<ItemYesNo.length)
                {
                    if(ItemYesNo[count] == true)
                    {
                        totLength++;
                        count++;
                    }
                    else
                    {
                        count++;
                    }
                }

                //will not send anything unless the user has selected items
                if(totLength>0) {
                    String[] FoodName = new String[totLength];
                    int[] CaloriesPerUnit = new int[totLength];
                    double[] PricePerUnit = new double[totLength];
                    int[] trackerArray = new int[totLength];

                    count = 0;
                    totLength = 0;
                    while (count < ItemYesNo.length) {
                        if (ItemYesNo[count] == true) {
                            trackerArray[totLength] = count;
                            totLength++;
                            count++;
                        } else {
                            count++;
                        }
                    }

                    //copies items at position 'arrayPlace' from the food, calories, and price
                    //arrays into their respective array that will be sent in the intent
                    while (arrayPlace < trackerArray.length) {
                        FoodName[arrayPlace] = foodArray[trackerArray[arrayPlace]];
                        CaloriesPerUnit[arrayPlace] = caloriesArray[trackerArray[arrayPlace]];
                        PricePerUnit[arrayPlace] = priceArray[trackerArray[arrayPlace]];
                        arrayPlace++;
                    }

                    //INPUT PRICE AND NUTRITION NAME IN THE LINE BELOW
                    Intent myIntent = new Intent(getApplicationContext(), INSERT HERE);
                    myIntent.putExtra("FoodName", FoodName);
                    myIntent.putExtra("CaloriesPerUnit", CaloriesPerUnit);
                    myIntent.putExtra("PricePerUnit", PricePerUnit);
                    startActivity(myIntent);
                }
            }
        });
        **/
    }

    //-------------------------------------private methods/classes--------------------------------------
    //fills the food list with values from each separate array
    private void populateFoodList()
    {
        myFood.add(new foodItem(foodArray[0], caloriesArray[0],priceArray[0], picId[0], ItemYesNo[0]));
        myFood.add(new foodItem(foodArray[1], caloriesArray[1],priceArray[1], picId[1], ItemYesNo[1]));
        myFood.add(new foodItem(foodArray[2], caloriesArray[2],priceArray[2], picId[2], ItemYesNo[2]));
        myFood.add(new foodItem(foodArray[3], caloriesArray[3],priceArray[3], picId[3], ItemYesNo[3]));
        myFood.add(new foodItem(foodArray[4], caloriesArray[4],priceArray[4], picId[4], ItemYesNo[4]));
        myFood.add(new foodItem(foodArray[5], caloriesArray[5],priceArray[5], picId[5], ItemYesNo[5]));
        myFood.add(new foodItem(foodArray[6], caloriesArray[6],priceArray[6], picId[6], ItemYesNo[6]));
        myFood.add(new foodItem(foodArray[7], caloriesArray[7],priceArray[7], picId[7], ItemYesNo[7]));
        myFood.add(new foodItem(foodArray[8], caloriesArray[8],priceArray[8], picId[8], ItemYesNo[8]));
        myFood.add(new foodItem(foodArray[9], caloriesArray[9],priceArray[9], picId[9], ItemYesNo[9]));
        myFood.add(new foodItem(foodArray[10], caloriesArray[10],priceArray[10], picId[10], ItemYesNo[10]));
        myFood.add(new foodItem(foodArray[11], caloriesArray[11],priceArray[11], picId[11], ItemYesNo[11]));
        myFood.add(new foodItem(foodArray[12], caloriesArray[12],priceArray[12], picId[12], ItemYesNo[12]));
        myFood.add(new foodItem(foodArray[13], caloriesArray[13],priceArray[13], picId[13], ItemYesNo[13]));
        myFood.add(new foodItem(foodArray[14], caloriesArray[14],priceArray[14], picId[14], ItemYesNo[14]));
        myFood.add(new foodItem(foodArray[15], caloriesArray[15],priceArray[15], picId[15], ItemYesNo[15]));
    }

    private void populateListView()
    {
        ArrayAdapter<foodItem> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.foodListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<foodItem>
    {
        public MyListAdapter()
        {
            super(CkFilAMenu.this, R.layout.food_item_view, myFood);
        }

        @Override
        public View getView(int position,View convertView, ViewGroup parent)
        {
            //finds the viewing template (the listview template created)
            View itemView = convertView;
            if(itemView == null)
            {
                itemView = getLayoutInflater().inflate(R.layout.food_item_view, parent, false);
            }

            //selecting the food item
            foodItem currentFoodItem = myFood.get(position);

            //setting the checkbox image for the food item
            ImageView imageView = (ImageView) itemView.findViewById(R.id.item_chkBox);
            imageView.setImageResource(currentFoodItem.getChkBoxID());

            //set the text value for item name
            TextView makeName = (TextView) itemView.findViewById(R.id.item_foodName);
            makeName.setText(currentFoodItem.getItemName());

            //set the value for the number of calories
            TextView makeCalories = (TextView) itemView.findViewById(R.id.item_foodCal);
            makeCalories.setText("" + currentFoodItem.getCalories());

            //set the value for the item price
            TextView makePrice = (TextView) itemView.findViewById(R.id.item_foodPrice);
            makePrice.setText("" + currentFoodItem.getPrice());

            return itemView;
        }

    }

    //basically an onclick event for the selected food item
    private void registerItemSelect()
    {
        ListView list = (ListView) findViewById(R.id.foodListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                foodItem clickedFoodItem = myFood.get(position);

                //determines if the item was previously selected
                if(ItemYesNo[position] == false)
                {
                    ItemYesNo[position] = true;
                    picId[position] = R.drawable.checked_checkbox;
                    clickedFoodItem.setChkBoxId(R.drawable.checked_checkbox);
                }
                else
                {
                    ItemYesNo[position] = false;
                    picId[position] = R.drawable.unchecked_checkbox;
                    clickedFoodItem.setChkBoxId(R.drawable.unchecked_checkbox);
                }

                //updates the items checkbox image
                ImageView imageView = (ImageView) view.findViewById(R.id.item_chkBox);
                imageView.setImageResource(picId[position]);
            }
        });
    }
}