/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterViewAnimator;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.logging.SimpleFormatter;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private  ViewPager viewPager;
    private SimpleFragmentPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("onCreate:", "called");
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());
        tabLayout = (TabLayout) findViewById(R.id.tab);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        //setTabs();

    }

//        final TextView textView=(TextView)findViewById(R.id.family);
//        TextView textView1=(TextView)findViewById(R.id.colors);
//        TextView textView2=(TextView)findViewById(R.id.numbers);
//        TextView textView3=(TextView)findViewById(R.id.phrases);
//        View.OnClickListener onClickListener=new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(),FamilyMembers.class);
//                startActivity(intent);
//            }
//        };textView.setOnClickListener(onClickListener);
//        View.OnClickListener onClickListener1=new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(),Color.class);
//                startActivity(intent);
//            }
//        };textView1.setOnClickListener(onClickListener1);
//        View.OnClickListener onClickListener2=new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(),Numbers.class);
//                startActivity(intent);
//            }
//        };textView2.setOnClickListener(onClickListener2);
//        View.OnClickListener onClickListener3=new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(),Phrases.class);
//                startActivity(intent);
//            }
//        };textView3.setOnClickListener(onClickListener3);

//        ArrayList<Mainnames> arrayList=new ArrayList<>();
//        arrayList.add(new Mainnames("Numbers",R.color.category_numbers));
//        arrayList.add(new Mainnames("Family Members",R.color.category_family));
//        arrayList.add(new Mainnames("Colors",R.color.category_colors));
//        arrayList.add(new Mainnames("Phrases",R.color.category_phrases));
//        Myadapter2 myadapter2=new Myadapter2(this,arrayList);
//        ListView listView=findViewById(R.id.listvieway);
//        AdapterView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Mainnames mainnames = (Mainnames) parent.getItemAtPosition(position);
//                String s=mainnames.getName();
//                Intent intent;
//                if(s == "Numbers"){
//                    intent=new Intent(getApplicationContext(),Numbers.class);
//                } else if (s == "Family Members") {
//                    intent=new Intent(getApplicationContext(),FamilyMembers.class);
//                }else if(s=="Colors"){
//                    intent=new Intent(getApplicationContext(),Color.class);
//                }else{
//                    intent=new Intent(getApplicationContext(),Phrases.class);
//                }
//                startActivity(intent);
//            }
//        };
//        listView.setAdapter(myadapter2);
//        listView.setOnItemClickListener(onItemClickListener);
//
//    }
//    @Override
//    public void onStop(){
//        super.onStop();
//            Myadapter.released(Myadapter.mediaPlayer);
//
//    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i("onresume:","called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("onRestart:","called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("onPause","called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart","called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("onStop","called");
    }
}
