package cn.example.ioj.presenter;

import android.util.Log;

import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.contract.NetWorkLoaderListener;
import cn.example.ioj.contract.SearchContract;
import cn.example.ioj.model.BaseModel;
import cn.example.ioj.model.SearchModel;
import cn.example.ioj.util.Constant;
import cn.example.ioj.view.activity.BaseActivity;
import cn.example.ioj.view.activity.SearchActivity;

/**
 * Created by Tolean on 2017/9/26.
 */

public class SearchPresenter extends BasePresenter<SearchActivity,SearchModel> implements SearchContract.Presenter {
    private String id,title,source,cloud;
    public SearchPresenter(SearchActivity mView) {
        super(mView);
    }

    @Override
    protected SearchModel getModel() {
        return new SearchModel();
    }

    @Override
    public void loadSearchProblemList(int searchtype, String text, int page, final boolean clean) {
        switch (searchtype){
            case 0:id=text;title="";source="";cloud="";
                break;
            case 1:id="";title=text;source="";cloud="";
                break;
            case 2:id="";title="";source=text;cloud="";
                break;
            case 3:id="";title="";source="";cloud=text;
                break;
            default:
        }
        mModel.LoadProblems(id, title, source, cloud, page, new NetWorkLoaderListener<ProblemsList>() {
            @Override
            public void onSucceed(ProblemsList data) {
                ((SearchActivity)(mView)).addPrblemsList(data,clean);
            }

            @Override
            public void onFailure(Throwable e) {
                mView.showToast(e.toString());
            }
        });
    }

    @Override
    public void getSuggest(String keyword) {
        if(keyword.length()<=0){
            return;
        }
        mView.setLoading(true);
        mModel.loadSuggest(keyword, new NetWorkLoaderListener<ProblemsList>() {
            @Override
            public void onSucceed(ProblemsList data) {
                if(data.getProblems().size()==0){
                    mView.setLoading(false);
                    return;
                }
                mView.showSuggest(data);
                mView.switchView(Constant.SUGGEST);
                mView.setLoading(false);
            }

            @Override
            public void onFailure(Throwable e) {
                //什么也不显示
                mView.setLoading(true);
            }
        });
    }
}
