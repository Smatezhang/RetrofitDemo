package com.zhuoxin.zhang.retrofitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void get(View view) {
        OkClient.getInstance().getRequest().enqueue(new UICallback() {
            @Override
            public void onFailureInUI(Call call, IOException e) {
                Toast.makeText(MainActivity.this,"失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponseInUI(Call call, Response response) {
                if (response.isSuccessful()){

                    try {
                        Toast.makeText(MainActivity.this,"成功"+response.body().string(),Toast.LENGTH_SHORT).show();
                    } catch (IOException mE) {
                        mE.printStackTrace();
                    }
                }
            }
        });
    }

    public void post(View view) {
        OkClient.getInstance().postRequest().enqueue(new UICallback() {
            @Override
            public void onFailureInUI(Call call, IOException e) {
                Toast.makeText(MainActivity.this,"失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponseInUI(Call call, Response response) {
                if (response.isSuccessful()){

                    try {
                        Toast.makeText(MainActivity.this,"成功"+response.body().string(),Toast.LENGTH_SHORT).show();
                    } catch (IOException mE) {
                        mE.printStackTrace();
                    }
                }
            }
        });
    }

    public void form(View view) {

        OkClient.getInstance().formRequest().enqueue(new UICallback() {
            @Override
            public void onFailureInUI(Call call, IOException e) {
                Toast.makeText(MainActivity.this,"失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponseInUI(Call call, Response response) {
                if (response.isSuccessful()){

                    try {
                        Toast.makeText(MainActivity.this,"成功"+response.body().string(),Toast.LENGTH_SHORT).show();
                    } catch (IOException mE) {
                        mE.printStackTrace();
                    }
                }
            }
        });
    }

    public void multi(View view) {
        OkClient.getInstance().multipartRequest().enqueue(new UICallback() {
            @Override
            public void onFailureInUI(Call call, IOException e) {
                Toast.makeText(MainActivity.this,"失败"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponseInUI(Call call, Response response) {
                if (response.isSuccessful()){

                    try {
                        Toast.makeText(MainActivity.this,"成功"+response.body().string(),Toast.LENGTH_SHORT).show();
                    } catch (IOException mE) {
                        mE.printStackTrace();
                    }
                }
            }
        });
    }

    public void skip(View view) {
        startActivity(new Intent(MainActivity.this,RetrofitActivity.class));
    }
}
