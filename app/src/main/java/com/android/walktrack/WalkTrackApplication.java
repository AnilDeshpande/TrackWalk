package com.android.walktrack;

import android.app.Application;

/**
 * Created by anideshp on 2/11/2016.
 */
public class WalkTrackApplication extends Application{

    private boolean isWalking;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public boolean isWalking() {
        return isWalking;
    }

    public void setIsWalking(boolean isWalking) {
        this.isWalking = isWalking;
    }
}
