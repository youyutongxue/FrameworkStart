package com.virgil.frameworkstart.find;

import android.databinding.ObservableField;

/**
 * Created by 陈有余 on 2017/3/13 09:35.
 * Description：
 */

public class FindViewModel {
    public final ObservableField<String> name = new ObservableField<>();

    public void loadData() {
        //网络访问，获取数据
        name.set("发现");
    }
}
