package com.example.hiotclound.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.hiotclound.utils.Constants;

/**
 * viewpager适配器
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {
    public MainViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){

            case Constants.MAIN_VIEWPAGER_INDEX_MAESSAGE:
                //创建信息的fragment todo
                fragment =  MessageFragment.newInstance();

                break;
            case Constants.MAIN_VIEWPAGER_INDEX_EQUIPMENT:
                //创建设备fragment
                fragment =  EquipmentFragment.newInstance();
                break;
            case Constants.MAIN_VIEWPAGER_INDEX_SCENE:
                //创建场景fragment
                fragment =  SceneFragment.newInstance();
                break;
            case Constants.MAIN_VIEWPAGER_INDEX_MINE:
                //创建我的fragment
                fragment =  MineFragment.newInstance();
                break;
            default:
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return Constants.MAIN_FRAGMENT_COUNT;
    }
}
