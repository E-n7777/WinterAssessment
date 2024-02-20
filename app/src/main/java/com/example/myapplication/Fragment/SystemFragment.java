package com.example.myapplication.Fragment;

import static com.example.myapplication.Util.Get.getData;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapters.SystemAdapter;
import com.example.myapplication.Bean.SystemTreeItem;
import com.example.myapplication.R;
import com.google.gson.Gson;
/**
 * description ：知识体系页面碎片
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class SystemFragment extends Fragment {
    private SystemAdapter systemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_system, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        systemData();
    }

    private void systemData() {
        String mUrl = "https://www.wanandroid.com/tree/json";
        new Thread(new Runnable() {
            @Override
            public void run() {
                String systemJson = getData(mUrl);
                Gson gson = new Gson();
                SystemTreeItem systemTreeItem = gson.fromJson(systemJson, SystemTreeItem.class);
                //切换到主线程
                goToUI(systemTreeItem);
            }
        }).start();
    }

    private void goToUI(SystemTreeItem systemTreeItem) {
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                systemAdapter.setSystemData(systemTreeItem);
            }
        });
    }

    private void initView(View view) {
        RecyclerView mRvSystem = view.findViewById(R.id.rv_system);
        mRvSystem.setLayoutManager(new LinearLayoutManager(getActivity()));
        systemAdapter = new SystemAdapter();
        mRvSystem.setAdapter(systemAdapter);
    }
}