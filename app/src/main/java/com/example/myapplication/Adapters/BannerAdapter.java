package com.example.myapplication.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.Bean.BannerItem;
import com.example.myapplication.R;
import com.example.myapplication.Util.WebViewUtil;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：首页banner的适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class BannerAdapter extends PagerAdapter {
    List<BannerItem.DataBean> mData = new ArrayList<>();
    public void setBannerPic(BannerItem bannerItem) {
        mData.clear();
        mData.addAll(bannerItem.getData());
        //刷新
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View item = LayoutInflater.from(container.getContext()).inflate(R.layout.item_banner, container, false);
        ImageView imageBanner = item.findViewById(R.id.img_banner);

        //设置数据
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE) // 不使用磁盘缓存
                .skipMemoryCache(true); // 跳过内存缓存

        int realPosition = position % mData.size();

        Glide.with(container.getContext())
                .load(mData.get(realPosition).getImagePath())
                .apply(options)
                .into(imageBanner);

        //点击监听，跳转到webView
        imageBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebViewUtil.class);
                intent.putExtra("url", mData.get(realPosition).getUrl());
                v.getContext().startActivity(intent);
            }
        });

        ViewGroup oldParent = (ViewGroup) imageBanner.getParent();
        if (oldParent != null) {
            oldParent.removeView(imageBanner); //从原来的父视图中移除
        }
        container.addView(imageBanner);
        return imageBanner;
    }

    //销毁view
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
