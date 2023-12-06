package com.bitmap.videoframetool;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSONObject;
import com.bitmap.videoframetool.data.ResponseCode;
import com.bitmap.videoframetool.data.ResponseData;
import com.bitmap.videoframetool.tasks.VideoFrameTask;
import com.bitmap.videoframetool.tasks.VideoInfoTask;
import com.bitmap.videoframetool.utils.VideoFrameUtil;
import com.bitmap.videoframetool.utils.VideoInfoUtil;

import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.bridge.UniJSCallback;
import io.dcloud.feature.uniapp.common.UniModule;

public class VideoFrameToolImp extends UniModule implements InVidelFrameTool {
    String TAG = "VideoFrameTool";

    /**
     * @description 获取第几帧的图片
     * @param videoUrl 视频源地址
     * @param index 第几帧
     * @param uniJSCallback
     */
    @RequiresApi(api = Build.VERSION_CODES.P)
    @UniJSMethod(uiThread = true)
    @Override
    public void getFrameAtIndex(String videoUrl,Integer index, UniJSCallback uniJSCallback) {
        JSONObject object = VideoFrameUtil.getVideoFirstFrame(videoUrl , index );
        try {
            ResponseData<JSONObject> responseData = new ResponseData<JSONObject>("成功" , ResponseCode.SUCCESS);
            responseData.setData(object);
            uniJSCallback.invoke(responseData);
        } catch (Exception e) {
            ResponseData responseData = new ResponseData<Exception>("失败" , ResponseCode.UNKWON_ERROR);
            responseData.setData(responseData);
            uniJSCallback.invoke(responseData);
            throw e;
        }
    }

    /**
     * @description 异步获取第几帧的图片
     * @param videoUrl 视频源地址
     * @param index 第几帧
     * @param uniJSCallback
     */
    @UniJSMethod(uiThread = true)
    @Override
    public void getFrameAtIndexAsync(String videoUrl, Integer index, UniJSCallback uniJSCallback) {
        VideoFrameTask videoFrameTask = new VideoFrameTask();
        videoFrameTask.execute(videoUrl, index , uniJSCallback);
    }

    /**
     * 同步获取视频详细信息
     * @param videoUrl 视频源地址
     * @param uniJSCallback uni回调函数
     */
    @UniJSMethod(uiThread = true)
    @Override
    public void getVideoInfo(String videoUrl, UniJSCallback uniJSCallback) {
        JSONObject object = VideoInfoUtil.getVideoInfo(videoUrl);
        try {
            ResponseData<JSONObject> responseData = new ResponseData<JSONObject>("成功" , ResponseCode.SUCCESS);
            responseData.setData(object);
            uniJSCallback.invoke(responseData);
        } catch (Exception e) {
            ResponseData<ResponseData> responseData = new ResponseData<ResponseData>("失败", ResponseCode.UNKWON_ERROR);
            responseData.setData(responseData);
            uniJSCallback.invoke(responseData);
            throw e;
        }
    }

    /**
     * 同步获取视频详细信息
     * @param videoUrl 视频源地址
     * @param uniJSCallback uni回调函数
     */
    @UniJSMethod(uiThread = true)
    @Override
    public void getVideoInfoAsync(String videoUrl, UniJSCallback uniJSCallback) {
        VideoInfoTask videoInfoTask = new VideoInfoTask();
        videoInfoTask.execute(videoUrl , uniJSCallback);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @UniJSMethod(uiThread = true)
    @Override
    public void getFirstFrame(String videoUrl, UniJSCallback uniJSCallback) {
        JSONObject object = VideoFrameUtil.getVideoFirstFrame(videoUrl , 0);
        try {
            ResponseData<JSONObject> responseData = new ResponseData<JSONObject>("成功" , ResponseCode.SUCCESS);
            responseData.setData(object);
            uniJSCallback.invoke(responseData);
        } catch (Exception e) {
            ResponseData responseData = new ResponseData<Exception>("失败" , ResponseCode.UNKWON_ERROR);
            responseData.setData(responseData);
            uniJSCallback.invoke(responseData);
            throw e;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @UniJSMethod(uiThread = true)
    @Override
    public void getFirstFrameAsync(String videoUrl, UniJSCallback uniJSCallback) {
        VideoFrameTask videoFrameTask = new VideoFrameTask();
        videoFrameTask.execute(videoUrl , 0 ,uniJSCallback);
    }
}
