package com.android.walktrack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by anideshp on 2/10/2016.
 */
public class TimerBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG=TimerBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Broadcast Received");
    }
}
