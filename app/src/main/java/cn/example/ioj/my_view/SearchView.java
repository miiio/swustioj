package cn.example.ioj.my_view;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.sip.SipAudioCall;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

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
    RecyclerView mReminder;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mSpEditor;
    private Context mContext;
    private BaseQuickAdapter mRmainderAdapter;
    private List<String> mRemainderList;
    private OnClickListener mSearchListener;
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
        mReminder=findViewById(R.id.reminder);
        initView();
    }

    private void initView() {
        mSharedPreferences=mContext.getSharedPreferences("remainder",Context.MODE_PRIVATE);
        mSpEditor=mSharedPreferences.edit();
        mReminder.setLayoutManager(new LinearLayoutManager(mContext));
        mRemainderList=new ArrayList<String>(3);
        for(int i=0;i<10;i++){
            String s=mSharedPreferences.getString(String.valueOf(i),"");
            if(s!="")
            mRemainderList.add(mSharedPreferences.getString(String.valueOf(i),""));
        }
        mRmainderAdapter=new BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_remainder,mRemainderList) {
            @Override
            protected void convert(BaseViewHolder helper, final String item) {
                helper.setText(R.id.remainder_text,item);
                helper.setOnClickListener(R.id.item_reminder, new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mReminder.setVisibility(GONE);
                        mEtSearchView.setText(item);
                        mSearch.callOnClick();
                    }
                });
                helper.setOnClickListener(R.id.delete, new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mRemainderList.remove(item);
                        mRmainderAdapter.notifyDataSetChanged();
                        refreshRemainder();
                    }
                });
            }

        };
        mReminder.setAdapter(mRmainderAdapter);
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
                if(mEtSearchView.getText().length()==0){
                    mReminder.setVisibility(VISIBLE);
                }
            }
        });
        mClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mEtSearchView.setText("");
            }
        });
        mSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
//                mSpEditor.putString("0",mEtSearchView.getText().toString());
                String s=mEtSearchView.getText().toString();
                if(!mRemainderList.contains(s))
                mRemainderList.add(0,s);
                if(mRemainderList.size()>10){
                    mRemainderList.remove(mRemainderList.size()-1);
                }
                mRmainderAdapter.notifyDataSetChanged();
                refreshRemainder();
                mSearchListener.onClick(view);
                mReminder.setVisibility(GONE);
            }
        });
    }

    /**
     * 返回当前选择的搜索类型
     *
     * @return
     */
    public int getSearchType() {
        return mSpinner2.getSelectedItemPosition();
    }
    public String getText(){
        return mEtSearchView.getText().toString();
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
        mSearchListener=listener;
    }
    private void refreshRemainder(){
        for(int i=0;i<mRemainderList.size();i++){
            mSpEditor.putString(String.valueOf(i),mRemainderList.get(i));
        }
        for(int i=mRemainderList.size();i<10;i++){
            mSpEditor.putString(String.valueOf(i),"");
        }
        mSpEditor.commit();
    }
}
