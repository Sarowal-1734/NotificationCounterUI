package com.example.notificationcounterui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout notificationIcon;
    private CardView cardViewNotificationNumberContainer;
    private TextView textViewNotificationCounter;

    private int notificationCount = 0;
    private int maxNotificationCount = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationIcon = findViewById(R.id.notificationIcon);
        cardViewNotificationNumberContainer = findViewById(R.id.cardViewNotificationNumberContainer);
        textViewNotificationCounter = findViewById(R.id.textViewNotificationCounter);

        // Click icon to vanish the notification counter value
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationCount = 0;
                showNotificationCount();
            }
        });

        // Call first time or every onStart or restart
        showNotificationCount();

    }

    private void showNotificationCount() {
        if (notificationCount == 0) {
            cardViewNotificationNumberContainer.setVisibility(View.INVISIBLE);
            return;
        }
        cardViewNotificationNumberContainer.setVisibility(View.VISIBLE);
        textViewNotificationCounter.setText("" + notificationCount);
    }

    public void onIncreaseButtonClicked(View view) {
        if (notificationCount != maxNotificationCount) {
            notificationCount++;
        }
        showNotificationCount();
    }

    public void onDeceaseButtonClicked(View view) {
        notificationCount--;
        showNotificationCount();
    }
}