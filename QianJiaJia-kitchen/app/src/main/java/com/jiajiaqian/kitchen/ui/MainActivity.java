package com.jiajiaqian.kitchen.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jiajiaqian.kitchen.R;
import com.jiajiaqian.kitchen.ui.base.BaseActivity;
import com.jiajiaqian.kitchen.ui.home.HomeFragment;
import com.jiajiaqian.kitchen.ui.personal.PersonalFragment;
import com.jiajiaqian.kitchen.ui.shop.ShopFragment;
import com.jiajiaqian.kitchen.ui.sort.SortFragment;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    private static final String FRAGMENT_HOME = "home";
    private static final String FRAGMENT_SORT = "sort";
    private static final String FRAGMENT_SHOP = "shop";
    private static final String FRAGMENT_PERSONAL = "personal";

    //控件成员变量
    private RadioButton mHome;
    private RadioButton mSort;
    private RadioButton mShop;
    private RadioButton mPersonal;
    private RadioGroup mBottomGroup;

    //该类其他成员变量
    private String mCurrentFragmentTag; //记录当前tab所对应的fragment

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {

        mHome = (RadioButton)this.findViewById(R.id.rdoBtn_tab_home);
        mSort = (RadioButton)this.findViewById(R.id.rdoBtn_tab_sort);
        mShop = (RadioButton)this.findViewById(R.id.rdoBtn_tab_shop);
        mPersonal = (RadioButton)this.findViewById(R.id.rdoBtn_tab_me);
        mBottomGroup = (RadioGroup)this.findViewById(R.id.rdoGrp_tab_list);

    }

    @Override
    public void initEvent() {
        mBottomGroup.setOnCheckedChangeListener(this);
        mHome.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.rdoBtn_tab_home:
                controlShowFragment(FRAGMENT_HOME);
                break;
            case R.id.rdoBtn_tab_sort:
                controlShowFragment(FRAGMENT_SORT);
                break;
            case R.id.rdoBtn_tab_shop:
                controlShowFragment(FRAGMENT_SHOP);
                break;
            case R.id.rdoBtn_tab_me:
                controlShowFragment(FRAGMENT_PERSONAL);
                break;
        }
    }

    private void controlShowFragment(String tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment oldFragment = fragmentManager.findFragmentByTag(mCurrentFragmentTag);
        if (oldFragment != null){
            transaction.hide(oldFragment);
        }
        mCurrentFragmentTag = tag;

        Fragment currentFragment = fragmentManager.findFragmentByTag(tag);
        if (currentFragment != null){
            transaction.show(currentFragment);
        }else {
            transaction.add(R.id.main_content,getFragment(tag),tag);
        }
        transaction.commitAllowingStateLoss();
    }

    private Fragment getFragment(String tag){
        Fragment fragment = null;
        switch (tag){
            case FRAGMENT_HOME:
                fragment = HomeFragment.newInstance();
                break;
            case FRAGMENT_SORT:
                fragment = SortFragment.newInstance();
                break;
            case FRAGMENT_SHOP:
                fragment = ShopFragment.newInstance();
                break;
            case FRAGMENT_PERSONAL:
                fragment = PersonalFragment.newInstance();
                break;
            default:
                break;
        }
        return fragment;
    }
}
