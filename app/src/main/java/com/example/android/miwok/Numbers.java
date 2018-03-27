package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_category);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new NumbersFragment())
                    .commit();
        }
    protected  void onStop(){
        super.onStop();
        Log.i("onStop","called");
       // Myadapter.released(Myadapter.mediaPlayer);
            Myadapter.released(Myadapter.mediaPlayer);
    }
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
        Myadapter.released(Myadapter.mediaPlayer);
      //  Myadapter.released(Myadapter.mediaPlayer);
        Log.i("onPause","called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart","called");
    }

}
