package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.ProjectAdapter;
import com.example.myapplication.Bean.ProjectItem;
import com.example.myapplication.R;
import com.google.gson.Gson;
/**
 * description ：项目pager里的碎片
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class ProjectListFragment extends Fragment {
    private ProjectAdapter projectAdapter;

    public static ProjectListFragment newInstance(int position, String list) {
        ProjectListFragment fragment = new ProjectListFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putString("list", list);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            String list = getArguments().getString("list");
            Log.d("mList", "mList-->" + list);

            initView(view);
            initList(list);
        }
    }

    private void initList(String list) {
        Gson gson = new Gson();
        ProjectItem projectItem = gson.fromJson(list, ProjectItem.class);

        projectAdapter.setProjectData(projectItem);
    }

    private void initView(View view) {
        //RecycleView
        RecyclerView mRvProject = view.findViewById(R.id.rv_project);
        mRvProject.setLayoutManager(new LinearLayoutManager(getActivity()));
        projectAdapter = new ProjectAdapter();
        mRvProject.setAdapter(projectAdapter);
    }
}