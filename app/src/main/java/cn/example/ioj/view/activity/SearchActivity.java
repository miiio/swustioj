package cn.example.ioj.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.example.ioj.R;
import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.contract.SearchContract;
import cn.example.ioj.my_view.SearchView;
import cn.example.ioj.presenter.BasePresenter;
import cn.example.ioj.presenter.SearchPresenter;
import cn.example.ioj.view.fragment.ProblemsListFragment;


/**
 * Created by Tolean on 2017/9/26.
 */

public class SearchActivity extends BaseActivity implements SearchContract.View ,BaseQuickAdapter.RequestLoadMoreListener{
    private int page=1;
    private boolean isNoMore=false;
    @BindView(R.id.searchView)
    SearchView mSearchView;
    @BindView(R.id.rv_prblist)
    RecyclerView rvPrblist;
    private BaseQuickAdapter rvAdapter;
    private List<ProblemsList.ProblemsBean> mProblemsBeanList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initView();

    }

    public void initView() {

       mSearchView.setOnbackListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchActivity.this.finish();
            }
        });
        mSearchView.setOnSearchListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page=1; isNoMore=false;
                ((SearchPresenter)mPresenter).loadSearchProblemList(mSearchView.getSearchType(),
                        mSearchView.getText(),page++,true);
            }
        });
        rvPrblist.setLayoutManager(new LinearLayoutManager(this));
        rvAdapter = new BaseQuickAdapter<ProblemsList.ProblemsBean,BaseViewHolder>(R.layout.item_prblist,mProblemsBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, final ProblemsList.ProblemsBean item) {
                helper.setText(R.id.tv_prblist_titel,item.getTitle());
                if(item.isAc()){
                    helper.setVisible(R.id.im_prblist_ac,true);
                }else{
                    helper.setVisible(R.id.im_prblist_ac,false);
                }
                helper.setOnClickListener(R.id.cardView_problemList, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SearchActivity.this,ProblemInfoActivity.class);
                        intent.putExtra("id",item.getId());
                        startActivity(intent);
                    }
                });
                helper.setText(R.id.tv_prblist_id,"("+item.getId()+")");
                helper.setText(R.id.tv_prblist_ac_rate,
                        "("+String.valueOf(item.getAc_num())+"/"+String.valueOf(item.getSubmit_num())
                                +") "+new DecimalFormat("0.00%").format((double) item.getAc_num()/item.getSubmit_num()));
            }
        };
        rvAdapter.setOnLoadMoreListener(this,rvPrblist);
        rvPrblist.setAdapter(rvAdapter);

    }

    /**
     * 显示问题列表
     *
     * @param problemsList 被显示的内容
     * @param clean        是否清空当前数据
     */
    @Override
    public void addPrblemsList(ProblemsList problemsList, boolean clean) {
        Log.i("Lyon",String.valueOf(problemsList.getTotal()));
        if(problemsList == null){
            return; //什么也没获取到
        }
        if(mProblemsBeanList == null){
            mProblemsBeanList = new ArrayList<>();
        }
        if(clean){
            mProblemsBeanList.clear();
        }
        if(problemsList.getProblems().size()==0){
            isNoMore=true;
        }
        mProblemsBeanList.addAll(problemsList.getProblems());
        rvAdapter.setNewData(mProblemsBeanList);
        rvAdapter.notifyDataSetChanged();

    }
    @Override
    public void showError(int code) {

    }

    @Override
    protected SearchPresenter getPresenter() {
        return new SearchPresenter(this);
    }

    @Override
    public void onLoadMoreRequested() {
        if(!isNoMore) {
            ((SearchPresenter) mPresenter).loadSearchProblemList(mSearchView.getSearchType(),
                    mSearchView.getText(), page++, false);
        }else{
            rvAdapter.loadMoreEnd();
        }
    }
}
