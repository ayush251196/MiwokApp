package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("FamilyActivity","created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new FamilyMembersFragment())
                .commit();
    }
    protected  void onStop(){
        super.onStop();
        Log.i("onStop","called");
            Myadapter.released(Myadapter.mediaPlayer);
       // Myadapter.released(Myadapter.mediaPlayer);
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
      //  Myadapter.released(Myadapter.mediaPlayer);
        Myadapter.released(Myadapter.mediaPlayer);
        Log.i("onPause","called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("onStart","called");
    }

}
