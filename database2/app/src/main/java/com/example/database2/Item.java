package com.example.database2;

public class Item {
    private int ivItemImageId;

    // TextView 1
    private String mItemInDigit;

    // TextView 1
    private String mItemInText;

    // create constructor to set the values for all the parameters of the each single view
    public Item(int itemImageId, String itemInDigit, String itemInText) {
        ivItemImageId = itemImageId;
        mItemInDigit = itemInDigit;
        mItemInText = itemInText;
    }

    // getter method for returning the ID of the imageview
    public int getItemImageId() {
        return ivItemImageId;
    }

    // getter method for returning the ID of the TextView 1
    public String getItemInDigit() {
        return mItemInDigit;
    }

    // getter method for returning the ID of the TextView 2
    public String getItemInText() {
        return mItemInText;
    }
}
