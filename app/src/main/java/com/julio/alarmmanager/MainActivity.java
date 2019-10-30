package com.julio.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSekaliJalan();
            }
        });
    }

    public void setSekaliJalan() {
        Context context = getApplicationContext();
        long interval = 3000L;

        Intent intent = new Intent(getApplicationContext(), HelloActivity.class);
        intent.putExtra("key", "Hai Dunia!");

        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                0, intent, 0);

        AlarmManager alarmManager = (AlarmManager) context
                .getSystemService(context.ALARM_SERVICE);

        alarmManager.setExact(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + interval,
                pendingIntent);
    }
}
