package com.zlb.component.app;

import android.app.Application;

/**
 * App容器
 *
 * @author zlb
 * @date 2019/8/24
 */
public class StormApplication extends Application {

    private static StormApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static StormApplication getInstance() {
        return mApplication;
    }
}
