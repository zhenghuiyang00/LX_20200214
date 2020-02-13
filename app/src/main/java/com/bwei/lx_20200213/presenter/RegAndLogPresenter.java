package com.bwei.lx_20200213.presenter;

import com.bwei.lx_20200213.base.BasePresenter;
import com.bwei.lx_20200213.contract.IRegAndLogContract;
import com.bwei.lx_20200213.model.RegAndLogModel;
import com.bwei.lx_20200213.model.entity.LoginEntity;
import com.bwei.lx_20200213.model.entity.RegisterEntity;

public class RegAndLogPresenter extends BasePresenter<IRegAndLogContract.IView> implements IRegAndLogContract.IPresenter {

    private RegAndLogModel regAndLogModel;

    @Override
    protected void initModel() {
        regAndLogModel = new RegAndLogModel();
    }

    @Override
    public void register(String phone, String pwd) {
        regAndLogModel.register(phone, pwd, new IRegAndLogContract.IModel.IModelCallBack() {
            @Override
            public void onRegisterSuccess(RegisterEntity registerEntity) {
                view.onRegisterSuccess(registerEntity);
            }

            @Override
            public void onRegisterFailure(Throwable throwable) {
                view.onRegisterFailure(throwable);

            }

            @Override
            public void onLoginSuccess(LoginEntity loginEntity) {
                view.onLoginSuccess(loginEntity);

            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);
            }
        });
    }

    @Override
    public void login(String phone, String pwd) {
        regAndLogModel.login(phone, pwd, new IRegAndLogContract.IModel.IModelCallBack() {
            @Override
            public void onRegisterSuccess(RegisterEntity registerEntity) {
                view.onRegisterSuccess(registerEntity);
            }

            @Override
            public void onRegisterFailure(Throwable throwable) {
                view.onRegisterFailure(throwable);

            }

            @Override
            public void onLoginSuccess(LoginEntity loginEntity) {
                view.onLoginSuccess(loginEntity);

            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);

            }
        });
    }
}
