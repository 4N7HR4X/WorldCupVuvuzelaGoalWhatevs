package com.binaryeclipse.worldcup.app;

import android.app.Application;
import android.content.Intent;

/**
 * Created by kurt on 2014/06/13.
 */
public class WorldCupApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this,GoalService.class));
    }
}
