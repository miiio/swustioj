package cn.example.ioj.model;

import android.content.Context;
import android.content.SharedPreferences;

import cn.example.ioj.contract.FirstContract;
import cn.example.ioj.util.Constant;

/**
 *
 *
 * Created by L on 2017/9/24.
 */

public class FirstModel extends BaseModel implements FirstContract.Model{
    private Context context;
    public FirstModel(Context context) {
        this.context = context;
    }

    @Override
    public boolean isFirst() {
        SharedPreferences sp = context.getSharedPreferences("firstSp",Context.MODE_PRIVATE);
        boolean is = sp.getBoolean("isFirst",true);
        return is;
    }

    @Override
    public boolean isLogin() {
        SharedPreferences sp = context.getSharedPreferences(Constant.SharedPreferencesUser,Context.MODE_PRIVATE);
        String username = sp.getString("username","");
        return username != "";
    }

    @Override
    public void setFirst(boolean is) {
        SharedPreferences sp = context.getSharedPreferences("firstSp",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("isFirst",is);
        editor.commit();
    }

    @Override
    public void onDestroy() {

    }
}
