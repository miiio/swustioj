package cn.example.ioj.my_view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import butterknife.BindView;
import cn.example.ioj.R;

/**
 * Created by Tolean on 2017/10/17.
 */

public class TextCard extends LinearLayout {
    TextView mTitle;
    ExpandableTextView mExpandTextView;
    TextView mTextView;
    private Context mContext;

    public TextCard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.text_card, this);
        mTitle=findViewById(R.id.title);
        mExpandTextView=findViewById(R.id.expand_text_view);
        mTextView=findViewById(R.id.expandable_text);
        initView();
    }
    public void setTitle(String title){
        mTitle.setText(title);
    }
    public void setText(String text){
        mExpandTextView.setText(text);

    }
    private void initView() {
    }
}
