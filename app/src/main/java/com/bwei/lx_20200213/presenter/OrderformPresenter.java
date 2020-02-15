package com.bwei.lx_20200213.presenter;

import com.bwei.lx_20200213.base.BasePresenter;
import com.bwei.lx_20200213.contract.OrderformContract;
import com.bwei.lx_20200213.model.OrderformModel;
import com.bwei.lx_20200213.model.entity.OrderfromEntity;

public class OrderformPresenter extends BasePresenter<OrderformContract.IView> implements OrderformContract.IPresenter {

    private OrderformModel orderformModel;

    @Override
    protected void initModel() {
        orderformModel = new OrderformModel();
    }

    @Override
    public void getOrderformData(int userId, String sessionId, int status, int page, int count) {
        orderformModel.getOrderformData(userId, sessionId, status, page, count, new OrderformContract.IModel.IModelCallback() {
            @Override
            public void onOrderformSuccess(OrderfromEntity orderfromEntity) {
                view.onOrderformSuccess(orderfromEntity);
            }

            @Override
            public void onOrderformFrailre(Throwable throwable) {
                view.onOrderformFrailre(throwable);
            }
        });
    }
}
