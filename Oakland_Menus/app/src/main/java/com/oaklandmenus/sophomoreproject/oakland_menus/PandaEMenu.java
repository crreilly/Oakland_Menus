package com.oaklandmenus.sophomoreproject.oakland_menus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PandaEMenu extends AppCompatActivity
{


    //------------------------ Subway Arrays -------------------------------------------------------
    String[] foodArray = {"Bowl (1 meat & 1 side)","Plate (2 meat & 1 side)","Bigger Plate (3 meat & 1 side)",
            "Chow Mein (side)","Mixed Vegetables (side)","White Rice (side)","Brown Rice (side)","Fried Rice (side)",
            "Orange Chicken (meat)","String Bean Chicken (meat)","Kung Pao Chicken (meat)",
            "Mushroom Chicken (meat)","Beijing Beef (meat)","Broccoli Beef (meat)","Shanghai Angus Steak (meat)",
            "Honey Walnut Shrimp (meat)","Chicken Egg Roll","Veggie Spring Rolls (2)","Fountain Drinks ",
            "Bottled Water","Bottled Drinks"};

    int[] caloriesArray = {0,0,0,510,80,380,420,520,380,190,290,170,470,150,310,360,200,190,250,0,250};

    double[] priceArray = {6.00,7.00,8.50,0,0,0,0,0,0,0,0,0,0,0,0,0,1.90,1.90,1.80,1.75,1.80};
    //----------------------------------------------------------------------------------------------


    //array will be false unless user wants an item, then that item's false will turn into a true
    boolean[] ItemYesNo = {false,false,false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false};

    //array holding the picture id (either checked or unchecked)
    int[] picId = {R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox};


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
        // REVISE ONCE PRICE AND NUTRITION CALCULATOR IS COMPLETE (JUST NEED THE NAME)
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
                    Intent myIntent = new Intent(getApplicationContext(), PriceAndCal.class);
                    myIntent.putExtra("FoodName", FoodName);
                    myIntent.putExtra("CaloriesPerUnit", CaloriesPerUnit);
                    myIntent.putExtra("PricePerUnit", PricePerUnit);
                    startActivity(myIntent);
                }
            }
        });

    }

    //-------------------------------------private methods/classes--------------------------------------
    //fills the food list with values from each separate array
    private void populateFoodList()
    {
        int itemCount = 0;

        //generates n items into the foodlist, where n is the amount of items in the food array
        //which was defined at the top in "subway arrays"
        while (itemCount < foodArray.length)
        {
            myFood.add(new foodItem(foodArray[itemCount], caloriesArray[itemCount],
                    priceArray[itemCount], picId[itemCount], ItemYesNo[itemCount]));
            itemCount++;
        }
    }

    //uses the template found in food_item_view to generate a list of templates by using myListAdapter
    private void populateListView()
    {
        ArrayAdapter<foodItem> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.foodListView);
        list.setAdapter(adapter);
    }

    //dynamically populates the list based off of the items in the arrayList
    private class MyListAdapter extends ArrayAdapter<foodItem>
    {
        public MyListAdapter()
        {
            super(PandaEMenu.this, R.layout.food_item_view, myFood);
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
            makePrice.setText(String.format("%.2f", currentFoodItem.getPrice()));

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

