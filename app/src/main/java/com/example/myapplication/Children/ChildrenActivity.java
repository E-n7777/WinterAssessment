package com.example.myapplication.Children;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Adapters.SystemChildrenAdapter;
import com.example.myapplication.Bean.SystemListItem;
import com.example.myapplication.R;
import com.example.myapplication.Util.Get;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * description ：知识体系ChildrenActivity
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class ChildrenActivity extends AppCompatActivity {
    private final String mBaseUrl = "https://www.wanandroid.com/article/list/";
    private SystemChildrenAdapter childrenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_children);

        Intent intent = getIntent();
        String cidBag = intent.getStringExtra("cid");
        String childrenName = intent.getStringExtra("childrenName");
        List<String> mCid = Arrays.asList(cidBag.split(","));
        List<String> mChildrenName = Arrays.asList(childrenName.split(","));

        initView();
        childrenList(mCid, mChildrenName);
    }

    private void childrenList(List<String> mCid, List<String> mChildrenName) {
        List<SystemListItem> listBag = new ArrayList<>();
        Gson gson = new Gson();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < mCid.size(); i++) {
                    for (int j = 0; j < 40; j++) {
                        String articleJson = Get.getWithParams(mBaseUrl + j + "/json?cid=", mCid.get(i));
                        SystemListItem listItem = gson.fromJson(articleJson, SystemListItem.class);
                        listBag.add(listItem);
                    }
                }
                //主线程
                goToUI(listBag, mChildrenName);
            }
        }).start();
    }

    private void goToUI(List<SystemListItem> listBag, List<String> mChildrenName) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                childrenAdapter.setData(listBag, mChildrenName);
            }
        });
    }

    private void initView() {
        //初始化标签栏
        PagerTabStrip mTabProject = findViewById(R.id.tab_system_children);
        mTabProject.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

        ViewPager vpSystemChildren = findViewById(R.id.vp_system_children);
        childrenAdapter = new SystemChildrenAdapter(getSupportFragmentManager());
        vpSystemChildren.setAdapter(childrenAdapter);
    }
}