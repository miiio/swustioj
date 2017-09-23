package cn.example.ioj.presenter;

import cn.example.ioj.contract.AboutMeContract;
import cn.example.ioj.model.AboutMeModel;
import cn.example.ioj.view.fragment.AboutMeFragment;

/**
 * Created by Tolean on 2017/9/22.
 */

public class AboutMePresenter extends BaseFragmentPresenter<AboutMeFragment,AboutMeModel> implements AboutMeContract.Presenter {
    public AboutMePresenter(AboutMeFragment fragment) {
        super(fragment);
    }

    @Override
    protected AboutMeModel getModel() {
        return null;
    }
}
