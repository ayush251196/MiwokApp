package com.example.android.miwok;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AYUSH on 25-03-2018.
 */

public class Myadapter2 extends ArrayAdapter<Mainnames> {

    Myadapter2(Activity context, ArrayList<Mainnames> arrayList) {
        super(context, 0,arrayList);
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.mainlayout, parent,false);
        }
        TextView textView =(TextView)view.findViewById(R.id.textmain);
        LinearLayout linearLayout=(LinearLayout) view.findViewById(R.id.ll);
        linearLayout.setBackgroundResource(getItem(position).getColor());
      //  textView.setBackgroundResource(getItem(position).getColor());
        textView.setText(getItem(position).getName());
        textView.setHeight(120);
        String s = getItem(position).getName();
        if(s == "Numbers"){
            Intent intent=new Intent(getContext(),Numbers.class);
        } else if (s == "Family Members") {
            Intent intent=new Intent(getContext(),FamilyMembers.class);
        }else if(s=="Colors"){
            Intent intent=new Intent(getContext(),Color.class);
        }else{
            Intent intent=new Intent(getContext(),Phrases.class);
        }
        return view;}
}