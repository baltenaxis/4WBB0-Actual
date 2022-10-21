package com.example.database2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {
    public ItemAdapter(@NonNull Context context, ArrayList<Item> arrayList){
        super(context,0,arrayList);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        View currentItemView = convertView;
        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
        }
        Item currentItemPosition = getItem(position);
        ImageView itemImage = currentItemView.findViewById(R.id.imageView);
        assert currentItemPosition != null;
        itemImage.setImageResource(currentItemPosition.getItemImageId());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView textView1 = currentItemView.findViewById(R.id.textView1);
        textView1.setText(currentItemPosition.getItemInDigit());

        // then according to the position of the view assign the desired TextView 2 for the same
        TextView textView2 = currentItemView.findViewById(R.id.textView2);
        textView2.setText(currentItemPosition.getItemInText());

        // then return the recyclable view
        return currentItemView;
    }
}
