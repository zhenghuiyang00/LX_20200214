package com.bwei.lx_20200213.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.bwei.lx_20200213.R;
import com.bwei.lx_20200213.base.BaseActivity;
import com.bwei.lx_20200213.contract.IRegAndLogContract;
import com.bwei.lx_20200213.model.entity.LoginEntity;
import com.bwei.lx_20200213.model.entity.RegisterEntity;
import com.bwei.lx_20200213.presenter.RegAndLogPresenter;

import butterknife.BindView;
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
        Toast.makeText(this, "注册成功"+registerEntity.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRegisterFailure(Throwable throwable) {
        Toast.makeText(this, "注册失败"+throwable.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginSuccess(LoginEntity loginEntity) {
        Toast.makeText(this, "登录成功"+loginEntity.getMessage(), Toast.LENGTH_SHORT).show();
        //登录成功之后要进入新的页面
        Intent intent = new Intent(this.getApplicationContext(), OrderfragmentActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(this, "登录失败"+throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }


    @OnClick({R.id.bt_login, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                String phont=edtPhone.getText().toString();
                String pwd=edtPwd.getText().toString();
                //需要加密
                String encryptPwd=EncryptUtils.encryptMD5ToString(pwd);
                encryptPwd=encryptPwd.substring(0,6);
                //去登录
                presenter.login(phont,encryptPwd);
                break;

            case R.id.bt_register:
                String phone1 =edtPhone.getText().toString();
                String pwd1=edtPwd.getText().toString();
                //需要加密
                String encryptpwd1=EncryptUtils.encryptMD5ToString(pwd1);
                //因为后台规定了密码长度，所以我们要处理
                encryptpwd1=encryptpwd1.substring(0,6);
                //去注册
                presenter.register(phone1,encryptpwd1);
                break;
        }
    }
}
