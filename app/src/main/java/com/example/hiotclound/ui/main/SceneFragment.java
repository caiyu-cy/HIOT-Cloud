package com.example.hiotclound.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hiotclound.R;
import com.example.hiotclound.ui.base.BaseFragment;
import com.example.hiotclound.ui.base.BasePresenter;

public class SceneFragment extends BaseFragment {

    /**
     * 创建fragment实例
     * @return
     */
    public static SceneFragment newInstance(){
        SceneFragment fragment = new SceneFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void injectDependencies() {

    }

    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_main, container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvMainFragment = view.findViewById(R.id.tv_main_fragment);
        tvMainFragment.setText("场景");
    }
}
