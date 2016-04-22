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

public class SubwayMenu extends AppCompatActivity
{


    //------------------------ Subway Arrays -------------------------------------------------------
    String[] foodArray = {" Meatball Marinara(6in)","Meatball Marinara(12in)","Black Forest Ham(6in)",
            "Black Forest Ham(12in)","Cold Cut Combo(6in)","Cold Cut Combo(12in)","Spicy Italian(6in)",
            "Spicy Italian(12in)","Veggie Delite(6in)","Veggie Delite(12in)","B.L.T.(6in)","B.L.T.(12in)",
            "Turkey Italiano Melt(6in)","Turkey Italiano Melt(12in)","Italian B.M.T(6in)","Italian B.M.T(12in)",
            "Turkey Breast(6in)","Turkey Breast(12in)","Turkey and Black Forest(6in)","Turkey and Black Forest(12in)",
            "Tuna(6in)","Tuna(12in)","Oven Roasted Chicken(6in)","Oven Roasted Chicken(12in)","Veggie Patty(6in)",
            "Veggie Patty(12in)","Sweet Onion Chicken(6in)","Sweet Onion Chicken(12in)","Steak and Cheese(6in)",
            "Steak and Cheese(12in)","Subway Club(6in)","Subway Club(12in)","Chicken and Bacon Ranch(6in)",
            "Chicken and Bacon Ranch(12in)","Roast Beef(6in)","Roast Beef(12in)","Subway Melt(6in)",
            "Subway Melt(12in)","Double Chicken Salad","Turkey Breast Salad","Spicy Italian Salad",
            "Tuna Salad","Veggie Delite","Chips","Cookies","Apples","Fountain Drink(21oz)",
            "Fountain Drink(30oz)","Bottled Beverage","Milk"};

    int[] caloriesArray = {480,960,290,580,360,720,480,960,230,560,380,760,510,1020,410,820,280,560,
            280,560,480,960,320,640,390,780,370,740,380,760,310,620,610,1220,320,640,410,820,220,110,
            310,310,60,130,210,35,260,320,160,100};

    double[] priceArray = {3.75,5.5,3.75,5.5,3.75,5.5,3.75,5.5,3.75,5.5,3.75,5.5,4.25,6.75,4.25,6.75,
            4.25,6.75,4.25,6.75,4.25,6.75,4.25,6.75,4.5,6.75,4.75,7.75,4.75,7.75,4.75,7.75,4.75,7.75,
            4.75,7.75,4.75,7.75,6,6,6,6,6,1.25,1.7,1.5,1.8,2,1.8,1.6};
    //----------------------------------------------------------------------------------------------


    //array will be false unless user wants an item, then that item's false will turn into a true
    boolean[] ItemYesNo = {false,false,false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,false,false,false,false,false,
            false,false,false,false,false,false,false,false,false,false};

    //array holding the picture id (either checked or unchecked)
    int[] picId = {R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox,
            R.drawable.unchecked_checkbox, R.drawable.unchecked_checkbox};

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
            super(SubwayMenu.this, R.layout.food_item_view, myFood);
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
