package com.zlb.sdk.db.realm;

import android.content.Context;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * @author zlb
 * @date 2019/8/24
 * @function 数据库管理类
 */
public class RealmManager {

    private static final String DB_NAME = "sdk.realm";

    private static Realm mRealm;

    public static Realm getRealm() {
        mRealm = Realm.getInstance(new RealmConfiguration
                .Builder()
                .name(DB_NAME)
                .build());
        return mRealm;
    }

    public static void init(Context context) {
        Realm.init(context);
        Log.e("realm", getRealm().getPath() + "XXX");
    }

    /**
     * 关闭Realm数据库
     */
    public static void closeRealm() {
        if (mRealm != null && !mRealm.isClosed()) {
            mRealm.close();
        }
    }
}
