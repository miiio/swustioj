package cn.example.ioj.view.activity.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.example.ioj.R;
import cn.example.ioj.presenter.impl.LoginPresenter;
import cn.example.ioj.view.activity.i.ILoginActivity;

/**
 * Created by Tolean on 2017/9/21.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginActivity {
    @BindView(R.id.et_login_username)
    TextInputEditText mEtLoginUsername;
    @BindView(R.id.til_login_username)
    TextInputLayout mTilLoginUsername;
    @BindView(R.id.im_login_clear_um)
    ImageView mImLoginClearUm;
    @BindView(R.id.et_login_pw)
    TextInputEditText mEtLoginPw;
    @BindView(R.id.im_login_clear_pw)
    ImageView mImLoginClearPw;
    @BindView(R.id.im_login_eyeable_pw)
    ImageView mImLoginEyeablePw;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter(this);
    }

    /**
     * 初始化View
     */
    private void initView() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    public void showError(int code) {

    }
}
