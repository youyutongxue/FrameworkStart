package com.virgil.frameworkstart;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.virgil.frameworkstart.find.FindFragment;
import com.virgil.frameworkstart.helper.FragmentHelper;
import com.virgil.frameworkstart.home.HomeFragment;
import com.virgil.frameworkstart.mall.MallFragment;
import com.virgil.frameworkstart.shop.ShopFragment;
import com.virgil.frameworkstart.user.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mContext = this;
    private BottomNavigationBar bottomNavigationBar = null;
    private FragmentManager manager = null;
    private List<Fragment> fragments = new ArrayList<>();

    private HomeFragment mHomeFragment = null;
    private MallFragment mMallFragment = null;
    private FindFragment mFindFragment = null;
    private ShopFragment mShopFragment = null;
    private UserFragment mUserFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        //设置标签选择样式
        //bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        //bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        //bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "商城"))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "门店"))
                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "我的"))
                .setActiveColor(R.color.hotpink)//设置选中标签的颜色(一般设置为app的主色)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentHelper.switchFragment(manager,fragments,position,R.id.layout_container,
                        0,0);
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {
            }
        });
    }

    private void initData() {
        manager = getSupportFragmentManager();
        mHomeFragment = new HomeFragment();
        fragments.add(mHomeFragment);
        mMallFragment = new MallFragment();
        fragments.add(mMallFragment);
        mFindFragment = new FindFragment();
        fragments.add(mFindFragment);
        mShopFragment = new ShopFragment();
        fragments.add(mShopFragment);
        mUserFragment = new UserFragment();
        fragments.add(mUserFragment);
        //默认显示第一个碎片
        FragmentHelper.replaceFragment(manager, fragments, 0, R.id.layout_container, 0, 0);
    }
}
