package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by AYUSH on 24-03-2018.
 */

public class Customnames {
    private String default_name,lang_name;
    private int imageid;
    private int musicid;
    Customnames(String default_name,String lang_name,int musicid){
        this.default_name=default_name;
        this.lang_name=lang_name;
        this.musicid=musicid;
    }
    Customnames(String default_name,String lang_name,int imageid,int musicid){
        this.default_name=default_name;
        this.lang_name=lang_name;
        this.imageid=imageid;
        this.musicid=musicid;
    }

    public String getDefault_name(){
        return default_name;
    }
    public String getLang_name(){return lang_name; }
    public int getImageid(){return  imageid; }
    public int getMusicid(){return musicid; }

}
