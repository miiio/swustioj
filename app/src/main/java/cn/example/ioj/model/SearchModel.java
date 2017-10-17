package cn.example.ioj.model;

import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.contract.NetWorkLoaderListener;
import cn.example.ioj.contract.SearchContract;

/**
 * Created by Tolean on 2017/9/26.
 */

public class SearchModel extends ProblemsListModel implements SearchContract.Model {
    @Override
    public void onDestroy() {

    }


}
