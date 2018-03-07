package com.itwill.intent.start.activityforresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public void xxx(View view) {
        /*
          결과 저장하고 finish
        */
        Intent dataIntent = new Intent();
        setResult(Activity.RESULT_OK, dataIntent);
        dataIntent.putExtra("name", "김경호");
        dataIntent.putExtra("address", "경기도민");
        finish();
    }
}
