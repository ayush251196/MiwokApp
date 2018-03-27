package com.example.android.miwok;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by AYUSH on 24-03-2018.
 */
public class Myadapter extends ArrayAdapter<Customnames> {
    private int colour;
    public static AudioManager am;
    private Context context;
 //   public static Toast toast;
    int i=0;
    public static MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener onCompletionListener=new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp){
            //am.abandonAudioFocus(afChangeListener);
            released(mp);
        }
    };
    Myadapter(Context context, ArrayList<Customnames> arrayList,int colour){
        super(context,0,arrayList);
        this.context=context;
        this.colour=colour;
    }
    public  static void released(MediaPlayer mp){
        if(am!=null){
            am.abandonAudioFocus(afChangeListener);
        }
        if(mp!=null){
            mp.release();
            mp=null;
        }

    }
    private static AudioManager.OnAudioFocusChangeListener afChangeListener=new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
               mediaPlayer.stop();
               released(mediaPlayer);
              // am.abandonAudioFocus(afChangeListener);
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                    mediaPlayer.start();
            }
        }
    };
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if(view==null){
            view=LayoutInflater.from(context).inflate(R.layout.listitem2,parent,false);
        }
        final Customnames customnames=getItem(position);
        final int musicid=customnames.getMusicid();
        int imageid=customnames.getImageid();
        ImageView imageView=(ImageView) view.findViewById(R.id.imageView4);
        if(imageid!=0) {
            imageView.setImageResource(imageid);
        }
        else{
            imageView.setVisibility(View.GONE);
        }
        LinearLayout layout=(LinearLayout) view.findViewById(R.id.llhelp);
        ImageView play=(ImageView) view.findViewById(R.id.playbutton);
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                released(mediaPlayer);
                Log.i("onclick ece","after releaase");
                int result = am.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC ,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    Log.i("access granted","yo");
                    mediaPlayer = MediaPlayer.create(context,musicid);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(onCompletionListener);
                }

            }
        };
        play.setOnClickListener(onClickListener);
        layout.setBackgroundResource(colour);
        TextView textView=(TextView)view.findViewById(R.id.tv1);
        textView.setText(customnames.getDefault_name());
        TextView textView1=(TextView)view.findViewById(R.id.tv2);
        textView1.setText(customnames.getLang_name());
        return view;
    }
}
