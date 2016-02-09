package com.android.walktrack;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ActvityMain extends AppCompatActivity {

    private static final String TAG=ActvityMain.class.getSimpleName();

    private TextView textViewMins, textViewSeconds, textViewMilliSeconds;
    private ImageButton imageButtonStartStop;

    private Context mContext;
    private boolean isTimerStarted;

    public class MyTimerAsyncTask extends AsyncTask<Void,Integer,Integer> {

        private int minutes, seconds, millSeconds;
        Thread thread;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            minutes=0;
            seconds=0;
            millSeconds=0;
            thread=new Thread(new Runnable() {
                @Override
                public void run() {

                }
            });
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Integer doInBackground(Void... voids) {

            while(!isTimerStarted){

            }


                return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_main);

        textViewMins=(TextView)findViewById(R.id.textViewMinis);
        textViewSeconds=(TextView)findViewById(R.id.textViewSecs);
        textViewMilliSeconds=(TextView)findViewById(R.id.textViewMilliSecs);
        mContext=getApplicationContext();

        imageButtonStartStop =(ImageButton)findViewById(R.id.imageButtonStartStop);

        imageButtonStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTimerStarted){
                    isTimerStarted=false;
                    imageButtonStartStop.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.icon_play));
                }else{
                    isTimerStarted=true;
                    imageButtonStartStop.setImageDrawable(ContextCompat.getDrawable(mContext,R.drawable.icon_stop));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actvity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
