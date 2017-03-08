package com.virgil.frameworkstart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.virgil.frameworkstart.base.BaseAppCompatActivity;
import com.virgil.frameworkstart.user.UserBean;

import java.util.ArrayList;

public class SecondActivity extends BaseAppCompatActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    protected void init() {
        getToolbarTitle().setText("登录");
        getSubTitle().setText("123");

    }

    @Override
    protected boolean isShowBacking() {
        return true;
    }

}
