package cn.example.ioj.view.activity;

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


/**
 * Created by Tolean on 2017/9/26.
 */

public class SearchActivity extends BaseActivity implements SearchContract.View {


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


//        mSearchView.setOnSearchBackIconClickListener(new SearchView.OnSearchBackIconClickListener() {
//            @Override
//            public void onClick(View view) {
//                SearchActivity.this.finish();
//            }
//        });
        mSearchView=(SearchView)findViewById(R.id.searchView);
        mSearchView.setSpinnerDate(new LinkedList<String>(Arrays.asList("ID","Title","Source","Cloud")));
        mSearchView.setOnbackListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchActivity.this.finish();
            }
        });
//        mSearchView.setSpinnerOnItemSelectedLisenter();
        rvPrblist.setLayoutManager(new LinearLayoutManager(this));
        rvAdapter = new BaseQuickAdapter<ProblemsList.ProblemsBean,BaseViewHolder>(R.layout.item_prblist,mProblemsBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, ProblemsList.ProblemsBean item) {
                helper.setText(R.id.tv_prblist_titel,item.getTitle());
                if(item.isAc()){
                    helper.setVisible(R.id.im_prblist_ac,true);
                }else{
                    helper.setVisible(R.id.im_prblist_ac,false);
                }
                helper.setText(R.id.tv_prblist_id,"("+item.getId()+")");
                helper.setText(R.id.tv_prblist_ac_rate,
                        "("+String.valueOf(item.getAc_num())+"/"+String.valueOf(item.getSubmit_num())
                                +") "+new DecimalFormat("0.00%").format((double) item.getAc_num()/item.getSubmit_num()));
            }
        };

        rvPrblist.setAdapter(rvAdapter);

//        mSearchView.setOnSearchActionListener(new SearchView.OnSearchActionListener() {
//
//            @Override
//
//            public void onSearchAction(String searchText) {
//
//                ((SearchPresenter)mPresenter).loadSearchProblemList(1,1,true);
//
//                mSearchView.addOneHistory(searchText);
//
//            }
//
//        });
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
}
