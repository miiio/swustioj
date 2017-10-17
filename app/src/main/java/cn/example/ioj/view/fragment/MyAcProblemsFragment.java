package cn.example.ioj.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.example.ioj.IOJApplication;
import cn.example.ioj.R;
import me.next.tagview.TagCloudView;

/**
 * Created by wax on 2017/10/14.
 */

public class MyAcProblemsFragment extends Fragment {
    @BindView(R.id.tagview_me)
    TagCloudView tagviewMe;
    Unbinder unbinder;
    private View fragmentRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentRootView = inflater.inflate(R.layout.fragment_myac, container, false);
        unbinder = ButterKnife.bind(this, fragmentRootView);
        init();
        return fragmentRootView;
    }

    private void init() {
        tagviewMe.setTags(((IOJApplication)getActivity().getApplication()).getUser().getProblemsInfo().getAc_pros());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
