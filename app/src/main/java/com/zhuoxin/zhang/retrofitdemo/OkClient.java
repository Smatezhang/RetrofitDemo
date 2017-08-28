package com.zhuoxin.zhang.retrofitdemo;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2017/8/28.
 */

public class OkClient {
    private static OkClient mOkClient;
    protected OkHttpClient mOkHttpClient;

    private OkClient(){
        HttpLoggingInterceptor mInterceptor = new HttpLoggingInterceptor();
        mInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkHttpClient = new OkHttpClient.Builder()
                        .addInterceptor(mInterceptor)
                        .build();
    }
    public static synchronized OkClient getInstance(){
        if (mOkClient == null){
            mOkClient = new OkClient();

        }
        return mOkClient;
    }

    /**
     * get 请求
     * @return
     */
    public Call getRequest(){
        Request mRequest = new Request.Builder()
                .url("https://api.github.com/search/repositories?q=language:java&page=1")
                .build();
        return mOkHttpClient.newCall(mRequest);
    }

    /**
     * post 请求
     * @return
     */
    public Call postRequest(){
        RequestBody mRequestBody = RequestBody.create(null, "{\n" +
                "\"Password\":\"654321\"\n" +
                "\"UserName\":\"qjd\",\n" +
                "}");
        Request mRequest = new Request.Builder()
                .url(" http://admin.syfeicuiedu.com/Handler/UserHandler.ashx?action=register")
                .post(mRequestBody)
                .build();
        return mOkHttpClient.newCall(mRequest);
    }

    /**
     * form 表单请求
     * @return
     */
    public Call formRequest(){
        FormBody mFormBody = new FormBody.Builder()
                .add("username", "张三")
                .add("password", "123456")
                .build();
        Request mRequest = new Request.Builder()
                .post(mFormBody)
                .url("http://wx.feicuiedu.com:9094/yitao/UserWeb?method=register")
                .build();
        return mOkHttpClient.newCall(mRequest);
    }

    /**
     * multipart 请求
     * @return
     */
    public Call multipartRequest(){
        RequestBody mRequestBody = RequestBody.create(null, "{\n" +
                "\"name\": \"yt59856b15cf394e7b84a7d48447d16098\",\n" +
                "\"username\": \"xc62\",\n" +
                "\"nickname\": \"555\",\n" +
                "\"password\": \"123456\",\n" +
                "\"uuid\": \"0F8EC12223174657B2E842076D54C361\"\n" +
                "}");
        MultipartBody mMultipartBody = new MultipartBody.Builder()
                .addPart(mRequestBody)
                .build();
        Request mRequest = new Request.Builder()
                .url("http://wx.feicuiedu.com:9094/yitao/UserWeb?method=update")
                .post(mMultipartBody)
                .build();
        return mOkHttpClient.newCall(mRequest);
    }



}
