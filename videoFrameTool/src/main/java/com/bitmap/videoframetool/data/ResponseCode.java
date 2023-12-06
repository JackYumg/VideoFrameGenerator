package com.bitmap.videoframetool.data;

/**
 * 返回数据的枚举数据
 */
public enum ResponseCode {
    SUCCESS(20000, "成功"),
    PERMISSION_DENEY(100001, "无权限"),
    UNKWON_ERROR(40000, "未知的错误"),
    INFO_ERROR(30001, "视频信息获取错误")
    ;
    private final int code;
    private final String desc;

    ResponseCode(int i, String desc) {
        this.code = i;
        this.desc = desc;
    }
}
