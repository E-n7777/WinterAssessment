package com.example.myapplication.Adapters;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/**
 * description ：重写banner的ViewPager
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class BannerViewPager extends ViewPager {
    private Handler mHandler;

    public BannerViewPager(@NonNull Context context) {
        super(context, null);
    }

    public BannerViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        //显示在窗口时自动轮播
        startLooper();
    }

    private void startLooper() {
        mHandler.postDelayed(action, 3000);//使第一张图也停留3s
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        //没显示在窗口时停止轮播
        stopLooper();
    }

    private void stopLooper() {
        mHandler.removeCallbacks(action);
    }

    private Runnable action = new Runnable() {
        @Override
        public void run() {
            //切换的内容
            int currentItem = getCurrentItem();
            currentItem++;
            setCurrentItem(currentItem);
            postDelayed(this, 3000);//3秒切换一个
        }
    };
}
