package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by AYUSH on 27-03-2018.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    public SimpleFragmentPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context=context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FamilyMembersFragment();
        } else if (position == 1){
            return new ColorFragment();
        } else if (position==2){
            return new PhrasesFragment();
        } else
            return new NumbersFragment() ;

    }
    @Override
    public String getPageTitle(int position) {
        // Generate title based on item position
        if (position == 0) {
            return "Family";
        } else if (position == 1) {
            return "Colors";
        } else if (position == 2) {
            return "Phrases";
        } else {
            return "Numbers";
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}

