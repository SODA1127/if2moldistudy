package com.itwill.intent.activity.remote.called;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent recieveIntent = getIntent();
        String action = recieveIntent.getAction();
        Log.e("intent action", action);
        if(action.equals("com.itwill.intent.activity.remote.called.ACTION_TEST")){
            Bitmap bitmap = recieveIntent.getParcelableExtra("image");
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            //imageView.setImageResource(R.drawable.donut);
            imageView.setImageBitmap(bitmap);
        }else{
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageResource(R.mipmap.ic_launcher);
        }
        setTitle(action);
    }

    public void xxx(View view) {
        finish();
    }

    public void yyy(View view){
        ComponentName componentName = new ComponentName("com.itwill.intent.activity.remote.call", "com.itwill.intent.activity.remote.call.MainActivity");
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.setComponent(componentName);
        startActivity(intent);

    }
}
