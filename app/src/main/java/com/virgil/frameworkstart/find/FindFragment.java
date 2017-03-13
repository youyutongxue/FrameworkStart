package com.virgil.frameworkstart.find;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.virgil.baselib.activity.BaseFragment;
import com.virgil.frameworkstart.R;
import com.virgil.frameworkstart.databinding.FragmentFindBinding;

import timber.log.Timber;


public class FindFragment extends BaseFragment<FragmentFindBinding> {
    private FindViewModel mFindViewModel = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    protected void setViewModel() {
        mFindViewModel = new FindViewModel();
        mBinding.setViewModel(mFindViewModel);
    }

    @Override
    protected void init() {
        mFindViewModel.loadData();
        //Timber用法
        Timber.d("test Timber %d", 10);
    }
}
