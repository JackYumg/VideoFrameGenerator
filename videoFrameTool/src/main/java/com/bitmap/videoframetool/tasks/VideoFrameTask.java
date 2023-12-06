package com.bitmap.videoframetool.tasks;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSONObject;
import com.bitmap.videoframetool.data.ResponseCode;
import com.bitmap.videoframetool.data.ResponseData;
import com.bitmap.videoframetool.utils.VideoFrameUtil;

import io.dcloud.feature.uniapp.bridge.UniJSCallback;

/**
 * 视频获取帧的任务
 */
public class VideoFrameTask extends AsyncTask {
    String TAG = "VideoFrameTask";
    UniJSCallback uniJSCallback;
    String videoUrl = "";
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected Object doInBackground(Object[] objects) {
        videoUrl = (String)objects[0];
        Integer index = (Integer) objects[1];
        uniJSCallback = (UniJSCallback) objects[2];

        JSONObject obj = VideoFrameUtil.getVideoFirstFrame(videoUrl,index);
        ResponseData responseData = new ResponseData("成功" , ResponseCode.SUCCESS);
        responseData.setData(obj);
        uniJSCallback.invoke(responseData);
        return obj;
    }

}
