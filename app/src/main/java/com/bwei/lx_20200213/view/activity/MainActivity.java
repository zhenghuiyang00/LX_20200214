package com.bwei.lx_20200213.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.EncryptUtils;
import com.bwei.lx_20200213.R;
import com.bwei.lx_20200213.base.BaseActivity;
import com.bwei.lx_20200213.contract.IRegAndLogContract;
import com.bwei.lx_20200213.model.entity.LoginEntity;
import com.bwei.lx_20200213.model.entity.RegisterEntity;
import com.bwei.lx_20200213.presenter.RegAndLogPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<RegAndLogPresenter> implements IRegAndLogContract.IView {


    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.edt_pwd)
    EditText edtPwd;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_register)
    Button Register;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected RegAndLogPresenter initPresenter() {
        return new RegAndLogPresenter();
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onRegisterSuccess(RegisterEntity registerEntity) {

    }

    @Override
    public void onRegisterFailure(Throwable throwable) {

    }

    @Override
    public void onLoginSuccess(LoginEntity loginEntity) {

    }

    @Override
    public void onLoginFailure(Throwable throwable) {

    }


    @OnClick({R.id.bt_login, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //登录
            case R.id.bt_login:

                break;
                //注册
            case R.id.bt_register:
                //加密
                String phone= edtPhone.getText().toString();
                String pwd= edtPwd.getText().toString();
                //密码加密
                EncryptUtils.encryptMD5ToString(pwd);


                break;
        }
    }
}
