package com.bwei.lx_20200213.contract;

import com.bwei.lx_20200213.model.entity.LoginEntity;
import com.bwei.lx_20200213.model.entity.RegisterEntity;

public interface IRegAndLogContract {
    interface IModel{
        void register(String phone,String pwd,IModelCallBack iModelCallBack);
        void login(String phone,String pwd,IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onRegisterSuccess(RegisterEntity registerEntity);
            void onRegisterFailure(Throwable throwable);

            void onLoginSuccess(LoginEntity loginEntity);
            void onLoginFailure(Throwable throwable);

        }

    }
    interface IView{
        //注册
        void onRegisterSuccess(RegisterEntity registerEntity);
        void onRegisterFailure(Throwable throwable);
        //登录
        void onLoginSuccess(LoginEntity loginEntity);
        void onLoginFailure(Throwable throwable);

    }

    interface IPresenter{
        void register(String phone,String pwd);
        void login(String phone,String pwd);
    }
}
