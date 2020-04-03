package com.zlb.component.network.http;


import com.zlb.component.module.recommand.BaseReCommandModel;
import com.zlb.sdk.okhttp.CommonOkHttpClient;
import com.zlb.sdk.okhttp.listener.DisposeDataHandle;
import com.zlb.sdk.okhttp.listener.DisposeDataListener;
import com.zlb.sdk.okhttp.listener.DisposeDownloadListener;
import com.zlb.sdk.okhttp.request.CommonRequest;
import com.zlb.sdk.okhttp.request.RequestParams;

/**
 * @author: vision
 * @function:
 * @date: 19/8/12
 */
public class RequestCenter {

    //根据参数发送所有post请求
    public static void postRequest(String url, RequestParams params, DisposeDataListener listener, Class<?> clazz) {
        CommonOkHttpClient.get(CommonRequest.
                createGetRequest(url, params), new DisposeDataHandle(listener, clazz));
    }

    public static void requestReCommandData(DisposeDataListener listener) {
        RequestCenter.postRequest(HttpConstants.HOME_RECOMMAND, null, listener, BaseReCommandModel.class);
    }

    public static void zhu(DisposeDataListener dataListener){

    }

    /**
     * 用户登陆请求
     *
     * @param listener
     * @param userName
     * @param passwd
     */
    public static void login(String userName, String passwd, DisposeDataListener listener) {
//        RequestParams params = new RequestParams();
//        params.put("mb", userName);
//        params.put("pwd", passwd);
//        RequestCenter.postRequest(HttpConstants.LOGIN, params, listener, User.class);
    }

    /**
     * 应用版本号请求
     *
     * @param listener
     */
    public static void checkVersion(DisposeDataListener listener) {
//        RequestCenter.postRequest(HttpConstants.CHECK_UPDATE, null, listener, UpdateModel.class);
    }

    public static void downloadFile(String url, String path, DisposeDownloadListener listener) {
//        CommonOkHttpClient.downloadFile(CommonRequest.createGetRequest(url, null),
//                new DisposeDataHandle(listener, path));
    }

    /**
     * 请求课程详情
     *
     * @param listener
     */
    public static void requestCourseDetail(String courseId, DisposeDataListener listener) {
//        RequestParams params = new RequestParams();
//        params.put("courseId", courseId);
//        RequestCenter.postRequest(HttpConstants.COURSE_DETAIL, params, listener, BaseCourseModel.class);
    }
}
