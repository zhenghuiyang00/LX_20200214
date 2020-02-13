package com.bwei.lx_20200213.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected P presenter;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),LayoutId(),null);
        presenter=initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        unbinder = ButterKnife.bind(this,view);
        initView(view);
        return view;
    }

    protected abstract void initView(View view);


    protected abstract P initPresenter();

    protected abstract int LayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();

    }

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deatch();
        }
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
