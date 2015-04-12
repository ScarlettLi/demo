package com.li.scarlett.myapplication;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2015/3/29.
 */
public class BaiduModel {

    public void fetchBaidu(Context context) {
        //1.获取一个RequestQueue对象
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);

        //2.创建一个StringRequest对象
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://www.baidu.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                 //服务器响应成功，将服务器返回的响应转换成一个Java Bean通过EventBus传递给事件监听处理
                  EventBus.getDefault().post(new ResultBeen(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //服务器响应失败，将服务器返回的响应转换成一个Java Bean通过EventBus传递给事件监听处理
                EventBus.getDefault().post(new ResultBeen(error.getMessage()));

            }
        });
        //3.将StringRequest对象添加到RequestQueue里面
        mRequestQueue.add(stringRequest);
    }

 }
