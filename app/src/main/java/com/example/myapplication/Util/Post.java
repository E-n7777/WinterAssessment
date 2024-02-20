package com.example.myapplication.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
/**
 * description ：POST请求
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class Post {
    public static String getPostData(String mUrl, HashMap<String, String> params) {
        String responseData = null;
        InputStream in = null;
        OutputStream outputStream = null;
        try {
            URL url = new URL(mUrl);
            HttpURLConnection connection = (HttpURLConnection)
                    url.openConnection();
            connection.setRequestMethod("POST");//设置请求⽅式为POST
            connection.setConnectTimeout(8000);//设置最⼤连接时间，单位为ms
            connection.setReadTimeout(8000);//设置最⼤的读取时间，单位为ms
            connection.setDoOutput(true);//允许输出流
            connection.setDoInput(true);//允许输入流
            StringBuilder dataToWrite = new StringBuilder();//构建参数值
            for (String key : params.keySet()) {
                dataToWrite.append(key).append("=").append(params.get(key)).append("&");
            }
            connection.connect();//正式连接
            outputStream = connection.getOutputStream();//开
            outputStream.write(dataToWrite.substring(0,
                    dataToWrite.length() - 1).getBytes());//去除最后⼀个&
            in = connection.getInputStream();//从接⼝处获取输⼊
            //这⾥就是服务器返回的
            responseData = StreamToString(in);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return responseData;
    }

    public static String StreamToString(InputStream in) {
        StringBuilder sb = new StringBuilder();
        String oneLine;//流转换为字符串的⼀⾏
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            while ((oneLine = reader.readLine()) != null) {//readLine⽅法将读取⼀⾏
                sb.append(oneLine).append('\n');//拼接字符串并且增加换⾏，提⾼可读性
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();//将拼接好的字符串返回出去
    }
}


