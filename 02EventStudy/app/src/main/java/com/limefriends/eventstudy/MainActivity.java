package com.limefriends.eventstudy;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                Log.d("click", "눌림");
                textView.setText("눌렸습니당" + count);
                if (count % 3 == 1) {
                    textView.setBackgroundColor(Color.RED);
                } else if (count % 3 == 2) {
                    textView.setBackgroundColor(Color.GREEN);
                } else if (count % 3 == 0) {
                    textView.setBackgroundColor(Color.BLUE);
                }
            }

        });
    }
}
