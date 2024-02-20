package com.example.myapplication.Fragment;

import static com.example.myapplication.Util.Get.getData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Adapters.BannerAdapter;
import com.example.myapplication.Adapters.HomeArticleAdapter;
import com.example.myapplication.Bean.BannerItem;
import com.example.myapplication.Bean.HomeArticleItem;
import com.example.myapplication.R;
import com.google.gson.Gson;
/**
 * description ：首页碎片
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class HomePageFragment extends Fragment {
    private String mUrlBanner = "https://www.wanandroid.com/banner/json";
    private RecyclerView recyclerView;
    private HomeArticleAdapter articleAdp;
    private ViewPager mViewPager;
    private BannerAdapter bannerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        home();
    }

    private void home() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                for (int i = 0; i < 40; i++) {
                    String mUrlArticle = "https://www.wanandroid.com/article/list/" + i + "/json";
                    String articleJson = getData(mUrlArticle);
                    HomeArticleItem homeArticleItem = gson.fromJson(articleJson, HomeArticleItem.class);
                    //主线程
                    articleGoToUI(homeArticleItem);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String bannerJson = getData(mUrlBanner);
                Gson gson = new Gson();
                BannerItem bannerItem = gson.fromJson(bannerJson, BannerItem.class);
                //主
                bannerGoToUI(bannerItem);
            }
        }).start();
    }

    private void bannerGoToUI(BannerItem bannerItem) {
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bannerAdapter.setBannerPic(bannerItem);
                mViewPager.setAdapter(bannerAdapter);
                //设置到中间位置，实现左右伪无限循环
                mViewPager.setCurrentItem(Integer.MAX_VALUE / 2);
            }
        });
    }

    private void articleGoToUI(HomeArticleItem homeArticleItem) {
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                articleAdp.setData(homeArticleItem);
            }
        });
    }

    private void initView(View view) {
        mViewPager = view.findViewById(R.id.vp_banner);
        bannerAdapter = new BannerAdapter();

        recyclerView = view.findViewById(R.id.rv_home_article);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        articleAdp = new HomeArticleAdapter();
        recyclerView.setAdapter(articleAdp);
    }
}