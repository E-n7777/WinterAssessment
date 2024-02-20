package com.example.myapplication.Adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Bean.SystemTreeItem;
import com.example.myapplication.Children.ChildrenActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：知识体系RecyclerView的适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class SystemAdapter extends RecyclerView.Adapter<SystemAdapter.InnerHolder> {
    public static List<SystemTreeItem.DataBean> mData = new ArrayList<>();

    @NonNull
    @Override
    public SystemAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemProject = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_system_list, parent, false);

        return new InnerHolder(itemProject);
    }

    @Override
    public void onBindViewHolder(@NonNull SystemAdapter.InnerHolder holder, @SuppressLint("RecyclerView") int position) {
        View itemView = holder.itemView;
        SystemTreeItem.DataBean dataBean = mData.get(position);

        TextView tvName = itemView.findViewById(R.id.tv_system_name);
        tvName.setText(dataBean.getName());

        TextView tvChildrenName = itemView.findViewById(R.id.tv_system_children);
        StringBuilder childrenName = new StringBuilder();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < dataBean.getChildren().size(); i++) {
            childrenName.append(dataBean.getChildren().get(i).getName()).append(",");
            id.append(dataBean.getChildren().get(i).getId()).append(",");
        }
        tvChildrenName.setText(childrenName.toString());
        Log.d("idBag", "idBag-->" + id.toString());

        LinearLayout item = itemView.findViewById(R.id.item_system_list);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChildrenActivity.class);
                Log.d("idClick", "idClick-->" + id.toString());
                intent.putExtra("cid", id.toString());
                intent.putExtra("childrenName", childrenName.toString());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setSystemData(SystemTreeItem systemTreeItem) {
        mData.clear();
        mData.addAll(systemTreeItem.getData());
        notifyDataSetChanged();
    }

    public static class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
