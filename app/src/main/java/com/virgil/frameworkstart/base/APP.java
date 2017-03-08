package com.virgil.frameworkstart.base;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by 陈有余 on 2017/3/8 10:43.
 */

public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //设置tagname,可以不写，默认为“PRETTYLOGGER”
        Logger.init("virgil");
    }
}
