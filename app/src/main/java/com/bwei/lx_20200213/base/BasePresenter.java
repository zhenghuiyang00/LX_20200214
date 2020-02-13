package com.bwei.lx_20200213.base;

public abstract class BasePresenter<V> {
    protected V view;

    //绑定
    public void attach(V view) {
        this.view = view;
    }
    //解绑
    public void deatch(){
        view=null;
    }

    public BasePresenter(){
        initModel();
    }
    //初始化model
    protected abstract void initModel();


}
