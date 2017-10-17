package cn.example.ioj.my_view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import cn.example.ioj.R;

/**
 * Created by Tolean on 2017/9/27.
 */

public class SearchView extends FrameLayout {
    @BindView(R.id.im_search_view_back)
    ImageView mImSearchViewBack;
    @BindView(R.id.et_search_view)
    AppCompatEditText mEtSearchView;
    @BindView(R.id.spinner_type)
    NiceSpinner mSpinnerType;
    private Context mContext;

    public SearchView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.search_view, this);
        mSpinnerType=findViewById(R.id.spinner_type);
        mImSearchViewBack=findViewById(R.id.im_search_view_back);
        initView();
    }

    private void initView() {
        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        mSpinnerType.attachDataSource(dataset);
//        mSpinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
    }
    public void setSpinnerDate(List<String> data){
//        mSpinnerType.attachDataSource(data);
    }
    public void setSpinnerOnItemSelectedLisenter(AdapterView.OnItemSelectedListener lisenter){
        mSpinnerType.setOnItemSelectedListener(lisenter);
    }
    public void setOnbackListener(OnClickListener listener){
        mImSearchViewBack.setOnClickListener(listener);
    }
}
