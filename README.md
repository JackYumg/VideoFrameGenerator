# VideoFrameGenerator
uniapp插件

# 使用方法

`
const tools = uni.requireNativePlugin('VideoFrameToolImp');
tools[apiName](...args , (res) => {
		const url = res.data;
});
`

## apis
`getVideoInfo：同步获取视频信息`

 `getVideoInfoAsync：异步获取视频信息`
 
 `getFirstFrame：同步获取视频首帧`
 
 `getFirstFrameAsync：异步获取视频首帧`
 
 `getFrameAtIndex：按照帧同步获取`
 
 `getFrameAtIndexAsync：按照帧异步获取`
