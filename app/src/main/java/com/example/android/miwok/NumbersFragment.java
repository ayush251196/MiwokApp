package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    public NumbersFragment() {
        Log.i("hi","amdfine");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("hi","fragment");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //super.onCreateView(inflater,container,savedInstanceState);
        Log.i("created","jo");
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
        ArrayList<Customnames> arrayList=new ArrayList<Customnames>();
        arrayList.add(new Customnames("one","luttu",R.drawable.number_one,R.raw.number_one));
        arrayList.add(new Customnames("two","qttu",R.drawable.number_two,R.raw.number_two));
        arrayList.add(new Customnames("three","ldttu",R.drawable.number_three,R.raw.number_three));
        arrayList.add(new Customnames("four","lwttu",R.drawable.number_four,R.raw.number_four));
        arrayList.add(new Customnames("five","leeuttu",R.drawable.number_five,R.raw.number_five));
        Myadapter myadapter=new Myadapter(getActivity(),arrayList,R.color.category_numbers);
        Myadapter.am= (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);
        ListView listView=(ListView)rootView.findViewById(R.id.listview);
        listView.setAdapter(myadapter);
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        Myadapter.released(Myadapter.mediaPlayer);
    }
}
