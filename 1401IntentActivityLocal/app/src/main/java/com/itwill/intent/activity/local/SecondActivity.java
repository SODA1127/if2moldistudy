package com.itwill.intent.activity.local;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView recvDataTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recvDataTV=(TextView)findViewById(R.id.recvDataTV);

        /*
            이 Activity를 실행한 Intent객체를 얻는다.
         */
        Intent recvIntent=this.getIntent();
        int recvAge = recvIntent.getIntExtra("no",0);
        String recvName=recvIntent.getStringExtra("name");
        boolean married = recvIntent.getBooleanExtra("married",false);
        Student recvStudent = (Student) recvIntent.getSerializableExtra("student");

        String recvStr=recvAge+"\n"+married+"\n"+recvName+"\n"
                +"--------------Student(Serializable)------------\n"+
                +recvStudent.getNo()+"\n"
                +recvStudent.getName()+"\n"+
                recvStudent.isMarried();
        recvDataTV.setText(recvStr);
    }

    public void xxx(View view) {
            /*
            Activity 종료
             */
            finish();
    }
}
