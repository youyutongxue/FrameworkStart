package com.virgil.baselib.activity;

import android.databinding.ObservableField;

import com.databinding.command.ReplyCommand;

/**
 * Created by 陈有余 on 2017/3/9 16:49.
 * Description：标题栏
 */

public class TitleBarViewModel {
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<Boolean> showLeft = new ObservableField<>();
    public final ObservableField<Integer> resId1 = new ObservableField<>();
    public final ObservableField<Integer> resId2 = new ObservableField<>();
    public ReplyCommand backCommand = new ReplyCommand(() ->
            App.getAppContext().getCurrentActivity().finish()
    );
    public ReplyCommand rightCommand1 = new ReplyCommand(() -> {
    });
    public ReplyCommand rightCommand2 = new ReplyCommand(() -> {
    });

    public TitleBarViewModel(String title, boolean showLeft) {
        this.title.set(title);
        this.showLeft.set(showLeft);
    }

    public void setRight(int resId, ReplyCommand command) {
        this.resId1.set(resId);
        this.rightCommand1 = command;
    }

    public void setRight2(int resId, ReplyCommand command) {
        this.resId2.set(resId);
        this.rightCommand2 = command;
    }

    public void setRight(int resId){
        this.resId1.set(resId);
    }

    public void setRight2(int resId){
        this.resId2.set(resId);
    }
}
