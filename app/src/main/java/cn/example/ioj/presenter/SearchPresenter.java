package cn.example.ioj.presenter;

import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.contract.NetWorkLoaderListener;
import cn.example.ioj.contract.SearchContract;
import cn.example.ioj.model.BaseModel;
import cn.example.ioj.model.SearchModel;
import cn.example.ioj.view.activity.BaseActivity;
import cn.example.ioj.view.activity.SearchActivity;

/**
 * Created by Tolean on 2017/9/26.
 */

public class SearchPresenter extends BasePresenter implements SearchContract.Presenter {
    private String id,title,source,cloud;
    public SearchPresenter(BaseActivity mView) {
        super(mView);
    }

    @Override
    protected SearchModel getModel() {
        return new SearchModel();
    }

    @Override
    public void loadSearchProblemList(int searchtype,String text, int page, final boolean clean) {
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
        ((SearchModel)mModel).LoadProblems(id, title, source, cloud, page, new NetWorkLoaderListener<ProblemsList>() {
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
}
