package com.oaklandmenus.sophomoreproject.oakland_menus;

public class priceAndCaloriesItem
{
    private String itemName;
    private int calories;
    private double price;

    //constructor for each food item
    public priceAndCaloriesItem(String itemName, int calories, double price)
    {
        super();
        this.itemName = itemName;
        this.calories = calories;
        this.price = price;
    }

    public String getItemName()
    {
        return itemName;
    }

    public int getCalories()
    {
        return calories;
    }

    public double getPrice()
    {
        return price;
    }

}
