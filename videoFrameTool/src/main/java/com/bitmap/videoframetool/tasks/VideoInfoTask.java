package com.bitmap.videoframetool.tasks;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSONObject;
import com.bitmap.videoframetool.data.ResponseCode;
import com.bitmap.videoframetool.data.ResponseData;
import com.bitmap.videoframetool.utils.VideoInfoUtil;

import io.dcloud.feature.uniapp.bridge.UniJSCallback;

/**
 * 视频信息任务
 */
public class VideoInfoTask extends AsyncTask {
    String TAG = "BackTask";
    String videoUrl = "";
    UniJSCallback uniJSCallback;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.i(TAG , "onPreExecute：开始执行任务");
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected Object doInBackground(Object[] objects) {
        this.videoUrl = (String) objects[0];
        this.uniJSCallback = (UniJSCallback) objects[1];
        this.generateImageData();
        return null;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        Log.i(TAG, "onProgressUpdate: 任务执行完成");
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void generateImageData() {
        try {
            JSONObject object = VideoInfoUtil.getVideoInfo(this.videoUrl);
            ResponseData responseData = new ResponseData<JSONObject>("成功" , ResponseCode.SUCCESS);
            responseData.setData(object);
            uniJSCallback.invoke(responseData);
        }catch (Exception e) {
            ResponseData responseData = new ResponseData<Exception>("失败" , ResponseCode.UNKWON_ERROR);
            responseData.setData(e);
            uniJSCallback.invoke(responseData);
        }

    }
}
