package com.virgil.frameworkstart.home;

import com.virgil.baselib.activity.BaseFragment;
import com.virgil.frameworkstart.R;
import com.virgil.frameworkstart.databinding.FragmentHomeBinding;

public class HomeFragment extends BaseFragment<FragmentHomeBinding> {
    private HomeViewModel mHomeViewModel = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void setViewModel() {
        mHomeViewModel = new HomeViewModel(getContext());
        mBinding.setViewmodel(mHomeViewModel);
    }
}
