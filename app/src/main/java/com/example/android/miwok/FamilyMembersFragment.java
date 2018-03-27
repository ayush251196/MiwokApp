package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
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
public class FamilyMembersFragment extends Fragment {


    public FamilyMembersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("FamilyFragment","created");
        View rootView = inflater.inflate(R.layout.activity_family_members, container, false);
        ArrayList<Customnames> arrayList=new ArrayList<Customnames>();
        Myadapter.am= (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);
        arrayList.add(new Customnames("father","apa",R.drawable.family_father,R.raw.family_father));
        arrayList.add(new Customnames("mother","ata",R.drawable.family_mother,R.raw.family_mother));
        arrayList.add(new Customnames("son","angsi",R.drawable.family_son,R.raw.family_son));
        arrayList.add(new Customnames("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        arrayList.add(new Customnames("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        arrayList.add(new Customnames("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        arrayList.add(new Customnames("older sister","tete",R.drawable.family_older_sister,R.raw.family_older_sister));
        arrayList.add(new Customnames("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        arrayList.add(new Customnames("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        arrayList.add(new Customnames("grandfather","pappa",R.drawable.family_grandfather,R.raw.family_grandfather));
        Myadapter myadapter=new Myadapter(getActivity(),arrayList,R.color.category_family);
        ListView listView=(ListView)rootView.findViewById(R.id.listviewf);
        listView.setAdapter(myadapter);
        return  rootView;
    }
    @Override
    public void onStop() {
        super.onStop();
        Myadapter.released(Myadapter.mediaPlayer);
    }

}
