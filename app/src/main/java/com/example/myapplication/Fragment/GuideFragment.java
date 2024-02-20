package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.GuideLeftAdapter;
import com.example.myapplication.Adapters.GuideRightAdapter;
import com.example.myapplication.Bean.GuideItem;
import com.example.myapplication.R;
import com.example.myapplication.Util.Get;
import com.google.gson.Gson;
/**
 * description ：导航页面碎片
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class GuideFragment extends Fragment {
    private GuideLeftAdapter leftAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guide, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        guide();
    }

    private void guide() {
        String mUrl = "https://www.wanandroid.com/navi/json";
        new Thread(new Runnable() {
            @Override
            public void run() {
                String guideJson = Get.getData(mUrl);
                Gson gson = new Gson();
                GuideItem guideItem = gson.fromJson(guideJson, GuideItem.class);

                goToUI(guideItem);
            }
        }).start();
    }
    private void goToUI(GuideItem guideItem) {
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                leftAdapter.setLeftData(guideItem);
            }
        });
    }

    private void initView(View view) {
        RecyclerView mRvLeft = view.findViewById(R.id.rv_guide_left);
        RecyclerView mRvRight = view.findViewById(R.id.rv_guide_right);
        GuideRightAdapter rightAdapter = new GuideRightAdapter();
        leftAdapter = new GuideLeftAdapter(mRvRight,rightAdapter);
        //left
        mRvLeft.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvLeft.setAdapter(leftAdapter);
    }
}