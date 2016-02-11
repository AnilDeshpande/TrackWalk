package com.android.walktrack;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;

/**
 * Created by anideshp on 2/10/2016.
 */
public class TimerCounterService extends IntentService {

    public static final String START_TIME="start_time";
    public static final String STOP_TIME="stop_time";
    public static final String CURRENT_TIME="current_time";
    public static final String COUNTER="counter";

    private long startTime;
    private long currentTime;
    private long stopTime;
    private long count=0;

    private Context mContext;
    private static final String TAG=TimerCounterService.class.getSimpleName();

    public TimerCounterService(){
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        mContext=getApplicationContext();
        Intent intent1=new Intent();
        intent1.setAction("com.TimerBroadcastReceiver");
        intent1.putExtra(START_TIME, new Date().getTime());
        while (((WalkTrackApplication)mContext).isWalking()){
            try {
                Log.i(TAG, "Service has started");
                Thread.sleep(1000);
                count++;
                intent1.putExtra(CURRENT_TIME, new Date().getTime());
                intent1.putExtra(COUNTER,count);
                intent1.putExtra("datevalue", new Date().getTime());
                sendBroadcast(intent1);
            }catch (InterruptedException e){
                Log.i(TAG,e.getMessage());
            }
        }
        intent1.putExtra(STOP_TIME, new Date().getTime());
        intent1.putExtra(COUNTER,count);
        sendBroadcast(intent1);
        stopSelf();
    }

}
