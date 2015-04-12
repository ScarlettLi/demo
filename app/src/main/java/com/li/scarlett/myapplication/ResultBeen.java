package com.li.scarlett.myapplication;

/**
 * Created by Administrator on 2015/3/29.
 */
public class ResultBeen {
    private int result;
    private String response;

    public ResultBeen(String response) {
        this.response =response;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return response;
    }
}
