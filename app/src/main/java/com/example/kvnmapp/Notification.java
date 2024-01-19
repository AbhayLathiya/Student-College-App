package com.example.kvnmapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class Notification extends AppCompatActivity {

    private static final String CHANNEL_ID = "My Channel";
    private static final int NOTIFICATION_ID = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.jnmp, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

        Bitmap largeIcon = bitmapDrawable.getBitmap();
        android.app.Notification notification;

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new android.app.Notification.Builder(this)
                    .setSmallIcon(R.drawable.jnmp)
                    .setContentText("New Message")
                    .setSubText("New Message from KVNM")
                    .setChannelId(CHANNEL_ID)
                    .build();

            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel", NotificationManager.IMPORTANCE_HIGH));
        }else {
            notification = new android.app.Notification.Builder(this)
                    .setSmallIcon(R.drawable.jnmp)
                    .setContentText("New Message")
                    .setSubText("New Message from KVNM")
                    .build();

            notificationManager.notify(NOTIFICATION_ID,notification);
        }
    }
}