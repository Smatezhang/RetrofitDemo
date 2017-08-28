package com.zhuoxin.zhang.retrofitdemo;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/8/28.
 */

public interface RetrofitApi {
    /**
     * get 请求
     * @return
     */
    //?q=language:java&page=1"
    @GET("https://api.github.com/{search}/repositories")
    Call<ResponseBody> getRequset(@Path("search")String search, @Query("q") String lj,@Query("page") String page);

    /**
     * post 请求
     * @param mRequestBody
     * @return
     */
    @POST("http://admin.syfeicuiedu.com/Handler/UserHandler.ashx?action=register")
    Call<ResponseBody> postRequest(@Body RequestBody mRequestBody);

    /**
     * form 表单请求
     * @param username
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("http://wx.feicuiedu.com:9094/yitao/UserWeb?method=register")
    Call<ResponseBody> formRequset(@Field("username") String username,
                                   @Field("password") String password);

    /**
     * multipart
     * 多部分请求
     * @param mPart
     * @return
     */
    @Multipart
    @POST("http://wx.feicuiedu.com:9094/yitao/UserWeb?method=update")
    Call<ResponseBody> multipartRequest(@Part MultipartBody.Part mPart);


}
