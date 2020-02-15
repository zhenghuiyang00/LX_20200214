package com.bwei.lx_20200213.view.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bwei.lx_20200213.R;
import com.bwei.lx_20200213.base.BaseActivity;
import com.bwei.lx_20200213.base.BasePresenter;
import com.bwei.lx_20200213.view.fragment.OrderformFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderfragmentActivity extends BaseActivity {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    //Fragment集合
    List<Fragment> fragmentList=new ArrayList<>();
    //标题字符串的集合
    List<String>titleList=new ArrayList<>();

    @Override
    protected void initData() {
        titleList.add("全部订单");
        titleList.add("待支付");
        titleList.add("待收货");
        titleList.add("待评价");
        titleList.add("完成");

        //1.构建五个Fragment
       OrderformFragment orderformFragment1=OrderformFragment.getInstance(0);
       OrderformFragment orderformFragment2=OrderformFragment.getInstance(0);
       OrderformFragment orderformFragment3=OrderformFragment.getInstance(0);
       OrderformFragment orderformFragment4=OrderformFragment.getInstance(0);
       OrderformFragment orderformFragment5=OrderformFragment.getInstance(0);

        //2.添加到Fragment结合
        fragmentList.add(orderformFragment1);
        fragmentList.add(orderformFragment2);
        fragmentList.add(orderformFragment3);
        fragmentList.add(orderformFragment4);
        fragmentList.add(orderformFragment5);

        //3.给vp设置适配器
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            //4.  getTabLayout设置标题     重写getPageTile方法
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);//要返回
            }
        });

        //5.tabLayout和viewPage关联
        tab.setupWithViewPager(vp);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_orderform;
    }


}
