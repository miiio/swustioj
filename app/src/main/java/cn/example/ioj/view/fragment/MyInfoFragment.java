package cn.example.ioj.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.example.ioj.IOJApplication;
import cn.example.ioj.R;
import cn.example.ioj.bean.UserBean;

/**
 * Created by wax on 2017/10/21.
 */

public class MyInfoFragment extends Fragment {
    @BindView(R.id.tv_me_school)
    TextView tvMeSchool;
    @BindView(R.id.tv_me_institution)
    TextView tvMeInstitution;
    @BindView(R.id.tv_me_class)
    TextView tvMeClass;
    @BindView(R.id.tv_me_id)
    TextView tvMeId;
    @BindView(R.id.tv_me_qq)
    TextView tvMeQq;
    @BindView(R.id.tv_me_email)
    TextView tvMeEmail;
    @BindView(R.id.tv_me_phone)
    TextView tvMePhone;
    @BindView(R.id.tv_me_maxim)
    TextView tvMeMaxim;
    Unbinder unbinder;
    @BindView(R.id.tv_me_realname)
    TextView tvMeRealname;
    private View fragmentRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentRootView = inflater.inflate(R.layout.fragment_myinfo, container, false);
        unbinder = ButterKnife.bind(this, fragmentRootView);
        initView();
        return fragmentRootView;
    }

    private void initView() {
        UserBean user = ((IOJApplication) getActivity().getApplication()).getUser();

        if (user.getReal_name().length() > 0) {
            tvMeRealname.setText(user.getReal_name());
        } else {
            tvMeRealname.setText("未填写");
        }

        if (user.getStudent_class().length() > 0) {
            tvMeClass.setText(user.getStudent_class());
        } else {
            tvMeClass.setText("未填写");
        }

        if (user.getEmail().length() > 0) {
            tvMeEmail.setText(user.getEmail());
        } else {
            tvMeEmail.setText("未填写");
        }

        if (user.getStudent_id().length() > 0) {
            tvMeId.setText(user.getStudent_id());
        } else {
            tvMeId.setText("未填写");
        }

        if (user.getInstitution().length() > 0) {
            tvMeInstitution.setText(user.getInstitution());
        } else {
            tvMeInstitution.setText("未填写");
        }

        if (user.getMaxim().length() > 0) {
            tvMeMaxim.setText(user.getMaxim());
        } else {
            tvMeMaxim.setText("未填写");
        }

        if (user.getPhone().length() > 0) {
            tvMePhone.setText(user.getPhone());
        } else {
            tvMePhone.setText("未填写");
        }

        if (user.getQq().length() > 0) {
            tvMeQq.setText(user.getQq());
        } else {
            tvMeQq.setText("未填写");
        }

        if (user.getSchool().length() > 0) {
            tvMeSchool.setText(user.getSchool());
        } else {
            tvMeSchool.setText("未填写");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
