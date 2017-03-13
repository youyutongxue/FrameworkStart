package com.virgil.frameworkstart.home.order.view;

import com.databinding.command.ReplyCommand;
import com.virgil.baselib.activity.BaseActivity;
import com.virgil.baselib.activity.TitleBarViewModel;
import com.virgil.frameworkstart.R;
import com.virgil.frameworkstart.databinding.ActivityOrderBinding;
import com.virgil.frameworkstart.home.order.viewmodel.OrderViewModel;

public class OrderActivity extends BaseActivity<ActivityOrderBinding> {
    private OrderViewModel mOrderViewModel = null;
    private TitleBarViewModel mTitleBarViewModel = null;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void setViewModel() {
        mOrderViewModel = new OrderViewModel();
        mTitleBarViewModel = new TitleBarViewModel("订单", true);
        mBinding.setViewmodel(mOrderViewModel);
        mTitleBarViewModel.setRight(R.mipmap.collect, new ReplyCommand(() -> {
            showSuccessToast("收藏成功");
        }));
        mTitleBarViewModel.setRight2(R.mipmap.icon_share, new ReplyCommand(() -> {
            showSuccessToast("分享成功");
        }));
        mBinding.setTitlebar(mTitleBarViewModel);
    }

    @Override
    protected void init() {
        mOrderViewModel.loadData();
    }
}
