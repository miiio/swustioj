package cn.example.ioj.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.example.ioj.R;
import cn.example.ioj.contract.LoginContract;
import cn.example.ioj.presenter.LoginPresenter;
import cn.example.ioj.util.Constant;

/**
 * Created by Tolean on 2017/9/21.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {


    @BindView(R.id.imageView)
    ImageView mImageView;
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
    @BindView(R.id.rtlayout_login_pw)
    RelativeLayout mRtlayoutLoginPw;
    @BindView(R.id.btn_login_login)
    Button mBtnLoginLogin;
    @BindView(R.id.ll_login_login_as_t)
    LinearLayout mLlLoginLoginAsT;
    @BindView(R.id.tv_login_login_as_t)
    TextView mTvLoginLoginAsT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        setListener();
        setStatusBarTransparent();
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

    private void setListener() {


        mEtLoginPw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (mEtLoginPw.getText().length() != 0) {
                    mImLoginClearPw.setVisibility(View.VISIBLE);
                } else {
                    mImLoginClearPw.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mEtLoginUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (mEtLoginUsername.getText().length() != 0) {
                    mImLoginClearUm.setVisibility(View.VISIBLE);
                } else {
                    mImLoginClearUm.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mImLoginClearUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEtLoginUsername.setText("");
            }
        });
        mImLoginClearPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEtLoginPw.setText("");
            }
        });
        /**
         * 登陆
         */
        mBtnLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这里添加点击登陆后的代码
                mPresenter.login(mEtLoginUsername.getText().toString(),
                        mEtLoginPw.getText().toString());
            }
        });


        //账号编辑框 焦点监听器
        mEtLoginUsername.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    mImLoginClearUm.setVisibility(View.GONE);
                }else if(mEtLoginUsername.getText().length() != 0){
                    mImLoginClearUm.setVisibility(View.VISIBLE);
                }
            }
        });

        //密码编辑框 焦点监听器
        mEtLoginPw.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b){
                    mImLoginClearPw.setVisibility(View.GONE);
                }else if(mEtLoginPw.getText().length() != 0){
                    mImLoginClearPw.setVisibility(View.VISIBLE);
                }
            }
        });

        /**
         * 以游客身份登陆
         */
        mTvLoginLoginAsT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这里添加以游客身份登陆的代码
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.putExtra("mode", Constant.LoginAsTr);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showError(int code) {

    }

    @Override
    public void onLoginSucceed() {
        Toast.makeText(this,"loginsucceed",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("mode", Constant.LoginUsePw);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginFailure(String errmsg) {
        Toast.makeText(this,errmsg,Toast.LENGTH_SHORT).show();
    }
}
