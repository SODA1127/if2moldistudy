package com.itwill.intent.activity.remote.call;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xxx(View view) {
        Intent intent = new Intent();
        intent.setAction("com.itwill.intent.activity.remote.called.ACTION_TEST");

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.w);
        intent.putExtra("image", bitmap);
        startActivity(intent);
    }





}
