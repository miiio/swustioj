package cn.example.ioj.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.example.ioj.R;
import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.contract.SearchContract;
import cn.example.ioj.presenter.SearchPresenter;
import cn.example.ioj.util.Constant;
import cn.example.ioj.util.SharedPreferencesUtil;


/**
 * Created by Tolean on 2017/9/26.
 */


public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchContract.View, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.et_search)
    AppCompatEditText etSearch;
    @BindView(R.id.im_search_back)
    ImageView imSearchBack;
    @BindView(R.id.progressbar_search_loading)
    ProgressBar progressbarSearchLoading;
    @BindView(R.id.im_search_clear)
    ImageView imSearchClear;
    @BindView(R.id.spinner_search)
    Spinner spinnerSearch;
    @BindView(R.id.im_search)
    ImageView imSearch;
    @BindView(R.id.framelayout_search_head)
    FrameLayout framelayoutSearchHead;
    @BindView(R.id.appbar_search)
    AppBarLayout appbarSearch;
    @BindView(R.id.rv_prblist)
    RecyclerView rvPrblist;
    @BindView(R.id.rv_search_history)
    RecyclerView rvSearchHistory;
    @BindView(R.id.rv_search_suggest)
    RecyclerView rvSearchSuggest;
    @BindView(R.id.linearlayout_search_history)
    LinearLayout linearlayoutSearchHistory;
    @BindView(R.id.tv_search_clearhistory)
    TextView tvSearchClearhistory;

    private int page = 1;
    private boolean isNoMore = false;
    private boolean isSearching = false;

    private BaseQuickAdapter rvProblemsAdapter;
    private BaseQuickAdapter rvSearchHistoryAdapter;
    private BaseQuickAdapter rvSuggestAdapter;

    private List<ProblemsList.ProblemsBean> mProblemsBeanList;
    private List<ProblemsList.ProblemsBean> mSuggestList = new ArrayList<>();
    private List<String> mSearchHistory = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_problems);
        ButterKnife.bind(this);
        initAdapter();
        initView();
        switchView(Constant.HISTORY); //进入显示搜索历史
        refreshSearchHistory();
    }

    private void initAdapter() {
        rvProblemsAdapter = new BaseQuickAdapter<ProblemsList.ProblemsBean, BaseViewHolder>(R.layout.item_search_prblist, mProblemsBeanList) {
            @Override
            protected void convert(BaseViewHolder helper, final ProblemsList.ProblemsBean item) {
                helper.setText(R.id.tv_prblist_titel, item.getTitle());
                if (item.isAc()) {
                    helper.setVisible(R.id.im_prblist_ac, true);
                } else {
                    helper.setVisible(R.id.im_prblist_ac, false);
                }
                helper.setOnClickListener(R.id.linearlayout_search_prbitem, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SearchActivity.this, ProblemInfoActivity.class);
                        intent.putExtra("id", item.getId());
                        startActivity(intent);
                    }
                });
                helper.setText(R.id.tv_prblist_id, "(" + item.getId() + ")");
                if (item.getSubmit_num() == 0) {
                    item.setSubmit_num(1); //防止除以0
                }
                helper.setText(R.id.tv_prblist_ac_rate,
                        "(" + String.valueOf(item.getAc_num()) + "/" + String.valueOf(item.getSubmit_num())
                                + ") " + new DecimalFormat("0.00%").format((double) item.getAc_num() / item.getSubmit_num()));
            }
        };

        rvSuggestAdapter = new BaseQuickAdapter<ProblemsList.ProblemsBean, BaseViewHolder>(R.layout.item_search_suggest, mSuggestList) {
            @Override
            protected void convert(BaseViewHolder helper, final ProblemsList.ProblemsBean item) {
                helper.setText(R.id.tv_search_suggest, item.getTitle());

                helper.setOnClickListener(R.id.item_suggest, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //点击
                        spinnerSearch.setSelection(1);
                        isSearching = true;
                        etSearch.setText(item.getTitle());
                        search();
                    }
                });
            }
        };

        rvSearchHistoryAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_remainder, mSearchHistory) {
            @Override
            protected void convert(BaseViewHolder helper, final String item) {
                helper.setText(R.id.remainder_text, item);
                helper.setOnClickListener(R.id.item_reminder, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //点击
                        spinnerSearch.setSelection(1);
                        isSearching = true;
                        etSearch.setText(item);
                        imSearchClear.setVisibility(View.VISIBLE);
                        search();
                    }
                });
                helper.setOnClickListener(R.id.delete, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mSearchHistory.remove(item);
                        SharedPreferencesUtil.updateSearchHistory(SearchActivity.this, mSearchHistory);
                        rvSearchHistoryAdapter.notifyDataSetChanged();
                    }
                });
            }

        };
    }


    public void initView() {

        spinnerSearch.setSelection(1);

        imSearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        //搜索事件
        imSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });

        rvPrblist.setLayoutManager(new LinearLayoutManager(this));
        rvProblemsAdapter.setOnLoadMoreListener(this, rvPrblist);
        rvPrblist.setAdapter(rvProblemsAdapter);

        rvSearchHistory.setLayoutManager(new LinearLayoutManager(this));
        rvSearchHistory.setAdapter(rvSearchHistoryAdapter);

        rvSearchSuggest.setLayoutManager(new LinearLayoutManager(this));
        rvSearchSuggest.setAdapter(rvSuggestAdapter);

        //清除输入
        imSearchClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etSearch.setText("");
                switchView(Constant.HISTORY);
            }
        });

        etSearch.addTextChangedListener(searchKeyWordWatcher);

        tvSearchClearhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSearchHistory.clear();
                SharedPreferencesUtil.clearAllSearchHistory(SearchActivity.this);
                rvSearchHistoryAdapter.notifyDataSetChanged();
                tvSearchClearhistory.setVisibility(View.GONE);
            }
        });
    }

    private void search() {
        int type = spinnerSearch.getSelectedItemPosition();
        String keyword = etSearch.getText().toString();
        page = 1;
        isNoMore = false;
        switchView(Constant.SEARCHRESULT);
        if (mSearchHistory.contains(keyword)) {
            mSearchHistory.remove(keyword);
        }
        mSearchHistory.add(0, keyword);
        SharedPreferencesUtil.updateSearchHistory(SearchActivity.this, mSearchHistory);
        tvSearchClearhistory.setVisibility(View.VISIBLE);
        mPresenter.loadSearchProblemList(type,
                keyword, page++, true);

        switchView(Constant.SEARCHRESULT);
    }

    private Handler getsuggestHandler = new Handler();

    /**
     * 延迟线程，看是否还有下一个字符输入
     */
    private Runnable getSuggestDelayRun = new Runnable() {

        @Override
        public void run() {
            //在这里调用服务器的接口，获取数据
            mPresenter.getSuggest(etSearch.getText().toString());
        }
    };

    /**
     * 监听编辑框文本输入
     */
    private TextWatcher searchKeyWordWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (isSearching) {
                return;
            }
            if (charSequence.length() != 0) {
                imSearchClear.setVisibility(View.VISIBLE);

            } else {
                switchView(Constant.HISTORY);
                imSearchClear.setVisibility(View.GONE);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(spinnerSearch.getSelectedItemPosition() != 1){
                return;
            }
            if(getSuggestDelayRun!=null){
                //每次editText有变化的时候，则移除上次发出的延迟线程
                getsuggestHandler.removeCallbacks(getSuggestDelayRun);
            }
            //editString = s.toString();

            //延迟800ms，如果不再输入字符，则执行该线程的run方法
            getsuggestHandler.postDelayed(getSuggestDelayRun, 800);
        }
    };

    /**
     * 显示问题列表
     *
     * @param problemsList 被显示的内容
     * @param clean        是否清空当前数据
     */
    @Override
    public void addPrblemsList(ProblemsList problemsList, boolean clean) {
        Log.i("Lyon", String.valueOf(problemsList.getTotal()));
        if (problemsList == null) {
            return; //什么也没获取到
        }
        if (mProblemsBeanList == null) {
            mProblemsBeanList = new ArrayList<>();
        }
        if (clean) {
            mProblemsBeanList.clear();
        }
        if (problemsList.getProblems().size() == 0) {
            isNoMore = true;
        }
        mProblemsBeanList.addAll(problemsList.getProblems());
        rvProblemsAdapter.setNewData(mProblemsBeanList);
        rvProblemsAdapter.notifyDataSetChanged();
        isSearching = false;
    }


    @Override
    public void setLoading(boolean loding) {
        progressbarSearchLoading.setVisibility(loding ? View.VISIBLE : View.GONE);
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
        if (!isNoMore) {
            ((SearchPresenter) mPresenter).loadSearchProblemList(spinnerSearch.getSelectedItemPosition(),
                    etSearch.getText().toString(), page++, false);
        } else {
            rvProblemsAdapter.loadMoreEnd();
        }
    }

    public void switchView(int which) {
        switch (which) {
            case Constant.HISTORY:
                linearlayoutSearchHistory.setVisibility(View.VISIBLE);
                rvSearchSuggest.setVisibility(View.GONE);
                rvPrblist.setVisibility(View.GONE);
                break;
            case Constant.SUGGEST:
                linearlayoutSearchHistory.setVisibility(View.GONE);
                rvSearchSuggest.setVisibility(View.VISIBLE);
                rvPrblist.setVisibility(View.GONE);
                break;
            case Constant.SEARCHRESULT:
                linearlayoutSearchHistory.setVisibility(View.GONE);
                rvSearchSuggest.setVisibility(View.GONE);
                rvPrblist.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void showSuggest(ProblemsList list) {
        mSuggestList.clear();
        mSuggestList.addAll(list.getProblems());
        rvSuggestAdapter.setNewData(mSuggestList);
        rvSuggestAdapter.notifyDataSetChanged();

    }

    void refreshSearchHistory() {
        SharedPreferencesUtil.loadSearchHistory(SearchActivity.this, mSearchHistory); //读取
        if(mSearchHistory.size()>0){
            tvSearchClearhistory.setVisibility(View.VISIBLE);
        }else{
            tvSearchClearhistory.setVisibility(View.GONE);
        }
    }
}


//public class SearchActivity extends BaseActivity implements SearchContract.View ,BaseQuickAdapter.RequestLoadMoreListener{
//    private int page=1;
//    private boolean isNoMore=false;
//    @BindView(R.id.searchView)
//    SearchView mSearchView;
//    @BindView(R.id.rv_prblist)
//    RecyclerView rvPrblist;
//    private BaseQuickAdapter rvProblemsAdapter;
//    private List<ProblemsList.ProblemsBean> mProblemsBeanList;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//        ButterKnife.bind(this);
//        initView();
//    }
//
//    public void initView() {
//
//       mSearchView.setOnbackListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                SearchActivity.this.finish();
//            }
//        });
//        mSearchView.setOnSearchListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                page=1; isNoMore=false;
//                ((SearchPresenter)mPresenter).loadSearchProblemList(mSearchView.getSearchType(),
//                        mSearchView.getText(),page++,true);
//            }
//        });
//
//
//
//        rvPrblist.setLayoutManager(new LinearLayoutManager(this));
//        rvProblemsAdapter = new BaseQuickAdapter<ProblemsList.ProblemsBean,BaseViewHolder>(R.layout.item_prblist,mProblemsBeanList) {
//            @Override
//            protected void convert(BaseViewHolder helper, final ProblemsList.ProblemsBean item) {
//                helper.setText(R.id.tv_prblist_titel,item.getTitle());
//                if(item.isAc()){
//                    helper.setVisible(R.id.im_prblist_ac,true);
//                }else{
//                    helper.setVisible(R.id.im_prblist_ac,false);
//                }
//                helper.setOnClickListener(R.id.cardView_problemList, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(SearchActivity.this,ProblemInfoActivity.class);
//                        intent.putExtra("id",item.getId());
//                        startActivity(intent);
//                    }
//                });
//                helper.setText(R.id.tv_prblist_id,"("+item.getId()+")");
//                helper.setText(R.id.tv_prblist_ac_rate,
//                        "("+String.valueOf(item.getAc_num())+"/"+String.valueOf(item.getSubmit_num())
//                                +") "+new DecimalFormat("0.00%").format((double) item.getAc_num()/item.getSubmit_num()));
//            }
//        };
//        rvProblemsAdapter.setOnLoadMoreListener(this,rvPrblist);
//        rvPrblist.setAdapter(rvProblemsAdapter);
//
//
//    }
//
//    /**
//     * 显示问题列表
//     *
//     * @param problemsList 被显示的内容
//     * @param clean        是否清空当前数据
//     */
//    @Override
//    public void addPrblemsList(ProblemsList problemsList, boolean clean) {
//        Log.i("Lyon",String.valueOf(problemsList.getTotal()));
//        if(problemsList == null){
//            return; //什么也没获取到
//        }
//        if(mProblemsBeanList == null){
//            mProblemsBeanList = new ArrayList<>();
//        }
//        if(clean){
//            mProblemsBeanList.clear();
//        }
//        if(problemsList.getProblems().size()==0){
//            isNoMore=true;
//        }
//        mProblemsBeanList.addAll(problemsList.getProblems());
//        rvProblemsAdapter.setNewData(mProblemsBeanList);
//        rvProblemsAdapter.notifyDataSetChanged();
//
//    }
//
//
//
//    @Override
//    public void showError(int code) {
//
//    }
//
//    @Override
//    protected SearchPresenter getPresenter() {
//        return new SearchPresenter(this);
//    }
//
//    @Override
//    public void onLoadMoreRequested() {
//        if(!isNoMore) {
//            ((SearchPresenter) mPresenter).loadSearchProblemList(mSearchView.getSearchType(),
//                    mSearchView.getText(), page++, false);
//        }else{
//            rvProblemsAdapter.loadMoreEnd();
//        }
//    }
//}
