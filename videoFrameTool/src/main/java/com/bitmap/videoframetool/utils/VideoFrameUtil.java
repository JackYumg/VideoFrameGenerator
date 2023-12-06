package com.bitmap.videoframetool.utils;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public class VideoFrameUtil {
    @RequiresApi(api = Build.VERSION_CODES.P)
    public static JSONObject getVideoFirstFrame(String videoUrl, Integer index) {
        try{
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(videoUrl , new HashMap<>());
            Bitmap bitmap = mediaMetadataRetriever.getFrameAtIndex(index);
            String imageStr = BitmapUtils.transformBitmapToBase64(bitmap);
            JSONObject object = new JSONObject();
            object.put("data", "data:image/png;base64," + imageStr.replace("\n", ""));
            return object;
        } catch (Exception e){
            Log.e("测试", "getVideoFirstFrame: " , e );
            throw e;
        }
    }
}
