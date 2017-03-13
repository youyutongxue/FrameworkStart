package com.virgil.frameworkstart.user;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.virgil.baselib.activity.BaseFragment;
import com.virgil.frameworkstart.R;
import com.virgil.frameworkstart.databinding.FragmentUserBinding;


public class UserFragment extends BaseFragment<FragmentUserBinding> {
    private UserViewModel mUserViewModel = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    protected void setViewModel() {
        mUserViewModel = new UserViewModel();
        mBinding.setViewModel(mUserViewModel);
    }

    @Override
    protected void init() {
        mUserViewModel.loadData();
    }
}
