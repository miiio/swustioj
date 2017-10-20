package cn.example.ioj.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by wax on 2017/10/20.
 */

public class SharedPreferencesUtil {
    public static final int MAXHISTORY = 20;

    /**
     * 从SharedPreferences中加载搜索历史，最新一条记录在最前面
     *
     * @param context
     * @return
     */
    public static void loadSearchHistory(Context context, List<String> history){
        SharedPreferences sp = context.getSharedPreferences("search_history",Context.MODE_PRIVATE);
        if(history == null){
            history = new ArrayList<>();
        }
        if(!history.isEmpty()){
            history.clear();
        }
        for(int i = 0; i<MAXHISTORY; i++){
            String _history = sp.getString(String.valueOf(i),"");
            if (!Objects.equals(_history, "")) {
                history.add(_history);
            }
        }
    }

    /**
     * 清空SharedPreferences中储存的所有搜索历史
     *
     * @param context
     */
    public static void clearAllSearchHistory(Context context){
        SharedPreferences sp = context.getSharedPreferences("search_history",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

    /**
     * 更新搜索记录
     *
     * @param context
     * @param history
     */
    public static void updateSearchHistory(Context context, List<String> history){
        SharedPreferences sp = context.getSharedPreferences("search_history",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        for(int i = 0; i<history.size(); i++){
            editor.putString(String.valueOf(i),history.get(i));
        }
        editor.commit();
    }
}
