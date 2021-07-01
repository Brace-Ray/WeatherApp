package com.myproject.weatherapp;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.myproject.weatherapp.util.TempBean;
import com.myproject.weatherapp.util.URLUtils;

import java.util.List;


public class CityWeatherFragment extends BaseFragment implements View.OnClickListener{


    TextView tempTv,cityTv,conditionTv,windTv,tempRangeTv,dateTv,clothIndexTv,carIndexTv,coldIndexTv,sportIndexTv,raysIndexTv,airIndexTv;
    ImageView dayIv;
    LinearLayout futureLayout;
    ScrollView outLayout;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_city_weather, container, false);
//        通过Activity传值获取到当前fragment加载到地方的天气情况
        Bundle bundle = getArguments();
        String city = bundle.getString("city");
        String Temp_url = URLUtils.getTemp_url("city");
        String Index_url = URLUtils.getIndex_url("city");

//        调用父类的load方法
        loadData(Temp_url);
        return view;
    }

    @Override
    public void onSuccess(String result) {
        //解析并展示数据
        parseShowData(result);

    }


    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
    }

    private void parseShowData(String result) {
        TempBean tempBean = new Gson().fromJson(result, TempBean.class);
        TempBean.ResultBean tempBeanResult = tempBean.getResult();
        dateTv.setText(tempBeanResult.getFuture().get(0).getDate());
        cityTv.setText(tempBeanResult.getCity());

//        拿到当天的城市天气信息
        TempBean.ResultBean.FutureBean todayTempResult = tempBeanResult.getFuture().get(0);
        TempBean.ResultBean.RealtimeBean realtime = tempBeanResult.getRealtime();
        windTv.setText(realtime.getDirect() + realtime.getPower());
        tempRangeTv.setText(todayTempResult.getTemperature());
        conditionTv.setText(realtime.getInfo());
        tempTv.setText(realtime.getTemperature() + "℃");
//        获取未来三天的天气情况
        List<TempBean.ResultBean.FutureBean> futureList = tempBeanResult.getFuture();
        futureList.remove(0);
        for(int i = 0; i < futureList.size(); i++){
            View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.item_main_center,null);
            itemView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
            futureLayout.addView(itemView);

            TextView idateTv = itemView.findViewById(R.id.item_center_tv_date);
            TextView iconTv = itemView.findViewById(R.id.item_center_tv_con);
            TextView windTv = itemView.findViewById(R.id.item_center_tv_wind);
            TextView itemRangeTv = itemView.findViewById(R.id.item_center_tv_temp);
            ImageView iIv = itemView.findViewById(R.id.item_center_iv);
//            对应位置的天气情况
            TempBean.ResultBean.FutureBean futureBean = futureList.get(i);
            idateTv.setText(futureBean.getDate());
            iconTv.setText(futureBean.getWeather());
            itemRangeTv.setText(futureBean.getTemperature());
            windTv.setText(futureBean.getDirect());
        }

    }

    private void initView(View view){
        //初始化控件
        tempTv = view.findViewById(R.id.frag_tv_currenttemp);
        tempTv = view.findViewById(R.id.frag_tv_currenttemp);
        cityTv = view.findViewById(R.id.frag_tv_city);
        conditionTv = view.findViewById(R.id.frag_tv_condition);
        windTv = view.findViewById(R.id.frag_tv_wind);
        tempRangeTv = view.findViewById(R.id.frag_tv_temprange);
        dateTv = view.findViewById(R.id.frag_tv_date);
        clothIndexTv = view.findViewById(R.id.frag_index_tv_dress);
        carIndexTv = view.findViewById(R.id.frag_index_tv_washcar);
        coldIndexTv = view.findViewById(R.id.frag_index_tv_cold);
        sportIndexTv = view.findViewById(R.id.frag_index_tv_sport);
        raysIndexTv = view.findViewById(R.id.frag_index_tv_rays);
        airIndexTv = view.findViewById(R.id.frag_index_tv_air);
        dayIv = view.findViewById(R.id.frag_iv_today);
        futureLayout = view.findViewById(R.id.frag_center_layout);

        //设置TextView的点击时间监听
        clothIndexTv.setOnClickListener(this);
        carIndexTv.setOnClickListener(this);
        coldIndexTv.setOnClickListener(this);
        sportIndexTv.setOnClickListener(this);
        raysIndexTv.setOnClickListener(this);
        airIndexTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        switch (v.getId()){
            case R.id.frag_index_tv_dress:
                builder.setTitle("穿衣指数");

                break;
            case R.id.frag_index_tv_washcar:
                builder.setTitle("洗车指数");
                break;
            case R.id.frag_index_tv_cold:
                builder.setTitle("感冒指数");
                break;
            case R.id.frag_index_tv_sport:
                builder.setTitle("运动指数");
                break;
            case R.id.frag_index_tv_rays:
                builder.setTitle("紫外线指数");
                break;
            case R.id.frag_index_tv_air:
                builder.setTitle("空调指数");
                break;
        }
        builder.create().show();

    }
}