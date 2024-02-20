package com.example.myapplication.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.Bean.SystemListItem;
import com.example.myapplication.Fragment.SystemListFragment;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：知识体系各分类pager适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class SystemChildrenAdapter extends FragmentPagerAdapter {
    List<SystemListItem> mListBag = new ArrayList<>();
    List<String> childrenName = new ArrayList<>();

    public SystemChildrenAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    public void setData(List<SystemListItem> listBag, List<String> mChildrenName) {
        mListBag.addAll(listBag);
        childrenName.addAll(mChildrenName);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Gson gson = new Gson();
        String list = gson.toJson(mListBag.get(position));

        SystemListFragment fragment = SystemListFragment.newInstance(position, list);
        return fragment;
    }

    @Override
    public int getCount() {
        return mListBag.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return childrenName.get(position);
    }
}
