package br.com.ajudafacil.ajudafacilapp;

import android.app.Activity;
import android.app.Notification;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                Notification notification = new Notification.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.ic_stat_ic_launcher_v2_transparente)
                        .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000, 1000})
                        .setContentTitle("Notificacao")
                        .setContentText("Mensagem")
                        .build();
            }
        });
    }
}
