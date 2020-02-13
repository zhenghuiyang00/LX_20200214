package com.bwei.lx_20200213.model;

import com.bwei.lx_20200213.contract.IRegAndLogContract;
import com.bwei.lx_20200213.model.entity.LoginEntity;
import com.bwei.lx_20200213.model.entity.RegisterEntity;
import com.bwei.lx_20200213.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RegAndLogModel implements IRegAndLogContract.IModel {
    /**
     * 注册
     * @param phone
     * @param pwd
     * @param iModelCallBack
     */
    @Override
    public void register(String phone, String pwd, IModelCallBack iModelCallBack) {
        NetUtil.getInstance()
                .getApi()
                .register(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RegisterEntity registerEntity) {
                        if ("0000".equals(registerEntity.getStatus())){
                            iModelCallBack.onRegisterSuccess(registerEntity);
                        }else {
                            iModelCallBack.onRegisterFailure(new Exception(registerEntity.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onRegisterFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 登录
     * @param phone
     * @param pwd
     * @param iModelCallBack
     */
    @Override
    public void login(String phone, String pwd, IModelCallBack iModelCallBack) {
        NetUtil.getInstance()
                .getApi()
                .login(phone,pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<LoginEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginEntity loginEntity) {
                        if ("0000".equals(loginEntity.getStatus())){
                            iModelCallBack.onLoginSuccess(loginEntity);
                        }else {
                            iModelCallBack.onLoginFailure(new Exception(loginEntity.getMessage()));
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onLoginFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
