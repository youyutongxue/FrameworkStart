package com.virgil.frameworkstart.user;

import android.databinding.ObservableField;

import javax.crypto.interfaces.PBEKey;

/**
 * Created by 陈有余 on 2017/3/13 09:55.
 * Description：
 */

public class UserViewModel {
    public final ObservableField<String> name = new ObservableField<>();

    public void loadData() {
        name.set("我的");
    }
}
