package com.virgil.frameworkstart.helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * Created by virgil on 2016/7/21.
 */
public class FragmentHelper {
    public static void replaceFragment(FragmentManager manager, List<Fragment> fragments,
                                       int tabIndex,int layoutId,int enter,int exit){
        FragmentTransaction transaction =manager.beginTransaction();
        if(enter!=0&&exit!=0){
            transaction.setCustomAnimations(enter,exit);
        }
        transaction.replace(layoutId,fragments.get(tabIndex));
        transaction.commit();
    }

    public static void switchFragment(FragmentManager manager, List<Fragment> fragments,
                                       int tabIndex,int layoutId,int enter,int exit){
        FragmentTransaction transaction =manager.beginTransaction();
        for (int i = 0; i <fragments.size() ; i++) {
            if(fragments.get(i).isVisible()){
                transaction.hide(fragments.get(i));
            }
        }

        if(enter!=0&&exit!=0){
            transaction.setCustomAnimations(enter,exit);
        }

        Fragment toFragment=fragments.get(tabIndex);
        if(toFragment.isAdded()){
            transaction.show(toFragment);
        }else{
            transaction.add(layoutId,toFragment);
        }
        transaction.commit();
    }
}
