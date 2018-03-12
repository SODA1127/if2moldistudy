package com.pyo.activity.asyn.simple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleResultRequestActivity extends Activity {

    private ImageView image;
    private Button textRequest;
    private Button imageRequest;
    private TextView textMessage;

    private static final int RESULT_CODE_TEXT = 100;
    private static final int RESULT_CODE_IMAGE = 200;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_layout);
        textMessage = findViewById(R.id.textMessage);
        textRequest = findViewById(R.id.textRequest);
        imageRequest = findViewById(R.id.imageRequest);
        image = findViewById(R.id.image);


        textRequest.setOnClickListener(view -> {

            Intent intent = new Intent(getApplication(),
                    ResponseActivityResult.class);
            startActivityForResult(intent, RESULT_CODE_TEXT);
        });
        imageRequest.setOnClickListener(view -> {
            Intent intent =
                    new Intent(getApplication(), ResponseActivityResult.class);
            startActivityForResult(intent, RESULT_CODE_IMAGE);
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case RESULT_CODE_TEXT:
                if (resultCode == RESULT_OK) {
                    textMessage.setText(data.getStringExtra("response_message"));
                } else {
                    Toast.makeText(this, data.getStringExtra("response_message"), Toast.LENGTH_SHORT).show();
                }
                break;
            case RESULT_CODE_IMAGE:
                if (resultCode == RESULT_OK) {
                    int imageIDValue = data.getIntExtra("response_image", -1);
                    if (imageIDValue != -1) {
                        image.setImageResource(imageIDValue);
                    } else {
                        Toast.makeText(this, " 이미지 ID값!" + imageIDValue, Toast.LENGTH_SHORT).show();
                    }
                    return;
                } else {
                    Toast.makeText(this, " 이미지 에러!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}