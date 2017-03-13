package com.virgil.baselib.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.virgil.baselib.R;
import com.virgil.baselib.utils.ToastCustomUtils;

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    protected T mBinding;
    private long mClickTime = 0l;
    private static int EXIT_TIMEOUT = 2500;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppContext().setCurrentActivity(this);
        mBinding = DataBindingUtil.setContentView(this, getLayoutId());
        App.getAppContext().setCurrentBinding(mBinding);
        setViewModel();
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.getAppContext().setCurrentBinding(mBinding);
        App.getAppContext().setCurrentActivity(this);
    }

    /**
     * 该抽象方法就是 onCreate中需要的layoutID
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

    /**
     * 显示加载dialog
     */
    protected void showLoading() {
        //Utils.showLoading(this);
    }

    /**
     * 隐藏加载dialog
     */
    protected void hideLoading() {
        //Utils.hideLoading();
    }

    /**
     * 右上角功能菜单采用menu的形式
     * 此方法为右上角点击事件，需要注意加上setSupportActionBar(toolbar);
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                //对没有处理的事件，交给父类来处理
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    /**
     * 判断是否是栈底
     *
     * @return
     */
    private boolean isRoot() {
        return isTaskRoot() || (getParent() != null && getParent().isTaskRoot());
    }

    /**
     * 监听返回键
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (isRoot() && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            long second = System.currentTimeMillis();
            if (second - mClickTime < EXIT_TIMEOUT) {
                finish();
                return true;
            } else {
                mClickTime = second;
                ToastCustomUtils.showWarningToast(this, "再按一次返回键退出");
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    //自定义样式的Toast显示
    //成功样式
    protected void showSuccessToast(String content) {
        ToastCustomUtils.showSuccessToast(this, content);
    }
    //错误样式
    protected void showErrorToast(String content) {
        ToastCustomUtils.showErrorToast(this, content);
    }
    //提示信息样式
    protected void showInfoToast(String content) {
        ToastCustomUtils.showInfoToast(this, content);
    }
    //警告样式
    protected void showWarningToast(String content) {
        ToastCustomUtils.showWarningToast(this, content);
    }
    //系统普通样式
    protected void showNormalToast(String content) {
        ToastCustomUtils.showNormalToast(this, content);
    }
    //带图标的系统普通样式
    protected void showNormalIconToast(String content) {
        Drawable icon = getResources().getDrawable(R.drawable.ic_pets_white_48dp);
        ToastCustomUtils.showNormalIconToast(this, content, icon);
    }
}

