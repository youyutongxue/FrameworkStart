# FrameworkStart 项目框架
###本文介绍如何快速的搭建起一个项目的框架
### 一、底部导航使用方法
### 1.Gradle：
```
compile 'com.ashokvarma.android:bottom-navigation-bar:1.3.0'
```
### 2.In your activity xml :
```
<com.ashokvarma.bottomnavigation.BottomNavigationBar
        android:layout_gravity="bottom"
        android:id="@+id/bottom_navigation_bar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```
### 3.In your class：
```
BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
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
            }

            @Override
            public void onTabUnselected(int position) {
            }

            @Override
            public void onTabReselected(int position) {
            }
        });
```

### 二、修改状态栏颜色、隐藏标题栏
```
<style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/hotpink</item>
        <item name="colorPrimaryDark">@color/hotpink</item>
        <item name="colorAccent">@color/hotpink</item>
    </style>
```
