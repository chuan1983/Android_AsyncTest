package org.iii.tw.asynctest;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MyTask mt1;
    private TextView mesg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mesg = (TextView)findViewById(R.id.mesg);
    }

    public void test1(View v){
        mt1 = new MyTask();
        mt1.execute("Brad","Kevin","Tony","John","Eric");
    }
    public void test2(View v){
        if(mt1 != null && !mt1.isCancelled()){   //防止沒按1而按2, 不等於空值而且沒有被取消
            mt1.cancel(true);
        }
    }
    private class MyTask extends AsyncTask<String,Object,String>{             //非同步的概念
        @Override
        protected void onPreExecute() {        //前
            super.onPreExecute();
            Log.d("brad","onPreExecute");

        }

        @Override
        //        第三個                第一個
        protected String doInBackground(String... params) {                //在背景中去做
            Log.d("brad","doInBackground");
            int i = 0;
            boolean isCancel = false;
            for (String name : params){
                if(isCancelled()){
                    isCancel = true;
                    break;
                }
                Log.d("brad","Hello,"+name);
                i++;
                publishProgress(i,name);            //裡面帶整數,傳遞到onProgressUpdate去執行
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
            return isCancel?"Cancel!":"Game Over";
        }

        @Override                    //第三個
        protected void onPostExecute(String end) {   //後
            super.onPostExecute(end);
            Log.d("brad","onPostExecute"+ end);

        }

        @Override                       //第二個
        protected void onProgressUpdate(Object... values) {  //更新
            super.onProgressUpdate(values);
            Log.d("brad","onProgressUpdate");
            mesg.setText((Integer)values[0] +":"+ (String)values[1] );
        }

        @Override                  //第三個
        protected void onCancelled(String end) {        //結束
            super.onCancelled(end);
            Log.d("brad","onCancelled" + end);

        }
    }
}
