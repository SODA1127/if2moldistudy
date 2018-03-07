package com.itwill.intent.activity.google.app.call;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xxx(View view) {
        int bid = view.getId();
        switch (bid){
            case R.id.dialerB :
                Intent intent1 = new Intent();
                intent1.setAction(Intent.ACTION_DIAL);
                Uri uriData = Uri.parse("tel:01054844731");
                intent1.setData(uriData);
                startActivity(intent1);
                break;
            case R.id.smsB :
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_SENDTO);
                intent2.setData(Uri.parse("sms:01054844731"));
                intent2.putExtra("sms_body", "안녕하세용");
                startActivity(intent2);
                break;
            case R.id.googleMapB :
                Intent intent3 = new Intent();
                intent3.setPackage("com.google.android.apps.maps");
                intent3.setData(Uri.parse("google.streetview:cbll=46.414382,10.013988"));
                startActivity(intent3);
                break;
            case  R.id.webSearchB :
                Intent intent4 = new Intent();
                intent4.setAction(Intent.ACTION_WEB_SEARCH);
                intent4.putExtra("query", "안드로이드");
                startActivity(intent4);
                break;
            case  R.id.audioPickB :
                Intent intent5 = new Intent();
                intent5.setAction(Intent.ACTION_GET_CONTENT);
                intent5.setType("audio/*");
                startActivity(intent5);
                break;
            case R.id.audioPlayB:
                Intent intent6=new Intent();
                intent6.setAction(Intent.ACTION_VIEW);
                intent6.setDataAndType(
                        Uri.fromFile(new File("/sdcard/test.mp3")), "audio/*");
                startActivity(intent6);
                break;
        }
    }
}
