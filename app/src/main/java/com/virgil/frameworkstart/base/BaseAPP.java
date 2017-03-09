package com.virgil.frameworkstart.base;

import android.text.TextUtils;

import com.orhanobut.logger.Logger;
import com.virgil.baselib.activity.App;
import com.virgil.frameworkstart.BuildConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import timber.log.Timber;

/**
 * Created by 陈有余 on 2017/3/8 10:43.
 */

public class BaseAPP extends App {

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
