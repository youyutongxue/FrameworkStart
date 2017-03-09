package com.virgil.baselib.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

/**
 * Created by 陈有余 on 2017/1/19 15:20.
 * 吐司工具类。如果项目中需要修改吐司样式，则直接修改ToastCustomUtils中的内容即可。
 */

public class ToastCustomUtils {
    private static Toast toast_error;
    private static Toast toast_success;
    private static Toast toast_info;
    private static Toast toast_warning;
    private static Toast toast_normal;
    private static Toast toast_normalIcon;

    // 土司-错误
    public static void showErrorToast(Context context, String text) {
        if (toast_error == null) {
            toast_error = Toasty.error(context, text, Toast.LENGTH_SHORT, true);
        } else {
            toast_error.cancel();
            toast_error = Toasty.error(context, text, Toast.LENGTH_SHORT, true);
        }
        toast_error.show();
    }

    // 土司-成功
    public static void showSuccessToast(Context context, String text) {
        if (toast_success == null) {
            toast_success = Toasty.success(context, text, Toast.LENGTH_SHORT, true);
        } else {
            toast_success.cancel();
            toast_success = Toasty.success(context, text, Toast.LENGTH_SHORT, true);
        }
        toast_success.show();
    }

    // 土司-信息
    public static void showInfoToast(Context context, String text) {
        if (toast_info == null) {
            toast_info = Toasty.info(context, text, Toast.LENGTH_SHORT, true);
        } else {
            toast_info.cancel();
            toast_info = Toasty.info(context, text, Toast.LENGTH_SHORT, true);
        }
        toast_info.show();
    }

    // 土司-警告
    public static void showWarningToast(Context context, String text) {
        if (toast_warning == null) {
            toast_warning = Toasty.warning(context, text, Toast.LENGTH_SHORT, true);
        } else {
            toast_warning.cancel();
            toast_warning = Toasty.warning(context, text, Toast.LENGTH_SHORT, true);
        }
        toast_warning.show();
    }

    // 土司-普通
    public static void showNormalToast(Context context, String text) {
        if (toast_normal == null) {
            toast_normal = Toasty.normal(context, text);
        } else {
            toast_normal.cancel();
            toast_normal = Toasty.normal(context, text);
        }
        toast_normal.show();
    }

    // 土司-普通+图标
    public static void showNormalIconToast(Context context, String text, Drawable icon) {
        if (toast_normalIcon == null) {
            toast_normalIcon = Toasty.normal(context, text, icon);
        } else {
            toast_normalIcon.cancel();
            toast_normalIcon = Toasty.normal(context, text, icon);
        }
        toast_normalIcon.show();
    }
}
