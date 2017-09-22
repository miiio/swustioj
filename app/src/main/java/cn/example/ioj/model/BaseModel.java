package cn.example.ioj.model;

import cn.example.ioj.contract.i.BaseContract;

/**
 * model的基类
 * 所有的model都应该继承这个基类,基类中提供了必要的方法
 * 并且应该实现{@link cn.example.ioj.contract.i.BaseContract.Model}接口的子接口
 * presenter通过IBaseModel的子接口调用model中的方法以获取相关数据
 *
 * Created by L on 2017/9/21.
 */

public abstract class BaseModel implements BaseContract.Model {

    public BaseModel(){

    }
    /**
     * 释放相关资源,通过presenter调用
     */
    public abstract void onDestroy();
}
