package com.example.myapplication.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Bean.SystemListItem;
import com.example.myapplication.R;
import com.example.myapplication.Util.WebViewUtil;

import java.util.ArrayList;
import java.util.List;
/**
 * description ：知识体系各分类RecyclerView适配器
 * author : 张恩琦
 * email : 1301731619@qq.com
 * date : 2024/2/20 09:56
 */
public class SystemListAdapter extends RecyclerView.Adapter<SystemListAdapter.InnerHolder> {
    private List<SystemListItem.DataBean.DatasBean> mDatas = new ArrayList<>();

    @NonNull
    @Override
    public SystemListAdapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemSystemChildren = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_system_children_list, parent, false);

        return new InnerHolder(itemSystemChildren);
    }

    @Override
    public void onBindViewHolder(@NonNull SystemListAdapter.InnerHolder holder, int position) {
        View itemView = holder.itemView;
        SystemListItem.DataBean.DatasBean datasBean = mDatas.get(position);

        TextView tvTitle = itemView.findViewById(R.id.tv_system_title);
        tvTitle.setText(datasBean.getTitle());

        TextView tvClassify = itemView.findViewById(R.id.tv_system_chapterName_superChapterName);
        StringBuilder classify = new StringBuilder();
        classify.append("分类：").append(datasBean.getSuperChapterName()).append("|").append(datasBean.getChapterName());
        tvClassify.setText(classify.toString());

        TextView tvShare = itemView.findViewById(R.id.tv_system_shareUser);
        tvShare.setText("分享人:" + datasBean.getShareUser());

        TextView tvTime = itemView.findViewById(R.id.tv_system_niceShareDate);
        tvTime.setText("时间:" + datasBean.getNiceDate());

        LinearLayout item = itemView.findViewById(R.id.item_system_children_list);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebViewUtil.class);
                intent.putExtra("url", datasBean.getLink().replace("http://", "https://"));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void setListData(SystemListItem listItem) {
        mDatas.addAll(listItem.getData().getDatas());
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
