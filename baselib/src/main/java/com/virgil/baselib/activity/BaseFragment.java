package com.virgil.baselib.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.virgil.baselib.R;
import com.virgil.baselib.util.ToastCustomUtils;

/**
 * Created by 陈有余 on 2017/3/9 15:39.
 * Description：
 */

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment {
    protected T mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        App.getAppContext().setCurrentBinding(mBinding);
        setViewModel();
        init();
        return mBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        App.getAppContext().setCurrentBinding(mBinding);
    }

    /**
     * 该抽象方法就是 onCreateView中需要的layoutID
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 绑定ViewModel
     */
    protected abstract void setViewModel();

    /**
     * 初始化view及data
     */
    protected void init() {
    }
}
