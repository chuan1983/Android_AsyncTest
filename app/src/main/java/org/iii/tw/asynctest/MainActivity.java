package org.iii.tw.asynctest;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test1(View v){

    }
    private class MyTask extends AsyncTask<Void,Void,Void>{             //非同步的概念
        @Override
        protected Void doInBackground(Void... params) {                //在背景中去做
            Log.d("brad","doInBackground");
            return null;
        }

        @Override
        protected void onPreExecute() {        //前
            super.onPreExecute();
            Log.d("brad","onPreExecute");

        }

        @Override
        protected void onPostExecute(Void aVoid) {   //後
            super.onPostExecute(aVoid);
            Log.d("brad","onPostExecute");

        }

        @Override
        protected void onProgressUpdate(Void... values) {  //更新
            super.onProgressUpdate(values);
            Log.d("brad","onProgressUpdate");

        }

        @Override
        protected void onCancelled(Void aVoid) {        //結束
            super.onCancelled(aVoid);
            Log.d("brad","onCancelled");

        }
    }
}
