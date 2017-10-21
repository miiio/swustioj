package cn.example.ioj.view.activity;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;



import butterknife.BindView;
import butterknife.ButterKnife;
import cn.example.ioj.R;
import cn.example.ioj.bean.ProblemBean;
import cn.example.ioj.contract.ProblemInfoContract;
import cn.example.ioj.my_view.TextCard;
import cn.example.ioj.presenter.ProblemInfoPresenter;

public class ProblemInfoActivity extends BaseActivity<ProblemInfoPresenter> implements ProblemInfoContract.View{

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
    @BindView(R.id.nsvScrollview)
    NestedScrollView mNsvScrollview;
    @BindView(R.id.prb_hint)
    CardView mPrbHint;
    @BindView(R.id.time_limit)
    TextView mTimeLimit;
    @BindView(R.id.memory_limit)
    TextView mMemoryLimit;
    @BindView(R.id.submission)
    TextView mSubmission;
    @BindView(R.id.accepted)
    TextView mAccepted;
    private boolean isHintHidden = false;
    private String _id;
    private TranslateAnimation mShowAction;
    private TranslateAnimation mHiddenAction;
    private float mOldY = 10000000, mFirstY = 10000000;



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


        initAnimations_Two();
        mTbarPrbInfo.setNavigationIcon(R.drawable.ic_back);
        setSupportActionBar(mTbarPrbInfo);
        /**
         * 这一句要放在setSupportActionBar后面才可以
         */
        mTbarPrbInfo.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mNsvScrollview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
//                        mFirstY=motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i("scroll", String.valueOf(motionEvent.getAction()));
                        mOldY = motionEvent.getY();
                        if (mFirstY < mOldY) {
                            if (isHintHidden == true) {
                                Log.i("scroll", "down");
                                isHintHidden = false;
                                mPrbHint.startAnimation(mShowAction);
                                mPrbHint.setVisibility(View.VISIBLE);
                            }
                        } else if (mFirstY >= mOldY) {
                            Log.i("scroll", "up");
                            if (isHintHidden == false) {
                                isHintHidden = true;
                                mPrbHint.startAnimation(mHiddenAction);
                                mPrbHint.setVisibility(View.GONE);
                            }
                        }
                        mFirstY = mOldY;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                }
                return false;
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
        mTbarPrbInfo.setTitle(problem.getTitle());
        mDescription.setText(problem.getPrblem_content());
        mInput.setText(problem.getProblem_input());
        mOutput.setText(problem.getProblem_output());
        mSampleinput.setText(problem.getProblem_samp_input());
        mSampleoutput.setText(problem.getProblem_samp_output());
        hint.setText(problem.getProblem_hint());
        source.setText(problem.getProblem_source());

        mTimeLimit.setText("Time limit(ms): " + String.valueOf(problem.getLimit_time()));
        mMemoryLimit.setText("Memory limit(kb): " + String.valueOf(problem.getLimit_mem()));
        mSubmission.setText("Submission: " + String.valueOf(problem.getSubmission()));
        mAccepted.setText("Accepted: " + String.valueOf(problem.getAccepted()));
        mPrbHint.setVisibility(View.VISIBLE);
    }

    private void initAnimations_Two() {
        mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAction.setDuration(500);
        mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f);
        mHiddenAction.setDuration(500);
    }


}
