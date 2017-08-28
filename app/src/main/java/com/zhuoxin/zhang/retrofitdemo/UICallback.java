package com.zhuoxin.zhang.retrofitdemo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/8/28.
 */

public abstract class UICallback implements Callback {
    Handler mHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    @Override
    public void onFailure(final Call call, final IOException e) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                onFailureInUI(call,e);
            }
        });

    }

    @Override
    public void onResponse(final Call call, final Response response) throws IOException {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
               onResponseInUI(call,response);
            }
        });
    }

    public abstract void onFailureInUI(Call call, IOException e);
    public abstract void onResponseInUI(Call call, Response response);

}
