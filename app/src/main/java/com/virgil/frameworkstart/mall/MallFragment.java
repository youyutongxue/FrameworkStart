package com.virgil.frameworkstart.mall;

import com.orhanobut.logger.Logger;
import com.virgil.baselib.activity.BaseFragment;
import com.virgil.frameworkstart.R;
import com.virgil.frameworkstart.databinding.FragmentMallBinding;
import com.virgil.frameworkstart.user.UserBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MallFragment extends BaseFragment<FragmentMallBinding> {
    private MallViewModel mMallViewModel = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mall;
    }

    @Override
    protected void setViewModel() {
        mMallViewModel = new MallViewModel();
        mBinding.setViewModel(mMallViewModel);
    }

    @Override
    protected void init() {
        mMallViewModel.loadData();
        loggerUse();
        LoggerOther();
    }

    /**
     * Logger的简单使用
     */
    private void loggerUse() {
        String name = "virgil";
        Logger.i(name);
        Logger.d("aaaaa");
        Logger.d("aaaaa，%s", name);
        getString(name, 18);
        List<UserBean> list = new ArrayList<>();
        list.add(new UserBean("user1", 1));
        list.add(new UserBean("user2", 2));
        list.add(new UserBean("user3", 3));
        list.add(new UserBean("user4", 4));
        //单独起一个名字：mytag
        Logger.t("mytag").d(list.toString());
    }

    private void LoggerOther() {
        Logger.d("hello");
        Logger.e("hello");
        Logger.w("hello");
        Logger.v("hello");
        Logger.wtf("hello");
        // 打印json格式
        String json = createJson().toString();
        Logger.json(json);
        // 打印xml格式
        //Logger.xml(XML_CONTENT);
        // 打印自定义级别、tag、信息等格式日志
        //Logger.log(DEBUG, "tag", "message", throwable);
    }

    public void getString(String name, int age) {
        Logger.d("大家好，我叫%s，今年%d，很高兴大家来看我的文章！！！", name, age);
    }

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

}
