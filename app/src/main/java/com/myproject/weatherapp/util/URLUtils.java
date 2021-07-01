package com.myproject.weatherapp.util;

public class URLUtils {
    public static final String key = "11d67622031ae1ef762e5d89412508d4";
    public static String temp_url = "http://apis.juhe.cn/simpleWeather/query";
    public static String index_url = "http://apis.juhe.cn/simpleWeather/life";

    public static String getTemp_url(String city){
        String url = temp_url + "?city=" + city + "&key"+key;
        return url;
    }

    public static String getIndex_url(String city){
        String url = index_url + "?city=" + city + "&key"+key;
        return url;
    }
}
