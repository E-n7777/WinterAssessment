package com.example.myapplication.Fragment;

import static com.example.myapplication.Util.Get.getData;
import static com.example.myapplication.Util.Get.getWithParams;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Adapters.ProjectVpAdapter;
import com.example.myapplication.Bean.ProjectItem;
import com.example.myapplication.Bean.TreeItem;
import com.example.myapplication.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：项目页面碎片
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class ProjectFragment extends Fragment {
    private final String mUrl = "https://www.wanandroid.com/project/tree/json";
    private final String mBaseUrl = "https://www.wanandroid.com/article/list/";
    private ProjectVpAdapter vpAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_project, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        project();
    }

    private void project() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String treeJson = getData(mUrl);
                Gson gson = new Gson();
                TreeItem treeItem = gson.fromJson(treeJson, TreeItem.class);
                gotoUI(treeItem);
            }
        }).start();
    }

    private void gotoUI(TreeItem treeItem) {
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                List<TreeItem.DataBean> mTreeList = new ArrayList<>();
                mTreeList.addAll(treeItem.getData());

                List<ProjectItem> projectBag = new ArrayList<>();
                List<String> name = new ArrayList<>();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < mTreeList.size(); i++) {
                            String cid = String.valueOf(mTreeList.get(i).getId());
                            name.add(mTreeList.get(i).getName());

                            Gson gson = new Gson();
                            for (int j = 0; j < 40; j++) {
                                String projectList = getWithParams(mBaseUrl + j + "/json?cid=", cid);
                                ProjectItem listItem = gson.fromJson(projectList, ProjectItem.class);
                                projectBag.add(listItem);
                            }
                        }
                        //主线程
                        goToUI(projectBag, name);
                    }
                }).start();
            }
        });
    }

    private void goToUI(List<ProjectItem> projectBag, List<String> name) {
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                vpAdapter.setProjectList(projectBag, name);
            }
        });
    }

    private void initView(View view) {
        //初始化标签栏
        PagerTabStrip mTabProject = view.findViewById(R.id.tab_project);
        mTabProject.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);

        //ViewPager
        ViewPager mVpProject = view.findViewById(R.id.vp_project);
        vpAdapter = new ProjectVpAdapter(getChildFragmentManager());
        mVpProject.setAdapter(vpAdapter);
    }
}