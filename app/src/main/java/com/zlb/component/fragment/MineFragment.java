package com.zlb.component.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zlb.component.R;
import com.zlb.component.fragment.base.BaseFragment;

/**
 * @author zlb
 * @date 2019/8/24
 */
public class MineFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {


    }
}
