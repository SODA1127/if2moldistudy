package com.pyo.simple.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public   class NewsSimpleLaunchActivity extends Activity {
    private Button startBtn;
    private Intent serviceIntent ;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        startBtn = findViewById(R.id.start_service);

		serviceIntent = new Intent(NewsSimpleLaunchActivity.this,NewsSimpleService.class);

        startBtn.setOnClickListener(view -> {
					serviceIntent.putExtra("newsSubject", 3);
					startService(serviceIntent);
		});
    }
}