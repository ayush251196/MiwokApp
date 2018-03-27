package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {


    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_color, container, false);
        ArrayList<Customnames> arrayList=new ArrayList<Customnames>();
        arrayList.add(new Customnames("red","wetetti",R.drawable.color_red,R.raw.color_red));
        arrayList.add(new Customnames("mustard yellow","chiwiite",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        arrayList.add(new Customnames("dusty yellow","topisa",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        arrayList.add(new Customnames("brown","chokki",R.drawable.color_brown,R.raw.color_brown));
        arrayList.add(new Customnames("gray","takkaki",R.drawable.color_gray,R.raw.color_gray));
        arrayList.add(new Customnames("black","kululli",R.drawable.color_black,R.raw.color_black));
        arrayList.add(new Customnames("white","kelelli",R.drawable.color_white,R.raw.color_white));
        Myadapter myadapter=new Myadapter(getActivity(),arrayList,R.color.category_colors);
        Myadapter.am= (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);
        ListView listView=(ListView)rootView.findViewById(R.id.listviewc);
        listView.setAdapter(myadapter);
        return  rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        Myadapter.released(Myadapter.mediaPlayer);
    }

}
