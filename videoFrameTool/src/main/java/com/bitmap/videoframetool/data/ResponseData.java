package com.bitmap.videoframetool.data;

/**
 * 返回数据的数据结构
 * @param <T> 未知类型
 */
public class ResponseData<T> {
    public ResponseData(String message, ResponseCode code) {
        this.message = message;
        this.code = code;
    }
    private String message;

    private ResponseCode code;

    T data;

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
