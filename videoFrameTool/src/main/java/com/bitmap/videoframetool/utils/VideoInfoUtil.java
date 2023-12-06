package com.bitmap.videoframetool.utils;

import android.media.MediaMetadataRetriever;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;
import java.util.HashMap;

public class VideoInfoUtil {
    public static JSONObject getVideoInfo(String videoUrl) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(videoUrl , new HashMap<>());
            int[] infos = {
                    MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER,
                    MediaMetadataRetriever.METADATA_KEY_ALBUM,
                    MediaMetadataRetriever.METADATA_KEY_ARTIST,
                    MediaMetadataRetriever.METADATA_KEY_AUTHOR,
                    MediaMetadataRetriever.METADATA_KEY_COMPOSER,
                    MediaMetadataRetriever.METADATA_KEY_DATE,
                    MediaMetadataRetriever.METADATA_KEY_GENRE,
                    MediaMetadataRetriever.METADATA_KEY_TITLE,
                    MediaMetadataRetriever.METADATA_KEY_YEAR,
                    MediaMetadataRetriever.METADATA_KEY_DURATION,
                    MediaMetadataRetriever.METADATA_KEY_NUM_TRACKS,
                    MediaMetadataRetriever.METADATA_KEY_WRITER,
                    MediaMetadataRetriever.METADATA_KEY_MIMETYPE,
                    MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST,
                    MediaMetadataRetriever.METADATA_KEY_DISC_NUMBER,
                    MediaMetadataRetriever.METADATA_KEY_COMPILATION,
                    MediaMetadataRetriever.METADATA_KEY_HAS_AUDIO,
                    MediaMetadataRetriever.METADATA_KEY_HAS_VIDEO,
                    MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH,
                    MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT,
                    MediaMetadataRetriever.METADATA_KEY_BITRATE,
                    MediaMetadataRetriever.METADATA_KEY_LOCATION,
                    MediaMetadataRetriever.METADATA_KEY_VIDEO_ROTATION,
                    MediaMetadataRetriever.METADATA_KEY_CAPTURE_FRAMERATE,
                    MediaMetadataRetriever.METADATA_KEY_HAS_IMAGE,
                    MediaMetadataRetriever.METADATA_KEY_IMAGE_COUNT,
                    MediaMetadataRetriever.METADATA_KEY_IMAGE_PRIMARY,
                    MediaMetadataRetriever.METADATA_KEY_IMAGE_WIDTH,
                    MediaMetadataRetriever.METADATA_KEY_IMAGE_HEIGHT,
                    MediaMetadataRetriever.METADATA_KEY_IMAGE_ROTATION,
                    MediaMetadataRetriever.METADATA_KEY_VIDEO_FRAME_COUNT,
                    MediaMetadataRetriever.METADATA_KEY_EXIF_OFFSET,
                    MediaMetadataRetriever.METADATA_KEY_EXIF_LENGTH,
                    MediaMetadataRetriever.METADATA_KEY_COLOR_STANDARD,
                    MediaMetadataRetriever.METADATA_KEY_COLOR_TRANSFER,
                    MediaMetadataRetriever.METADATA_KEY_COLOR_RANGE,
                    MediaMetadataRetriever.METADATA_KEY_SAMPLERATE,
                    MediaMetadataRetriever.METADATA_KEY_BITS_PER_SAMPLE,
                    MediaMetadataRetriever.METADATA_KEY_XMP_OFFSET,
                    MediaMetadataRetriever.METADATA_KEY_XMP_LENGTH
            };
            JSONObject object = new JSONObject();
            for (int info : infos) {
                String infoStr = mediaMetadataRetriever.extractMetadata(info);
                object.put(String.valueOf(info) , infoStr);
            }
            return object;
        } catch (Exception e) {
            throw e;
        }
    }
}
