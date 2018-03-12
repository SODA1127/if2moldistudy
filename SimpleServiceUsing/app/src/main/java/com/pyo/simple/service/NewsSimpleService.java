package com.pyo.simple.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class NewsSimpleService extends Service {

    //인텐트로 넘어온 엑스트라 값.
    //초기 뉴스의 종류만 선택 함
    private int      extraValue;

    private BackGroundSubThread subThread;
    /*
     * startService() 후에 처음 호출되는 서비스 콜백 메소드
     */
    @Override
    public void onCreate(){
        super.onCreate();
        Toast.makeText(this, "Service 콜백 메소드 onCreate() 실행! ", Toast.LENGTH_SHORT).show();
    }
   /*
    * 원격 호출시에 넘겨준 원격 인터페이스 객체
    * 로컬에서는 null을 넘겨 준다.
    */

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    /*
     *  서비스 콜백 메소드
     */
    @Override
    public  int onStartCommand(Intent intent, int flags, int startId){
        super.onStartCommand(intent,flags,startId);
        if( flags == START_FLAG_RETRY){
            //정상종료가 아닌 경우 반드시 실행되어야 하는 인텐트를 여기서 다시 진행 함
        }
        if( intent == null  ){
            //START_STICKY모드로 비정상 종료시 처리해야 하는 업무
        }
        extraValue = intent.getIntExtra("newsSubject", 0);
        subThread = new BackGroundSubThread("BACK_THREAD_1");
        subThread.start();
        Toast.makeText(this, "Service 콜백 메소드 onStartCommand() 실행! ", Toast.LENGTH_SHORT).show();
        //서비스의 비정상적 종료시에 null 값을 가진 인텐트가 재실행 됨
        return START_STICKY;
    }
    /*
     *  stopService 호출시  콜백 됨
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if( subThread  != null &&  subThread.isAlive()){ //백그라운드가 살아 있다면
            subThread.interrupt();
        }
        this.stopSelf(); //서비스 종료
    }
    private Handler handler = new Handler(){
        public void handleMessage(Message backGroundMessage){
            String newsMessage = (String)backGroundMessage.obj;
            switch(backGroundMessage.what){
                case  0 :
                    Toast.makeText(getApplication(),"정치면 : " +
                            newsMessage, Toast.LENGTH_LONG).show();
                    break;
                case  1 :
                    Toast.makeText(getApplication(), "경제면 : " +
                            newsMessage, Toast.LENGTH_LONG).show();
                    break;
                case  2 :
                    Toast.makeText(getApplication(), "사회면 : " +
                            newsMessage, Toast.LENGTH_LONG).show();
                    break;
                default :
                    Toast.makeText(getApplication(), "연예면 : " +
                            newsMessage, Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };
    /*
     *  백그라운드 쓰레드는 서비스의 라이프 사이클을 벗어남
     */
    private  class BackGroundSubThread extends Thread{
        private HashMap<String,String> newsMap;
        private Random  random ;
        public BackGroundSubThread(String threadName){
            super(threadName);
            random = new Random(System.currentTimeMillis());
            newsMap= new HashMap<>();
            newsMap.put("정치", "한반도 극적 통일 이루어져~~~");
            newsMap.put("경제", "통일한국 GNP 10만 달러 이룩");
            newsMap.put("사회", "대한민국 노총각 결혼추진위원회 헌법에 명시화");
            newsMap.put("연예", "소녀시대 수영 아카데미 여우 주연상 수상");
        }
        public void run(){
            while(!isInterrupted()){
                Message newsMessage = handler.obtainMessage();
                newsMessage.what = extraValue;
                if( extraValue == 0 ){
                    newsMessage.obj =  newsMap.get("정치");
                }else if( extraValue == 1){
                    newsMessage.obj =  newsMap.get("경제");
                }else if( extraValue == 2){
                    newsMessage.obj =  newsMap.get("사회");
                }else{
                    newsMessage.obj =  newsMap.get("연예");
                }
                extraValue = random.nextInt(4);
                try{
                    sleep(3000);
                }catch(InterruptedException ie){
                    newsMessage.obj = " sleep() 도중 인터럽트 발생!";
                    currentThread().interrupt();
                }
                handler.sendMessage(newsMessage);
            }
        }
    }
}