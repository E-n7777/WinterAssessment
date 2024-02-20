package com.example.myapplication.Util;

import static com.example.myapplication.Util.Post.StreamToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * description ：Get请求
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class Get {

    public static String getData(String mUrl) {
        String responseData = null;
        HttpURLConnection connection;
        InputStream in = null;
        try {
            URL url = new URL(mUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");//设置请求⽅式为GET
            connection.setConnectTimeout(3000);//设置最⼤连接时间
            connection.setReadTimeout(3000);//设置最⼤的读取时间
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            connection.connect();//正式连接

            int code = connection.getResponseCode();
            if (code == 200) {
                in = connection.getInputStream();//从接⼝处获取
                responseData = StreamToString(in);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return responseData;
    }

    //带参数的get请求
    public static String getWithParams(String mBaseUrl, String cid) {
        String responseData = null;
        HttpURLConnection connection;
        InputStream in = null;
        try {
            URL url = new URL(mBaseUrl + cid);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");//设置请求⽅式为GET
            connection.setConnectTimeout(3000);//设置最⼤连接时间
            connection.setReadTimeout(3000);//设置最⼤的读取时间
            connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
            connection.connect();//正式连接

            int code = connection.getResponseCode();
            if (code == 200) {
                in = connection.getInputStream();//从接⼝处获取
                responseData = StreamToString(in);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return responseData;
    }
}
