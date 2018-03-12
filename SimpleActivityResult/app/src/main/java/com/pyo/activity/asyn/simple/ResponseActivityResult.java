package com.pyo.activity.asyn.simple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ResponseActivityResult extends Activity  {
	EditText  responseEdit;
	@Override
   public void onCreate(Bundle bundle){
	   super.onCreate(bundle);
	  
	   setContentView(R.layout.activity_result_layout);
     
	    responseEdit = findViewById(R.id.edit_response_text);
	   final ImageView taraImage = findViewById(R.id.tara_image);
	   Button  textResponse = findViewById(R.id.textResponse);
	   
	   textResponse.setOnClickListener(view -> {
			String  responseMessage = responseEdit.getText().toString();
			Intent intent = new Intent();
			if( responseMessage.length() <= 0){
				responseMessage = "에디터에 문자가 입력되지 않았네요!";
				intent.putExtra("response_message", responseMessage);
				setResult(RESULT_CANCELED,intent);
			}else{
				intent.putExtra("response_message", responseMessage);
				setResult(RESULT_OK,intent);
			}
			finish();
	   }) ;
	   taraImage.setOnClickListener(view -> {
			Intent intent = new Intent();
			intent.putExtra("response_image", R.drawable.tara_jee_yeon);
			setResult(RESULT_OK,intent);
			finish();
	  });
   }
}
