package com.myproject.weatherapp;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.myproject.weatherapp.bean.WeatherBean;
import com.myproject.weatherapp.util.TempBean;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


/*使用xutils加载网络数据
* 1、声明整体模块
* 2、执行网络请求操作
* */
public class BaseFragment extends Fragment implements Callback.CommonCallback<String>{

    public void loadData(String path){
        RequestParams params = new RequestParams(path);
        x.http().get(params,this);

    }

//    获取数据成功时会回调的接口
    @Override
    public void onSuccess(String result) {

    }

    //    获取数据失败时会调用的接口
    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }

//    取消请求时，会调用的接口
    @Override
    public void onCancelled(CancelledException cex) {

    }

//    请求完成后，会调用的接口
    @Override
    public void onFinished() {

    }
}
