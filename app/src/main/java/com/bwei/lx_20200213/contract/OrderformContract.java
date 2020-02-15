package com.bwei.lx_20200213.contract;

import com.bwei.lx_20200213.model.entity.OrderfromEntity;

public interface OrderformContract {
    interface IModel{
        void getOrderformData(int userId,String sessionId,int status,int page,int count,IModelCallback iModelCallback);
        interface  IModelCallback{
            void onOrderformSuccess(OrderfromEntity orderfromEntity);
            void onOrderformFrailre(Throwable throwable);


        }
    }

    interface IView{
        void onOrderformSuccess(OrderfromEntity orderfromEntity);
        void onOrderformFrailre(Throwable throwable);

    }
    interface IPresenter{
        void getOrderformData(int userId,String sessionId,int status,int page,int count);
    }


}
