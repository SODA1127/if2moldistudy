package com.itwill.tablelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    double tmp = 0;
    String num = "";
    String cmd = "";

    // 숫자 버튼
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;

    //계산 버튼
    Button plusB;
    Button minusB;
    Button timesB;
    Button devideB;
    Button equalB;

    //부가 기능 버튼
    Button cButton;
    Button deleteB;
    ToggleButton historyB;
    Button dotB;

    //숫자화면
    TextView numTV;
    TextView historyTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


}
