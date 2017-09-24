package cn.example.ioj.my_view;

import android.content.Context;
import android.drm.DrmStore;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Printer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.example.ioj.R;

/**
 * Created by Tolean on 2017/9/24.
 */

public class AboutMeCardView extends CardView {
    private Context mContext;
    private LinearLayout mLinearLayout;
    private ImageView mImageView;
    private TextView mTextView_tv;
    private TextView mTextView_num;
    public AboutMeCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        LayoutInflater.from(mContext).inflate(R.layout.item_abm_card,this);
        initView();
    }
    private void initView(){
        mImageView=(ImageView)findViewById(R.id.im_aboutme_card);
        mTextView_tv=(TextView)findViewById(R.id.tv_aboutme_card_text);
        mTextView_num=(TextView)findViewById(R.id.tv_aboutme_card_number);
    }

    /**
     * 设置card的图片
     * @param R
     */
    public void setImageView(int R){
        mImageView.setImageResource(R);
    }

    /**
     * 设置card的标题
     * @param string
     */
    public void setTextView_tv(String string){
        mTextView_tv.setText(string);
    }

    /**
     * 设置数量
     * @param string
     */
    public void setTextView_num(String string){
        mTextView_num.setText(string);
    }
}
