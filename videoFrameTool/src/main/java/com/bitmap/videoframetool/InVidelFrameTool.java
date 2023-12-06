package com.bitmap.videoframetool;

import android.graphics.Bitmap;

import org.json.JSONException;

import java.io.IOException;

import io.dcloud.feature.uniapp.bridge.UniJSCallback;

public interface InVidelFrameTool {
    public void getFrameAtIndex(String videoUrl ,Integer index, UniJSCallback uniJSCallback);
    public void getFrameAtIndexAsync(String videoUrl , Integer index,UniJSCallback uniJSCallback);
    public void getVideoInfo(String videoUrl , UniJSCallback uniJSCallback);
    public void getVideoInfoAsync(String videoUrl , UniJSCallback uniJSCallback);
    public void getFirstFrame(String videoUrl, UniJSCallback uniJSCallback);
    public void getFirstFrameAsync(String videoUrl, UniJSCallback uniJSCallback);
}
