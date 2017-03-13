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
### 三、Logger日志的使用
### 1.Gradle:
```
compile 'com.orhanobut:logger:1.15'
```
### 2.使用方法：
#### 在Application中初始化tag：Logger.init("tagName");
#### 也可以不写，默认为“PRETTYLOGGER”
#### 简单使用：
```
String userName = "virgil";
Logger.i(userName);
```
#### 给当前打印的换一个单独的tag名
```
Logger.t("App").i(userName);
```
#### 也可以打印非字符串类型的数据
```
Logger.i("大家好，我叫%s，今年%d，很高兴认识大家！", "virgil", 18);
```
#### Logger还可以打印很多形式的数据，极大的方便了我们的开发
```
Logger.d("hello");
Logger.e("hello");
Logger.w("hello");
Logger.v("hello");
Logger.wtf("hello");
// 打印json格式
String json = createJson().toString();
Logger.json(json);
// 打印xml格式
Logger.xml(XML_CONTENT);
// 打印自定义级别、tag、信息等格式日志
Logger.log(DEBUG, "tag", "message", throwable);

// 创建json数据
private JSONObject createJson() {    
    try {        
        JSONObject person = new JSONObject(); 
        person.put("phone", "12315");
        JSONObject address = new JSONObject();       
        address.put("country", "china");
        address.put("province", "fujian");       
        address.put("city", "xiamen");   
        person.put("address", address);
        person.put("married", true);        
        return person;    
    } catch (JSONException e) {        
        Logger.e(e, "create json error occured");    
    }    
    return null;
}
```
#### Logger库还针对显示可以自己自定义
```
Settings setting = Logger.init("MainActivity");
setting.logLevel(LogLevel.FULL) //  显示全部日志，LogLevel.NONE不显示日志，默认是Full   
     .methodCount(5)         //  方法栈打印的个数，默认是2        
     .methodOffset(0)        //  设置调用堆栈的函数偏移值，0的话则从打印该Log的函数开始输出堆栈信息，默认是0
     .hideThreadInfo();      //  隐藏线程信息
     .logAdapter(new AndroidLogAdapter());// 自定义一个打印适配器，这里适配了Android的Log打印，你也可以自己实现LogAdapter接口来做一些特殊需求的日志打印适配
```
##### 线程显示隐藏了，方法栈显示的偏移量为0，表示从打印的Log的地方开始算方法数的5个堆栈内的方法都打印出来。

#### 打印数组、List、map等对象数据
```
String[] names = {"Jerry", "Emily", "小五", "hongyang", "七猫"};
Logger.d(names);  // 打印字符数组
List<User> users = new ArrayList<>();
for (int i = 0; i < names.length; i++) {    
    User user = new User(names[i], 10 + i);
    users.add(user);
}
Logger.d(users);  // 打印List

class User {    
    private String name;    
    private int age;    
    public User(String name, int age) {        
        this.name = name;        
        this.age = age;    
    }    
    public String getName() {        
        return name;    
    }    
    public void setName(String name) {        
        this.name = name;    
    }    
    public int getAge() {        
        return age;    
    }    
    public void setAge(int age) {        
        this.age = age;    
    }    
    // 要覆写对象的toString方法才可以打印出完整的日志信息
    @Override    
    public String toString() {        
      return "User{" +                
          "name='" + name + '\'' +                
          ", age=" + age +                
          '}';   
    }
  }
```
### 四、BaseActivity和BaseFragment用法
```
public class OrderActivity extends BaseActivity<ActivityOrderBinding> {
    private OrderViewModel mOrderViewModel = null;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void setViewModel() {
        mOrderViewModel = new OrderViewModel();
        mBinding.setViewmodel(mOrderViewModel);
    }

    @Override
    protected void init() {
        mOrderViewModel.loadData();
    }
}
```

```
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
```
### 五、title bar用法
#### 1.xml文件
```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:bind="http://schemas.android.com/apk/res-auto">

    <data>

        <variable
            name="viewmodel"
            type="com.virgil.frameworkstart.home.order.viewmodel.OrderViewModel"/>
        <variable name="titlebar" type="com.virgil.baselib.activity.TitleBarViewModel"/>
    </data>

    <LinearLayout
        android:id="@+id/activity_order"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context="com.virgil.frameworkstart.home.order.view.OrderActivity">

        <include layout="@layout/layout_title_bar_normal"
            bind:titlebar="@{titlebar}"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="12dp"
            android:layout_marginTop="12dp"
            android:text="@{viewmodel.name}"
            tools:text="name"/>

    </LinearLayout>
</layout>
```

#### 2.Activity
```
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
```
#### 3.效果图
![](https://github.com/youyutongxue/FrameworkStart/blob/master/app/src/main/java/com/virgil/frameworkstart/art/titlebar.jpeg)
