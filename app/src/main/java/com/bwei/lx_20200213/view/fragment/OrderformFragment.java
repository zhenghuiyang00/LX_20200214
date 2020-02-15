package com.bwei.lx_20200213.view.fragment;


import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bwei.lx_20200213.R;
import com.bwei.lx_20200213.base.BaseFragment;
import com.bwei.lx_20200213.contract.OrderformContract;
import com.bwei.lx_20200213.model.entity.OrderfromEntity;
import com.bwei.lx_20200213.presenter.OrderformPresenter;
import com.bwei.lx_20200213.view.adapter.OrderformAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderformFragment extends BaseFragment<OrderformPresenter> implements OrderformContract.IView {

    @BindView(R.id.rv_order)
    RecyclerView rvOrder;
    private int status=0;
    private int page=1;
    //所有数据，也可以叫旧数据
    List<OrderfromEntity.OrderListBean>list=new ArrayList<>();

    @Override
    protected void initView(View view) {

    }

    @Override
    protected OrderformPresenter initPresenter() {
        return new OrderformPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.fragment_orderform;
    }

    @Override
    protected void initData() {
        //获取当前订单状态
        Bundle bundle=getArguments();

        if (bundle != null) {
            status=bundle.getInt("status");
        }
        //在initData里面联网
        presenter.getOrderformData(27801,
                "158166515478527801",
                this.status,page,5);

    }

    public static OrderformFragment getInstance(int status) {
        OrderformFragment orderformFragment = new OrderformFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("status", status);
        //核心代码
        orderformFragment.setArguments(bundle);
        return orderformFragment;
    }


    @Override
    public void onOrderformSuccess(OrderfromEntity orderfromEntity) {
        //0.拿到订单结合，将订单集合，添加到就数据里面
        list.addAll(orderfromEntity.getOrderList());
        //1.设置布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvOrder.setLayoutManager(linearLayoutManager);
        //设置适配器
        OrderformAdapter orderformAdapter=new OrderformAdapter(list);
        rvOrder.setAdapter(orderformAdapter);
    }

    @Override
    public void onOrderformFrailre(Throwable throwable) {

    }
}
