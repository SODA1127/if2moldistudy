package org.techtown.thread.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * AsyncTask 를 이용하여 백그라운드 작업을 실행하는 방법에 대해 알 수 있다.
 */
public class MainActivity extends AppCompatActivity {

    TextView textView;
    ProgressBar progress;
    BackgroundTask task;
    Button executeButton;
    Button cancelButton;

    int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        progress = (ProgressBar) findViewById(R.id.progress);

        // 실행 버튼 이벤트 처리
        executeButton = (Button) findViewById(R.id.executeButton);
        executeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 새로운 Task 객체를 만들고 실행
                task = new BackgroundTask();
                task.execute(100);
                executeButton.setText("실행중");
                executeButton.setEnabled(false);
                cancelButton.setEnabled(true);
            }
        });


        // 취소 버튼 이벤트 처리
        cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setEnabled(false);


        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (cancelButton.getText().toString().equals("중지")) {
                    task.cancel(true);
                    executeButton.setEnabled(true);
                    executeButton.setText("실행");
                } else if (cancelButton.getText().toString().equals("초기화")) {
                    value = 0;
                    cancelButton.setText("중지");
                    progress.setProgress(value);
                    textView.setText("초기화 됨.");
                    cancelButton.setEnabled(false);
                }

            }
        });
    }

    /**
     * 새로운 Task 객체를 정의
     */
    class BackgroundTask extends AsyncTask<Integer, Integer, Integer> {
        @Override
        protected void onPreExecute() {
            progress.setProgress(value);
            cancelButton.setText("중지");
        }

        @Override
        protected Integer doInBackground(Integer... values) {
            while (isCancelled() == false) {
                value++;
                if (value >= 100) {
                    break;
                } else {
                    publishProgress(value);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                }
            }

            return value;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progress.setProgress(values[0].intValue());
            textView.setText("Current Value : " + values[0].toString());
        }

        @Override
        protected void onPostExecute(Integer result) {
            value = 0;
            progress.setProgress(value);
            textView.setText("Finished.");
            executeButton.setEnabled(true);
            executeButton.setText("실행");
            cancelButton.setEnabled(false);
        }

        @Override
        protected void onCancelled() {
            if (isCancelled() == true) {
                cancelButton.setText("초기화");
                progress.setProgress(value);
                textView.setText("중지됨.");
            }
        }
    }

}
