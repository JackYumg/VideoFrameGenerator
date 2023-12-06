package com.bitmap.videoframetool.utils;

import android.graphics.Bitmap;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapUtils {

    public static String transformBitmapToBase64(Bitmap bitmap) {
        if (null == bitmap) throw new NullPointerException();
        // if (null == bitmap) return null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //把bitmap100%高质量压缩 到 output对象里
        bitmap.compress(Bitmap.CompressFormat.PNG, 1, outputStream);
        byte[] imageByte = outputStream.toByteArray();
        return Base64.encodeToString(imageByte, Base64.DEFAULT);
    }
}