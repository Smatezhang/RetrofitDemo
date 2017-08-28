package com.zhuoxin.zhang.retrofitdemo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/8/28.
 */

public class RetrofitClient {
    private static RetrofitClient mRetrofitClient;

    protected OkHttpClient mOkHttpClient;
    protected Retrofit mRetrofit;

    private RetrofitClient() {
        HttpLoggingInterceptor mInterceptor = new HttpLoggingInterceptor();
        mInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(mInterceptor)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(mOkHttpClient)
                .build();
    }
    public static synchronized RetrofitClient getInstance(){
        if (mRetrofitClient == null){
         mRetrofitClient =   new RetrofitClient();
        }
        return mRetrofitClient;
    }

    public RetrofitApi getApi(){
        RetrofitApi mRetrofitApi = mRetrofit.create(RetrofitApi.class);
        return mRetrofitApi;
    }
}
