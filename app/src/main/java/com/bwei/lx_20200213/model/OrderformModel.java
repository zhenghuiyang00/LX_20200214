package com.bwei.lx_20200213.model;

import com.bwei.lx_20200213.contract.OrderformContract;
import com.bwei.lx_20200213.model.entity.OrderfromEntity;
import com.bwei.lx_20200213.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class OrderformModel implements OrderformContract.IModel{

    @Override
    public void getOrderformData(int userId, String sessionId, int status, int page, int count, IModelCallback iModelCallback) {
        NetUtil.getInstance()
                .getApi()
                //订单
                .getOrderformData(userId,sessionId,status,page,count)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<OrderfromEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OrderfromEntity orderfromEntity) {
                        if ("0000".equals(orderfromEntity.getStatus())){
                            iModelCallback.onOrderformSuccess(orderfromEntity);
                        }else {
                            iModelCallback.onOrderformFrailre(new Exception(orderfromEntity.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallback.onOrderformFrailre(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
