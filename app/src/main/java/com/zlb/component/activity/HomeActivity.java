package com.zlb.component.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.zlb.component.R;
import com.zlb.component.activity.base.BaseActivity;
import com.zlb.component.fragment.HomeFragment;
import com.zlb.component.fragment.MessageFragment;
import com.zlb.component.fragment.MineFragment;
import com.zlb.component.module.recommand.BaseReCommandModel;
import com.zlb.component.network.http.RequestCenter;
import com.zlb.sdk.okhttp.listener.DisposeDataListener;

/**
 * @author zlb
 * @date 2019/8/24
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private FragmentManager fm;
    private HomeFragment mHomeFragment;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private Fragment mCurrent;
    private Fragment mCommonFragmentOne;

    private RelativeLayout mHomeLayout;
    private RelativeLayout mMessageLayout;
    private RelativeLayout mMineLayout;

    private TextView mHomeView;
    private TextView mMessageView;
    private TextView mMineView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        initView();

        mHomeFragment = new HomeFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, mHomeFragment);
        fragmentTransaction.commit();

    }

    private void initView() {

        mHomeLayout = (RelativeLayout) findViewById(R.id.home_layout_view);
        mHomeLayout.setOnClickListener(this);

        mMessageLayout = (RelativeLayout) findViewById(R.id.message_layout_view);
        mMessageLayout.setOnClickListener(this);

        mMineLayout = (RelativeLayout) findViewById(R.id.mine_layout_view);
        mMineLayout.setOnClickListener(this);

        mHomeView = (TextView) findViewById(R.id.home_image_view);
        mMessageView = (TextView) findViewById(R.id.message_image_view);
        mMineView = (TextView) findViewById(R.id.mine_image_view);

        mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);


        RequestCenter.requestReCommandData(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                BaseReCommandModel mRecommandData = (BaseReCommandModel) responseObj;
            }

            @Override
            public void onFailure(Object reasonObj) {
                Log.d("zhu", "onFailure=" + reasonObj.toString());
            }
        });


    }

    private void hideFragment(Fragment fragment, FragmentTransaction ft) {
        if (fragment != null) {
            ft.hide(fragment);
        }
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.home_layout_view:
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_pond);
                hideFragment(mMessageFragment, ft);
                hideFragment(mMineFragment, ft);
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                } else {
                    mCurrent = mHomeFragment;
                    ft.show(mHomeFragment);
                }
                break;
            case R.id.message_layout_view:
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mMineView.setBackgroundResource(R.drawable.comui_tab_pond);

                hideFragment(mHomeFragment, ft);
                hideFragment(mMineFragment, ft);

                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    ft.add(R.id.content_layout, mMessageFragment);
                } else {
                    mCurrent = mMessageFragment;
                    ft.show(mMessageFragment);
                }
                break;
            case R.id.mine_layout_view:
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mMineView.setBackgroundResource(R.drawable.comui_tab_pond_selected);

                hideFragment(mHomeFragment, ft);
                hideFragment(mMessageFragment, ft);

                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    ft.add(R.id.content_layout, mMineFragment);
                } else {
                    mCurrent = mMineFragment;
                    ft.show(mMineFragment);
                }
                break;
            default:
                break;
        }
        ft.commit();
    }
}
