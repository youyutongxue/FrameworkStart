package com.virgil.frameworkstart.shop;

import com.virgil.baselib.activity.BaseFragment;
import com.virgil.frameworkstart.R;
import com.virgil.frameworkstart.databinding.FragmentShopBinding;

public class ShopFragment extends BaseFragment<FragmentShopBinding> {
    private ShopViewModel mShopViewModel = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected void setViewModel() {
        mShopViewModel = new ShopViewModel();
        mBinding.setViewModel(mShopViewModel);
    }

    @Override
    protected void init() {
        mShopViewModel.loadData();
    }
}
