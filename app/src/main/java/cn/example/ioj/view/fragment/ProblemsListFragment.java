package cn.example.ioj.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

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

/**
 * Created by L on 2017/9/22.
 */

public class ProblemsListFragment extends BaseFragment<ProblemsListPresenter> implements ProblemsListContract.View {
    View fragmentRootView;
    @BindView(R.id.rv_prblist)
    RecyclerView rvPrblist;
    Unbinder unbinder;

    private List<ProblemsBean> mProblemsBeanList;
    private BaseQuickAdapter rvAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentRootView = inflater.inflate(R.layout.fragment_prblist, container, false);
        unbinder = ButterKnife.bind(this, fragmentRootView);
        mPresenter.LoadProblemsListPage(1);
        initView();
        return fragmentRootView;
    }

    private void initView() {
        rvPrblist.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAdapter = new BaseQuickAdapter<ProblemsBean,BaseViewHolder>(R.layout.item_prblist,mProblemsBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, ProblemsBean item) {
                helper.setText(R.id.tv_prblist_titel,item.getTitle());
                if(item.isAc()){
                    helper.setVisible(R.id.im_prblist_ac,true);
                }
                helper.setText(R.id.tv_prblist_id,"("+item.getId()+")");
                helper.setText(R.id.tv_prblist_ac_rate,
                        "("+String.valueOf(item.getAc_num())+"/"+String.valueOf(item.getSubmit_num())
                                +")"+new DecimalFormat("0.00%").format((double) item.getAc_num()/item.getSubmit_num()));
            }
        };

        rvPrblist.setAdapter(rvAdapter);
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
        if(problemsList == null){
            return; //什么也没获取到
        }
        if(mProblemsBeanList == null){
            mProblemsBeanList = new ArrayList<>();
        }
        if(clean){
            mProblemsBeanList.clear();
        }
        mProblemsBeanList.addAll(problemsList.getProblems());

//        initView();
        //rvAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
