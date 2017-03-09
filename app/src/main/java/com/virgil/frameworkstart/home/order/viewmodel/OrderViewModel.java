package com.virgil.frameworkstart.home.order.viewmodel;

import android.databinding.ObservableField;

/**
 * Created by 陈有余 on 2017/3/9 15:29.
 * Description：
 */

public class OrderViewModel {
    public final ObservableField<String> name = new ObservableField<>();

    public OrderViewModel(){

    }

    public void loadData(){
        //网络访问获取数据
        name.set("virgil");
    }
}
