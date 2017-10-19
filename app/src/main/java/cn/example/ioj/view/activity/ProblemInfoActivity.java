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

public class ProblemInfoActivity extends BaseActivity<ProblemInfoPresenter> implements ProblemInfoContract.View {

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
    @BindView(R.id.hint)
    TextCard hint;
    @BindView(R.id.source)
    TextCard source;

    private String _id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promblem_info);
        ButterKnife.bind(this);
        _id = getIntent().getStringExtra("id");
        initView();
        mPresenter.loadInfo(_id);
    }

    private void initView() {
        mTbarPrbInfo.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(mTbarPrbInfo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTbarPrbInfo.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加返回的语句
                finish();
            }
        });
        mDescription.setTitle("Description");
        mInput.setTitle("Input");
        mOutput.setTitle("Output");
        mSampleinput.setTitle("Sample Input");
        mSampleoutput.setTitle("Sample Output");
        hint.setTitle("Hint");
        source.setText("Source");
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
//        mDescription.setText(this.getString(R.string.test_description));
//        mInput.setText(this.getString(R.string.test_input));
//        mOutput.setText(this.getString(R.string.test_output));
//        mSampleinput.setText(this.getString(R.string.test_sampleinput));
//        mSampleoutput.setText(this.getString(R.string.test_sampleputput));
        mTbarPrbInfo.setTitle(problem.getTitle());
        mDescription.setText(problem.getPrblem_content());
        mInput.setText(problem.getProblem_input());
        mOutput.setText(problem.getProblem_output());
        mSampleinput.setText(problem.getProblem_samp_input());
        mSampleoutput.setText(problem.getProblem_samp_output());
        hint.setText(problem.getProblem_hint());
        source.setText(problem.getProblem_source());
    }
}
