package com.virgil.frameworkstart.home;

import android.content.Context;
import android.content.Intent;

import com.databinding.command.ReplyCommand;
import com.virgil.frameworkstart.home.order.view.OrderActivity;
import com.weavey.loading.lib.LoadingLayout;

/**
 * Created by 陈有余 on 2017/3/9 15:40.
 * Description：
 */

public class HomeViewModel {
    private Context mContext;

    public HomeViewModel(Context context) {
        mContext = context;
    }

    public void loadData(){

    }

    public ReplyCommand clickCommand = new ReplyCommand(() -> {
        mContext.startActivity(new Intent().setClass(mContext, OrderActivity.class));
        //ToastCustomUtils.showSuccessToast(mContext, "success");
    });
}
