package com.itwill.intent.start.activityforresult;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void xxx(View view) {
        int bid = view.getId();
        if(bid == R.id.button){
            Intent intent = new Intent();
            Class clazz = SubActivity.class;
            intent.setClass(getApplicationContext(), clazz);
            startActivityForResult(intent, 99);
        }else if(bid == R.id.button3){
            Intent intent = new Intent();
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 98);
        }


        /*Intent intent = new Intent();
        intent.setClass(getApplicationContext(), SubActivity.class);
        startActivityForResult(intent, 99);*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 99){
            if(resultCode == Activity.RESULT_OK){
                String recvName = data.getStringExtra("name");
                String recvAddress = data.getStringExtra("address");
                setTitle("받은 데이터 : " + recvName +", " + recvAddress);
            }
        }else if(requestCode == 98){
            if(resultCode == Activity.RESULT_OK){
                Bitmap recvBitmap = data.getParcelableExtra("data");
                ImageView imageView = (ImageView)findViewById(R.id.imageView);
                imageView.setImageBitmap(recvBitmap);
            }else if(requestCode ==Activity.RESULT_CANCELED){

            }
        }
    }
}
