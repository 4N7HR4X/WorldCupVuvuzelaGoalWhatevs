package com.binaryeclipse.worldcup.app;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;


//test with: adb shell am broadcast -a com.binaryeclipse.worldcup.app.GOAL
public class GoalService extends Service {
    public static final String ACTION_GOAL = "com.binaryeclipse.worldcup.app.GOAL";
    String TAG = GoalService.class.getSimpleName();
    public GoalService() {}
    private WindowManager windowManager;
    private View goalView;
    private WindowManager.LayoutParams params;

    private SoundPool soundPool;
    AudioManager audioManager;

    private int soundID;
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG,"GOAL!!!");
            playVuvuzela();
            showBall();
            new Handler().postDelayed(new Runnable() { // removeNotification the ball after 5 secs
                @Override
                public void run() {
                    removeNotification();
                }
            },5000);
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        // Load the sound
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        audioManager= (AudioManager) getSystemService(AUDIO_SERVICE);
        soundID = soundPool.load(this, R.raw.vuvuzela, 1);
        registerReceiver(receiver,new IntentFilter(ACTION_GOAL));


        goalView = View.inflate(this,R.layout.score_notification,null);
        params = new WindowManager.LayoutParams(
				WindowManager.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.TYPE_PHONE,
				WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
				PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.CENTER;
        params.x = 0;
		params.y = 100;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"started: ");
        return START_STICKY;
    }


    private void showBall(){
		windowManager.addView(goalView, params);
    }

    private void playVuvuzela(){
        float actualVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        soundPool.play(soundID, volume, volume, 1, 0, 1f);
    }


    private void removeNotification(){
        windowManager.removeView(goalView);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"destroyed");
        unregisterReceiver(receiver);
        if (goalView != null) windowManager.removeView(goalView);
        super.onDestroy();
    }
}
