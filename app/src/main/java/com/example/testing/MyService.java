package com.example.testing;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;



import static android.content.ContentValues.TAG;

public class MyService extends Service {
    public MyService() {
    }
    Handler h;
    @Override
    public void onCreate() {
        Log.d(TAG, "service create ");
        super.onCreate();
        h = new Handler();
    }

    @Override

    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();


        h.post(new Runnable() {
            @Override
            public void run() {

                try { Thread.sleep(2000); }
                catch (InterruptedException e) { e.printStackTrace(); }
                Log.d(TAG, "run:working 1");
            }
        });
        h.post(new Runnable() {
            @Override
            public void run() {

                try { Thread.sleep(2000); }
                catch (InterruptedException e) { e.printStackTrace(); }

                Log.d(TAG, "run:working 2");
            }
        });
        return  START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service Destroyed");
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
