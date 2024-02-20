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

import com.example.myapplication.Adapters.SystemListAdapter;
import com.example.myapplication.Bean.SystemListItem;
import com.example.myapplication.R;
import com.google.gson.Gson;
/**
 * description ：知识体系pager里的碎片
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class SystemListFragment extends Fragment {
    private SystemListAdapter listAdapter;

    public static SystemListFragment newInstance(int position, String list) {
        SystemListFragment fragment = new SystemListFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putString("mList", list);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_system_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            String mList = getArguments().getString("mList");
            Log.d("mList", "mList-->" + mList);

            initView(view);
            setList(mList);
        }
    }

    private void setList(String mList) {
        Gson gson = new Gson();
        SystemListItem systemList = gson.fromJson(mList, SystemListItem.class);
        listAdapter.setListData(systemList);
    }

    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.rv_system_children);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listAdapter = new SystemListAdapter();
        recyclerView.setAdapter(listAdapter);
    }
}