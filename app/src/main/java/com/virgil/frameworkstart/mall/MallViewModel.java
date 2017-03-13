package com.virgil.frameworkstart.mall;

import android.databinding.ObservableField;

/**
 * Created by 陈有余 on 2017/3/10 16:40.
 * Description：
 */

public class MallViewModel {
    public final ObservableField<String> name = new ObservableField<>();

    public void loadData() {
        name.set("商城");
    }
}
