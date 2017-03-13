package com.virgil.frameworkstart.home;

import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.virgil.baselib.activity.BaseFragment;
import com.virgil.frameworkstart.R;
import com.virgil.frameworkstart.databinding.FragmentHomeBinding;
import com.weavey.loading.lib.LoadingLayout;

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

    @Override
    protected void init() {
        mBinding.loading.setStatus(LoadingLayout.Loading);

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mBinding.loading.setStatus(LoadingLayout.Empty);
            }
        }, 3000);*/

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mBinding.loading.setStatus(LoadingLayout.No_Network);
            }
        }, 3000);*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mBinding.loading.setStatus(LoadingLayout.Error);
            }
        }, 3000);

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mBinding.loading.setStatus(LoadingLayout.Success);
            }
        }, 3000);*/

        mBinding.loading.setOnReloadListener(new LoadingLayout.OnReloadListener() {
            @Override
            public void onReload(View v) {
                mBinding.loading.setStatus(LoadingLayout.Success);
            }
        });
    }
}
