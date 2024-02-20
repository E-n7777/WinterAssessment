package com.example.myapplication.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.Bean.ProjectItem;
import com.example.myapplication.Fragment.ProjectListFragment;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：项目页面pager的适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class ProjectVpAdapter extends FragmentPagerAdapter {
    List<ProjectItem> mProjectBag = new ArrayList<>();
    List<String> mName = new ArrayList<>();

    public ProjectVpAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    public void setProjectList(List<ProjectItem> projectBag, List<String> name) {
        mProjectBag.clear();
        mProjectBag.addAll(projectBag);
        mName.addAll(name);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mName.size();
    }

    //返回当前的fragment
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Gson gson = new Gson();
        String list = gson.toJson(mProjectBag.get(position));
        ProjectListFragment fragment = ProjectListFragment.newInstance(position, list);

        return fragment;
    }

    //设置标签栏分类文字
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mName.get(position);
    }
}
