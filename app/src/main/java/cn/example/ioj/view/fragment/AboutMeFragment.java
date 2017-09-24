package cn.example.ioj.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.example.ioj.R;
import cn.example.ioj.contract.AboutMeContract;
import cn.example.ioj.my_view.AboutMeCardView;
import cn.example.ioj.presenter.AboutMePresenter;

/**
 * Created by Tolean on 2017/9/22.
 */

public class AboutMeFragment extends BaseFragment<AboutMePresenter> implements AboutMeContract.View {
    @BindView(R.id.im_aboutme_setting)
    ImageView mImAboutmeSetting;
    @BindView(R.id.cv_login_problem)
    AboutMeCardView mCvLoginProblem;
    Unbinder unbinder;
    @BindView(R.id.cv_login_collect)
    AboutMeCardView mCvLoginCollect;
    private View fragmentRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentRootView = inflater.inflate(R.layout.fragment_about_me, container, false);
        unbinder = ButterKnife.bind(this, fragmentRootView);
        initView();
        return fragmentRootView;
    }

    private void initView() {
        mCvLoginProblem.setImageView(R.drawable.question);
        mCvLoginProblem.setTextView_tv("问题");
        mCvLoginProblem.setTextView_num("0");

        mCvLoginCollect.setImageView(R.drawable.collect);
        mCvLoginCollect.setTextView_tv("收藏");
        mCvLoginCollect.setTextView_num("0");
    }

    @Override
    public void showError(int code) {

    }

    @Override
    protected AboutMePresenter getPresenter() {
        return new AboutMePresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
