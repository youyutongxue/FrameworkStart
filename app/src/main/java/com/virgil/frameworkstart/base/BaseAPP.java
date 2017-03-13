package com.virgil.frameworkstart.base;

import android.text.TextUtils;

import com.orhanobut.logger.Logger;
import com.virgil.baselib.activity.App;
import com.virgil.frameworkstart.BuildConfig;
import com.virgil.frameworkstart.R;
import com.weavey.loading.lib.LoadingLayout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import timber.log.Timber;

/**
 * Created by 陈有余 on 2017/3/8 10:43.
 */

public class BaseApp extends App {

    @Override
    public void onCreate() {
        super.onCreate();
        //设置tagName,可以不写，默认为“PRETTYLOGGER”
        Logger.init("virgil_logger");
        //在这里先使用Timber.plant注册一个Tree，然后调用静态的.d .v 去使用
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new FileLoggingTree());
        }
        Timber.tag("virgil_timber");

        //loading布局相关参数初始化
        LoadingLayout.getConfig()
                .setErrorText("出错啦~请稍后重试！")
                .setEmptyText("抱歉，暂无数据")
                .setNoNetworkText("无网络连接，请检查您的网络···")
                .setErrorImage(R.mipmap.define_error)
                .setEmptyImage(R.mipmap.define_empty)
                .setNoNetworkImage(R.mipmap.define_nonetwork)
                .setAllTipTextColor(R.color.gray)
                .setAllTipTextSize(14)
                .setReloadButtonText("点我重试哦")
                .setReloadButtonTextSize(14)
                .setReloadButtonTextColor(R.color.gray)
                .setReloadButtonWidthAndHeight(150,40)
                .setAllPageBackgroundColor(R.color.background)
                .setLoadingPageLayout(R.layout.define_loading_page);
    }

    private class FileLoggingTree extends Timber.Tree {
        String CacheDiaPath = getApplicationContext().getCacheDir().toString();

        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            if (TextUtils.isEmpty(CacheDiaPath)) {
                return;
            }
            File file = new File(CacheDiaPath + "/log.txt");
            Logger.i("file.path:" + file.getAbsolutePath() + ",message:" + message);
            FileWriter writer = null;
            BufferedWriter bufferedWriter = null;
            try {
                writer = new FileWriter(file);
                bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(message);
                bufferedWriter.flush();
            } catch (IOException e) {
                Logger.i("存储文件失败");
                e.printStackTrace();
            } finally {
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
