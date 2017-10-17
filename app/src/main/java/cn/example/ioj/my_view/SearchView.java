package cn.example.ioj.my_view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import butterknife.BindView;
import cn.example.ioj.R;

/**
 * Created by Tolean on 2017/9/27.
 */

public class SearchView extends FrameLayout {
    ImageView mImSearchViewBack;
    AppCompatEditText mEtSearchView;
    ImageView mClear;
    ImageView mSearch;
    LinearLayout mEtButton;
    Spinner mSpinner2;
    private Context mContext;

    public SearchView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.search_view, this);
        mEtSearchView=findViewById(R.id.et_search_view);
        mImSearchViewBack = findViewById(R.id.im_search_view_back);
        mEtButton=findViewById(R.id.et_button);
        mClear=findViewById(R.id.clear);
        mSearch=findViewById(R.id.search);

        mSpinner2=findViewById(R.id.spinner2);
        initView();
    }

    private void initView() {
        mEtSearchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(mEtSearchView.getText().length()!=0) {
                    mEtButton.setVisibility(VISIBLE);
                }else{
                    mEtButton.setVisibility(GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mEtSearchView.setText("");
            }
        });
    }

    /**
     * 返回当前选择的搜索类型
     *
     * @return
     */
    public int getSearchType() {
        return mSpinner2.getId();
    }

    /**
     * 设置返回按钮监听事件
     *
     * @param listener
     */
    public void setOnbackListener(OnClickListener listener) {
        mImSearchViewBack.setOnClickListener(listener);
    }

    /**
     * 设置 搜索按钮点击后的事件
     *
     * @param listener
     */
    public void setOnSearchListener(OnClickListener listener) {
        mSearch.setOnClickListener(listener);
    }
}
