//Name(s): Calvin Reilly
//Project: CSE280 Group Project
//Description: The java class that describes the object foodItem, which in turn will represent every
//singular menu item from each selected restaurants menu. All of the variables except for the
//boolean variable 'checked' will be visible in the UI's listview. This class is not specific to
//any activity and will be used by each food menu activity.
//Last Modified: November 18, 2015

package com.oaklandmenus.sophomoreproject.oakland_menus;

public class foodItem
{
    private String itemName;
    private int calories;
    private double price;
    private int chkBoxID;
    private boolean checked;

    //constructor for each food item
    public foodItem(String itemName, int calories, double price, int chkBoxID, boolean checked)
    {
        super();
        this.itemName = itemName;
        this.calories = calories;
        this.price = price;
        this.chkBoxID = chkBoxID;
        this.checked = checked;
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

    public int getChkBoxID()
    {
        return chkBoxID;
    }

    public void setChkBoxId(int picValue)
    {

        chkBoxID = picValue;

    }

    public boolean isChecked()
    {
        return checked;
    }
}
