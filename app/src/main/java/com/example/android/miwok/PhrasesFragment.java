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
public class PhrasesFragment extends Fragment {


    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_phrases, container, false);
        ArrayList<Customnames> arrayList=new ArrayList<Customnames>();
        arrayList.add(new Customnames("Where are you going?","minto wukusus",R.raw.phrase_where_are_you_going));
        arrayList.add(new Customnames("What is your name?","tinna oyaase na",R.raw.phrase_what_is_your_name));
        arrayList.add(new Customnames("My name is..","oyaaset...",R.raw.phrase_my_name_is));
        arrayList.add(new Customnames("How are you feeling?","michaksas?",R.raw.phrase_how_are_you_feeling));
        arrayList.add(new Customnames("I'm feeling good.","aanas'a",R.raw.phrase_im_feeling_good));
        Myadapter myadapter=new Myadapter(getActivity(),arrayList,R.color.category_phrases);
        Myadapter.am= (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);
        ListView listView=(ListView)rootView.findViewById(R.id.listviewp);
        listView.setAdapter(myadapter);
        return rootView;
    }
    @Override
    public void onStop() {
        super.onStop();
        Myadapter.released(Myadapter.mediaPlayer);
    }
}
