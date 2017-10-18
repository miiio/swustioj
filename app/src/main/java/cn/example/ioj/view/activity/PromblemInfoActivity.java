package cn.example.ioj.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.example.ioj.R;
import cn.example.ioj.bean.ProblemBean;
import cn.example.ioj.contract.ProblemInfoContract;
import cn.example.ioj.my_view.TextCard;
import cn.example.ioj.presenter.ProblemInfoPresenter;

public class PromblemInfoActivity extends BaseActivity<ProblemInfoPresenter> implements ProblemInfoContract.View {

    @BindView(R.id.tbar_prb_info)
    Toolbar mTbarPrbInfo;
    @BindView(R.id.description)
    TextCard mDescription;
    @BindView(R.id.input)
    TextCard mInput;
    @BindView(R.id.output)
    TextCard mOutput;
    @BindView(R.id.sampleinput)
    TextCard mSampleinput;
    @BindView(R.id.sampleoutput)
    TextCard mSampleoutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promblem_info);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mTbarPrbInfo.setNavigationIcon(R.drawable.ic_back);
        mTbarPrbInfo.setTitle("A+B");
        mTbarPrbInfo.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加返回的语句
            }
        });
        setSupportActionBar(mTbarPrbInfo);
        mDescription.setTitle("Description");
        mInput.setTitle("Input");
        mOutput.setTitle("Output");
        mSampleinput.setTitle("Sample Input");
        mSampleoutput.setTitle("Sample Output");
        onSuccessed(new ProblemBean());
    }

    @Override
    protected ProblemInfoPresenter getPresenter() {
        return new ProblemInfoPresenter(this);
    }

    @Override
    public void showError(int code) {

    }

    @Override
    public void onSuccessed(ProblemBean problem) {
        mDescription.setText(this.getString(R.string.test_description));
        mInput.setText(this.getString(R.string.test_input));
        mOutput.setText(this.getString(R.string.test_output));
        mSampleinput.setText(this.getString(R.string.test_sampleinput));
        mSampleoutput.setText(this.getString(R.string.test_sampleputput));
    }
}
