package cn.example.ioj.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.header.TaurusHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.example.ioj.R;
import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.bean.ProblemsList.ProblemsBean;
import cn.example.ioj.contract.ProblemsListContract;
import cn.example.ioj.presenter.ProblemsListPresenter;
import cn.example.ioj.view.activity.ProblemInfoActivity;

/**
 * Created by L on 2017/9/22.
 */

public class ProblemsListFragment extends BaseFragment<ProblemsListPresenter> implements ProblemsListContract.View, BaseQuickAdapter.RequestLoadMoreListener {
    View fragmentRootView;
    @BindView(R.id.rv_prblist)
    RecyclerView rvPrblist;
    Unbinder unbinder;
    @BindView(R.id.refreshlayut_prblist)
    SmartRefreshLayout refreshlayutPrblist;

    private List<ProblemsBean> mProblemsBeanList;
    private BaseQuickAdapter rvAdapter;
    private int page = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentRootView = inflater.inflate(R.layout.fragment_prblist, container, false);
        unbinder = ButterKnife.bind(this, fragmentRootView);
        initView();
        mPresenter.LoadProblemsListPage(page++, true);
        return fragmentRootView;
    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if(isVisibleToUser){
//            mPresenter.LoadProblemsListPage(page++,true);
//        }
//    }

    public void moveToTop() {
        rvPrblist.scrollToPosition(0);
    }

    private void initView() {
        rvPrblist.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAdapter = new BaseQuickAdapter<ProblemsBean, BaseViewHolder>(R.layout.item_prblist, mProblemsBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, final ProblemsBean item) {
                helper.setText(R.id.tv_prblist_titel, item.getTitle());
                if (item.isAc()) {
                    helper.setVisible(R.id.im_prblist_ac, true);
                } else {
                    helper.setVisible(R.id.im_prblist_ac, false);
                }
                helper.setOnClickListener(R.id.cardView_problemList, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ProblemsListFragment.this.getActivity(), ProblemInfoActivity.class);
                        intent.putExtra("id", item.getId());
                        startActivity(intent);
                    }
                });
                helper.setText(R.id.tv_prblist_id, "(" + item.getId() + ")");
                helper.setText(R.id.tv_prblist_ac_rate,
                        "(" + String.valueOf(item.getAc_num()) + "/" + String.valueOf(item.getSubmit_num())
                                + ") " + new DecimalFormat("0.00%").format((double) item.getAc_num() / item.getSubmit_num()));
            }
        };

        rvAdapter.setOnLoadMoreListener(this, rvPrblist);
        rvPrblist.setAdapter(rvAdapter);


        //设置 Header
        refreshlayutPrblist.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                page = 1;
                mPresenter.LoadProblemsListPage(page++, true);
            }
        });
    }

    @Override
    public void showError(int code) {

    }

    @Override
    protected ProblemsListPresenter getPresenter() {
        return new ProblemsListPresenter(this);
    }


    /**
     * 显示问题列表
     *
     * @param problemsList 被显示的内容
     * @param clean        是否清空当前数据
     */
    @Override
    public void addPrblemsList(ProblemsList problemsList, boolean clean) {
        if (problemsList == null) {
            return; //什么也没获取到
        }
        if (mProblemsBeanList == null) {
            mProblemsBeanList = new ArrayList<>();
        }
        if (clean) {
            mProblemsBeanList.clear();
            refreshlayutPrblist.finishRefresh();
        }
        mProblemsBeanList.addAll(problemsList.getProblems());
        rvAdapter.setNewData(mProblemsBeanList);
        rvAdapter.notifyDataSetChanged();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onLoadMoreRequested() {
        mPresenter.LoadProblemsListPage(page++, false);
    }
}
