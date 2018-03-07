package com.itwill.intent.activity.local;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void xxx(View view) {

        Intent intent=new Intent();
        //가. 명시적인 클래스 이름(주소)
        /*****CASE1[local]******/
        intent.setClass(getApplicationContext(),SecondActivity.class);

        /*****CASE2******/
        /*intent.setClassName("com.itwill.intent.activity.local",
                "com.itwill.intent.activity.local.SecondActivity");*/

        /*****CASE3******/
        /*ComponentName componentName=
                new ComponentName("com.itwill.intent.activity.local",
                        "com.itwill.intent.activity.local.SecondActivity");*/
        //intent.setComponent(componentName);


        //나.EXTRA DATA(반드시 직렬화가 가능한객체여야한다.)
        intent.putExtra("no",30);
        intent.putExtra("name","KIM");
        intent.putExtra("married",true);
        Student student=new Student(3,"김경호",true);
        intent.putExtra("student",student);
        /*
        Intent를 사용해서 Activity실행 + 데이타전달
         */
        startActivity(intent);



    }
}
