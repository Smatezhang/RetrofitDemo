package com.zhuoxin.zhang.retrofitdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Callback;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
    }

    public void get(View view) {
        RetrofitClient.getInstance().getApi().getRequset("search","language:java","2").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    Toast.makeText(RetrofitActivity.this,"成功"+response.body().string(),Toast.LENGTH_SHORT).show();
                } catch (IOException mE) {
                    mE.printStackTrace();
                }

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this,"成功"+
                        t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });
    }

    public void post(View view) {
        RequestBody mRequestBody = RequestBody.create(null, "{\n" +
                "\"Password\":\"654321\",\n" +
                "\"UserName\":\"qjd\"\n" +
                "}");
        RetrofitClient.getInstance().getApi().postRequest(mRequestBody).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    Toast.makeText(RetrofitActivity.this,"成功"+response.body().string(),Toast.LENGTH_SHORT).show();
                } catch (IOException mE) {
                    mE.printStackTrace();
                }

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this,"成功"+
                        t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });
    }

    public void form(View view) {

        RetrofitClient.getInstance().getApi().formRequset("张三","123456").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    Toast.makeText(RetrofitActivity.this,"成功"+response.body().string(),Toast.LENGTH_SHORT).show();
                } catch (IOException mE) {
                    mE.printStackTrace();
                }

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this,"成功"+
                        t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });
    }

    public void multi(View view) {
         /*MultipartBody.Part part = MultipartBody.Part.createFormData("aaa","{\n" +
                "\"name\": \"yt59856b15cf394e7b84a7d48447d16098\",\n" +
                "\"username\": \"xc62\",\n" +
                "\"nickname\": \"555\",\n" +
                "\"password\": \"123456\",\n" +
                "\"uuid\": \"0F8EC12223174657B2E842076D54C361\"\n" +
                "}");*/
        RequestBody mRequestBody = RequestBody.create(null, "{\n" +
                "\"name\": \"yt59856b15cf394e7b84a7d48447d16098\",\n" +
                "\"username\": \"xc62\",\n" +
                "\"nickname\": \"555\",\n" +
                "\"password\": \"123456\",\n" +
                "\"uuid\": \"0F8EC12223174657B2E842076D54C361\"\n" +
                "}");
        MultipartBody.Part mAaa = MultipartBody.Part.createFormData("aaa", null, mRequestBody);
        RetrofitClient.getInstance().getApi().multipartRequest(mAaa).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    Toast.makeText(RetrofitActivity.this,"成功"+response.body().string(),Toast.LENGTH_SHORT).show();
                } catch (IOException mE) {
                    mE.printStackTrace();
                }

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this,"成功"+
                        t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });
    }

    public void skip(View view) {
        startActivity(new Intent(RetrofitActivity.this,MainActivity.class));
    }
}
